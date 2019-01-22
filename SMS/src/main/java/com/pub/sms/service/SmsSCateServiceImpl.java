package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsSCateDao;
import com.pub.sms.model.SmsSubCate;

@Service
public class SmsSCateServiceImpl implements SmsSCateService{
	@Autowired
	private SmsSCateDao ssd;

	@Override
	public Collection<SmsSubCate> list() {
		return ssd.list();
	}
	@Override
	public Collection<SmsSubCate> selectlist(int pickmcate) {
		return ssd.selectlist(pickmcate);
	}
}
