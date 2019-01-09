package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsCha;

@Repository
public class SmsChaDaoImpl implements SmsChaDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Collection<SmsCha> list(SmsCha smscha) {
		return sst.selectList("smsChans.list", smscha);
	}
}
