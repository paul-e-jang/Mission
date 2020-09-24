package com.sjwp.mission.apis.payload;


import javax.validation.constraints.NotNull;

public class LogsPayload {
	
	@NotNull
	String UserCode;
	@NotNull
	String Name;
	
	public String getUserCode() {
		return UserCode;
	}
	public void setUserCode(String userCode) {
		UserCode = userCode;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
