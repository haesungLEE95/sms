package com.pub.sms.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsMCateDao;
import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsSubCate;

@Service
public class SmsMCateServiceImpl implements SmsMCateService {
	@Autowired
	private SmsMCateDao smd;

	@Override
	public Collection<SmsMainCate> list() {
		return smd.list();
	}


	
}
