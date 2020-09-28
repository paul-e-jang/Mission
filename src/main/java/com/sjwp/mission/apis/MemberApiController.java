package com.sjwp.mission.apis;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.DefaultToken;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sjwp.mission.apis.payload.MemberRegistrationPayload;
import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;
import com.sjwp.mission.config.security.CurrentUser;
import com.sjwp.mission.domain.model.member.MemberAlreadyExistsException;
import com.sjwp.mission.domain.model.member.MemberRegistrationException;
import com.sjwp.mission.domain.model.member.MemberRegistrationManagement;
import com.sjwp.mission.domain.model.member.MemberService;
import com.sjwp.mission.domain.model.member.SimpleMember;

import javax.validation.Valid;

@RestController
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
      management.register(payload.getUsername(), payload.getPassword(), payload.getEmailAddress(), payload.getName());
      return Result.created();
    } catch (MemberRegistrationException e) {
      String errorMessage = "오류 발생";
      
      if(e instanceof MemberAlreadyExistsException) {
    	  errorMessage = e.getMessage();
      }
      
      return Result.failure(errorMessage);
    }
  }
  
  @RequestMapping(value="/api/user", produces= MediaType.APPLICATION_JSON_VALUE)
  public String getCurrentMemberJson(@CurrentUser SimpleMember user) {
    	
  	String currentUser = "Guest";
  	Gson gson = new Gson();
  	JsonObject json = new JsonObject();
  	
  	if (!user.getName().equals("GUEST")) {
  		currentUser = user.getName();
          json.addProperty("user", currentUser);
          json.addProperty("authenticated", true);
  	}
      
      return gson.toJson(json);
  }
}
