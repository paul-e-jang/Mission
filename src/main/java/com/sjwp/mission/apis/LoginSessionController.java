package com.sjwp.mission.apis;


import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sjwp.mission.config.security.CurrentUser;
import com.sjwp.mission.domain.model.member.SimpleMember;

@RestController
public class LoginSessionController {
	

    @RequestMapping(value="/api/user", produces= MediaType.APPLICATION_JSON_VALUE)
    public String getCurrentMemberJson(@CurrentUser SimpleMember user) {
      	
    	String currentUser = "Guest";
    	Gson gson = new Gson();
    	JsonObject json = new JsonObject();
    	
    	if (user != null) {
    		currentUser = user.getName();
            json.addProperty("user", currentUser);
            json.addProperty("authenticated", true);
    	}
        
        return gson.toJson(json);
    }

}
