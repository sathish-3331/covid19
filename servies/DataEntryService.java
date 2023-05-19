package com.project.covidtracker.servies;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.project.covidtracker.dao.DataEntryDAO;
import com.project.covidtracker.dao.PositiveDAO;
import com.project.covidtracker.model.DeathUpdatePojo;
import com.project.covidtracker.model.NegativePojo;
import com.project.covidtracker.model.PositivePojo;

@Service
public class DataEntryService {
	DataEntryDAO dataentrydao=new DataEntryDAO();
    PositiveDAO positivedao=new PositiveDAO();
    public void searchMunciapalityname(HttpServletRequest httprequest,HttpServletResponse response) throws IOException {
	String corpoartionName=	httprequest.getParameter("municipalityId");
	String location=dataentrydao.findMunicipalityName(Integer.parseInt(corpoartionName));
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("YouChooseMunicipalLocataion",location);
	PrintWriter print = response.getWriter();
    print.print(jsonObject);
    print.flush();
    print.close();
}
    public void insertData(HttpServletRequest httprequest) {
	String patientName=httprequest.getParameter("patientName");
	String aadharNumber= httprequest.getParameter("addharNumber");
    String mobileNumber=httprequest.getParameter("mobileNumber");
    String strDate=httprequest.getParameter("Testdate");
    String patientAge=httprequest.getParameter("Patientage");
    String gender=httprequest.getParameter("gender");
    String trackId=httprequest.getParameter("trackId");
    String zoneName=httprequest.getParameter("zoneName");
    String municiPalityName=httprequest.getParameter("MuniciPalityName");
    String result=httprequest.getParameter("result");
    String stateName=httprequest.getParameter("stateName");
    Date date =Date.valueOf(strDate);
    Long convert=Long.parseLong(mobileNumber); 
    Long convertAadhar=Long.parseLong(aadharNumber);
    Integer convertTrackId=Integer.parseInt(trackId);
    Integer convertAge=Integer.parseInt(patientAge);
    //SqlInsert
    if(result.equals("Positive")) {
    PositivePojo positiveUser = new PositivePojo();
    positiveUser.setPatientName(patientName);
    positiveUser.setAddharNo(convertAadhar);//aadharNumber
    positiveUser.setMobileNo(convert);//mobileNumber
    positiveUser.setCaseOccuerDate(date);
    positiveUser.setPatientAge(convertAge);//Age
    positiveUser.setGender(gender);
    positiveUser.setMunicipalityId(convertTrackId);
    positiveUser.setZoneName(zoneName);
    positiveUser.setMunicipalityName(municiPalityName);
    positiveUser.setStateName(stateName);
    positiveUser.setTestResult(result);
    positiveUser.setCountryName("INDIA");
    positiveUser.setConfirmedCase(1);
    positivedao.insertPoitivePatient(positiveUser);
    positivedao.deleteTestPatient(convertAadhar);
    }else {
   	 NegativePojo negativeUser=new NegativePojo();
   	 negativeUser.setNegativePatientName(patientName);
   	 negativeUser.setNegativeAaddharNo(convertAadhar);
   	 negativeUser.setNegativeMobileNo(convert);
   	 negativeUser.setNegativeCaseOccuerDate(date);
   	 negativeUser.setNegativePatientAge(convertAge);
   	 negativeUser.setNegativeGender(gender);
   	 negativeUser.setNegativeMunicipalityId(convertTrackId);
   	 negativeUser.setNegativeZoneName(zoneName);
   	 negativeUser.setNegativeMunicipalityName(municiPalityName);
   	 negativeUser.setNegativeStateName(stateName);
   	 negativeUser.setNegativeTestResult(result);
   	 negativeUser.setNegativeCountryName("INDIA");
   	 negativeUser.setNegativeConfirmedCase(1);
   	 dataentrydao.insertNegativePatient(negativeUser);
     positivedao.deleteTestPatient(convertAadhar);
   	 
    }
    }
    
    public void  deleteNegative(Integer id) {
    	 dataentrydao.removeNegative(id);
    }
    
   public void deathUpdate(HttpServletRequest httpServletRequest) {
		 String deathPatientAaddharNo=httpServletRequest.getParameter("deathPatientAaddharNo");
		 String deathPatientName=httpServletRequest.getParameter("deathPatientName");
		 String deathPatientGender=httpServletRequest.getParameter("deathPatientGender");
		 String deathPatientAge=httpServletRequest.getParameter("deathPatientAge");
		 String deathPatientMobileNo=httpServletRequest.getParameter("deathPatientMobileNo");
		 String zoneName=httpServletRequest.getParameter("zoneName");
		 String municipalityId=httpServletRequest.getParameter("municipalityId");
		 String stateName=httpServletRequest.getParameter("stateName");
		 String deathForReson=httpServletRequest.getParameter("resonForDeath");  
	 Long convertAadharNo=Long.parseLong(deathPatientAaddharNo);
	 Integer convertPatientAge=Integer.parseInt(deathPatientAge);
	 Long convertMobileNo=Long.parseLong(deathPatientMobileNo); 
     Integer covertMunicipalityId=Integer.parseInt(municipalityId);
     
     DeathUpdatePojo deathUpdate=new DeathUpdatePojo();
     deathUpdate.setDeathPatientAaddharNo(convertAadharNo);
     deathUpdate.setDeathPatientName(deathPatientName);
     deathUpdate.setDeathPatientGender(deathPatientGender);
     deathUpdate.setDeathPatientAge(convertPatientAge);
     deathUpdate.setDeathPatientMobileNo(convertMobileNo);
     deathUpdate.setZoneName(zoneName);
     deathUpdate.setMunicipalityId(covertMunicipalityId);
     deathUpdate.setStateName(stateName);
     deathUpdate.setCountryName("INDIA");
     deathUpdate.setStatus("Death");
     deathUpdate.setResonForDeath(deathForReson);
     deathUpdate.setConfirmedCase(1);
     dataentrydao.updateDeath(deathUpdate);
     positivedao.deleteTestPatient(convertAadharNo);
   }
    
	public  void reUpdatePatient(HttpServletRequest httpServletRequest) {
		 String deathPatientAaddharNo=httpServletRequest.getParameter("updatePatientAaddharNo");
		 Long convertAadharNo=Long.parseLong(deathPatientAaddharNo);
		 dataentrydao.reUpdatePatient(convertAadharNo);
	}
}  

