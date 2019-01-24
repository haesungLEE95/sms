package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsReqReply;

public interface SmsReqReplyDao {

	Collection<SmsReqReply> list(int rq_no);

	void insert(SmsReqReply rb);

	void delete(int rq_re_no);

	void update(SmsReqReply rb);
}
