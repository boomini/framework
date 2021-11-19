package com.ssafy.hw2.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.hw2.model.CateVO;
import com.ssafy.hw2.model.ItemVO;

public interface GoodsDAO {
	List<ItemVO> list() throws Exception;
	List<CateVO> listCate(Map<String, Object> map ) throws Exception;
	void insert(ItemVO item) throws Exception;
	int modify(Map<String, Object> map ) throws Exception;
	ItemVO getItem(int seq)  throws Exception ;
	int login(Map<String, String> map) throws Exception;
	void delete(List<String> del) throws Exception;
	void modify(ItemVO item)throws Exception;
	void insertFile(ItemVO item) throws Exception;
}
