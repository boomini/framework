package com.ssafy.test.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.test.model.PhoneDto;
import com.ssafy.test.model.UserInfoDto;

public interface PhoneMapper {
	UserInfoDto login(Map<String, String> map) throws Exception;
	void registerPhone(PhoneDto phoneDto) throws Exception;
	List<PhoneDto> listPhone() throws Exception;
	PhoneDto getPhone(String num) throws Exception;
	void deletePhone(String num) throws Exception;
}
