package com.ssafy.guestbook;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.MemberService;


public class MemberTest extends UnitTestConfig{
	private final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	
	
	@Autowired
	private MemberService memberService;
	
	@Test
	@Ignore
	public void nullTest() {
//		if(memberService != null) {
//			logger.debug("memberService : {}", memberService);
//		}
		
		//assertNull(memberService);
		assertNotNull(memberService);
	}
	
	@Test
	@Ignore
	public void dbConnectionTest() throws SQLException{
		DataSource dataSource = context.getBean(DataSource.class);
		Connection conn = dataSource.getConnection();
		logger.debug("Connection : {}", conn) ;
	}
	
	@Test
	public void login() throws Exception{
		Map<String,String> map= new HashMap<String, String>();
		map.put("userId", "ssafy");
		map.put("userPwd", "ssafy");
		MemberDto memberDto = memberService.login(map);
		logger.debug("memberDto : {}", memberDto);
	}
}
