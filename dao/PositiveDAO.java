package com.project.covidtracker.dao;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.project.covidtracker.connection.ConnectionUtil;
import com.project.covidtracker.inter.PositiveInterface;
import com.project.covidtracker.mapper.PositiveMapper;
import com.project.covidtracker.model.PositivePojo;

	public class PositiveDAO implements PositiveInterface {
		Logger logger = LoggerFactory.getLogger(PositiveDAO.class);
		JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();

		public void insertPoitivePatient(PositivePojo saveUser)  {
			String sql = "insert  into Positive_Datas(addharno,patientname,gender,patientage,mobileno,zonename,municipalityid,municipalityname,statename,countryname,caseoccureddate,testresult,confirmedcase,MessageStatus)Values(?,?,?,?,?,?,?,?,?,?,?,?,?,'Pending')";
			Object[] params = {saveUser.getAddharNo(),saveUser.getPatientName(),saveUser.getGender(),saveUser.getPatientAge(),
					saveUser.getMobileNo(),saveUser.getZoneName(),saveUser.getMunicipalityId(),saveUser.getMunicipalityName(),saveUser.getStateName(),
					saveUser.getCountryName(),saveUser.getCaseOccuerDate(),saveUser.getTestResult(),saveUser.getConfirmedCase()};
			 jdbcTemplate.update(sql, params);
			logger.info("in InsertPoitivePatient - save");
		}
		public String deleteTestPatient(Long aadharNumber) {
			String sql = "DELETE FROM Appointment_Data WHERE aadharnumber=?";
			String requestId=aadharNumber.toString();
	        jdbcTemplate.update(sql, requestId);
			return requestId;
		
		}
			
		

		public int update(PositivePojo u1) {
			String sql = "update usersdetail set user_name=? where user_id=?";
			Object[] params = { u1.getPatientName(), u1.getPatientId() };
			return jdbcTemplate.update(sql, params);
		}

		public List<PositivePojo> listUsers() {
			String sql = "select * from PositiveUseres";
            logger.info("ListofUseres");
			return  jdbcTemplate.query(sql, new PositiveMapper());
		}

		public PositivePojo findOne(Integer userId) {
			String sql = "select user_name from usersdetail where id=?";
			logger.info("Finding one record.....");
			return  jdbcTemplate.queryForObject(sql, new PositiveMapper(), userId);
		}
            public String findById(String stateName) {
			String sql = "select SUM(ConfirmedCase)as total_Cases from PositiveUseres where StateName=?";
			String queryForObject = null;
			try {
				queryForObject = jdbcTemplate.queryForObject(sql, String.class, stateName);
				logger.info(queryForObject);
			} catch (EmptyResultDataAccessException e) {
				logger.info(e.toString());
			}
			return queryForObject;
		}
		public String find() {
			String sql = "select SUM(ConfirmedCase)as total_Cases from PositiveUseres";
	        logger.info("DB Status");
			String queryForObject = null;
			try {
				queryForObject = jdbcTemplate.queryForObject(sql, String.class);
				logger.info(queryForObject);
			} catch (EmptyResultDataAccessException e) {
				logger.info(e.toString());
			}
			return queryForObject;
		}
	}

