package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsSellBoard;
import com.pub.sms.service.SmsSellBoardService;

public interface SmsSellBoardDao {

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
