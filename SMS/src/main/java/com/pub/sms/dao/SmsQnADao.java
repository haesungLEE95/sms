package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsQnA;

public interface SmsQnADao {

	int insert(SmsQnA smsqna);

	Collection<SmsQnA> list(SmsQnA smssqa);

	int getTotal(SmsQnA smssqa);

	SmsQnA select(int num);

}
