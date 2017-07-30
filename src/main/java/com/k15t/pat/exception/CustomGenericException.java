package com.k15t.pat.exception;

/**
 * This is a generic exception class which is extending RuntimeException
 * 
 * @author Mahidhar
 *
 */
public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errCode;
	private String errMsg;

	/**
	 * This method returns the Error Code
	 * @return
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * This method sets the Error Code
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * This method returns the Error Message
	 * @return
	 */
	public String getErrMsg() {
		return errMsg;
	}
	
	/**
	 * This method sets the Error Message
	 * @param errMsg
	 */

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * A constructor with Error Code and Error Message
	 * @param errCode
	 * @param errMsg
	 */
	public CustomGenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
}
