package com.pub.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsMemDao;
import com.pub.sms.model.SmsMem;

@Service
public class SmsMemServiceImpl implements SmsMemService {
	@Autowired
	private SmsMemDao smd;

	public SmsMem select(String mem_id) {
		return smd.select(mem_id);
	}

	public int insert(SmsMem mem) {
		return smd.insert(mem);
	}


}
