package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsChaDao;
import com.pub.sms.model.SmsCha;

@Service
public class SmsChaServiceImpl implements SmsChaService{
	@Autowired
	private SmsChaDao scd;

	@Override
	public Collection<SmsCha> list(SmsCha smscha) {
		return scd.list(smscha);
	}
	
	@Override
	public SmsCha select(SmsCha smscha) {
		return scd.select(smscha);
	}

	@Override
	public int insert(SmsCha smscha) {
		return scd.insert(smscha);
	}

	@Override
	public void updateReadcount(int num) {
		scd.updateReadcount(num);		
	}

	@Override
	public SmsCha selectno(int num) {
		return scd.selectno(num);
	}

	@Override
	public int getTotal(SmsCha smscha) {
		return scd.getTotal(smscha);
	}

	@Override
	public int update(SmsCha smscha) {
		return scd.update(smscha);
	}

	@Override
	public int delete(int num) {
		return scd.delete(num);
	}


}
