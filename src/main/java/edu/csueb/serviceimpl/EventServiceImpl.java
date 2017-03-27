package edu.csueb.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.csueb.dao.EventDao;
import edu.csueb.data.Event;
import edu.csueb.services.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;
	private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);
	
	@Transactional
	@Override
	public Event create(Event eventData) {
		return eventDao.create(eventData);
	}

	@Transactional
	@Override
	public void update(Event eventData) {
		eventDao.update(eventData);
	}

	@Transactional
	@Override
	public void delete(int eventid) {
		eventDao.delete(eventid);
	}

	@Transactional
	@Override
	public Event getEvent(int eventid) {
		return eventDao.getEvent(eventid);
	}

	@Transactional
	@Override
	public List getAllEvents() {
		return eventDao.getAllEvents();
	}
	
	@Override
	public List getRegisteredEvents(int userid) {
		logger.info("Going to get Registered Events.");
		return eventDao.getRegisteredEvents(userid);
	}
	
	@Override
	public void cancelRegistration(int eventid,int userid){
		try{
			logger.info("Going to cancel Registration");
			eventDao.cancelRegistration(eventid, userid);
			logger.info("Cancelation done.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isAlreadyRegistered(int userid,int eventid){
		try{
			List<Event> userEventList=eventDao.getRegisteredEvents(userid);
			logger.info("Event List ::"+userEventList);
			if(userEventList==null || userEventList.isEmpty()){
				logger.info("EVent list is null.");
				return false;
			}
			else
			{
				for(Event event : userEventList){
					if(event.getEventid()==eventid)
						return true;
				}
				logger.info("No registered event found.");
			}
				return false;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return true;
		}
	}
}
