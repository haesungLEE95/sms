package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsQuest;

public interface SmsQuestService {

	int insert(SmsQuest smsqst);

	Collection<SmsQuest> buyList(int mem_no);

	Collection<SmsQuest> selList(int mem_no);

	SmsQuest select(SmsQuest smsqst);

	int comp(SmsQuest smsqst);

}