package com.sxtj.mobilehis.usertest.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:hib-config.xml" })
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class TestServiceTest {

	@Resource
	private TestService testService;
	
	@Test
	public void testGet() {
		this.testService.editUser();
	}
	
	@Test
	public void testEdit() {
		this.testService.editUser();
	}

}
