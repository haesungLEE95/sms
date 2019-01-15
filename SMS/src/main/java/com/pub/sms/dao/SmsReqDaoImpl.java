package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsReq;

@Repository
public class SmsReqDaoImpl implements SmsReqDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int getTotal(SmsReq smsReq) {
		return sst.selectOne("smsreqns.getTotal", smsReq);
	}

	@Override
	public Collection<SmsReq> list(SmsReq smsReq) {
		return sst.selectList("smsreqns.list", smsReq);
	}

	@Override
	public int insert(SmsReq smsReq) {
		return sst.insert("smsreqns.insert",smsReq);
	}

	@Override
	public void updateReadcount(int num) {
		sst.update("smsreqns.updateReadcount",num);
	}

	@Override
	public SmsReq select(int num) {
		return sst.selectOne("smsreqns.select",num);
	}

	@Override
	public void updateCondition(int num) {
		sst.update("smsreqns.updateCondition",num);
	}

	@Override
	public int update(SmsReq smsReq) {
		return sst.update("smsreqns.update",smsReq);
	}
}
