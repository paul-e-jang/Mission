package com.sjwp.mission.domain.model.member;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class SimpleMember implements UserDetails, Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 5157621489865838758L;
/* Authentication을 위한 읽기전용 객체 */

  private MemberId memberId;
  private String username;
  private String password;
  private String name;
  private String emailAddress;

  public SimpleMember(Member member) {
    this.memberId = member.getMemberId();
    this.username = member.getUsername();
    this.password = member.getPassword();
    this.name = member.getName();
    this.emailAddress = member.getEmailAddress();
  }

  public MemberId getMemberId() {
    return memberId;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }
    

  public String getName() {
	return name;
  }

  public String getEmailAddress() {
	return emailAddress;
  }

@Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SimpleMember)) return false;
    SimpleMember that = (SimpleMember) o;
    return Objects.equals(username, that.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberId);
  }

  @Override
  public String toString() {
    return "SimpleMember{" +
      "memberId=" + memberId +
      ", membername='" + username + '\'' +
      ", password=[Protected]" +
      ", name='" + name + '\'' +
      ", emailAddress='" + emailAddress + '\'' +
      '}';
  }
}
