package com.pub.sms.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pub.sms.dao.SmsSellBoardDao;
import com.pub.sms.model.SmsSellBoard;



@Service
public class SmsSellBoardServiceImpl implements SmsSellBoardService{
	@Autowired
	private SmsSellBoardDao ssbd;

	@Override
	public int getTotal(SmsSellBoard smssel) {
		return ssbd.getTotal(smssel);
	}

	@Override
	public Collection<SmsSellBoard> list(SmsSellBoard smssel) {
		return ssbd.list(smssel);
	}

	@Override
	public int insert(SmsSellBoard smssel) {
		return ssbd.insert(smssel);
	}

	@Override
	public SmsSellBoard select(int num) {
		return ssbd.select(num);
	}

	@Override
	public int update(SmsSellBoard smssel) {
		return ssbd.update(smssel);
	}

	@Override
	public int delete(int num) {
		return ssbd.delete(num);
	}

	@Override
	public int getMCateTotal(int mNum) {
		return ssbd.getMCateTotal(mNum);
	}
	public int getSCateTotal(int sNum) {
		return ssbd.getSCateTotal(sNum);
	}

	@Override
	public Collection<SmsSellBoard> mCateList(SmsSellBoard smssel) {
		return ssbd.mCateList(smssel);
	}

	@Override
	public Collection<SmsSellBoard> sCateList(SmsSellBoard smssel) {
		return ssbd.sCateList(smssel);
	}
}
