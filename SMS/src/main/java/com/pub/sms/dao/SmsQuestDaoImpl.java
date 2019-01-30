package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsQuest;

@Repository
public class SmsQuestDaoImpl implements SmsQuestDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int insert(SmsQuest smsqst) {
		return sst.insert("smsquestns.insert",smsqst);
	}

	@Override
	public Collection<SmsQuest> list(int mem_no) {
		return sst.selectList("smsquestns.list",mem_no);
	}

}
