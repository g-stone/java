package com.sxtj.mobilehis.usertest.dao;

import java.io.Serializable;
import java.util.List;

import com.sxtj.mobilehis.usertest.entity.User;

/**
 * HIS数据库交互基础DAO类
 * @author dba
 *
 */
public interface HisBaseDao {
	/**
	 * Session操作保存USER实体到HIS数据库中
	 * @param aUser
	 * @return
	 */
	String addUser(User aUser);
	
	/**
	 * SESSION删除USER实体从HIS数据库，后执行查询（异常SQL语句抛出异常）
	 * @param _class
	 * @param identify
	 */
	void deleteUser(Class<? extends Object> _class, Serializable identify);
	
	/**
	 * JdbcTemplate操作SQL删除表t_demo_user记录(发生异常)
	 * @param identify
	 */
	void deleteSqlUser(Serializable identify);
	
	/**
	 * JdbcTemplate操作SQL删除表t_demo_user记录(发生异常)
	 * @param identify
	 */
	void deleteMixtureUser(Serializable identify);
	
	List<Object> getList();
	
	/**
	 * SQLQuery操作SQL删除pat_master_index表记录
	 * @return
	 */
	boolean deleteData();
	
	/**
	 * JdbcTemplate操作SQL删除T_DEMO_USER记录
	 * @return
	 */
	boolean deleteOracleData();
	
	<T> List<T> processNativeCaller();
}
