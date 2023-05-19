package com.project.covidtracker.servies;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.covidtracker.dao.AdminDAO;
import com.project.covidtracker.dao.AppointmentUserDAO;
import com.project.covidtracker.dao.DataEntryDAO;
import com.project.covidtracker.model.AdminLoginPojo;
import com.project.covidtracker.model.AppointmentPojo;

@Service
public class AdminService {
	Logger logger = LoggerFactory.getLogger(AdminService.class);
	AdminDAO admindao=new AdminDAO() ;
    DataEntryDAO dataentrydao=new DataEntryDAO() ;
	AppointmentUserDAO appointmentuserdao=new AppointmentUserDAO();
    public Boolean adminLogin(AdminLoginPojo login, HttpSession session,Model model) {
   return admindao.adminLogin(login, session, model);
}
  public void negativeList(HttpSession session) {
	  dataentrydao.alertNegative(session);
  }
   public  void noAppoinment(Model model) throws JsonProcessingException {
	 admindao.apponitmentAlert(model);
 	 Integer approved=appointmentuserdao.approvedAppointment();
 	 model.addAttribute("approved", approved);
 	 Integer rejected=appointmentuserdao.rejectedAppointment();
 	 model.addAttribute("rejected", rejected);
 	 Integer pending=appointmentuserdao.pendingAppointment();
 	 model.addAttribute("pending", pending);
 	 Integer totalAppointment=appointmentuserdao.totalAppointment();
 	 model.addAttribute("totalAppointment", totalAppointment);
  }
   public void appoinmentApproved(AppointmentPojo appointmentPojo,Model model) throws JsonProcessingException {
	   admindao.approvedPatient(appointmentPojo,model);
	   noAppoinment(model);
   }
   public void appoinmentrejected(AppointmentPojo appointmentPojo,Model model) throws JsonProcessingException {
	   admindao.rejectAppointment(appointmentPojo,model);
	   noAppoinment(model);
   }
  
}
