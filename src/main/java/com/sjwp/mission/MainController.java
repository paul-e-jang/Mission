package com.sjwp.mission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping(value="/")
	public String restTest() {
		return "static/index.html";
	}

}
