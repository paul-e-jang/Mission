package com.sjwp.mission.domain.model.log;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LogsRepository extends JpaRepository<Logs, Long> {
	
	@Query(value="select * from logs L where L.user_code=:user_code and L.log_outed_at is null", nativeQuery = true)
    public Logs findByUserCode(@Param(value = "user_code") String userCode);
    
    @Transactional
    @Modifying
    @Query(value="update logs L set L.log_outed_at = sysdate where L.user_code=:user_code and L.log_outed_at is null", nativeQuery = true)
    int setLogOutTime(@Param(value = "user_code") String userCode);
    
    
    public List<Logs> findAllByOrderByIdDesc();
    
}
