package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsChaReply;

@Repository
public class SmsChaReplyDaoImpl implements SmsChaReplyDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Collection<SmsChaReply> list(int cha_no) {
		return sst.selectList("rechans.list", cha_no);
	}

	@Override
	public void insert(SmsChaReply scr) {

		sst.insert("rechans.insert", scr);
	}

	@Override
	public void delete(int rep_no) {
		sst.update("rechans.delete", rep_no);
	}

	@Override
	public void update(SmsChaReply scr) {
		sst.update("rechans.update", scr);
	}

}