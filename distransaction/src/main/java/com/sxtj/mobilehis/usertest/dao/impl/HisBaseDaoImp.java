package com.sxtj.mobilehis.usertest.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sxtj.mobilehis.usertest.dao.HisBaseDao;
import com.sxtj.mobilehis.usertest.entity.User;

@Component("databaseHisDao")
public class HisBaseDaoImp implements HisBaseDao{
	@Autowired
	@Qualifier("sessionFactoryHis")
	private SessionFactory sessionFactoryHis;
	@Autowired
	@Qualifier("jdbcTemplateHis")
	private JdbcTemplate jdbcTemplateHis;
	
	@SuppressWarnings("unchecked")
	public String addUser(User aUser) {
		SQLQuery query = sessionFactoryHis
							.getCurrentSession()
							.createSQLQuery("select * from t_demo_logs");
		
		List<Object> list = query.list();
		
		System.out.println(list.size());
		
		User hisUser = new User();
		hisUser.setUsername("黄文");
		hisUser.setUserpass("123456");
		Session session = sessionFactoryHis.getCurrentSession();
		Serializable tmpSerializable = session.save(hisUser);
		
		System.err.println("HIS数据库预保存用户操作：" + hisUser);
		
		return tmpSerializable.toString();
	}
	
	@SuppressWarnings("unchecked")
	public void deleteUser(Class<? extends Object> _class, Serializable identify) {
		Session session = sessionFactoryHis.getCurrentSession();
		Object entity = session.load(_class, identify);
		
		if(entity != null){
			System.err.println("HIS数据库删除用户操作：" + entity);
			session.delete(entity);
		}
		SQLQuery query = session.createSQLQuery("select  from t_demo_logsssss");
		
		List<Object> list = query.list();
		
		System.out.println(list.size());
	}
	
	public void deleteSqlUser(Serializable identify) {
		int count = jdbcTemplateHis.update("delete * from t_demo_user where userid = ?", new Object[]{identify});
		
		System.err.println("HIS delete effect count : " + count);
	}
	
	public void deleteMixtureUser(Serializable identify) {
		int count = jdbcTemplateHis.update("delete * from t_demo_user where userid = ?", new Object[]{identify});
		
		System.err.println("HIS delete effect count : " + count);
	}
	
	public List<Object> getList() {
		Session session = sessionFactoryHis.getCurrentSession();
		SQLQuery tmpQuery = session
				.createSQLQuery("select name  from pat_master_index where patient_id=?");
		tmpQuery.setParameter(0, "M00115214");
		List<?> tmpList = tmpQuery.list();
		List<Object> tmpObjectList = new ArrayList<Object>();
		for (int i = 0; i < tmpList.size(); i++) {
			tmpObjectList.add(tmpList.get(i));
		}
		return tmpObjectList;
	}
	
	public boolean deleteData() {
		Session session = sessionFactoryHis.getCurrentSession();
		SQLQuery tmpQuery = session
				.createSQLQuery("delete from pat_master_index where patient_id=?");
		tmpQuery.setParameter(0, "123456");
		int tmpRs = tmpQuery.executeUpdate();
		if (tmpRs <= 0) {
			return false;
		}
		return true;
	}

	public boolean deleteOracleData() {
		String tmpSql = "delete from T_DEMO_USER where userid=?";
		int tmpRs = jdbcTemplateHis.update(tmpSql,
				new Object[] { "4028b8814fd53a4f014fd53a5e420001" });
		if (tmpRs <= 0) {
			return false;
		}
		return true;
	}
	
	public <T> List<T> processNativeCaller() {
		Session session = sessionFactoryHis.getCurrentSession();
		ProcedureCall call = session.createStoredProcedureCall("pkg_autowebservice.proc_deptlist", User.class);
		call.registerParameter(1, String.class, ParameterMode.IN).bindValue("");
		call.registerParameter(2, String.class, ParameterMode.IN).bindValue("");
		call.registerParameter(3, Object.class, ParameterMode.REF_CURSOR);
		
		ProcedureOutputs ots = call.getOutputs();
		ResultSetOutput sets = (ResultSetOutput)call.getOutputs().getCurrent();
		System.out.println(sets.getResultList().size());
		
		
		return null;
	}
	
}
