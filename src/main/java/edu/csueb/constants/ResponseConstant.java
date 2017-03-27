package edu.csueb.constants;

/**
 * This class contains response code and messages for all responses.
 * -ve value represents error while +ve value represents success.
 * @author disha
 */
public class ResponseConstant {

	public static final long DEFAULT_RESPONSE= -1200;
	public static final long SUCCESS_RESPONSE= 1200;
	
	public static final long SQL_EXCEPTION_RESPONSE= -1201;
	public static final String SQL_EXCEPTION_RESPONSE_MSG= "SQL Exception occured while executing Query." ;
	
	public static final long CREATE_USER_FAIL_RESPONSE = -1202;
	public static final long CREATE_USER_SUCCESS_RESPONSE = 1202;
	
	public static final String CREATE_USER_FAIL_RESPONSE_MSG = "Error while crating User in the system. Please contact system administrator.";
	public static final String CREATE_USER_SUCCESS_RESPONSE_MSG = "User is successfully created in the system.";
	
	public static String getErrorMsg(long errorCode){
		String response="";
		
		if(CREATE_USER_FAIL_RESPONSE==errorCode){
			response= CREATE_USER_FAIL_RESPONSE_MSG;
		}
		else if(CREATE_USER_SUCCESS_RESPONSE==errorCode){
			response= CREATE_USER_SUCCESS_RESPONSE_MSG;
		}
		
		return response;
	}
	
}
