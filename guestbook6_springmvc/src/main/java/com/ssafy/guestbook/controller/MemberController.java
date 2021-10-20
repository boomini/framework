package com.ssafy.guestbook.controller;


import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/register")
	public String register() {
		return "user/join";
	}
	
	@PostMapping("/register")
	public String register(MemberDto memberDto, Model model) {

		logger.debug("memberDto info : {}", memberDto);
		ModelAndView mav = new ModelAndView("");
		//model : data
		//view : view
		try {
			memberService.registerMember(memberDto);
			return "redirect:/user/login";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 가입 중 문제 발생!!!");
			return "error/error";
		}
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
		logger.debug("map:{}", map.get("userId"));
		try {
			MemberDto memberDto = memberService.login(map);
			if(memberDto!=null) {
				session.setAttribute("userinfo", memberDto);
				Cookie cookie = new Cookie("ssafy_id", map.get("userId"));
				cookie.setPath("/");
				if("saveok".equals(map.get("idsave"))) {
					cookie.setMaxAge(60*60*24*365*40);
				}else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
				return "redirect:/";
			}else {
				model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
				return "user/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}