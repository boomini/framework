package com.ssafy.hw2.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.hw2.model.CateVO;
import com.ssafy.hw2.model.ItemVO;

public interface GoodsDAO {
	List<ItemVO> list() throws Exception;
	List<CateVO> listCate(Map<String, Object> map ) throws Exception;
	int insert(Map<String, Object> map ) throws Exception;
	int modify(Map<String, Object> map ) throws Exception;
}
