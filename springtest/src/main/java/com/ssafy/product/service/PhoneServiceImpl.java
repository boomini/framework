package com.ssafy.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dao.IPhoneDAO;
import com.ssafy.product.model.Phone;

@Service
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	IPhoneDAO phonedao;
	
	private PhoneServiceImpl(IPhoneDAO phonedao ) {
		this.phonedao = phonedao;
	}
	
	@Override
	public void insert(Map<String, String> map) throws Exception {
		phonedao.insert(map);
		
	}

	@Override
	public List<Phone> list() throws Exception {
		return phonedao.list();
	}

	@Override
	public Phone viewone(String num) throws Exception {
		return phonedao.viewone(num);
	}

	@Override
	public void delete(String num) throws Exception {
		phonedao.delete(num);
		
	}

	@Override
	public boolean login(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return phonedao.login(map);
	}

}
