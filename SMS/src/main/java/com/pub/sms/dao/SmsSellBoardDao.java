package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsSellBoard;

public interface SmsSellBoardDao {

	int getTotal(SmsSellBoard smssel);

	Collection<SmsSellBoard> list(SmsSellBoard smssel);

	int insert(SmsSellBoard smssel);

}
