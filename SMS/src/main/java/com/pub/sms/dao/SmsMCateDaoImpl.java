package com.pub.sms.dao;

import java.util.Collection;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pub.sms.model.SmsMainCate;
import com.pub.sms.model.SmsSubCate;

@Repository
public class SmsMCateDaoImpl implements SmsMCateDao {
	@Autowired
	private SqlSessionTemplate sst;
	//1
	@Override
	public Collection<SmsMainCate> list() {
		return sst.selectList("smsmaincatens.list");
	}

}
