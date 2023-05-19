package com.project.covidtracker.servies;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.covidtracker.dao.StaffDAO;
import com.project.covidtracker.exception.DublicateMailIdException;
import com.project.covidtracker.model.StaffPojo;
@Service
public class StaffService {
	  StaffDAO staffdao=new StaffDAO();

		public Boolean satffLogin(StaffPojo user, HttpSession session, Model model) {
			return staffdao.satffLogin(user, session, model);
			}
		public int forgetPassword(String eMail, String passWord) {
			return staffdao.forgetPassword(eMail, passWord);
			
		}
		public void save(StaffPojo saveUser) {
			staffdao.save(saveUser);
		}
		public void existingMailId(StaffPojo user) throws DublicateMailIdException{
			staffdao.existingMailId(user);
		}

}
