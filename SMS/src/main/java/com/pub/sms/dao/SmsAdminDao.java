package com.pub.sms.dao;

import java.util.Collection;
import java.util.List;

import com.pub.sms.model.SmsAdmin;
import com.pub.sms.model.SmsMem;

public interface SmsAdminDao {

	Collection<SmsMem> list(SmsMem smsMem);

	int total(SmsMem smsMem);

	SmsMem adminDelMem(String chk);

	SmsAdmin adminSel(String admin_id);


}
