package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsMem;

public interface SmsMemDao {

	int insert(SmsMem mem);

	SmsMem select(String mem_id);

	int firstUpdate(SmsMem mem);

	SmsMem memNick(int mem_no);

	SmsMem memEail(int mem_no);


}
