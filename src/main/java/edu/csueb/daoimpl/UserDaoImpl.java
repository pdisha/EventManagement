package edu.csueb.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.csueb.dao.UserDao;
import edu.csueb.data.User;
import edu.csueb.data.UserEventRel;

/**
 * Data Access Obj implemetation for User
 * @author disha
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public User create(User userData) {
		session.getCurrentSession().save(userData);
		return userData;
	}

	@Override
	public void update(User userData) {
		session.getCurrentSession().update(userData);
	}

	@Override
	public void delete(int userId) {
		session.getCurrentSession().delete(getUser(userId));
	}

	@Override
	public User getUser(int userId) {
		return (User) session.getCurrentSession().get(User.class, userId);
	}

	@Override
	public List getAllUsers() {
		return session.getCurrentSession().createQuery("from User").list(); 
	}
	
	@Override
	public User getUserByUsername(String username) {
		Query query =session.getCurrentSession().createSQLQuery(
				"select * from User u where u.username = :username").addEntity(User.class)
				.setParameter("username", username);
		if(query.list()!=null && query.list().size()!=0)
			return (User)query.list().get(0);
		else
			return null;
		
	}
	
	@Override
	public UserEventRel registerEvent(UserEventRel rel){
		 session.getCurrentSession().save(rel);
		 return rel;
	}
}
