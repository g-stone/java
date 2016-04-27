package com.sxtj.mobilehis.usertest.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sxtj.mobilehis.usertest.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hib-config.xml" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class BussinessServiceTest {
	
	@Autowired
	private IDatabaseBussinessService databaseBusinessService;
	
	@Test
	public void testAdd(){
		User aUser = new User();
		aUser.setUsername("黄文");
		aUser.setUserpass("huangwen");
		
		databaseBusinessService.addUser(aUser);
	}
	
	@Test
	public void testDelete(){
		databaseBusinessService.deleteUser(User.class, "4028b8814fed7309014fed7312630001", "4028b8814fed7309014fed7311250000");
	}
	
	@Test
	public void testSqlDelete(){
		databaseBusinessService.deleteSqlUser("4028b8814fed7309014fed7312630001", "4028b8814fed7309014fed7311250000");
	}
	
	@Test
	public void testMixtureDelete(){
		databaseBusinessService.deleteMixtureUser("4028b8814fed7309014fed7312630001", "4028b8814fed7309014fed7311250000");
	}
	
	@Test
	public void editSuccessUser(){
		databaseBusinessService.editSuccessUser(null, "4028b8814fed7309014fed7311250000");
	}
	
	@Test
	public void proc(){
		databaseBusinessService.processNativeCaller();
	}
}
