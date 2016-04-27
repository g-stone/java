package com.sxtj.mobilehis.usertest.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sxtj.mobilehis.usertest.dao.HisBaseDao;
import com.sxtj.mobilehis.usertest.dao.PhpBaseDao;
import com.sxtj.mobilehis.usertest.entity.User;
import com.sxtj.mobilehis.usertest.service.IDatabaseBussinessService;

@Component("databaseBusinessService")
public class DatabaseBussinessServiceImp implements IDatabaseBussinessService{
	@Autowired
	private HisBaseDao hisBaseDao;
	@Autowired
	private PhpBaseDao phpBaseDao;
	
	public void addUser(User aUser) {
		phpBaseDao.addUser(aUser);
		hisBaseDao.addUser(aUser);
	}
	
	public void deleteUser(Class<? extends Object> _class, String hisUserId, String phpUserId) {
		phpBaseDao.deleteUser(_class, phpUserId);
		hisBaseDao.deleteUser(_class, hisUserId);
	}
	
	public void deleteSqlUser(String hisUserId, String phpUserId) {
		phpBaseDao.deleteSqlUser(phpUserId);
		hisBaseDao.deleteSqlUser(hisUserId);
	}
	
	public void deleteMixtureUser(String hisUserId, String phpUserId) {
		phpBaseDao.deleteMixtureUser(phpUserId);
		hisBaseDao.deleteMixtureUser(hisUserId);
	}
	
	public boolean editUser() {
		boolean tmpBDel = hisBaseDao.deleteData();
		boolean tmpBDelete = phpBaseDao.addData("userName", "userPwd");
		
		System.err.println("操作结果：" + tmpBDel + ", " + tmpBDelete);
		
		return false;
	}
	
	public void editSuccessUser(User hisUser, Serializable phpUserId) {
		hisBaseDao.addUser(hisUser);
		phpBaseDao.deleteSqlUser(phpUserId);
	}
	
	public List<User> processNativeCaller() {
		return hisBaseDao.processNativeCaller();
	}
}
