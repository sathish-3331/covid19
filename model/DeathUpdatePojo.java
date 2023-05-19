package com.project.covidtracker.model;

import java.sql.Date;

public class DeathUpdatePojo {
     private Integer deathPatientId;
     private  Long deathPatientAaddharNo;
     private  String deathPatientName;
     private String deathPatientGender;
     private Integer deathPatientAge;
     private Long deathPatientMobileNo;
     private String zoneName;
     private Integer staffId;
     private Integer municipalityId;
     private String municipalityName;
     private Integer stateId;
     private String stateName;
     private Integer countryId;
     private String countryName;
     private Date deathCaseOccurDate;
	 private Integer confirmedCase;
	 private String Status;
	 private String resonForDeath;
	 
	public String getResonForDeath() {
		return resonForDeath;
	}
	public void setResonForDeath(String resonForDeath) {
		this.resonForDeath = resonForDeath;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Integer getConfirmedCase() {
		return confirmedCase;
	}
	public void setConfirmedCase(Integer confirmedCase) {
		this.confirmedCase = confirmedCase;
	}
	public Integer getDeathPatientId() {
		return deathPatientId;
	}
	public void setDeathPatientId(Integer deathPatientId) {
		this.deathPatientId = deathPatientId;
	}
	public Long getDeathPatientAaddharNo() {
		return deathPatientAaddharNo;
	}
	public void setDeathPatientAaddharNo(Long deathPatientAaddharNo) {
		this.deathPatientAaddharNo = deathPatientAaddharNo;
	}
	public String getDeathPatientName() {
		return deathPatientName;
	}
	public void setDeathPatientName(String deathPatientName) {
		this.deathPatientName = deathPatientName;
	}
	public String getDeathPatientGender() {
		return deathPatientGender;
	}
	public void setDeathPatientGender(String deathPatientGender) {
		this.deathPatientGender = deathPatientGender;
	}
	public Integer getDeathPatientAge() {
		return deathPatientAge;
	}
	public void setDeathPatientAge(Integer deathPatientAge) {
		this.deathPatientAge = deathPatientAge;
	}
	public Long getDeathPatientMobileNo() {
		return deathPatientMobileNo;
	}
	public void setDeathPatientMobileNo(Long deathPatientMobileNo) {
		this.deathPatientMobileNo = deathPatientMobileNo;
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
	public Date getDeathCaseOccurDate() {
		return deathCaseOccurDate;
	}
	public void setDeathCaseOccurDate(Date deathCaseOccurDate) {
		this.deathCaseOccurDate = deathCaseOccurDate;
	}
	@Override
	public String toString() {
		return "DeathUpdatePojo [deathPatientId=" + deathPatientId + ", deathPatientAaddharNo=" + deathPatientAaddharNo
				+ ", deathPatientName=" + deathPatientName + ", deathPatientGender=" + deathPatientGender
				+ ", deathPatientAge=" + deathPatientAge + ", deathPatientMobileNo=" + deathPatientMobileNo
				+ ", zoneName=" + zoneName + ", staffId=" + staffId + ", municipalityId=" + municipalityId
				+ ", municipalityName=" + municipalityName + ", stateId=" + stateId + ", stateName=" + stateName
				+ ", countryId=" + countryId + ", countryName=" + countryName + ", deathCaseOccurDate="
				+ deathCaseOccurDate + ", confirmedCase=" + confirmedCase + ", Status=" + Status + ", resonForDeath="
				+ resonForDeath + "]";
	}



  
}
