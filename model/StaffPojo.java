package com.project.covidtracker.model;


public class StaffPojo {
     private Integer userId;     
     private String userName;       
     private String mailId;   
     private String password;
     private Long  mobileNumber;   
     private String address;
    

	public Integer getUserId() {
		return userId;
	}

	public int setUserId(Integer userId) {
		return this.userId=userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StaffPojo [userId=" + userId + ", userName=" + userName + ", mailId=" + mailId + ", password="
				+ password + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}

     
}
