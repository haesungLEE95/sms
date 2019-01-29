package com.pub.sms.dao;

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

}
