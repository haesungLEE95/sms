package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsChaReply;

public interface SmsChaReplyDao {

	Collection<SmsChaReply> list(int rep_no);

	void insert(SmsChaReply scr);

	void delete(int rep_no);

	void update(SmsChaReply scr);


}
