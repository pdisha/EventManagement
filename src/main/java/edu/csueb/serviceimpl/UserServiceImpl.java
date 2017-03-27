package edu.csueb.serviceimpl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.csueb.constants.ResponseConstant;
import edu.csueb.dao.UserDao;
import edu.csueb.data.ResponseData;
import edu.csueb.data.User;
import edu.csueb.data.UserEventRel;
import edu.csueb.services.UserService;

/**
 * @author disha
 */
@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao;
	
	@Transactional
	public User create(User userData) {
		 return userDao.create(userData);
	}
	
	@Transactional
	public ResponseData update(User userData) {
		userDao.update(userData);
		ResponseData response = new ResponseData();
		response.setResponseCode(ResponseConstant.SUCCESS_RESPONSE);
		response.setResponseMsg("User Detail is successfully updated.");
		return response;
	}

	@Transactional
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}
	
	@Transactional
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Transactional
	public List getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	@Transactional
	public User authenticateUser(String username,String password){
		User data=null;
		try{
			logger.info("Inside Authenticate User Method:: Username: "+username+" and Password:"+password);
			data = userDao.getUserByUsername(username);
			if(data!=null && data.getPassword().equals(password)){
				logger.info("Returning true value as user is valid. !");
				return data;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	@Transactional
	public UserEventRel registerEvent(UserEventRel rel){
		return userDao.registerEvent(rel);
	}
	
}
