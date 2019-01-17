package com.pub.sms.dao;

import java.util.Collection;

import com.pub.sms.model.SmsChaReply;

public interface SmsChaReplyDao {

	Collection<SmsChaReply> list(int rep_no);

}
