package com.pub.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsSellBoDao;

@Service
public class SmsSellBoServiceImpl implements SmsSellBoService{
	@Autowired
	private SmsSellBoDao ssbd;
	
}
