package com.sjwp.mission.apis;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;
import com.sjwp.mission.config.security.CurrentUser;
import com.sjwp.mission.domain.model.log.Logs;
import com.sjwp.mission.domain.model.log.LogsService;
import com.sjwp.mission.domain.model.member.SimpleMember;

public class LogsApiController {
	
	LogsService service;
	
	public LogsApiController(LogsService service) {
		super();
		this.service = service;
	}
	
    @GetMapping(value="/api/fetchLogs")
    @ResponseBody
    public List<Logs> fetchLogs() {
    	return service.findAll();
    }
    
    @PostMapping(value="/api/loginReg")
    @ResponseBody
    public ResponseEntity<ApiResult> loginReg(@CurrentUser SimpleMember member) {
    	Logs logs = Logs.Create(member.getUsername(), member.getName());
    	service.save(logs);
    	return Result.created();
    }
    
    @PostMapping(value="/api/logOutReg")
    @ResponseBody
    public ResponseEntity<ApiResult> logOutReg(@CurrentUser SimpleMember member) {
    	service.afterLogout(member.getUsername());
    	return Result.ok();
    }

}
