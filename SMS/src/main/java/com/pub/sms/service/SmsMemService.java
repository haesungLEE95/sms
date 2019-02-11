package com.pub.sms.service;

import java.util.Collection;
import java.util.List;

import com.pub.sms.model.SmsCha;
import com.pub.sms.model.SmsChaReply;
import com.pub.sms.model.SmsMem;
import com.pub.sms.model.SmsQuest;
import com.pub.sms.model.SmsSellBoard;

public interface SmsMemService {

	SmsMem select(String mem_id);

	int insert(SmsMem mem);
	
	int firstUpdate(SmsMem mem);
	
	SmsMem memNick(int mem_no);

	SmsMem nickSelect(String nickname);

	int updateImg(SmsMem mem);

	int updateInfo(SmsMem mem);

	int updateMem(SmsMem mem);

	int chargeMny(SmsMem mem);
	//수정

	void buyItem(SmsQuest smsqst);

	void selItem(SmsSellBoard sb);
}
