package com.ssafy.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.hw2.model.ItemVO;
import com.ssafy.hw2.service.GoodsService;
import com.ssafy.hw2.service.GoodsServiceImpl;

public class GoodsMain {
	public static void main(String[] args) { //		com/ssafy/configuration/applicationContext.xml 설정
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/configuration/applicationContext.xml");
		GoodsService goodsService= context.getBean("gService", GoodsServiceImpl.class);
		try {
			List<ItemVO> list = goodsService.list();
			for(ItemVO item : list) {
				System.out.println(item);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
