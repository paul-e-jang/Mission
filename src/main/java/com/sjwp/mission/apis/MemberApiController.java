package com.sjwp.mission.apis;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sjwp.mission.apis.payload.MemberRegistrationPayload;
import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;
import com.sjwp.mission.domain.model.member.MemberAlreadyExistsException;
import com.sjwp.mission.domain.model.member.MemberRegistrationException;
import com.sjwp.mission.domain.model.member.MemberRegistrationManagement;
import com.sjwp.mission.domain.model.member.MemberService;

import javax.validation.Valid;

@Controller
public class MemberApiController {

  private MemberService service;
  private MemberRegistrationManagement management;

  public MemberApiController(MemberService service, MemberRegistrationManagement management) {
    this.service = service;
    this.management = management;
  }

  @PostMapping("/api/registrations")
  public ResponseEntity<ApiResult> register(@Valid @RequestBody MemberRegistrationPayload payload) throws MemberRegistrationException {
    try {
      management.register(payload.getMemberCode(), payload.getPassword(), payload.getEmailAddress(), payload.getName());
      return Result.created();
    } catch (MemberRegistrationException e) {
      String errorMessage = "오류 발생";
      
      if(e instanceof MemberAlreadyExistsException) {
    	  errorMessage = e.getMessage();
      }
      
      return Result.failure(errorMessage);
    }
  }
}
