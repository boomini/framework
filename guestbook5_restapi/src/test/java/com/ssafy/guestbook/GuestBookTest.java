package com.ssafy.guestbook;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.service.GuestBookService;

public class GuestBookTest  extends UnitTestConfig{
	private final Logger logger = LoggerFactory.getLogger(GuestBookTest .class);
	
	@Autowired
	private GuestBookService guestBookService;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("----------------- test class start----------------");
	}
	

	@AfterClass
	public static void afterClass() {
		System.out.println("----------------- test class end----------------");
	}
	
	@Before
	public void before() {
		System.out.println("----------------- test method start----------------");
	}
	@After
	public void after() {
		System.out.println("----------------- test mehotd end----------------");
	}
	@Test
	@Ignore
	public void listTest() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pg", "1");
		map.put("spp", "5");
		map.put("key", "");
		map.put("word", "");
		List<GuestBookDto> list = guestBookService.listArticle(map);
		assertEquals(5,list.size());
		logger.debug("list: {}",list);
	}
	
	@Test
	public void updateTest() throws Exception {
		GuestBookDto guestBookDto = new GuestBookDto();
		guestBookDto.setArticleNo(1);
		guestBookDto.setSubject("제목 바꿔요!!!");
		guestBookDto.setContent("제목 바꿔요!!!");
		guestBookService.updateArticle(guestBookDto);
	}
}
