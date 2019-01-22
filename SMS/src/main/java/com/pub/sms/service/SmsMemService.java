package com.pub.sms.service;

import java.util.Collection;
import java.util.List;

import com.pub.sms.model.SmsCha;
import com.pub.sms.model.SmsChaReply;
import com.pub.sms.model.SmsMem;

public interface SmsMemService {

	SmsMem select(String mem_id);

	int insert(SmsMem mem);
	
	int firstUpdate(SmsMem mem);
	
	SmsMem memNick(int mem_no);

	SmsMem nickSelect(String nickname);

	int update(SmsMem mem);

}
