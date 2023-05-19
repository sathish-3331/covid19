package com.project.covidtracker.model;

import java.sql.Date;



public class AppointmentPojo {

	private Integer appointRegId;
	private Integer userId;
	private Long aadharNumber;
	private String userName;
	private Integer age;
	private Long mobileNo;
	private String gender;
	private String mailId;
	private String password;
	private String zoneAreaName;
	private Integer postCode;
	private String stateName;
	private Date  appoinmentRequiredDate;
    private String appointmenStatus;
    private String feverorChills;
    private String cough;
    private String thoratPain;
    private String  fatigue;
    private String muscleOrBodyAches;
    private String otherHealthIssue;
    
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getOtherHealthIssue() {
		return otherHealthIssue;
	}
	public void setOtherHealthIssue(String otherHealthIssue) {
		this.otherHealthIssue = otherHealthIssue;
	}
	public Integer getAppointRegId() {
		return appointRegId;
	}
	public void setAppointRegId(Integer appointRegId) {
		this.appointRegId = appointRegId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getZoneAreaName() {
		return zoneAreaName;
	}
	public void setZoneAreaName(String zoneAreaName) {
		this.zoneAreaName = zoneAreaName;
	}
	public Integer getPostCode() {
		return postCode;
	}
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	public Date getAppoinmentRequiredDate() {
		return appoinmentRequiredDate;
	}
	public void setAppoinmentRequiredDate(Date appoinmentRequiredDate) {
		this.appoinmentRequiredDate = appoinmentRequiredDate;
	}
	public String getAppointmenStatus() {
		return appointmenStatus;
	}
	public void setAppointmenStatus(String appointmenStatus) {
		this.appointmenStatus = appointmenStatus;
	}
	public String getFeverorChills() {
		return feverorChills;
	}
	public void setFeverorChills(String feverorChills) {
		this.feverorChills = feverorChills;
	}
	public String getCough() {
		return cough;
	}
	public void setCough(String cough) {
		this.cough = cough;
	}
	public String getThoratPain() {
		return thoratPain;
	}
	public void setThoratPain(String thoratPain) {
		this.thoratPain = thoratPain;
	}
	public String getFatigue() {
		return fatigue;
	}
	public void setFatigue(String fatigue) {
		this.fatigue = fatigue;
	}
	public String getMuscleOrBodyAches() {
		return muscleOrBodyAches;
	}
	public void setMuscleOrBodyAches(String muscleOrBodyAches) {
		this.muscleOrBodyAches = muscleOrBodyAches;
	}
	@Override
	public String toString() {
		return "AppointmentPojo [appointRegId=" + appointRegId + ", userId=" + userId + ", aadharNumber=" + aadharNumber
				+ ", userName=" + userName + ", age=" + age + ", mobileNo=" + mobileNo + ", gender=" + gender
				+ ", mailId=" + mailId + ", password=" + password + ", zoneAreaName=" + zoneAreaName + ", postCode="
				+ postCode + ", stateName=" + stateName + ", appoinmentRequiredDate=" + appoinmentRequiredDate
				+ ", appointmenStatus=" + appointmenStatus + ", feverorChills=" + feverorChills + ", cough=" + cough
				+ ", thoratPain=" + thoratPain + ", fatigue=" + fatigue + ", muscleOrBodyAches=" + muscleOrBodyAches
				+ ", otherHealthIssue=" + otherHealthIssue + "]";
	}

    

    
	

 
}
