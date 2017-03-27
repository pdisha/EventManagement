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

import edu.csueb.constants.LoginConstant;
import edu.csueb.data.Event;
import edu.csueb.data.User;
import edu.csueb.services.EventService;
import edu.csueb.services.UserService;

/**
 * Handles requests for the application home page.
 * @author disha
 */
@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	@Autowired
	EventService eventService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="home", method=RequestMethod.POST)
    public String home( HttpServletRequest request,Model model) {
		String action = request.getParameter("action");//login,signup,loginPsw"
		logger.info("Action to be performed is  "+action);
		String returnPage ="home"; 
		User data=null;
		if(LoginConstant.LOGIN_ACTION.equals(action)){
			String username= request.getParameter("loginUName");
			String password = request.getParameter("loginPsw");
			data=userService.authenticateUser(username, password);
			if(data==null)
				request.setAttribute("response", "Error while logging.Username and Password are mismatched.");
			
		}
		else if(LoginConstant.SIGNUP_ACTION.equals(action)){
			data = new User();
			String usernam = request.getParameter("uName");
			String fName = request.getParameter("fName");
			String lName = request.getParameter("lName");
			String email = request.getParameter("email");
			String password = request.getParameter("psw");
			
			data.setEmail(email);
			data.setfName(fName);
			data.setLastName(lName);
			data.setUsername(usernam);
			data.setPassword(password);
			
			data=userService.create(data);
			logger.info("Yeah....Create User is ::"+data);
		}
		else if("Home".equals(action)){
			data = (User)request.getSession().getAttribute("user");
		}
		else if("Search".equals(action)){
			List<User> userList = userService.getAllUsers();
			System.out.println("UserList::"+userList);
			model.addAttribute("userList",userList);
			model.addAttribute("size",userList.size());
			return "Search";
		}
		else if("Event".equals(action)){
			List<Event> eventList = eventService.getAllEvents();
			System.out.println("EventList::"+eventList);
			model.addAttribute("eventList",eventList);
			model.addAttribute("size",eventList.size());
			return "ListEvent";
		}
		else if("MyEvents".equals(action)){
			int userid = ((User)request.getSession().getAttribute("user")).getUserId();
			List<Event> eventList =eventService.getRegisteredEvents(userid);
			System.out.println("Registered EventList::"+eventList);
			model.addAttribute("eventList",eventList);
			model.addAttribute("size",eventList.size());
			request.setAttribute("onlyMyEvents", true);
			return "ListEvent";
		}
		if(data!=null){
			model.addAttribute("user", data);
			request.getSession().setAttribute("user", data);
			returnPage="welcome";
		}
		
        return returnPage;
    }
}
