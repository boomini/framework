package com.ssafy.hw2.service;

import java.util.List;
import java.util.Map;

import com.ssafy.hw2.model.CateVO;
import com.ssafy.hw2.model.ItemVO;

public interface GoodsService {
	List<ItemVO> list() throws Exception;
	List<CateVO> listCate(Map<String, Object> map) throws Exception;
	void insert(ItemVO item) throws Exception;
	boolean modify(Map<String,Object> map) throws Exception;
	ItemVO getItem(int seq)  throws Exception ; 
	int login(Map<String, String> map) throws Exception;
	void delete(List<String> del)throws Exception;
	void modify(ItemVO item)throws Exception;
}
