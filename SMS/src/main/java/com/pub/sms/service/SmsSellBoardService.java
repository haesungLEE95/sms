package com.pub.sms.service;

import java.util.Collection;

import com.pub.sms.model.SmsSellBoard;

public interface SmsSellBoardService {

	int getTotal(SmsSellBoard smssel);
	Collection<SmsSellBoard> list(SmsSellBoard smssel);

	int insert(SmsSellBoard smssel);

	SmsSellBoard select(int num);

	int update(SmsSellBoard smssel);

	int delete(int num);

	int getMCateTotal(int mNum);

	int getSCateTotal(int sNum);

	Collection<SmsSellBoard> mCateList(SmsSellBoard smssel);

	Collection<SmsSellBoard> sCateList(SmsSellBoard smssel);
	
	Collection<SmsSellBoard> selectno(int mem_no);

}
