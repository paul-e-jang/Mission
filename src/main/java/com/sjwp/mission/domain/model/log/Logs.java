package com.sjwp.mission.domain.model.log;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sjwp.mission.domain.model.AbstractBaseEntity;


@Entity
@Table(name = "Logs")
public class Logs extends AbstractBaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7069790312811582251L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USER_CODE", length = 100, nullable = false)
    private String UserCode;
    @Column(name = "Name")
    private String Name;
    @Column(name = "LOG_IN_AT")
    private Date logInAt;
    @Column(name = "LOG_OUTED_AT")
    private Date logOuttedAt;

    public Logs() {
    }

    public Logs(String UserCode, String Name, Date logInAt, Date logOuttedAt) {
        this.UserCode = UserCode;
        this.Name = Name;
        this.logInAt = logInAt;
        this.logOuttedAt = logOuttedAt;
    }



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserCode() {
		return UserCode;
	}

	public void setUserCode(String userCode) {
		UserCode = userCode;
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
                ", UserCode='" + UserCode + '\'' +
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
                Objects.equals(UserCode, logs.UserCode) &&
                Objects.equals(Name, logs.Name) &&
                Objects.equals(logInAt, logs.logInAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserCode, Name, logInAt, logOuttedAt);
    }
}
