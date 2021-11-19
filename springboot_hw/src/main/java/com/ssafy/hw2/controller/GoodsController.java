package com.ssafy.hw2.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.hw2.model.FileInfo;
import com.ssafy.hw2.model.ItemVO;
import com.ssafy.hw2.service.GoodsService;
import com.ssafy.hw2.util.Uploader;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/goods")
@Api("Homework API")
public class GoodsController {
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	@Autowired
	GoodsService goodsService;
	
	@GetMapping("/register")
	public String register() {
		return "goods/register";
	}
	
	@PostMapping("/register")
	public String register(ItemVO item, @RequestParam("upfile") MultipartFile[] files, HttpServletRequest request, RedirectAttributes redirectAttributest) throws Exception{
		logger.debug("register item: {}", item);
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		if(!files[0].isEmpty()) {
			for(MultipartFile mfile: files) {
				FileInfo cfile = new FileInfo();
				cfile.setFile_name(mfile.getOriginalFilename());
				cfile.setPhoto_seq(item.getSeq());
				cfile.setFile_size(mfile.getSize());
				Map<String, String> upload = Uploader.uploadFile(mfile, request);
				cfile.setFile_path_org(upload.get("filePathOrg"));
				cfile.setFile_path_thumb(upload.get("filePathThumb"));
				fileInfos.add(cfile);
				System.out.println(cfile);
			}
			System.out.println(fileInfos);
			item.setFileInfos(fileInfos);
			System.out.println(item);
		}
		
		goodsService.insert(item);
		redirectAttributest.addFlashAttribute("msg", "글작성 성공!!!");
		return "redirect:/goods/list";		
	}
	
	@ApiOperation(value = "상품 목록", notes="<b>상품 목록</b>을 리턴")
	@ApiResponses({
		@ApiResponse(code = 200, message="성공!!!"),
		@ApiResponse(code = 404, message="not found page!!!"),
		@ApiResponse(code = 500, message="server error!!!")
	})
	@RequestMapping(value = "/", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public @ResponseBody List<ItemVO> userList() throws Exception {
		List<ItemVO> list = goodsService.list();
		logger.debug("회원목록 : {}", list);
		return list;
//		return memberService.listMember();
	}
	@GetMapping("/modify")
	public ModelAndView modify(@RequestParam("seq") int seq) throws Exception {
		ModelAndView mav = new ModelAndView();
		ItemVO itemvo = goodsService.getItem(seq);
		mav.addObject("itemvo",itemvo);
		mav.setViewName("goods/modify");
		return mav;
	}
	
	@PostMapping("/modify")
	public String modify(ItemVO item, RedirectAttributes redirectAttributest) throws Exception{
		goodsService.modify(item);
		redirectAttributest.addFlashAttribute("msg", "글수정 성공!!!");
		return "redirect:/goods/list";		
	}
	
	@GetMapping("/login")
	public String login() throws Exception{
		return "goods/login";		
	}
	@GetMapping("/list")
	public String golist() throws Exception{
		return "goods/list";		
	}
	@PostMapping("/login")
	public String login(@RequestParam Map<String,String> map, HttpSession session,Model model) throws Exception{
		logger.debug("map:{}", map.get("userid"));
		String userid = (String) map.get("userid");
		try {
			if(goodsService.login(map)==1) {
				session.setAttribute("userinfo", userid);
				return "redirect:/";
			}else {
				model.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
				return "goods/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}	
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";		
	}
	
	@PostMapping("/delete")
	public String delete(String[] delch) throws Exception{
		List<String> del = Arrays.asList(delch);
		goodsService.delete(del);
		return "redirect:/goods/list";		
	}

}
