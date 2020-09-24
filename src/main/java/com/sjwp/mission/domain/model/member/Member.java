package com.sjwp.mission.domain.model.member;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sjwp.mission.domain.model.AbstractBaseEntity;


@Entity
@Table(name = "Member")
public class Member extends AbstractBaseEntity{
	
	static final long serialVersionUID = 2826879243205409697L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERNAME", length = 20)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "EMAIL_ADDRESS", nullable = false, length = 50)
    private String emailAddress;
    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    public Member() {
    }

    public static Member create(String username, String password, String emailAddress, String name) {
    	Member member = new Member();
        member.username = username;
        member.password = password;
        member.emailAddress = emailAddress;
        member.name = name;
        return member;
    }



    public Long getId() {
		return id;
	}
    
    public MemberId getMemberId() {
		return new MemberId(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return "Course [" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", emailAddress=" + emailAddress +
                ", name=" + name +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member course = (Member) o;
        return name == course.name &&
                Objects.equals(username, course.username) &&
                Objects.equals(password, course.password) &&
                Objects.equals(emailAddress, course.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, emailAddress, name);
    }
}
