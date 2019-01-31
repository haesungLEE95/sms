package com.pub.sms.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsQnA;

@Repository
public class SmsQnADaoImpl implements SmsQnADao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int insert(SmsQnA smsqna) {
		return sst.insert("smsqnans.insert",smsqna);
	}
}
