package com.sjwp.mission.domain.model.member;

public class MemberAlreadyExistsException extends MemberRegistrationException{
	
	private static final long serialVersionUID = 5779231407690011443L;
	
	String message;
	
	MemberAlreadyExistsException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
