package com.project.covidtracker.servies;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.covidtracker.dao.AppointmentUserDAO;
import com.project.covidtracker.model.AppointmentPojo;
import com.project.covidtracker.model.PositivePojo;


@Service
public class AppoinmentService {
	AppointmentUserDAO appointmentuserdao= new AppointmentUserDAO();
    public void appointmentInsert(AppointmentPojo appoinmentpojo) {
		appointmentuserdao.testApplyPatientData(appoinmentpojo);
    }
    public  List<Long> findPatientAadharNumberDao(){
    	return appointmentuserdao.findPatientAadharNumberDao();
    }
    public void checkReport( PositivePojo login,HttpSession session,Model model) throws JsonProcessingException {
    	appointmentuserdao.checkReport(login, session,model);
    }
    public Boolean patientLogin(PositivePojo user, HttpSession session, Model model) {
    	return appointmentuserdao.patientLogin(user, session, model);
    }
    public List<AppointmentPojo> findpatient(long aadharNumber){
    	return appointmentuserdao.findpatient(aadharNumber);
    }
}
