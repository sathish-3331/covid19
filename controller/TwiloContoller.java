package com.project.covidtracker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.covidtracker.applicationproperties.Smsservice;
import com.project.covidtracker.dao.DataEntryDAO;


@RestController
public class TwiloContoller {
	
	Smsservice smsservice=new Smsservice();
	DataEntryDAO dataEntryDAO=new DataEntryDAO();
	Logger logger = LoggerFactory.getLogger(TwiloContoller.class);
	@PostMapping("/sendSms")
	public String sendSms(HttpServletRequest httprequest,HttpServletResponse response,Model model) {
		String report=httprequest.getParameter("report");
		if(report.equals("Positive")) {
        String body = httprequest.getParameter("name").toString()+" ,Covid Test report was Positive So You have to Qurantine  Yourself for 14-Days...";
		smsservice.sendSms("+91"+httprequest.getParameter("mobileNumber"),"+12056712127", body);
		String mobileNumber=httprequest.getParameter("mobileNumber");
		Long phoneNo=Long.parseLong(mobileNumber);
		dataEntryDAO.sendMessageSuccesfully(phoneNo);
		}	
		else if(report.equals("Recovered")) {
	        String body = httprequest.getParameter("name").toString()+" was recovered from covid .Need to take rest atleast 10 days...";
			smsservice.sendSms("+91"+httprequest.getParameter("mobileNumber"),"+12056712127", body);
			String mobileNumber=httprequest.getParameter("mobileNumber");
			Long phoneNo=Long.parseLong(mobileNumber);
			dataEntryDAO.sendMessageSuccesfully(phoneNo);
		}
		 else{
			String body = httprequest.getParameter("name").toString()+" ,Covid test Report was Negative So You  take Re-Test(One Week or 12days)";
			httprequest.getParameter("name");
			smsservice.sendSms("+91"+httprequest.getParameter("mobileNumber"),"+12056712127", body);
			String mobileNumber=httprequest.getParameter("mobileNumber");
			Long phoneNo=Long.parseLong(mobileNumber);
			dataEntryDAO.negativeSendMessageSuccessfully(phoneNo);
		}
		return "Message Send Succefully!";
		}
	}
	
