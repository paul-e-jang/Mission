package com.sjwp.mission.domain.model.member;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Article")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "STUDENT_CODE", length = 20, nullable = false)
    private String studentCode;
    @Column(name = "PASSWORD", nullable = false, length = 20)
    private int password;
    @Column(name = "EMAIL_ADDRESS", nullable = false, length = 50)
    private String emailAddress;
    @Column(name = "NAME", nullable = false, length = 20)
    private Date name;

    public Member() {
    }

    public Member(String studentCode, int password, String emailAddress, Date name) {
        this.studentCode = studentCode;
        this.password = password;
        this.emailAddress = emailAddress;
        this.name = name;
    }



    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getstudentCode() {
		return studentCode;
	}

	public void setstudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public int getpassword() {
		return password;
	}

	public void setpassword(int password) {
		this.password = password;
	}

	public String getemailAddress() {
		return emailAddress;
	}

	public void setemailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getname() {
		return name;
	}

	public void setname(Date name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return "Course [" +
                "id=" + id +
                ", studentCode='" + studentCode + '\'' +
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
                Objects.equals(studentCode, course.studentCode) &&
                Objects.equals(password, course.password) &&
                Objects.equals(emailAddress, course.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentCode, password, emailAddress, name);
    }
}
