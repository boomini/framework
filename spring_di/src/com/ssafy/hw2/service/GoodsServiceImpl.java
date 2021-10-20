package com.ssafy.hw2.service;

import java.util.List;
import java.util.Map;

import com.ssafy.hw2.dao.GoodsDAOImpl;
import com.ssafy.hw2.dao.GoodsDAO;
import com.ssafy.hw2.model.CateVO;
import com.ssafy.hw2.model.ItemVO;

public class GoodsServiceImpl implements GoodsService{
	GoodsDAO goodsdao;
	private GoodsServiceImpl(GoodsDAO goodsdao ) {
		this.goodsdao=goodsdao;
	}
	

	@Override
	public List<ItemVO> list() throws Exception {
		return goodsdao.list();
	}

	@Override
	public List<CateVO> listCate(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return goodsdao.listCate(map);
	}

	@Override
	public String insert(Map<String, Object> map) throws Exception {
		int status = goodsdao.insert(map);
		return "";
	}

	@Override
	public boolean modify(Map<String, Object> map) throws Exception {
		int status = goodsdao.modify(map);	
		return true;
	}

}
