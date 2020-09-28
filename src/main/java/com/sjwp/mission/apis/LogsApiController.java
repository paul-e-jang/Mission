package com.sjwp.mission.apis;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjwp.mission.apis.result.ApiResult;
import com.sjwp.mission.apis.result.Result;
import com.sjwp.mission.config.security.CurrentUser;
import com.sjwp.mission.domain.model.log.Logs;
import com.sjwp.mission.domain.model.log.LogsService;
import com.sjwp.mission.domain.model.member.SimpleMember;

@Controller
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
    public ResponseEntity<ApiResult> loginReg(@CurrentUser SimpleMember member, HttpServletRequest req) {
    	String sid = req.getSession().getId();
    	Optional<Logs> log = service.findFirstBySessionId(sid);
    	if(!log.isPresent()) {
    	Logs logs = Logs.Create(member.getUsername(), member.getName(), req.getSession().getId());
    	service.save(logs);
    	}
    	return Result.created();
    }
    
    @PutMapping(value="/api/logOutReg")
    @ResponseBody
    public String logOutReg(@CurrentUser SimpleMember member, HttpServletRequest req) {
    	service.Logout(req.getSession().getId());
    	return "redirect:/logout";
    }

}
