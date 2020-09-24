package com.sjwp.mission.apis.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class MemberRegistrationPayload {

  @Size(min = 2, max = 20, message = "아이디는 최소 2글자, 최대 20글자 입니다.")
  @NotNull
  private String memberCode;
  
  @Size(min = 10, max = 20, message = "패스워드는 최소 10글자, 최대 20자입니다.")
  @NotNull
  private String password;

  @Email(message = "이메일 주소가 유효하지 않습니다.")
  @Size(max = 50, message = "이메일 주소는 50글자를 초과할 수 없습니다.")
  @NotNull
  private String emailAddress;

  
  @Size(max = 20, message = "이름은 최대 20글자 입니다.")
  @NotNull
  private String name;


public String getMemberCode() {
	return memberCode;
}


public void setMemberCode(String memberCode) {
	this.memberCode = memberCode;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getEmailAddress() {
	return emailAddress;
}


public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}
  
  

}
