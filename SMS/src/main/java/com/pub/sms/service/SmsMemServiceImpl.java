package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsMemDao;
import com.pub.sms.model.SmsChaReply;
import com.pub.sms.model.SmsMem;

@Service
public class SmsMemServiceImpl implements SmsMemService {
	@Autowired
	private SmsMemDao smd;

	public SmsMem select(String mem_id) {
		return smd.select(mem_id);
	}
	public SmsMem memNick(int mem_no) {
		return smd.memNick(mem_no);
	}
	public int insert(SmsMem mem) {
		return smd.insert(mem);
	}

	public int firstUpdate(SmsMem mem) {
		return smd.firstUpdate(mem);
	}


}
