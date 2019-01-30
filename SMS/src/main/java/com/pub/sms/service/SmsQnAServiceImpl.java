package com.pub.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsQnADao;
import com.pub.sms.model.SmsQnA;

@Service
public class SmsQnAServiceImpl implements SmsQnAService {
	@Autowired
	private SmsQnADao sqd;

	@Override
	public int insert(SmsQnA smsqna) {
		return sqd.insert(smsqna);
	}
}
