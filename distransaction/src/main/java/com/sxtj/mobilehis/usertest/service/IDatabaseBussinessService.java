package com.sxtj.mobilehis.usertest.service;

import java.io.Serializable;
import java.util.List;

import com.sxtj.mobilehis.usertest.entity.User;

/**
 * Service服务
 * @author dba
 */
public interface IDatabaseBussinessService {
	/**
	 * 事务正常执行，保存用户到HIS和PHP两个数据库中
	 * 执行结果预测：事务正常提交，用户分别保存到两个数据库中
	 * @param aUser
	 */
	void addUser(User aUser);
	
	/**
	 * Hibernate Session操作USER实体，从HIS中删除用户后执行查询发生异常；从PHP数据库中删除用户无异常。
	 * 执行结果预测：异常发生事务回滚，HIS库和PHP库用户都没有删除掉
	 * @param _class
	 * @param hisUserId
	 * @param phpUserId
	 */
	void deleteUser(Class<? extends Object> _class, String hisUserId, String phpUserId);
	
	/**
	 * JdbcTemplate执行删除SQL操作，从HIS库中删除用户SQL发生异常；从PHP库中删除用户无异常。
	 * 执行结果预测：异常发生事务回滚，HIS库和PHP库用户都没有删除掉
	 * @param hisUserId
	 * @param phpUserId
	 */
	void deleteSqlUser(String hisUserId, String phpUserId);
	
	/**
	 * HIS库JdbcTemplate执行SQL和PHP库Hibernate Session执行实体删除操作，HIS库执行删除发生异常；PHP库执行删除无异常
	 * 执行结果预测：异常发生事务回滚，HIS库和PHP库数据都没有删除掉
	 * @param hisUserId
	 * @param phpUserId
	 */
	void deleteMixtureUser(String hisUserId, String phpUserId);
	
	/**
	 * HIS库SQLQuery执行SQL删除操作和PHP库SQLQuery执行SQL添加操作，HIS库执行正常，PHP库执行发生异常
	 * 执行结果预测：异常发生事务回滚，HIS库数据未删除和PHP库数据没有添加上
	 * @return
	 */
	boolean editUser();
	
	/**
	 * HIS库Session保存实体、PHP库JdbcTemplate执行SQL删除数据
	 * @param hisUser
	 * @param phpUserId
	 */
	void editSuccessUser(User hisUser, Serializable phpUserId);
	
	List<User> processNativeCaller();
}
