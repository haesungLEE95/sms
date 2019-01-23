package com.pub.sms.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsAdminDao;
import com.pub.sms.model.SmsAdmin;
import com.pub.sms.model.SmsMem;

@Service
public class SmsAdminServiceImpl implements SmsAdminService {
	@Autowired
	private SmsAdminDao sad;

	@Override
	public Collection<SmsMem> list(SmsMem smsMem) {
		return sad.list(smsMem);
	}

	@Override
	public int total(SmsMem smsMem) {
		return sad.total(smsMem);
	}

	@Override
	public SmsMem adminDelMem(String chk) {
		return sad.adminDelMem(chk);
	}

	@Override
	public SmsAdmin select(String admin_id) {
		return sad.adminSel(admin_id);
	}



}
