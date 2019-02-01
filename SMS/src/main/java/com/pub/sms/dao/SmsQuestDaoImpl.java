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
	public Collection<SmsQuest> buyList(int mem_no) {
		return sst.selectList("smsquestns.buyList",mem_no);
	}

	@Override
	public Collection<SmsQuest> selList(int mem_no) {
		return sst.selectList("smsquestns.selList",mem_no);
	}

	@Override
	public SmsQuest select(SmsQuest smsqst) {
		return sst.selectOne("smsquestns.select",smsqst);
	}

	@Override
	public int comp(SmsQuest smsqst) {
		return sst.update("smsquestns.comp",smsqst);
	}

}
