package edu.csueb.dao;

import java.util.List;

import edu.csueb.data.Event;

/**
 * @author disha
 */
public interface EventDao {

	public Event create(Event eventData);
	
	public void update(Event eventData);
	
	public void delete(int eventid);
	
	public Event getEvent(int eventid);
	
	public List getAllEvents();
	
	public List getRegisteredEvents(int userid);
	public void cancelRegistration(int eventid,int userid);
	
}
