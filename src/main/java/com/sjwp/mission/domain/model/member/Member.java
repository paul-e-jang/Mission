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
    /**
	 * 
	 */
	private static final long serialVersionUID = -6118481297088751224L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "MEMBER_CODE", length = 20, nullable = false)
    private String memberCode;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "EMAIL_ADDRESS", nullable = false, length = 50)
    private String emailAddress;
    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

    public Member() {
    }

    public static Member create(String memberCode, String password, String emailAddress, String name) {
    	Member member = new Member();
        member.memberCode = memberCode;
        member.password = password;
        member.emailAddress = emailAddress;
        member.name = name;
        return member;
    }



    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getpassword() {
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
                ", memberCode='" + memberCode + '\'' +
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
                Objects.equals(memberCode, course.memberCode) &&
                Objects.equals(password, course.password) &&
                Objects.equals(emailAddress, course.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberCode, password, emailAddress, name);
    }
}
