package com.sjwp.mission.domain.model.log;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LogsService {
	
	@Autowired
	LogsRepository repo;

    public List<Logs> findAll(){
    	return repo.findAllByOrderByIdDesc();
    }
    
	public Logs save(Logs logs) {
		return repo.save(logs);
	}
	
	public Logs afterLogout(String userCode) {
		Logs log = repo.findByUserCode(userCode);
		log.setLogOuttedAt(new Date());
		return repo.save(log);
	}
}
