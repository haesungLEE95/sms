package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsQuest;

public interface SmsQuestService {

	int insert(SmsQuest smsqst);

	Collection<SmsQuest> list(int mem_no);

}
