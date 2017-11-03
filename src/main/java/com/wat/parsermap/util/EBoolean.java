/**
 * 
 */
package com.wat.parsermap.util;
 
public class EBoolean {
	
	private boolean r;
	
	private String message;
	
	public EBoolean() {
		r = false;
	}
	
	public EBoolean(boolean result) {
		r = result;
	}
	
	public EBoolean(boolean result, String msg) {
		r = result;
		message = msg;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void addMessage(String message) {
		if (this.message == null) {
			this.message = "";
		}
		
		this.message += message;
	}
	
	public boolean isRight() {
		return r;
	}
	
	public void setResult(boolean result) {
		r = result;
	}

}
