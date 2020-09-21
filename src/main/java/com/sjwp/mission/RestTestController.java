package com.sjwp.mission;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class RestTestController {
	
	@RequestMapping(value="/resttest", produces=MediaType.APPLICATION_JSON_VALUE)
	public String restTest() {
		JsonObject json = new JsonObject();
		json.addProperty("이름", "장은학");
		
		return json.toString();
	}

}
