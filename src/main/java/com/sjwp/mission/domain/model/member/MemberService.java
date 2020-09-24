package com.sjwp.mission.domain.model.member;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MemberService implements MemberDetailService {
	
	@Autowired
	MemberRepository memberRepository;

	public Member save(Member member) {
		return memberRepository.save(member);
	}

    public void delete(Long memberId) {
    	memberRepository.deleteById(memberId);
    }

    public List<Member> findAll(){
    	return (List<Member>) memberRepository.findAll();
    }
    
    public boolean existsByUsernameOrEmailAddress(String username, String emailAddress){
    	return memberRepository.existsByUsernameOrEmailAddress(username, emailAddress);
    }
    
    
    public Optional<Member> findByUsername(String username) {
    	return memberRepository.findByUsername(username);
    }
    
    public Optional<Member> findByEmailAddress(String emailAddress) {
    	return memberRepository.findByEmailAddress(emailAddress);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    if (StringUtils.isEmpty(username)) {
	      throw new UsernameNotFoundException("등록되지 않은 사용자입니다.");
	    }	
	    	Optional<Member> member = username.contains("@")?
	    			memberRepository.findByEmailAddress(username) : memberRepository.findByUsername(username);
	    	if(member.isPresent()) {
	    		Member newMember = member.get();
	    		return new SimpleMember(newMember);
	    	}else {
	    		throw new UsernameNotFoundException("등록되지 않은 사용자입니다.");
	    	}
	}
}
