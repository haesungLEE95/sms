package com.pub.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsMemDao;

@Service
public class SmsMemServiceImpl implements SmsMemService {
	@Autowired
	private SmsMemDao smd;
}
