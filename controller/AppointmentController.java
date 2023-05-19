package com.project.covidtracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.covidtracker.dao.AppointmentUserDAO;
import com.project.covidtracker.model.AppointmentPojo;
import com.project.covidtracker.model.PositivePojo;
import com.project.covidtracker.servies.AdminService;
import com.project.covidtracker.servies.AppoinmentService;


@Controller
public class AppointmentController {

    AppointmentUserDAO  appointmentuserdao=new AppointmentUserDAO();

	AppoinmentService appoinmentservice=new AppoinmentService();

	AdminService adminservice=new AdminService() ;

	@PostMapping("/AppoinmentRequest")
	public String appointmentPatient(@ModelAttribute("Appointment")AppointmentPojo appointmentPojo,HttpSession session,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {
		/* appointmentuserdao.testApplyPatientData(appointmentPojo); */
	String mailId=httpServletRequest.getParameter("mailId");
	String check=appointmentuserdao.testApplyPatientData(appointmentPojo,mailId);
    PrintWriter print = httpServletResponse.getWriter();
    if(appointmentPojo.getAadharNumber() != null)
    	appointmentuserdao.appointmentInsert(appointmentPojo);
       else if(check.equals("Your MailId is Verifed") ){
    	print.print("Your MailId is Verifed");
    	 print.flush();
    	    print.close();
       //httpServletResponse.sendRedirect("AppoinmentBooking.html");
    }
    
    else if(check.equals("This MailId Already Exit!") ) {
    	print.print("MailId Already Exists...");
    	 print.flush();
    	    print.close();
    	// httpServletResponse.sendRedirect("AppoinmentBooking.html");
    	
    }
    AppointmentPojo appointmentPojo1=new AppointmentPojo();
   
	//return check;
	return "AppoinmentBooking.html";
		}
	@PostMapping("/ListTest")
	public void listTest(HttpServletRequest httprequest,HttpServletResponse response) throws IOException {
		String aadharNumber = httprequest.getParameter("aadharNumber");
		List<AppointmentPojo> list=appoinmentservice.findpatient(Long.parseLong(aadharNumber));
		 JSONObject jsonObject = new JSONObject();
		for(AppointmentPojo appoinment : list) {
            jsonObject.put("userName", appoinment.getUserName());
			jsonObject.put("AadharNumber", appoinment.getAadharNumber().toString());
			jsonObject.put("age",appoinment.getAge().toString());
			jsonObject.put("gender",appoinment.getGender());
			jsonObject.put("mobilenumber",appoinment.getMobileNo().toString());
			jsonObject.put("FeverOrChills",appoinment.getFeverorChills());
			jsonObject.put("Cough",appoinment.getCough());
			jsonObject.put("ThoratPain",appoinment.getThoratPain());
			jsonObject.put("Fatigue",appoinment.getFatigue());
			jsonObject.put("MuscleOrBodyAches",appoinment.getMuscleOrBodyAches());
			jsonObject.put("StateName",appoinment.getStateName());
		}
        PrintWriter print = response.getWriter();
        print.print(jsonObject);
        print.flush();
        print.close();
	}
	  @PostMapping("/TestPatientLogin")
	  public String testPatient(@ModelAttribute("testLogin")PositivePojo login,HttpSession session,Model model) throws JsonProcessingException {
	    	 appoinmentservice.patientLogin(login, session, model);
	    	   if(Boolean.TRUE.equals(appoinmentservice.patientLogin(login, session, model))) {
	    		   appoinmentservice.checkReport(login, session,model);
	               return "Covid-19Certificate.html";
	               }
	    	       else if(Boolean.FALSE.equals(appoinmentservice.patientLogin(login, session, model))) {
	               return "ErrorPage.html";
	               }
	              return "ErrorPage.html";
	    	 
	     }
	  
	  @PostMapping("/AppoinmnetApproved")
	     public String appointmentReqApproved(@ModelAttribute("checkbox")AppointmentPojo appointmentPojo,
	    		Model model) throws JsonProcessingException {
	             adminservice.appoinmentApproved(appointmentPojo,model);
	             return "AppointmentDashBorad.html";
	    	 }
	     @PostMapping("/AppoinmnetRejected")
	     public String appointmentReqRej(@ModelAttribute("checkbox")AppointmentPojo appointmentPojo,Model model) throws JsonProcessingException {
	    	  adminservice.appoinmentrejected(appointmentPojo,model);
					return "AppointmentDashBorad.html";
	     }
	    
	     @RequestMapping("/AdminLoginPage")
	     public String pageFind() {
			return "jsp/newAdmin.jsp";
	    	 
	     }
	}
	

