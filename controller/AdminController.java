package com.project.covidtracker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.project.covidtracker.dao.AdminDAO;
import com.project.covidtracker.dao.AppointmentUserDAO;
import com.project.covidtracker.dao.DataEntryDAO;
import com.project.covidtracker.dao.StaffDAO;

import com.project.covidtracker.model.AdminLoginPojo;
import com.project.covidtracker.model.AppointmentPojo;

import com.project.covidtracker.model.StaffPojo;
import com.project.covidtracker.servies.AdminService;
import com.project.covidtracker.servies.AppoinmentService;
import com.project.covidtracker.servies.CaseCountService;
import com.project.covidtracker.servies.StaffService;
import com.project.covidtracker.validation.Validation;



@Controller
public class AdminController {

   private   AdminDAO admindao=new AdminDAO();
 
     AppointmentUserDAO appointmentuserdao=new AppointmentUserDAO();

     AdminService adminservice=new AdminService();

     DataEntryDAO dataentrydao=new DataEntryDAO();

     CaseCountService casecountservice=new CaseCountService();

     StaffDAO staffdao=new StaffDAO() ;

	 AppointmentUserDAO appoinmentuserdao=new AppointmentUserDAO();

	 AppoinmentService appoinmentservice=new AppoinmentService();

	StaffService staffservice=new StaffService();
     @RequestMapping("/Test")
     public String testPatient() {
    	 
		return "TestPatientLoginForm.html";
    	 
     }
     @RequestMapping("/newNewAppoinment")
    	 public String appoinment(@ModelAttribute("Appointment")AppointmentPojo appointmentPojo,HttpSession session) {
		return "AppoinmentBooking.html";
    	 
     }
     @RequestMapping("/LandingPage")
     public String landingPage() {
		return "LandingPage.html";
    	 
     }

     @RequestMapping("/AdminChart")
     public String adminChart(Model model) {
    	 casecountservice.caseCount(model);
    	 casecountservice.chart(model);
		return "jsp/AdminChart.jsp";
    	 
     }
     @PostMapping("/AdminLogin")
     public String adminLogin(@ModelAttribute("admin")AdminLoginPojo adminPojo,HttpSession session,Model model) throws JsonProcessingException {
              casecountservice.caseCount(model); 
			  casecountservice.chart(model);
  	   if( Boolean.TRUE.equals(adminservice.adminLogin(adminPojo, session, model))) {
				  dataentrydao.merageData(model);
               return "AdminDashBorad.html";
               }
    	   else if( Boolean.FALSE.equals(adminservice.adminLogin(adminPojo, session, model))) {
               return "AdminLogin.html";
               }
              return "AdminLogin.html" ;
    	 
     }
    @RequestMapping("/slickGrid")
    public String slickGrid(Model model) throws JsonProcessingException {
  	  admindao.alertPositivePatient(model); 
		return "SlickGrid.html";
    	
    }

 	@RequestMapping("/patientlogin")
 	public String testPatientLogin() {
 		return "TestPatientLoginForm.html";
 		
 	}
    @RequestMapping("/StaffPage")
	 public String staffLoginPage(@ModelAttribute("StaffReg")StaffPojo user) {
		return "StaffRegLog.html";
		 
	 }
  //Medical Staff Register
    @GetMapping("/staffRegister")
	public String saveUser(@ModelAttribute("StaffReg")StaffPojo user ) {
   	       staffservice.save(user);
           return "StaffRegLog.html";

}
     @RequestMapping("/AdminPage")
     public String positiveAlert(Model model,HttpSession session,@ModelAttribute("admin")AdminLoginPojo adminPojo) {
		return "AdminLogin.html";
    	 
     }
     @RequestMapping("/Appointments")
    	  public String appointmentReq(Model model) throws JsonProcessingException {
    	  adminservice.noAppoinment( model);
    	 return "AppointmentDashBorad.html";
    }
     @RequestMapping("/AboutUs")
     public String aboutUs() {
		return "AboutUs.html";
    	 
     }
     @RequestMapping("/design")
     public String findPatient() {
    	 
		return "SlickGrid.html";
  }
}
