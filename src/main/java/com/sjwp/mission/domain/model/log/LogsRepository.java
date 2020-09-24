package com.sjwp.mission.domain.model.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LogsRepository extends JpaRepository<Logs, Long> {
	
    @Query(value="update logs set log_outed_at=sysdate where id = (select max(id) from logs where user_code=:user_code)", nativeQuery=true)
    public Logs afterLogout( @Param("user_code") String userCode);
}
