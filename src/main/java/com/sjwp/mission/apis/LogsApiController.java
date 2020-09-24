package com.sjwp.mission.apis;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjwp.mission.domain.model.log.Logs;
import com.sjwp.mission.domain.model.log.LogsService;

public class LogsApiController {
	
	LogsService service;
	
	public LogsApiController(LogsService service) {
		super();
		this.service = service;
	}
	
    @GetMapping(value="/api/fetchLogs")
    @ResponseBody
    public List<Logs> fetchLogs() {
    	return (List<Logs>) service.findAll();
    }

}
