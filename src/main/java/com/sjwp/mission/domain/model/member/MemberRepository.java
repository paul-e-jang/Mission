package com.sjwp.mission.domain.model.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Optional<Member> findByMemberCode(String memberCode);
	Optional<Member> findByEmailAddress(String emailAddress);
	boolean existsByMemberCodeOrEmailAddress(String memberCode, String emailAddress);
}
