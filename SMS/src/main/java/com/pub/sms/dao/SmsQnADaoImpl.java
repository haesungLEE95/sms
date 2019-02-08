package com.pub.sms.dao;

import java.util.Collection;

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

	@Override
	public Collection<SmsQnA> list(SmsQnA smssqa) {
		return sst.selectList("smsqnans.list", smssqa);
	}

	@Override
	public int getTotal(SmsQnA smssqa) {
		return sst.selectOne("smsqnans.getTotal", smssqa);
	}

	@Override
	public SmsQnA select(int num) {
		return sst.selectOne("smsqnans.select", num);
	}
}
