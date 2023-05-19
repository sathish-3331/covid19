package com.project.covidtracker.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.covidtracker.connection.ConnectionUtil;
import com.project.covidtracker.inter.AppointmentInterface;
import com.project.covidtracker.mapper.AppointmnetViewMapper;
import com.project.covidtracker.mapper.PositiveMapper;
import com.project.covidtracker.mapper.TestLoginMapper;
import com.project.covidtracker.mapper.TestPatientMapper;
import com.project.covidtracker.model.AppointmentPojo;
import com.project.covidtracker.model.PositivePojo;


public class AppointmentUserDAO implements AppointmentInterface{
	Logger logger = LoggerFactory.getLogger(AppointmentUserDAO.class);
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
        
        AppointmentPojo appoinmentpojo=new AppointmentPojo();

  
    	public void viewAppointmnet(HttpSession session2) {
    		Integer appointmentUserId = (Integer) session2.getAttribute("Id");
    		String viewLeave = "Select appointregid,userid,username,age,mobilenumber,Gender,mailid,password,zoneareaname,postcode,appoinmentrequireddate,appointmenstatus from Appointment_Data where userid=?";
    		List<AppointmentPojo> view = jdbcTemplate.query(viewLeave, new AppointmnetViewMapper(), appointmentUserId);
    			session2.setAttribute("viewAppointment", view);
    		

    	}
    	public Integer approvedAppointment() {  
			  String sql = "select COUNT(*) from Appointment_Data where appointmenstatus='Approved'";
			  return jdbcTemplate.queryForObject(sql, Integer.class);
			 
		}	
    	public Integer rejectedAppointment() {  
			  String sql ="select COUNT(*) from Appointment_Data where appointmenstatus='Rejected'";
			  jdbcTemplate.queryForObject(sql, Integer.class);
			return jdbcTemplate.queryForObject(sql, Integer.class);
		}	
    	public Integer pendingAppointment() {  
			  String sql = "select COUNT(*) from Appointment_Data where appointmenstatus='Pending'";
			 
			return jdbcTemplate.queryForObject(sql, Integer.class);
		}	
    	public Integer totalAppointment() {  
			  String sql = "select COUNT(*) from Appointment_Data";
			return jdbcTemplate.queryForObject(sql, Integer.class);
		}


		@Override
          public String testApplyPatientData(AppointmentPojo appointmentPojo,String mailId) {
			
			String sql1="select  Count(MAILID) from APPOINTMENT_DATA where MAILID=?";
  			Integer stroeMailId=jdbcTemplate.queryForObject(sql1, Integer.class,mailId);
		
			if(stroeMailId==0) {
                return "Your MailId is Verifed";
			}else {
				
				return "This MailId Already Exit!" ;
			}
			
		}
	public String addharNumbeValid(AppointmentPojo appointmentPojo,Long aadharNumber) {
		String sql1="select  Count(AADHARNUMBER) from APPOINTMENT_DATA where AADHARNUMBER=?";
			Integer stroeMailId=jdbcTemplate.queryForObject(sql1, Integer.class,aadharNumber);
	
		if(stroeMailId==0) {
            return "Your AadharNumber is Verifed";
		}else {
			
			return "This aadharNumber Invalid!" ;
		}
		
	}
		
    public void appointmentInsert(AppointmentPojo appointmentPojo) {
	String sql = "insert into Appointment_Data(aadharNumber,username,age,mobilenumber,Gender,mailid,password,zoneareaname,postcode,appoinmentrequireddate,symptoms1,Symptoms2,Symptoms3,Symptoms4,Symptoms5,appointmenstatus,other_Issue,STATENAME)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'Pending',?,?)";
	Object[] params = {appointmentPojo.getAadharNumber(),appointmentPojo.getUserName(),appointmentPojo.getAge(),appointmentPojo.getMobileNo(),appointmentPojo.getGender(),appointmentPojo.getMailId(),appointmentPojo.getPassword(),appointmentPojo.getZoneAreaName(),
			appointmentPojo.getPostCode(),appointmentPojo.getAppoinmentRequiredDate(),appointmentPojo.getFeverorChills(),appointmentPojo.getCough(),
			appointmentPojo.getThoratPain(),appointmentPojo.getFatigue(),appointmentPojo.getMuscleOrBodyAches(),appointmentPojo.getOtherHealthIssue(),appointmentPojo.getStateName()
			                            };	
	jdbcTemplate.update(sql, params);
}
		
    public List<Long> findPatientAadharNumberDao() { 
			 String status="Approved";
			  String sql ="SELECT aadharnumber FROM Appointment_Data where APPOINTMENSTATUS='"+status+"'" ; 
			  logger.info("connection"+jdbcTemplate); 
			  List<Long> data3 = jdbcTemplate.queryForList(sql, Long.class); 
			  logger.info("data3");
			  return data3;
}
		 public List<AppointmentPojo> findpatient(long aadharNumber) { 
			 String sql ="SELECT username,aadharNumber,age,Gender,mobilenumber,symptoms1,Symptoms2,Symptoms3,Symptoms4,Symptoms5,STATENAME FROM Appointment_Data where aadharNumber=?";
		     logger.info(sql);
			  List<AppointmentPojo> data3 = jdbcTemplate.query(sql,new TestPatientMapper(),aadharNumber );
			logger.info("data3"); 
			 return data3;
}
			public Boolean patientLogin(PositivePojo user, HttpSession session, Model model) {
				logger.info("StaffLogin");
				String status;
				Long userId =user.getAddharNo();
				Long pass =user.getMobileNo();
				try {
				String loginQuery = "SELECT patientname,mobileno FROM Positive_Datas where addharno=? union SELECT patientname,mobileno from NEGATIVE_DATAS where ADDHARNO=?";
				Object[] userIds= {userId,userId};
				List<PositivePojo> adminPassword = jdbcTemplate.query(loginQuery, new TestLoginMapper(), userIds);
				for (PositivePojo adminpass : adminPassword) {
					if (adminpass != null) {
						Long dbPassWord = adminpass.getMobileNo();
						if (pass.equals(dbPassWord)) {
							
							
								status="Success";
								String adminName = adminpass.getPatientName();
								session.setAttribute("userName", adminName);
								model.addAttribute("LoginStatus",status);
								
							  
                        return true;
						} else {
							status = "invalidCredentials";
							model.addAttribute("loginStatus", status);
							return false;
						}

					}

				}
				status = "invalidCredentials";
				model.addAttribute("loginStatus", status);
				} catch (NullPointerException e) {
					logger.info(e.toString());
					}
				return false;
		}
		
	public void checkReport( PositivePojo login,HttpSession session,Model model) throws JsonProcessingException {
	  long aadhar= login.getAddharNo();
         String sql="select ADDHARNO,PATIENTNAME,MOBILENO,GENDER,PATIENTAGE,TESTRESULT,CASEOCCUREDDATE from Positive_Datas where ADDHARNO=?  Union select ADDHARNO,PATIENTNAME,MOBILENO,GENDER,PATIENTAGE,TESTRESULT,CASEOCCUREDDATE from NEGATIVE_DATAS where ADDHARNO=?";
     	 Object[] userIds= {aadhar,aadhar};
		 List<PositivePojo>positiveAlert=jdbcTemplate.query(sql,new PositiveMapper(),userIds);
			for(PositivePojo positivepojo:positiveAlert) {
				System.out.println();
				model.addAttribute("aadharNumber",positivepojo.getAddharNo());
				model.addAttribute("patientName", positivepojo.getPatientName());
				model.addAttribute("mobileNo", positivepojo.getGender());
				model.addAttribute("gender", positivepojo.getGender());
				model.addAttribute("age", positivepojo.getPatientAge());
				model.addAttribute("testResult", positivepojo.getTestResult());
				model.addAttribute("date", positivepojo.getCaseOccuerDate());
	}

		  }
	@Override
	public Integer approvedAppointment(AppointmentPojo appointmentPojo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void testApplyPatientData(AppointmentPojo appointmentPojo) {
		// TODO Auto-generated method stub
		
	}
}		

