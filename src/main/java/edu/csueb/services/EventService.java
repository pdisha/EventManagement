package edu.csueb.services;

import java.util.List;

import edu.csueb.data.Event;

public interface EventService {
	
	public Event create(Event eventData);
	
	public void update(Event eventData);
	
	public void delete(int eventid);
	
	public Event getEvent(int eventid);
	
	public List getAllEvents();
	
	public void cancelRegistration(int eventid,int userid);
	
	public List getRegisteredEvents(int userid);
	
	public boolean isAlreadyRegistered(int userid,int eventid);
}
