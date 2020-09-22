package com.sjwp.mission.domain.model.member;

import java.util.List;

public interface MemberService {

    Member store(Member member);

    void delete(Long memberId);

    Member findById(Long memberId);

    List<Member> findAll();
}
