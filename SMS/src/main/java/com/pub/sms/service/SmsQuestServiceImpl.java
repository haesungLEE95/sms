package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsQuestDao;
import com.pub.sms.model.SmsQuest;

@Service
public class SmsQuestServiceImpl implements SmsQuestService {
	@Autowired
	private SmsQuestDao sqd;

	@Override
	public int insert(SmsQuest smsqst) {
		return sqd.insert(smsqst);
	}

	@Override
	public Collection<SmsQuest> buyList(int mem_no) {
		return sqd.buyList(mem_no);
	}

	@Override
	public Collection<SmsQuest> selList(int mem_no) {
		return sqd.selList(mem_no);
	}

	@Override
	public SmsQuest select(SmsQuest smsqst) {
		return sqd.select(smsqst);
	}

	@Override
	public int comp(SmsQuest smsqst) {
		return sqd.comp(smsqst);
	}
	
}