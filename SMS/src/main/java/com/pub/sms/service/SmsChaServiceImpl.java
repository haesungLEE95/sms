package com.pub.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsChaDao;

@Service
public class SmsChaServiceImpl implements SmsChaService{
	@Autowired
	private SmsChaDao scd;
}
