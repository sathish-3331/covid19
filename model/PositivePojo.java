package com.project.covidtracker.model;

import java.sql.Date;


public class PositivePojo {
	 private  Integer positiveId;
     private Integer patientId;
     private  Long addharNo;
     private  String patientName;
     private String gender;
     private Integer patientAge;
     private Long mobileNo;
     private String zoneName;
     private Integer staffId;
     private Integer municipalityId;
     private String municipalityName;
     private Integer stateId;
     private String stateName;
     private Integer countryId;
     private String countryName;
     private Date caseOccuerDate;
     private String testResult;
     private String MessageStatus;
     private Integer confirmedCase;
    
	public String getMessageStatus() {
		return MessageStatus;
	}
	public void setMessageStatus(String messageStatus) {
		MessageStatus = messageStatus;
	}
	public Integer getPositiveId() {
		return positiveId;
	}
	public void setPositiveId(Integer positiveId) {
		this.positiveId = positiveId;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public Long getAddharNo() {
		return addharNo;
	}
	public void setAddharNo(Long addharNo) {
		this.addharNo = addharNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	public Integer getMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(Integer municipalityId) {
		this.municipalityId = municipalityId;
	}
	public String getMunicipalityName() {
		return municipalityName;
	}
	public void setMunicipalityName(String municipalityName) {
		this.municipalityName = municipalityName;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Date getCaseOccuerDate() {
		return caseOccuerDate;
	}
	public void setCaseOccuerDate(Date caseOccuerDate) {
		this.caseOccuerDate = caseOccuerDate;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public Integer getConfirmedCase() {
		return confirmedCase;
	}
	public void setConfirmedCase(Integer confirmedCase) {
		this.confirmedCase = confirmedCase;
	}
	@Override
	public String toString() {
		return "PositivePojo [positiveId=" + positiveId + ", patientId=" + patientId + ", addharNo=" + addharNo
				+ ", patientName=" + patientName + ", gender=" + gender + ", patientAge=" + patientAge + ", mobileNo="
				+ mobileNo + ", zoneName=" + zoneName + ", staffId=" + staffId + ", municipalityId=" + municipalityId
				+ ", municipalityName=" + municipalityName + ", stateId=" + stateId + ", stateName=" + stateName
				+ ", countryId=" + countryId + ", countryName=" + countryName + ", caseOccuerDate=" + caseOccuerDate
				+ ", testResult=" + testResult + ", MessageStatus=" + MessageStatus + ", confirmedCase=" + confirmedCase
				+ "]";
	}


}
