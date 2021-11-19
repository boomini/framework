package com.ssafy.product.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.product.model.Phone;

public interface IPhoneDAO {
	void insert(Map<String, String> map) throws Exception;
	List<Phone> list()throws Exception;
	void delete(String num)throws Exception;
	Phone viewone(String num) throws Exception;
	boolean login(Map<String, String> map) throws Exception;
}
