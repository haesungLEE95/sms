package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsReqReply;

@Repository
public class SmsReqReplyDaoImpl implements SmsReqReplyDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Collection<SmsReqReply> list(int rq_no) {
		return sst.selectList("rbdns.list", rq_no);
	}

	@Override
	public void insert(SmsReqReply rb) {
		sst.insert("rbdns.insert", rb);
	}

	@Override
	public void delete(int rq_re_no) {
		sst.update("rbdns.delete", rq_re_no);
	}

	@Override
	public void update(SmsReqReply rb) {
		sst.update("rbdns.update", rb);
	}

}
