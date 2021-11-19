package com.ssafy.product.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.product.model.Phone;
import com.ssafy.product.service.IPhoneService;

@Controller
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	IPhoneService phoneservice;
	
	@GetMapping("/register")
	public String register() {
		return "phone/PhoneReg";
	}
	
	@GetMapping("/list")
	public ModelAndView list() throws Exception{

		ModelAndView mav = new ModelAndView();
		List<Phone> list = phoneservice.list();
		System.out.println(list);
		mav.addObject("phoneList",list);
		mav.setViewName("phone/PhoneList");
		return mav;
	}
	
	@GetMapping("/result")
	public String result() {
		return "phone/Result";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam Map<String,String> map) throws Exception{
		System.out.println("register 등록" + map);
		phoneservice.insert(map);
		return "redirect:/phone/Result";		
	}
	
	@GetMapping("/view")
	public ModelAndView viewone(@RequestParam("num") String num) throws Exception{
		ModelAndView mav = new ModelAndView();
		Phone phone = phoneservice.viewone(num);
		System.out.println(phone.toString());
		mav.addObject("phone",phone);
		mav.setViewName("phone/PhoneView");
		return mav;
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("num") String num) throws Exception{

		phoneservice.delete(num);
		return "redirect:/phone/list";
	}
	
	@GetMapping("/login")
	public String login() throws Exception{
		return "phone/login";		
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String,String> map, HttpSession session,Model model) throws Exception{
		String userid = (String) map.get("userid");
		try {
			if(phoneservice.login(map)) {
				session.setAttribute("userinfo", userid);
				return "redirect:/";
			}else {
				model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
				return "phone/login";
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
