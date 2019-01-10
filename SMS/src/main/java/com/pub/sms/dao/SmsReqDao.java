package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsReq;

public interface SmsReqDao {

	int getTotal(SmsReq smsReq);

	Collection<SmsReq> list(SmsReq smsReq);

}
