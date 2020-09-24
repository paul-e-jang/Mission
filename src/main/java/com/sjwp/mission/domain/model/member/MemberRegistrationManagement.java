package com.sjwp.mission.domain.model.member;

import java.util.Optional;

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
		  if(service.existsByMemberCode(memberCode)) {
			  throw new MemberCodeAlreadyExistsException("이미 등록된 아이디입니다.");
		  } if(service.existsByEmailAddress(emailAddress)) {
			  throw new EmailAddressAlreadyExistsException("이미 등록된 이메일입니다.");
		  }
			  String encryptedPassword = passwordEncryptor.encrypt(password);
			  Member newMember = Member.create(memberCode, encryptedPassword, emailAddress, name);
			  service.save(newMember);
	  }
  }

