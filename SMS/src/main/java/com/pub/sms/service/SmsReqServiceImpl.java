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

	@Override
	public int insert(SmsReq smsReq) {
		return srd.insert(smsReq);
	}

	@Override
	public void updateReadcount(int num) {
		srd.updateReadcount(num);
	}

	@Override
	public SmsReq select(int num) {
		return srd.select(num);
	}

	@Override
	public void updateCondition(int num) {
		srd.updateCondition(num);
	}

	@Override
	public int update(SmsReq smsReq) {
		return srd.update(smsReq);
	}
	
}
