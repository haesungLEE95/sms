package com.pub.sms.service;
import java.util.Collection;

import com.pub.sms.model.SmsSubCate;

public interface SmsSCateService {

	Collection<SmsSubCate> list();
	Collection<SmsSubCate> selectlist(int pickmcate);

}
