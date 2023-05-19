package com.project.covidtracker.model;

public class AdminLoginPojo {
	private String userName;
	private String userPassword;
	private Integer userId;
	
	
	public AdminLoginPojo(String userName, String userPassword, Integer userId) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public AdminLoginPojo() {
		
	}

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	@Override
	public String toString() {
		return "AdminLoginPojo [userName=" + userName + ", userId=" + userPassword + "]";
	}
	
}
