package com.project.covidtracker.inter;


import javax.servlet.http.HttpSession;

import com.project.covidtracker.model.AppointmentPojo;



public interface AppointmentInterface {
	
	 public void viewAppointmnet(HttpSession session2);
	   	public Integer approvedAppointment(AppointmentPojo appointmentPojo);
	   	public Integer rejectedAppointment();
	   	public Integer pendingAppointment();
	   	public Integer totalAppointment() ;
	    public void testApplyPatientData(AppointmentPojo appointmentPojo);
	    public String testApplyPatientData(AppointmentPojo appointmentPojo, String mailId);
}
