package com.sjwp.mission.apis.payload;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class LogsPayload {
	
	@NotNull
	String UserCode;
	@NotNull
	String Name;
	@NotNull
	Date logInAt;
	@NotNull
	Date logOuttedAt;
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
	public Date getLogInAt() {
		return logInAt;
	}
	public void setLogInAt(Date logInAt) {
		this.logInAt = logInAt;
	}
	public Date getLogOuttedAt() {
		return logOuttedAt;
	}
	public void setLogOuttedAt(Date logOuttedAt) {
		this.logOuttedAt = logOuttedAt;
	}
	
	
	

}
