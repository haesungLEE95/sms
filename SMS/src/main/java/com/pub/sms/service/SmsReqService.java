package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsReq;

public interface SmsReqService {

	int getTotal(SmsReq smsreq);

	Collection<SmsReq> list(SmsReq smsReq);

	int insert(SmsReq smsReq);

	void updateReadcount(int num);

	SmsReq select(int num);

	void updateCondition(int num);

	int update(SmsReq smsReq);

}
