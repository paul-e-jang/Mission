package com.sjwp.mission.domain.model;

import java.io.Serializable;

public abstract class AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = -6902541159525766957L;

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}
