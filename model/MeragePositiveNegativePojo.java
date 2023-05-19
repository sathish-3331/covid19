package com.project.covidtracker.model;

public class MeragePositiveNegativePojo {
	private Integer testPositiveId;
	private Integer testNegatived;
	private Long testAddhar;
	private String testPatientName;
	private Long testMobileNo;
	private String testDataResult;
	
	public Integer getTestPositiveId() {
		return testPositiveId;
	}
	public void setTestPositiveId(Integer testPositiveId) {
		this.testPositiveId = testPositiveId;
	}
	public Integer getTestNegatived() {
		return testNegatived;
	}
	public void setTestNegatived(Integer testNegatived) {
		this.testNegatived = testNegatived;
	}
	public Long getTestAddhar() {
		return testAddhar;
	}
	public void setTestAddhar(Long testAddhar) {
		this.testAddhar = testAddhar;
	}
	public String getTestPatientName() {
		return testPatientName;
	}
	public void setTestPatientName(String testPatientName) {
		this.testPatientName = testPatientName;
	}
	public Long getTestMobileNo() {
		return testMobileNo;
	}
	public void setTestMobileNo(Long testMobileNo) {
		this.testMobileNo = testMobileNo;
	}
	public String getTestDataResult() {
		return testDataResult;
	}
	public void setTestDataResult(String testResult) {
		this.testDataResult = testResult;
	}
	@Override
	public String toString() {
		return "MeragePositiveNegativePojo [testPositiveId=" + testPositiveId + ", testNegatived=" + testNegatived
				+ ", testAddhar=" + testAddhar + ", testPatientName=" + testPatientName + ", testMobileNo="
				+ testMobileNo + ", testDataResult=" + testDataResult + "]";
	}
	
	

}
