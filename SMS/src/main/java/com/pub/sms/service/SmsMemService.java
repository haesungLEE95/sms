package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsMem;

public interface SmsMemService {

	SmsMem select(String mem_id);

	int insert(SmsMem mem);

	

	
	
}
