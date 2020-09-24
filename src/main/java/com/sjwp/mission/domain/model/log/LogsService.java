package com.sjwp.mission.domain.model.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogsService {
	
	@Autowired
	LogsRepository repo;

    public List<Logs> findAll(){
    	return (List<Logs>) repo.findAll();
    }
}
