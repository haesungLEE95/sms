package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsReq;

public interface SmsReqService {

	int getTotal(SmsReq smsreq);

	Collection<SmsReq> list(SmsReq smsReq);

}
