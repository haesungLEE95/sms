package com.pub.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsQnAReplyDao;

@Service
public class SmsQnAReplyServiceImpl implements SmsQnAReplyService{
	@Autowired
	private SmsQnAReplyDao sqrd;
}
