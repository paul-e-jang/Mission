package com.sjwp.mission.apis.authentication;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sjwp.mission.config.security.CurrentUser;
import com.sjwp.mission.domain.model.log.LogsService;
import com.sjwp.mission.domain.model.member.SimpleMember;

public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	LogsService service;
	
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                      Authentication authentication) throws IOException {
    response.setStatus(HttpStatus.OK.value());
  }
  
  public static SimpleMember getSimpleMember(@CurrentUser SimpleMember member) {
	return member;
  }
}
