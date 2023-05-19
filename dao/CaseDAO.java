package com.project.covidtracker.dao;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.project.covidtracker.connection.ConnectionUtil;
import com.project.covidtracker.inter.CaseInterface;





	public class CaseDAO implements CaseInterface {
		JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();

	/*----Total CountryWise  Cases Count---*/
		
		public Integer positiveData() {  
			  String sql = "select SUM(ConfirmedCase)as total_Cases from Positive_Datas";
              return jdbcTemplate.queryForObject(sql, Integer.class);
		}	   
			   
		public Integer negetiveData() {
			   String sql= "select SUM(ConfirmedCase)as total_Cases from Negative_Datas";
			return  jdbcTemplate.queryForObject(sql, Integer.class);
		}   
		public Integer recoveredData() {
			   String sql = "select SUM(ConfirmedCase)as total_Cases from Positive_Datas where TestResult='Recovered'";
			return jdbcTemplate.queryForObject(sql, Integer.class);
			 
			  }
		/*--------------StateWise Cases Count --------*/
		 public String positiveStateData(String stateName,Model model) {
				String sql = "select SUM(confirmedcase)as total_Cases from Positive_Datas where StateName=?";
				model.addAttribute("userPassedName", stateName);
				String queryForObject = null;
				queryForObject = jdbcTemplate.queryForObject(sql, String.class, stateName);
				return queryForObject;
				}
		 public String negativeStateData(String stateName) {
				String sql = "select SUM(confirmedcase)as total_Cases from Negative_Datas where StateName=?";
				String queryForObject = null;
				queryForObject = jdbcTemplate.queryForObject(sql, String.class, stateName);
				return queryForObject;
				}
		 public String recoveredStateData(String stateName) {
				String sql = "select SUM(confirmedcase)as total_Cases from Positive_Datas  where TestResult='Recovered' AND  StateName=?";
	
				String queryForObject = null;
				queryForObject = jdbcTemplate.queryForObject(sql, String.class, stateName);
				return queryForObject;
				}
		 //Male or Female Count In DB data//
		 
		public Integer male() {
				String sql = "select COUNT(*) from Positive_Datas where Gender='Male'";
				return jdbcTemplate.queryForObject(sql,Integer.class);
				}

		 public Integer female() {
				String sql = "select COUNT(*) from Positive_Datas where Gender='Female'";
				return jdbcTemplate.queryForObject(sql, Integer.class);
	
		 }
		 public Integer age15To25() {
				String sql = "Select COUNT(PatientAge) as age from Positive_Datas where PatientAge between 15 and 25";
				return  jdbcTemplate.queryForObject(sql, Integer.class);
	
		 }
		 public Integer age25To45() {
				String sql = "Select COUNT(PatientAge) as age from Positive_Datas where PatientAge between 25 and 45";
				return jdbcTemplate.queryForObject(sql, Integer.class);
	
		 }
	   public Integer age45To70() {
			String sql = "Select COUNT(PatientAge) as age from Positive_Datas where PatientAge between 45 and 70";
			return jdbcTemplate.queryForObject(sql, Integer.class);

	 }
	   public Integer age70To90() {
			String sql = "Select COUNT(PatientAge) as age from Positive_Datas where PatientAge between 70 and 90";
           return jdbcTemplate.queryForObject(sql, Integer.class);
	 }
	   public Integer age90To110() {
			String sql = "Select COUNT(PatientAge) as age from Positive_Datas where PatientAge between 90 and 110";
          return jdbcTemplate.queryForObject(sql, Integer.class);

	 }
		 
	}
