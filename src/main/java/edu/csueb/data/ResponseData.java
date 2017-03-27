package edu.csueb.data;

/**
 * General Response Data
 * @author disha
 */
public class ResponseData {

	private long responseCode;
	private String responseMsg;
	private Object responseObject;
	
	public ResponseData(long defaultCode){
		responseCode= defaultCode;
	}
	public ResponseData(){
		responseCode= -1l;
	}
	
	public long getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	
	
	
}
