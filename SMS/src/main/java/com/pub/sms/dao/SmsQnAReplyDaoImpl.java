package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsQnaReply;

@Repository
public class SmsQnAReplyDaoImpl implements SmsQnAReplyDao{
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Collection<SmsQnaReply> list(int qna_no) {
		return sst.selectList("smsqnareplyns.list", qna_no);
	}

	@Override
	public void insert(SmsQnaReply sqr) {
		sst.insert("smsqnareplyns.insert", sqr);
	}

	@Override
	public void delete(int qna_no) {
		sst.update("smsqnareplyns.delete", qna_no);
	}

	@Override
	public void update(SmsQnaReply sqr) {
		sst.update("smsqnareplyns.delete", sqr);
	}
	
}
