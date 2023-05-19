package com.project.covidtracker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.covidtracker.dao.DataEntryDAO;
import com.project.covidtracker.dao.PositiveDAO;
import com.project.covidtracker.servies.DataEntryService;
import com.twilio.rest.chat.v1.service.User;

@Controller
public class DataEntryController {



	
	DataEntryService dataentryservice=new DataEntryService();
	DataEntryDAO dataentrydao=new DataEntryDAO();
	String status;
	@PostMapping("/FindMunicipalityName")
	public void serachMunicipalityName(HttpServletRequest httprequest,HttpServletResponse response) throws IOException {
		dataentryservice.searchMunciapalityname(httprequest, response);
	
	 	}
	
	@PostMapping("/InsertPositiveNegative")
	public void positive(HttpServletRequest httprequest,HttpServletResponse response){
		dataentryservice.insertData(httprequest);
	     
	}
	@PostMapping("/RemoveNegativeData")
	public void removeNegativePatient(HttpServletRequest httprequest,HttpServletResponse response) {
		String negativeId=httprequest.getParameter("negativeId");
		Integer id=Integer.parseInt(negativeId);
		dataentryservice.deleteNegative(id);
	    
	}
	@GetMapping("/DeathUpdate")
	public String updateDeath(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Model model) throws JsonProcessingException {
		dataentryservice.deathUpdate(httpServletRequest);
	     dataentrydao.deathUpdate(model);
			return "DeathUpdate.html";
	}
    @GetMapping("/reUpdateAppointment")
    public String reUpdate(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Model model) throws JsonProcessingException {
    	dataentryservice.reUpdatePatient(httpServletRequest);
    	 dataentrydao.deathUpdate(model);
		return "DeathUpdate.html";
    }
}
