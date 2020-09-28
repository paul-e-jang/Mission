package com.sjwp.mission.domain.model.log;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
	
	public Optional<Logs> findFirstBySessionId(String sessionId) {
		return repo.findFirstBySessionId(sessionId);
	}
	
	public void Logout(String sessionId) {
		Optional<Logs> logs = repo.findFirstBySessionId(sessionId);
		logs.ifPresent(e -> {
			e.setLogOuttedAt(new Date());
			repo.save(e);
		});
	}
}
