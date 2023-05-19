package com.project.covidtracker.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.covidtracker.connection.ConnectionUtil;
import com.project.covidtracker.inter.AdminInterFace;
import com.project.covidtracker.mapper.AdminLoginMapper;
import com.project.covidtracker.mapper.AppointmnetViewMapper;
import com.project.covidtracker.mapper.PositiveMapper;
import com.project.covidtracker.model.AdminLoginPojo;
import com.project.covidtracker.model.AppointmentPojo;
import com.project.covidtracker.model.PositivePojo;




public class AdminDAO implements AdminInterFace {

	Logger logger = LoggerFactory.getLogger(AdminDAO.class);
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
   
	public void apponitmentAlert(Model model) throws JsonProcessingException {
		String viewappoinment="Select appointregid,username,age,mobilenumber,Gender,mailid,zoneareaname,postcode,appoinmentrequireddate,appointmenstatus from Appointment_Data where appointmenstatus='Pending' and other_Issue='none'";
		List<AppointmentPojo>viewReq=jdbcTemplate.query(viewappoinment,new AppointmnetViewMapper());
		List<Map<String,Object>>appointmentList=new ArrayList<>();
		for(AppointmentPojo appointmentPojo:viewReq) {
			Map<String, Object>appointmentPatientList=new HashMap<>();
			appointmentPatientList.put("appointregid",appointmentPojo.getAppointRegId());
			appointmentPatientList.put("username",appointmentPojo.getUserName());
			appointmentPatientList.put("age",appointmentPojo.getAge());
			appointmentPatientList.put("mobilenumber",appointmentPojo.getMobileNo());
			appointmentPatientList.put("Gender",appointmentPojo.getGender());
			appointmentPatientList.put("zoneareaname",appointmentPojo.getZoneAreaName());
			appointmentPatientList.put("postcode",appointmentPojo.getPostCode());
			appointmentPatientList.put("appoinmentrequireddate",appointmentPojo.getAppoinmentRequiredDate());
			appointmentPatientList.put("appointmenstatus",appointmentPojo.getAppointmenStatus());
			appointmentList.add(appointmentPatientList);
}
		ObjectMapper appointments=new ObjectMapper();
        String pos=appointments.writeValueAsString(appointmentList);
		model.addAttribute("appointmentList",pos);
		logger.info(pos); 
	}
	public void alertPositivePatient(Model model) throws JsonProcessingException {
		String sql=" Select positiveid,patientname,mobileno,testresult from Positive_Datas where testresult='Positive' and patientname,mobileno,testresult from Positive_Datas where MessageStatus='Pending' ";
		List<PositivePojo>positiveAlert=jdbcTemplate.query(sql,new PositiveMapper());
		List<Map<String,Object>>positiveList=new ArrayList<>();
		for(PositivePojo positivepojo:positiveAlert) {
			Map<String, Object>patientList=new HashMap<>();
			patientList.put("positiveId", positivepojo.getPositiveId());
			patientList.put("patientName", positivepojo.getPatientName());
			patientList.put("mobileNo", positivepojo.getMobileNo());
			patientList.put("testResult",positivepojo.getTestResult());
			positiveList.add(patientList);
}
		recoveredCase();
        ObjectMapper patientList=new ObjectMapper();
        String pos=patientList.writeValueAsString(positiveList);
		model.addAttribute("positivePatientList",pos);
		logger.info(pos);
        
	}
	public void recoveredCase() {
		String sql=" UPDATE Positive_Datas SET testresult ='Recovered' WHERE ADDHARNO in (select addharno from Positive_Datas where caseoccureddate<sysdate-7) AND testresult='Positive'";
		jdbcTemplate.update(sql);
	}
	public void approvedPatient(AppointmentPojo appointmentPojo,Model model) throws JsonProcessingException {
		Integer appointmentId=appointmentPojo.getAppointRegId();
		Integer appoinmentPatientId=null;
		String appointregid=appointmentPojo.getUserName();
		String[] leaveId=appointregid.split("[, .]+");
		for(String myId:leaveId) {
			appoinmentPatientId=Integer.parseInt(myId);
		String approved="Update Appointment_Data set appointmenstatus='Approved' where appointregid=?";
		jdbcTemplate.update(approved,appoinmentPatientId );
		apponitmentAlert(model);
		}
	}
   public void rejectAppointment(AppointmentPojo appointmentPojo,Model model) throws JsonProcessingException {
	   Integer appointmentId=appointmentPojo.getAppointRegId();
		Integer appoinmentPatientId=null;
		String requestId=appointmentPojo.getUserName();
		String[]  rejectId=requestId.split("[, .]+");
		for(String myId:rejectId) {
			appoinmentPatientId=Integer.parseInt(myId);
		String rejected="Update Appointment_Data set appointmenstatus='Rejected' where appointregid=?";
		jdbcTemplate.update(rejected,appoinmentPatientId );
		apponitmentAlert(model);
		}
	}
	public Boolean adminLogin(AdminLoginPojo user, HttpSession session, Model model) {
		logger.info("Login");
		String status;
		Integer userId =user.getUserId();
		String pass =user.getUserPassword();
		try {
		String loginQuery = "SELECT adminname,adminpassword FROM admintable where adminid=?";
		List<AdminLoginPojo> adminPassword = jdbcTemplate.query(loginQuery, new AdminLoginMapper(), userId);
		for (AdminLoginPojo adminpass : adminPassword) {

			if (adminpass != null) {
				String dbPassWord = adminpass.getUserPassword();
				if (pass.equals(dbPassWord)) {
					
					
						status="Success";
						String adminName = adminpass.getUserName();
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
  


}

