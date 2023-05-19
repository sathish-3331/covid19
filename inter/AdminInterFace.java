package com.project.covidtracker.inter;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.covidtracker.model.AdminLoginPojo;
import com.project.covidtracker.model.AppointmentPojo;
import com.project.covidtracker.model.PositivePojo;

public interface AdminInterFace {
    public void apponitmentAlert(Model model) throws JsonProcessingException;
	public void alertPositivePatient(Model model) throws JsonProcessingException;
	public void approvedPatient(AppointmentPojo appointmentPojo,Model model) throws JsonProcessingException ;
	public void rejectAppointment(AppointmentPojo appointmentPojo,Model model) throws JsonProcessingException ;
	public Boolean adminLogin(AdminLoginPojo user, HttpSession session, Model model) ;
} 
