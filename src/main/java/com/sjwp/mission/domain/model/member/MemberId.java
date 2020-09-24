package com.sjwp.mission.domain.model.member;

import com.sjwp.mission.domain.model.AbstractBaseId;

public class MemberId extends AbstractBaseId{
	
  private static final long serialVersionUID = -3316570974935023332L;

  public MemberId(long id) {
    super(id);
  }

  public String toString() {
    return String.valueOf(value());
  }
}
