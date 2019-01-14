package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsSubCate;

@Repository
public class SmsSCateDaoImpl implements SmsSCateDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Collection<SmsSubCate> list() {
		return sst.selectList("smssubcatens.list");
	}
	@Override
	public Collection<SmsSubCate> selectlist(int pickmcate) {
		return sst.selectList("smssubcatens.selectlist",pickmcate);
	}

}
