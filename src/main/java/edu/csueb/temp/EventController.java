package edu.csueb.temp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.csueb.data.Event;
import edu.csueb.data.User;
import edu.csueb.services.EventService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@RequestMapping(value="/event", method=RequestMethod.POST)
    public String event( HttpServletRequest request,Model model) {
		String returnPage ="welcome";
		String action = request.getParameter("action");
		logger.info("Action is ::"+action);
		if("RedirectCreate".equals(action)){
			return "CreateEvent";
		}
		else if("Create".equals(action)){
			Event eventData = new Event();
			eventData.setName(request.getParameter("name"));
			eventData.setDescription(request.getParameter("description"));
			eventData.setLocation(request.getParameter("location"));
			eventData.setTotalseats(Integer.valueOf(request.getParameter("totalseats")));
			eventData.setRegseats(0);
			logger.info("Date is ::"+request.getParameter("time"));
			eventData.setTime(new Date());
			eventService.create(eventData);
			request.setAttribute("response", "Event is created successfully.");
			return "CreateEvent";
		}
		else if("Edit".equals(action)){
			updateEvent(request,model);
			request.setAttribute("response", "Event is updated successfully.");
			return "UpdateEvent";
		}
		else if("Delete".equals(action)){
			String deleteid = request.getParameter("deletedItems");
			int userid = ((User)request.getSession().getAttribute("user")).getUserId();
			
			eventService.cancelRegistration(Integer.valueOf(deleteid), userid);
			eventService.delete(Integer.valueOf(deleteid));
			request.setAttribute("response", "Event is deleted successfully.");
			return redirectSearch(model);
			
		}
		else if("Search".equals(action)){
			return redirectSearch(model);
		}
		else if("RedirectUpdate".equals(action)){
			String updateId = request.getParameter("updateItem");
			Event event = eventService.getEvent(Integer.valueOf(updateId));
			request.setAttribute("event",event);
			return "UpdateEvent";
		}
		return returnPage;
	}
	
	private String redirectSearch(Model model){
		List<Event> eventList = eventService.getAllEvents();
		System.out.println("EventList::"+eventList);
		model.addAttribute("eventList",eventList);
		model.addAttribute("size",eventList.size());
		return "ListEvent";
	}
	
	private void updateEvent( HttpServletRequest request,Model model){
		
		String id = request.getParameter("eventid");
		Event event = eventService.getEvent(Integer.valueOf(id));
		
		String newName= request.getParameter("name");
		String description= request.getParameter("description");
		String totalSeats= request.getParameter("totalseats");
		String location= request.getParameter("location");
		String time= request.getParameter("time");
		
		event.setName(newName);
		event.setDescription(description);
		event.setTotalseats(Integer.valueOf(totalSeats));
		event.setLocation(location);
		event.setTime(new Date());
		request.setAttribute("event",event);
		eventService.update(event);
	}
}
