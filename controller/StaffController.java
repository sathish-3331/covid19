package com.project.covidtracker.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.covidtracker.connection.ConnectionUtil;
import com.project.covidtracker.dao.AppointmentUserDAO;
import com.project.covidtracker.dao.DataEntryDAO;
import com.project.covidtracker.dao.StaffDAO;
import com.project.covidtracker.exception.DublicateMailIdException;
import com.project.covidtracker.model.AdminLoginPojo;
import com.project.covidtracker.model.StaffPojo;
import com.project.covidtracker.servies.AppoinmentService;
import com.project.covidtracker.servies.StaffService;
import com.project.covidtracker.validation.Validation;


@Controller
public class StaffController {
	
	DataEntryDAO dataentrydao=new DataEntryDAO();

    StaffDAO staffdao=new StaffDAO();

	AppointmentUserDAO appoinmentuserdao=new AppointmentUserDAO();

	AppoinmentService appoinmentservice=new AppoinmentService();

	StaffService staffservice=new StaffService();
	
         Validation valid=new Validation();
         Logger logger=LoggerFactory.getLogger(StaffController.class); 
       
       @GetMapping("/StartTest")
       public String testPatients(Model model) {
 		  List<Long> list=appoinmentservice.findPatientAadharNumberDao();
 		  List<Long>municiPalityList=dataentrydao.dropDownMunicipalityId();
          model.addAttribute("ListofMunicipalityId",municiPalityList.toString());
 		  model.addAttribute("ListofAadharNumber",list.toString());
		return "HospitalForm.html"; 
       }
  	@GetMapping("/loginStaff")
          public String loginStaff(@ModelAttribute("user")StaffPojo staffpojo,HttpSession session,Model model) throws JsonProcessingException {
		  logger.info("Through login controller"); 
		  staffservice.satffLogin(staffpojo, session, model);
		  if(Boolean.TRUE.equals(staffservice.satffLogin(staffpojo, session, model))) {
			 Integer positiveCount= dataentrydao.positiveCount();
		     Integer negativeCount=dataentrydao.negativeCount();
		     Integer count=positiveCount+negativeCount;
		     model.addAttribute("EntryDataCount", count);
		  return "MedicalDashBorad.html"; 
		  } 
		  else if(Boolean.FALSE.equals(staffservice.satffLogin(staffpojo, session, model))) {
		  return "StaffRegLog.html";
		  } 
		  return "StaffRegLog.html";
		  
		  }

     	// Admin login Controller
     	@PostMapping("/Adminlogin")
        public String adminLogin(@RequestParam("uname")String adminName,@RequestParam("psw") String password,HttpSession session,Model model) {
            logger.info("Through login controller");
            
            AdminLoginPojo user=new AdminLoginPojo();
            user.setUserName(adminName);
            user.setUserPassword(password);      
            if(model.getAttribute("loginstatus").equals("Success")) {
                return "jsp/DashBorad.jsp";
                }else if(model.getAttribute("loginStatus").equals("invalidCredentials")) {
                return "jsp/AdminLogin.jsp";
                }
               return "";
            
     	}
     	
     	@RequestMapping("/Froget")
     	public String forgetPassword(@RequestParam("user_email")String eMail,@RequestParam("psw") String password) {
     		staffservice.forgetPassword(eMail, password);
     		return "jsp/Forget.jsp";
     	}
     	
     @RequestMapping("/DeathUpdateStaff")
    	 public String deathUpdate(Model model) throws JsonProcessingException {
    	 dataentrydao.deathUpdate(model);
		return "DeathUpdate.html";
			
    		 
    	 }
     @PostMapping("/LoginStaffValid")
     public String loginStaffValid(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,ModelAndView modelAndView,HttpSession session) throws IOException, ServletException {
 		String userMailId=httpServletRequest.getParameter("userId");
 	    String userPassword=httpServletRequest.getParameter("userPassword");
 	    PrintWriter print = httpServletResponse.getWriter();
 	    String checkStaff=  staffdao.staffLogin(httpServletRequest, httpServletResponse, userMailId, userPassword, session);
 	    String nameOfUser=(String) session.getAttribute("userName");
 	     if(checkStaff.equals("UserMailId Invalid")) {
 	    	 print.print("UserMailId Invalid");
 	    	 print.flush();
 	    	 print.close(); 
 	    	 return "StaffRegLog.html";
 	     }else if(checkStaff.equals("Invalid MailId(or) Password")) {
 	    	 print.print("Invalid MailId(or) Password");
 	    	 print.flush();
 	    	 print.close();
 	    	 return "StaffRegLog.html";
 	     }else if(checkStaff.equals("Credentials Invalid!")) {
 	    	 print.print("Credentials Invalid!");
 	    	 print.flush();
 	    	 print.close(); 
 	    	 return "StaffRegLog.html";
 	     }
 	     else {
 	        print.print("Your Session Will Be Activate");
 	       // httpServletRequest.getRequestDispatcher("/MedicalDashBorad.html").forward(httpServletRequest, httpServletResponse);
 	        print.flush();
 	        print.close(); 
 	    	
 	        return checkStaff;
 	     }
        } 
     
     @RequestMapping("/launch")
     public ModelAndView launch(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,ModelAndView modelAndView,Model model,HttpSession session) throws IOException, ServletException {
    	String nameOfTheUser=(String) session.getAttribute("userName");
    	 modelAndView.setViewName("/MedicalDashBorad.html");
		 Integer positiveCount= dataentrydao.positiveCount();
	     Integer negativeCount=dataentrydao.negativeCount();
	     Integer count=positiveCount+negativeCount;
	     model.addAttribute("EntryDataCount", count);
		return modelAndView;
       }
}

