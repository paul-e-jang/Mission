package com.sjwp.mission.domain.model.member;

public class EmailAddressAlreadyExistsException extends MemberRegistrationException {
	
	String message;
	
	EmailAddressAlreadyExistsException(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3559394921268052226L;

}
