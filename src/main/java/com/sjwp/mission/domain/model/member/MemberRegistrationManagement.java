package com.sjwp.mission.domain.model.member;


import org.springframework.stereotype.Component;
import com.sjwp.mission.config.security.PasswordEncryptor;

@Component
public class MemberRegistrationManagement {

	  private MemberService service;
	  private PasswordEncryptor passwordEncryptor;

	  public MemberRegistrationManagement(MemberService service, PasswordEncryptor passwordEncryptor) {
	    this.service = service;
	    this.passwordEncryptor = passwordEncryptor;
	  }

	  public void register(String memberCode, String password, String emailAddress, String name)
	    throws MemberRegistrationException {
		  if(service.existsByMemberCodeOrEmailAddress(memberCode, emailAddress)) {
			 throw new MemberAlreadyExistsException("이메일이나 아이디가 이미 등록되어있습니다.");
		  }else {
			  String encryptedPassword = passwordEncryptor.encrypt(password);
			  Member newMember = Member.create(memberCode, encryptedPassword, emailAddress, name);
			  service.save(newMember);
		  }
	  }
  }

