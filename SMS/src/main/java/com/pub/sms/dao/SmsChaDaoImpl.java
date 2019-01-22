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
	@Override
	public SmsCha select(SmsCha smscha) {
		return sst.selectOne("smsChans.select", smscha);
	}
	@Override
	public int insert(SmsCha smscha) {
		return sst.insert("smsChans.insert", smscha);
	}
	@Override
	public void updateReadcount(int num) {
		sst.update("smsChans.updateReadcount", num);
	}
	@Override
	public SmsCha select(int num) {
		return sst.selectOne("smsChans.selectno", num);
	}
	@Override
	public int getTotal(SmsCha smscha) {
		return sst.selectOne("smsChans.getTotal", smscha);
	}

}