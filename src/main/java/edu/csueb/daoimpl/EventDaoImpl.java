package edu.csueb.daoimpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.csueb.dao.EventDao;
import edu.csueb.data.Event;

@Repository
public class EventDaoImpl implements EventDao{

	@Autowired
	private SessionFactory session;
	
	@Override
	public Event create(Event eventData) {
		session.getCurrentSession().save(eventData);
		return eventData;
	}

	@Override
	public void update(Event eventData) {
		session.getCurrentSession().update(eventData);
	}

	@Override
	public void delete(int eventid) {
		session.getCurrentSession().delete(getEvent(eventid));
	}

	@Override
	public Event getEvent(int eventid) {
		return (Event) session.getCurrentSession().get(Event.class, eventid);
	}

	@Override
	public List getAllEvents() {
		return session.getCurrentSession().createQuery("from Event").list();
	}
	
	@Override
	public List getRegisteredEvents(int userid) {
		String query = "select * from Event e where e.eventid in ("
				+ "select eventid from UserEventRel where userid = :userid)";

		SQLQuery myQuery = session.openSession().createSQLQuery(query).addEntity(Event.class);
		myQuery.setParameter("userid", userid);
		return myQuery.list();
	}
	
	public void cancelRegistration(int eventid,int userid){
		String query = "delete from UserEventRel where eventid = :eventid and userid = :userid";
		SQLQuery myQuery = session.openSession().createSQLQuery(query);
		myQuery.setParameter("userid", userid);
		myQuery.setParameter("eventid", eventid);
		myQuery.executeUpdate();
	}
}
