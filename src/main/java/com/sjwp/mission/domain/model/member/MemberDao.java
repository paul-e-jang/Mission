package com.sjwp.mission.domain.model.member;

import java.util.List;

public interface MemberDao {

    Member store(Member course);

    void delete(Long courseId);

    Member findById(Long courseId);

    List<Member> findAll();
}
