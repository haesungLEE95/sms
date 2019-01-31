package com.pub.sms.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsCharge;

@Repository
public class SmsChargeDaoImpl implements SmsChargeDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int chargeMny(SmsCharge scg) {
		return sst.insert("smsChargens.chargeMny", scg);
	}
	
	
	
}
