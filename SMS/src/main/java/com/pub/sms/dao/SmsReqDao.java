package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsReq;

public interface SmsReqDao {

	int getTotal(SmsReq smsReq);

	Collection<SmsReq> list(SmsReq smsReq);

	int insert(SmsReq smsReq);

	void updateReadcount(int num);

	SmsReq select(int num);

	void updateCondition(int num);

	int update(SmsReq smsReq);

	int delete(int num);

}
