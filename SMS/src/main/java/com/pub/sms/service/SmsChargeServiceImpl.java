package com.pub.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsChargeDao;
import com.pub.sms.model.SmsCharge;

@Service
public class SmsChargeServiceImpl implements SmsChargeService {
	@Autowired
	private SmsChargeDao scd;
	
	@Override
	public int chargeMny(SmsCharge scg) {
		return scd.chargeMny(scg);
	}

}
