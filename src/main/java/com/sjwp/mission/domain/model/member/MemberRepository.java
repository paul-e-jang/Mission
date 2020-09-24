package com.sjwp.mission.domain.model.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Optional<Member> findByUsername(String username);
	Optional<Member> findByEmailAddress(String emailAddress);
	boolean existsByUsernameOrEmailAddress(String username, String emailAddress);
}
