package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsReqDao;
import com.pub.sms.model.SmsReq;

@Service
public class SmsReqServiceImpl implements SmsReqService {
	@Autowired
	private SmsReqDao srd;

	@Override
	public int getTotal(SmsReq smsReq) {
		return srd.getTotal(smsReq);
	}

	@Override
	public Collection<SmsReq> list(SmsReq smsReq) {
		return srd.list(smsReq);
	}
	
}
