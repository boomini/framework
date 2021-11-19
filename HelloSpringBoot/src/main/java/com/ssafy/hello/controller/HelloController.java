package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/hsb")
	public String hello(Model model) {
		System.out.println("여기오나?");
		model.addAttribute("msg", "안녕하세요 ㅅ프링부트!1");
		return "hello";
	}
	
	@GetMapping("/rest")
	@ResponseBody
	public String hello() {
		return "Spring Boot Rest call!!!";
	}
}
