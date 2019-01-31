package com.pub.sms.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SmsQnAReplyDaoImpl implements SmsQnAReplyDao{
	@Autowired
	private SqlSessionTemplate sst;
	
}
