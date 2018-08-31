package com.cg.spring.plpmod21.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private int c_id;
	private String c_username;
	private String c_password;
	private long accountNo;
	
	
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_username() {
		return c_username;
	}
	public void setC_username(String c_username) {
		this.c_username = c_username;
	}
	public String getC_password() {
		return c_password;
	}
	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public Customer(int c_id, String c_username, String c_password, long accountNo) {
		super();
		this.c_id = c_id;
		this.c_username = c_username;
		this.c_password = c_password;
		this.accountNo = accountNo;
	}
	public Customer() {
		super();
	}
	
	
}
