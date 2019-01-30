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
	public Collection<SmsQuest> list(int mem_no) {
		return sqd.list(mem_no);
	}
}
