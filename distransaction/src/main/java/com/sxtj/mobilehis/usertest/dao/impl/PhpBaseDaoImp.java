package com.sxtj.mobilehis.usertest.dao.impl;

import java.io.Serializable;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sxtj.mobilehis.usertest.dao.PhpBaseDao;
import com.sxtj.mobilehis.usertest.entity.User;

@Component("databasePhpDao")
public class PhpBaseDaoImp implements PhpBaseDao{
	@Autowired
	@Qualifier("sessionFactoryPhp")
	private SessionFactory sessionFactoryPhp;
	@Autowired
	@Qualifier("jdbcTemplatePhp")
	private JdbcTemplate jdbcTemplatePhp;
	
	public String addUser(User aUser) {
		User phpUser = new User();
		phpUser.setUsername("李新鹏");
		phpUser.setUserpass("1123456");
		Session session = sessionFactoryPhp.getCurrentSession();
		Serializable tmpSerializable = session.save(phpUser);
		
		System.err.println("PHP数据库预保存用户操作：" + phpUser);
		
		return tmpSerializable.toString();
	}
	
	public void deleteUser(Class<? extends Object> _class, Serializable identify) {
		Session session = sessionFactoryPhp.getCurrentSession();
		Object entity = session.load(_class, identify);
		
		if(entity != null){
			System.err.println("PHP数据库删除用户操作：" + entity);
			session.delete(entity);
		}
	}
	
	public void deleteSqlUser(Serializable identify) {
		int count = jdbcTemplatePhp.update("delete from t_demo_user where userid = ?", new Object[]{identify});
		
		System.err.println("PHP delete effect count : " + count);
	}
	
	public void deleteMixtureUser(Serializable identify) {
		Session session = sessionFactoryPhp.getCurrentSession();
		Object entity = session.load(User.class, identify);
		
		if(entity != null){
			System.err.println("PHP数据库删除用户操作：" + entity);
			session.delete(entity);
		}
	}

	public boolean addData(String aUserName, String aPassWard) {
		Session session = sessionFactoryPhp.getCurrentSession();
		SQLQuery tmpQuery = session
				.createSQLQuery("insert into t_demo values(?,?)");
		tmpQuery.setParameter(0, aUserName);
		tmpQuery.setParameter(1, aPassWard);
		int tmpRs = tmpQuery.executeUpdate();
		if (tmpRs <= 0) {
			return false;
		}
		return true;
	}
}
