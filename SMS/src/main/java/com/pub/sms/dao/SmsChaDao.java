package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsCha;

public interface SmsChaDao {

	Collection<SmsCha> list(SmsCha smscha);

	SmsCha select(SmsCha smscha);

	int insert(SmsCha smscha);

	void updateReadcount(int num);

	SmsCha select(int num);

	int getTotal(SmsCha smscha);


}
