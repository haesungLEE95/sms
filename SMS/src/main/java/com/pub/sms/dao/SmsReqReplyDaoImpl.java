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
		return sst.selectList("smsreqreplyns.list", rq_no);
	}
	@Override
	public void insert(SmsReqReply rb) {
		sst.insert("smsreqreplyns.insert", rb);
	}

	@Override
	public void delete(int rq_re_no) {
		sst.update("smsreqreplyns.delete", rq_re_no);
	}

	@Override
	public void update(SmsReqReply rb) {
		sst.update("smsreqreplyns.update", rb);
	}

}
