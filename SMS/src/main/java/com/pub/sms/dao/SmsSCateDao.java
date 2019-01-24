package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsSubCate;

public interface SmsSCateDao {

	Collection<SmsSubCate> list();
	Collection<SmsSubCate> selectlist(int pickmcate);
}
