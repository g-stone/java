package com.sxtj.mobilehis.usertest.dao;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sxtj.mobilehis.usertest.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hib-config.xml" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class BussinessDaoTest {
	@Resource
	private PhpBaseDao databasePhpDao;
	@Resource
	private HisBaseDao databaseHisDao;

	@Test
	public void addHisUser() {
		User tmpUser = new User();
		tmpUser.setUserpass("1234566666");
		tmpUser.setUsername("yjw66");
		String tmpStr = databaseHisDao.addUser(tmpUser);
		if (tmpStr == null || tmpStr.equals("")) {
			System.out.println("添加失败！");
		} else {
			System.out.println("添加成功！");
		}
	}
	
	@Test
	public void addPhpUser() {
		User tmpUser = new User();
		tmpUser.setUserpass("123456");
		tmpUser.setUsername("yjw");
		String tmpStr = databasePhpDao.addUser(tmpUser);
		if (tmpStr == null || tmpStr.equals("")) {
			System.out.println("添加失败！");
		} else {
			System.out.println("添加成功！");
		}
	}
}
