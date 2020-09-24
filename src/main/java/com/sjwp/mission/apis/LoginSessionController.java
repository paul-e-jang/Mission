package com.sjwp.mission.apis;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sjwp.mission.config.security.CurrentUser;
import com.sjwp.mission.domain.model.member.SimpleMember;

@Controller
public class LoginSessionController {
	

    @RequestMapping(value="/api/user", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getCurrentMemberJson(Model model, @CurrentUser SimpleMember user) {
      	
    	String currentUser = "Guest";
    	
    	if (user != null) {
    		currentUser = user.getName();
        	model.addAttribute("user", currentUser);
            model.addAttribute("authenticated", true);
    	}
        
        return "toJson";
    }

}
