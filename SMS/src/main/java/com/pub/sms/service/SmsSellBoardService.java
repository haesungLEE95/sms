package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsSellBoard;

public interface SmsSellBoardService {

	int getTotal(SmsSellBoard smssel);

	Collection<SmsSellBoard> list(SmsSellBoard smssel);

	int insert(SmsSellBoard smssel);

}
