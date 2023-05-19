package com.project.covidtracker.model;

import java.sql.Date;

public class NegativePojo {
	 private  Integer negativeId;
     private Integer negativePatientId;
     private  Long negativeAaddharNo;
     private  String negativePatientName;
     private String negativeGender;
     private Integer negativePatientAge;
     private Long negativeMobileNo;
     private String negativeZoneName;
     private Integer negativeStaffId;
     private Integer negativeMunicipalityId;
     private String negativeMunicipalityName;
     private Integer negativeStateId;
     private String negativeStateName;
     private Integer negativeCountryId;
     private String negativeCountryName;
     private Date negativeCaseOccuerDate;
     private String negativeTestResult;
     private Integer negativeConfirmedCase;
	public Integer getNegativeId() {
		return negativeId;
	}
	public void setNegativeId(Integer negativeId) {
		this.negativeId = negativeId;
	}
	public Integer getNegativePatientId() {
		return negativePatientId;
	}
	public void setNegativePatientId(Integer negativePatientId) {
		this.negativePatientId = negativePatientId;
	}
	public Long getNegativeAaddharNo() {
		return negativeAaddharNo;
	}
	public void setNegativeAaddharNo(Long negativeAaddharNo) {
		this.negativeAaddharNo = negativeAaddharNo;
	}
	public String getNegativePatientName() {
		return negativePatientName;
	}
	public void setNegativePatientName(String negativePatientName) {
		this.negativePatientName = negativePatientName;
	}
	public String getNegativeGender() {
		return negativeGender;
	}
	public void setNegativeGender(String negativeGender) {
		this.negativeGender = negativeGender;
	}
	public Integer getNegativePatientAge() {
		return negativePatientAge;
	}
	public void setNegativePatientAge(Integer negativePatientAge) {
		this.negativePatientAge = negativePatientAge;
	}
	public Long getNegativeMobileNo() {
		return negativeMobileNo;
	}
	public void setNegativeMobileNo(Long negativeMobileNo) {
		this.negativeMobileNo = negativeMobileNo;
	}
	public String getNegativeZoneName() {
		return negativeZoneName;
	}
	public void setNegativeZoneName(String negativeZoneName) {
		this.negativeZoneName = negativeZoneName;
	}
	public Integer getNegativeStaffId() {
		return negativeStaffId;
	}
	public void setNegativeStaffId(Integer negativeStaffId) {
		this.negativeStaffId = negativeStaffId;
	}
	public Integer getNegativeMunicipalityId() {
		return negativeMunicipalityId;
	}
	public void setNegativeMunicipalityId(Integer negativeMunicipalityId) {
		this.negativeMunicipalityId = negativeMunicipalityId;
	}
	public String getNegativeMunicipalityName() {
		return negativeMunicipalityName;
	}
	public void setNegativeMunicipalityName(String negativeMunicipalityName) {
		this.negativeMunicipalityName = negativeMunicipalityName;
	}
	public Integer getNegativeStateId() {
		return negativeStateId;
	}
	public void setNegativeStateId(Integer negativeStateId) {
		this.negativeStateId = negativeStateId;
	}
	public String getNegativeStateName() {
		return negativeStateName;
	}
	public void setNegativeStateName(String negativeStateName) {
		this.negativeStateName = negativeStateName;
	}
	public Integer getNegativeCountryId() {
		return negativeCountryId;
	}
	public void setNegativeCountryId(Integer negativeCountryId) {
		this.negativeCountryId = negativeCountryId;
	}
	public String getNegativeCountryName() {
		return negativeCountryName;
	}
	public void setNegativeCountryName(String negativeCountryName) {
		this.negativeCountryName = negativeCountryName;
	}
	public Date getNegativeCaseOccuerDate() {
		return negativeCaseOccuerDate;
	}
	public void setNegativeCaseOccuerDate(Date negativeCaseOccuerDate) {
		this.negativeCaseOccuerDate = negativeCaseOccuerDate;
	}
	public String getNegativeTestResult() {
		return negativeTestResult;
	}
	public void setNegativeTestResult(String negativeTestResult) {
		this.negativeTestResult = negativeTestResult;
	}
	public Integer getNegativeConfirmedCase() {
		return negativeConfirmedCase;
	}
	public void setNegativeConfirmedCase(Integer negativeConfirmedCase) {
		this.negativeConfirmedCase = negativeConfirmedCase;
	}
	@Override
	public String toString() {
		return "NegativePojo [negativeId=" + negativeId + ", negativePatientId=" + negativePatientId
				+ ", negativeAaddharNo=" + negativeAaddharNo + ", negativePatientName=" + negativePatientName
				+ ", negativeGender=" + negativeGender + ", negativePatientAge=" + negativePatientAge
				+ ", negativeMobileNo=" + negativeMobileNo + ", negativeZoneName=" + negativeZoneName
				+ ", negativeStaffId=" + negativeStaffId + ", negativeMunicipalityId=" + negativeMunicipalityId
				+ ", negativeMunicipalityName=" + negativeMunicipalityName + ", negativeStateId=" + negativeStateId
				+ ", negativeStateName=" + negativeStateName + ", negativeCountryId=" + negativeCountryId
				+ ", negativeCountryName=" + negativeCountryName + ", negativeCaseOccuerDate=" + negativeCaseOccuerDate
				+ ", negativeTestResult=" + negativeTestResult + ", negativeConfirmedCase=" + negativeConfirmedCase
				+ "]";
	}

}