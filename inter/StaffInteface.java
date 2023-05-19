package com.project.covidtracker.inter;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.project.covidtracker.exception.DublicateMailIdException;
import com.project.covidtracker.model.StaffPojo;



public interface StaffInteface {
	public void save(StaffPojo saveUser);
	public Integer positive() ;
	public Boolean satffLogin(StaffPojo user, HttpSession session, Model model);
}
