package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsQuest;

public interface SmsQuestDao {

	int insert(SmsQuest smsqst);

	Collection<SmsQuest> list(int mem_no);

}
