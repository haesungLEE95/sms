package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsQnA;

public interface SmsQnAService {

	int insert(SmsQnA smsqna);

	Collection<SmsQnA> list(SmsQnA smssqa);

	int getTotal(SmsQnA smssqa);

}
