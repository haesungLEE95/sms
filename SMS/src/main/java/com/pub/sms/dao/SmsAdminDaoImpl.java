package com.pub.sms.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;
import com.pub.sms.model.SmsAdmin;
import com.pub.sms.model.SmsMem;


@Repository
public class SmsAdminDaoImpl implements SmsAdminDao {
	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Collection<SmsMem> list(SmsMem smsMem) {
/*		System.out.println("start="+smsMem.getStartRow());
		System.out.println("end="+smsMem.getEndRow());
		System.out.println("sear="+smsMem.getSearch());
		System.out.println("key="+smsMem.getKeyword());*/
		return sst.selectList("smsMemns.adminMemList", smsMem);
	}

	@Override
	public int total(SmsMem smsMem) {
		return sst.selectOne("smsMemns.adminTotal", smsMem);
	}

	@Override
	public SmsMem adminDelMem(String chk) {
		return sst.selectOne("smsMemns.adminDelMem", chk);
	}

	@Override
	public SmsAdmin adminSel(String admin_id) {
		return sst.selectOne("smsAdminns.adminSel", admin_id);
	}

}
