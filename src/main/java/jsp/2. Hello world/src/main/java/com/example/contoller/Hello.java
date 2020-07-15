package com.example.contoller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
class Hello {
	@RequestMapping("/hello")
	public String getHello(){
		return "home/hello";
	}
}





