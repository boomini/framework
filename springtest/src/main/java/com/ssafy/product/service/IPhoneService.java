package com.ssafy.product.service;

import java.util.List;
import java.util.Map;

import com.ssafy.product.model.Phone;

public interface IPhoneService {

	void insert(Map<String,String> map) throws Exception;
	List<Phone> list()throws Exception;
	Phone viewone(String num) throws Exception;
	void delete(String num)throws Exception;
	boolean login(Map<String, String> map) throws Exception;
}
