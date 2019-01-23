package com.pub.sms.service;

import java.util.Collection;
import java.util.List;

import com.pub.sms.model.SmsAdmin;
import com.pub.sms.model.SmsMem;

public interface SmsAdminService {

	Collection<SmsMem> list(SmsMem smsMem);

	int total(SmsMem smsMem);

	SmsMem adminDelMem(String chk);

	SmsAdmin select(String admin_id);



}
