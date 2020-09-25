package com.sjwp.mission.domain.model.log;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sjwp.mission.domain.model.AbstractBaseEntity;


@Entity
@Table(name = "Logs")
public class Logs extends AbstractBaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7378280742268000546L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_CODE", length = 100, nullable = false)
    private String userCode;
    @Column(name = "Name")
    private String Name;
    
    @Column(name = "LOG_IN_AT")
    private Date logInAt;
    
    @Column(name = "LOG_OUTED_AT", nullable = true)
    private Date logOuttedAt;

    public Logs() {
    }

    public Logs(String userCode, String Name) {
        this.userCode = userCode;
        this.Name = Name;
        this.logInAt = new Date();
    }
    
    public static Logs Create(String userCode, String Name) {
    	Logs logs = new Logs();
        logs.userCode = userCode;
        logs.Name = Name;
        logs.logInAt = new Date();
        return logs;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getLogInAt() {
		return logInAt;
	}

	public void setLogInAt(Date logInAt) {
		this.logInAt = logInAt;
	}

	public Date getLogOuttedAt() {
		return logOuttedAt;
	}

	public void setLogOuttedAt(Date logOuttedAt) {
		this.logOuttedAt = logOuttedAt;
	}

	@Override
    public String toString() {
        return "Course [" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", Name=" + Name +
                ", logInAt=" + logInAt +
                ", logOuttedAt=" + logOuttedAt +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logs logs = (Logs) o;
        return id ==  logs.id&&
                Objects.equals(userCode, logs.userCode) &&
                Objects.equals(Name, logs.Name) &&
                Objects.equals(logInAt, logs.logInAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userCode, Name, logInAt, logOuttedAt);
    }
}
