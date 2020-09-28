package com.sjwp.mission.apis.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.sjwp.mission.domain.model.log.LogsService;
import com.sjwp.mission.domain.model.member.SimpleMember;

public class SimpleLogoutHandler implements LogoutHandler {
	
	@Autowired
	LogsService service;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		
		SimpleMember currentMember = (SimpleMember) authentication.getPrincipal();
		service.afterLogout(currentMember.getName());
		
	}

}
