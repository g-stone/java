package com.sxtj.mobilehis.usertest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_DEMO_USER")
public class User {
	private String userid;
	private String username;
	private String userpass;
	
	@Id
	@Column(name = "userid", columnDefinition = "varchar(32) comment '主键ID'")
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Column(name = "username", columnDefinition = "varchar(32) comment '用户名'")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "userpass", columnDefinition = "varchar(32) comment '密码'")
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userpass=" + userpass + "]";
	}
	
}
