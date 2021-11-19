package com.ssafy.hw2.service;

import java.util.List;
import java.util.Map;

import com.ssafy.hw2.model.CateVO;
import com.ssafy.hw2.model.ItemVO;

public interface GoodsService {
	List<ItemVO> list() throws Exception;
	List<CateVO> listCate(Map<String, Object> map) throws Exception;
	String insert(Map<String,Object> map) throws Exception;
	boolean modify(Map<String,Object> map) throws Exception; 
}
