package edu.csueb.dao;

import java.util.List;

import edu.csueb.data.User;
import edu.csueb.data.UserEventRel;

/**
 * @author disha
 */
public interface UserDao {
	
		public User create(User userData);
		
		public void update(User userData);
		
		public void delete(int userId);
		
		public User getUser(int userId);
		
		public User getUserByUsername(String username);
		
		public List getAllUsers();
		
		public UserEventRel registerEvent(UserEventRel rel);
		
}
