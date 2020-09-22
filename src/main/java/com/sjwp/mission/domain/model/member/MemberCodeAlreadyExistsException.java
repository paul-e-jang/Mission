package com.sjwp.mission.domain.model.member;

public class MemberCodeAlreadyExistsException extends MemberRegistrationException{
	
	private static final long serialVersionUID = 5779231407690011443L;
	
	String message;
	
	MemberCodeAlreadyExistsException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
