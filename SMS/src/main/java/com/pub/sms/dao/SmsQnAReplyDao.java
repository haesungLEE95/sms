package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsQnaReply;

public interface SmsQnAReplyDao {

	Collection<SmsQnaReply> list(int qna_no);

	void insert(SmsQnaReply sqr);

	void delete(int qna_no);

	void update(SmsQnaReply sqr);



}
