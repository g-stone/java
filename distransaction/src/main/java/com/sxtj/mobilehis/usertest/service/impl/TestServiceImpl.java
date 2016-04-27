package com.sxtj.mobilehis.usertest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sxtj.mobilehis.usertest.dao.HisBaseDao;
import com.sxtj.mobilehis.usertest.dao.PhpBaseDao;
import com.sxtj.mobilehis.usertest.service.TestService;

@Component("testService")
public class TestServiceImpl implements TestService {
	
	@Autowired
	private HisBaseDao hisBaseDao;
	
	@Autowired
	private PhpBaseDao phpBaseDao;
	
	@SuppressWarnings("unused")
	public boolean editUser() {
		
		boolean tmpBDel = hisBaseDao.deleteData();
	/*	
		hisBaseDao.deleteOracleData();*/
		
		boolean tmpBDelete = phpBaseDao.addData("userName", "userPwd");
		
		return false;
	}

}
