package com.sxtj.mobilehis.usertest.dao;

import java.io.Serializable;

import com.sxtj.mobilehis.usertest.entity.User;

/**
 * PHP数据库交互基础DAO
 * @author dba
 */
public interface PhpBaseDao {
	/**
	 * 保存一个用户到PHP数据库中
	 * @param aUser
	 * @return
	 */
	String addUser(User aUser);
	
	/**
	 * 删除一个指定的用户从PHP数据库中
	 * @param _class
	 * @param identify
	 */
	void deleteUser(Class<? extends Object> _class, Serializable identify);
	
	/**
	 * SQL语句删除用户
	 * @param identify
	 */
	void deleteSqlUser(Serializable identify);
	
	void deleteMixtureUser(Serializable identify);
	
	public boolean addData(String aUserName, String aPassWard);
}
