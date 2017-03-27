package edu.csueb.temp;

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
import edu.csueb.data.ResponseData;
import edu.csueb.data.User;
import edu.csueb.data.UserEventRel;
import edu.csueb.services.EventService;
import edu.csueb.services.UserService;

@Controller
public class UserController  
{
	@Autowired
	UserService userService;
	
	@Autowired
	EventService eventService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/userUpdate", method=RequestMethod.POST)
    public String perfrmAction( HttpServletRequest request,Model model) {
		
		String action = request.getParameter("action");
		
		logger.info("Action is "+action);
		
		if("Edit".equals(action))
		{
			ResponseData response= updateUser(request, model);
			request.setAttribute("response", response.getResponseMsg());
			return "Update";
			
		}
		else if("Delete".equals(action))
		{
			String deletedStr= request.getParameter("deletedItems");

			logger.info("Deleted List is :: "+deletedStr);
			userService.delete(Integer.valueOf(deletedStr));

			request.setAttribute("response","Selected record is deleted successfully. ");
			List<User> userList = userService.getAllUsers();
			System.out.println("UserList::"+userList);
			model.addAttribute("userList",userList);
			model.addAttribute("size",userList.size());
			return "Search";
		}
		else if("RedirectUpdate".equals(action)){
			String updateId = request.getParameter("updateItem");
			User user = userService.getUser(Integer.valueOf(updateId));
			request.setAttribute("user",user);
			return "Update"; 
		}
		else if("Search".equals(action)){
			List<User> userList = userService.getAllUsers();
			System.out.println("UserList::"+userList);
			model.addAttribute("userList",userList);
			model.addAttribute("size",userList.size());
			return "Search";
		}
		else if("Register".equals(action)){
			String eventid = request.getParameter("updateItem");
			int userid = ((User)request.getSession().getAttribute("user")).getUserId();
			if(!eventService.isAlreadyRegistered(userid, Integer.valueOf(eventid))){
				UserEventRel rel = new UserEventRel();
				rel.setEventid(Integer.valueOf(eventid));
				rel.setUserid(userid);
				userService.registerEvent(rel);
				
				Event eventData =eventService.getEvent(Integer.valueOf(eventid));
				eventData.setRegseats(eventData.getRegseats()+1);
				eventService.update(eventData);
				request.setAttribute("response", "Congraulations! Registration completed.");
			}
			else {
				request.setAttribute("response", "You have already registered for selected event.");
			}
			List<Event> eventList = eventService.getAllEvents();
			System.out.println("EventList::"+eventList);
			model.addAttribute("eventList",eventList);
			model.addAttribute("size",eventList.size());
			return "ListEvent";
			
		}
		else if("Cancel".equals(action)){
			String eventid = request.getParameter("updateItem");
			int userid = ((User)request.getSession().getAttribute("user")).getUserId();
			eventService.cancelRegistration(Integer.valueOf(eventid), userid);
			Event eventData =eventService.getEvent(Integer.valueOf(eventid));
			eventData.setRegseats(eventData.getRegseats()-1);
			eventService.update(eventData);
			request.setAttribute("response", "Registration Cancelled for selected Event.");
			
			List<Event> eventList = eventService.getRegisteredEvents(userid);
			request.setAttribute("onlyMyEvents", true);
			System.out.println("Reg EventList::"+eventList);
			model.addAttribute("eventList",eventList);
			model.addAttribute("size",eventList.size());
			return "ListEvent";
			
		}
		return "welcome";
	}
    
   
	private ResponseData updateUser( HttpServletRequest request,Model model){
		
		String id = request.getParameter("userid");
		User user = userService.getUser(Integer.valueOf(id));
		String newFName= request.getParameter("fName");
		String newLName= request.getParameter("lName");
		String newUsername= request.getParameter("uName");
		String newEmail= request.getParameter("email");
		String newPassword= request.getParameter("newPsw");
		String oldPassword =request.getParameter("psw");
		logger.info("Old user data : "+user);
		logger.info("New Password "+newPassword+ " old Password "+ oldPassword);
		if(!user.getPassword().equals(oldPassword)){
			request.setAttribute("user",user);
			ResponseData response = new ResponseData();
			response.setResponseMsg("Old Password is incorrect.");
			response.setResponseCode(-1);
			return response;
		}
		user.setfName(newFName);
		user.setLastName(newLName);
		user.setUsername(newUsername);
		user.setEmail(newEmail);
		user.setPassword(newPassword);
		request.setAttribute("user",user);
		return userService.update(user);

	}
}
