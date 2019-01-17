package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsCha;

public interface SmsChaService {

	Collection<SmsCha> list(SmsCha smscha);

	SmsCha select(SmsCha smscha);

	int insert(SmsCha smscha);

	void updateReadcount(int num);

	SmsCha selectno(int num);

	int getTotal(SmsCha smscha);

	int update(SmsCha smscha);

	int delete(int num);

}
