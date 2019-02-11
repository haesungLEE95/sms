package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsChaReply;
import com.pub.sms.model.SmsMem;
import com.pub.sms.model.SmsQuest;
import com.pub.sms.model.SmsSellBoard;

public interface SmsMemDao {

	int insert(SmsMem mem);

	SmsMem select(String mem_id);

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
