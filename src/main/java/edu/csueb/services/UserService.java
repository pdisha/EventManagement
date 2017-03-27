package edu.csueb.services;

import java.util.List;

import edu.csueb.data.ResponseData;
import edu.csueb.data.User;
import edu.csueb.data.UserEventRel;

/**
 * @author disha
 */
public interface UserService {

	public User create(User userData);
	
	public ResponseData update(User userData);
	
	public void delete(int userId);
	
	public User getUser(int userId);
	
	public User getUserByUsername(String username);
	
	public List getAllUsers();
	
	public User authenticateUser(String username,String password);
	
	public UserEventRel registerEvent(UserEventRel rel);
}
