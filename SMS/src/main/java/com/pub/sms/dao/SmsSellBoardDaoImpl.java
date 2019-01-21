package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsSellBoard;

@Repository
public class SmsSellBoardDaoImpl implements SmsSellBoardDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int getTotal(SmsSellBoard smssel) {
		return sst.selectOne("smssellboardns.getTotal", smssel);
	}

	@Override
	public Collection<SmsSellBoard> list(SmsSellBoard smssel) {
		return sst.selectList("smssellboardns.list", smssel);
	}

	@Override
	public int insert(SmsSellBoard smssel) {
		return sst.insert("smssellboardns.insert",smssel);
	}

	@Override
	public SmsSellBoard select(int num) {
		return sst.selectOne("smssellboardns.select",num);
	}

	@Override
	public int update(SmsSellBoard smssel) {
		return sst.update("smssellboardns.update",smssel);
	}

	@Override
	public int delete(int num) {
		return sst.delete("smssellboardns.delete",num);
	}
}
