package com.project.covidtracker.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.covidtracker.connection.ConnectionUtil;
import com.project.covidtracker.inter.DataEntryInterface;
import com.project.covidtracker.mapper.AppointmnetViewMapper;
import com.project.covidtracker.mapper.DeathMapper;
import com.project.covidtracker.mapper.MergePositiveNegativeMapper;
import com.project.covidtracker.mapper.NegativeMapper;
import com.project.covidtracker.mapper.PositiveMapper;
import com.project.covidtracker.model.AppointmentPojo;
import com.project.covidtracker.model.DeathUpdatePojo;
import com.project.covidtracker.model.MeragePositiveNegativePojo;
import com.project.covidtracker.model.NegativePojo;
import com.project.covidtracker.model.PositivePojo;


public class DataEntryDAO implements DataEntryInterface {
	Logger logger = LoggerFactory.getLogger(DataEntryDAO.class);
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();

	public void insertNegativePatient(NegativePojo saveUser) {
			String sql = "insert  into Negative_Datas(addharno,patientname,gender,patientage,mobileno,zonename,municipalityid,municipalityname,statename,countryname,caseoccureddate,testresult,confirmedcase)Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			Object[] params = {saveUser.getNegativeAaddharNo(),saveUser.getNegativePatientName(),saveUser.getNegativeGender(),saveUser.getNegativePatientAge(),
					saveUser.getNegativeMobileNo(),saveUser.getNegativeZoneName(),saveUser.getNegativeMunicipalityId(),saveUser.getNegativeMunicipalityName(),saveUser.getNegativeStateName(),
					saveUser.getNegativeCountryName(),saveUser.getNegativeCaseOccuerDate(),saveUser.getNegativeTestResult(),saveUser.getNegativeConfirmedCase()};
			 jdbcTemplate.update(sql, params);
		}
		public void alertNegative(HttpSession session) {
			String sql=" Select negativeid,patientname,mobileno,testresult from negative_datas where testresult='Negative'";
			List<NegativePojo>negativeAlert=jdbcTemplate.query(sql,new NegativeMapper());
				session.setAttribute("negativeid",negativeAlert);		
		}

		public int removeNegative(Integer id) {
			String sql = "DELETE FROM Negative_Datas WHERE negativeid=?";
			String requestId=id.toString();
			return jdbcTemplate.update(sql, requestId);
		}
		public void deleteTestPatient(Long aadharNumber) {
			String sql = "DELETE FROM TestPatient_Data WHERE aadharnumber=?";
			String requestId=aadharNumber.toString();
			jdbcTemplate.update(sql, requestId);
		
		}
		public List<NegativePojo> listUsers() {
			String sql = "select * from PositiveUseres";
			return jdbcTemplate.query(sql,new NegativeMapper());
		}

		public NegativePojo findOne(Integer userId) {
			String sql = "select user_name from usersdetail where id=?";
			return  jdbcTemplate.queryForObject(sql,new NegativeMapper(), userId);
		}

		public String findById(String stateName) {
			String sql = "select SUM(ConfirmedCase)as total_Cases from PositiveUseres where StateName=?";
			String queryForObject = null;
			try {
				queryForObject = jdbcTemplate.queryForObject(sql, String.class, stateName);
			} catch (EmptyResultDataAccessException e) {
				logger.info(e.toString());
			}
			return queryForObject;
		}
		//Auto Entry StateName
		public String findStateName(Integer convertTrackId) {
			String sql="select State_Name from StateIndiaFind where municipality_Id=?";
			String queryForObject = null;
			try {
				queryForObject = jdbcTemplate.queryForObject(sql, String.class,convertTrackId);
			} catch (EmptyResultDataAccessException e) {
				logger.info(e.toString());
			}
			return queryForObject;
			}
		
           //Daynamic dropDown 
		  public List<Long>dropDownMunicipalityId() {
			   String sql = "Select  municipality_Id from StateIndiaFind";
			   logger.info("DropDownList");
			   return jdbcTemplate.queryForList(sql, Long.class);
			 
			  }
		  
		    public String findMunicipalityName(Integer municiplaityId) {
		    	 String sql="SELECT municipality_Name from StateIndiaFind where municipality_Id=?";
					return jdbcTemplate.queryForObject(sql, String.class,municiplaityId);
					}
		    
		    public Integer positiveCount() {
				   String sql = "Select  count(*) from POSITIVE_DATAS";
				   logger.info("DropDownList");
				   return jdbcTemplate.queryForObject(sql, Integer.class);
				 
				  }
		    public Integer negativeCount() {
				   String sql = "Select  count(*) from POSITIVE_DATAS";
				   logger.info("DropDownList");
				   return jdbcTemplate.queryForObject(sql, Integer.class);
				 
				  }
		    public  void merageData(Model model) throws JsonProcessingException {
		    	String sql="select POSITIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from Positive_Datas where MESSAGESTATUS='Pending'  Union select NEGATIVEID,ADDHARNO,PATIENTNAME,MOBILENO,TESTRESULT from NEGATIVE_DATAS where MESSAGESTATUS='Pending'";
		    	List<MeragePositiveNegativePojo>mergeDataList=jdbcTemplate.query(sql,new MergePositiveNegativeMapper());
				List<Map<String,Object>>mergePN=new ArrayList<>();
				for(MeragePositiveNegativePojo meragePositiveNegativePojo:mergeDataList) {
					Map<String, Object>mergeList=new HashMap<>();
					mergeList.put("testPositiveId", meragePositiveNegativePojo.getTestPositiveId());
					mergeList.put("testAadharNumber",meragePositiveNegativePojo.getTestAddhar());
					mergeList.put("testPatientName", meragePositiveNegativePojo.getTestPatientName());
					mergeList.put("testMobileNo", meragePositiveNegativePojo.getTestMobileNo());
					mergeList.put("testDataResult", meragePositiveNegativePojo.getTestDataResult());
					mergePN.add(mergeList);
					}
				
				   List<Map<String, Object>> mergeLists=mergePN.stream().toList();
				
				    ObjectMapper mergePositiveNegative=new ObjectMapper();
			        String totalList=mergePositiveNegative.writeValueAsString(mergeLists);
					model.addAttribute("mergePositiveNegative",totalList);
		    }
	
		    public void sendMessageSuccesfully(Long mobileNo) {
				String approved="Update POSITIVE_DATAS set MessageStatus='Send' where MOBILENO=?";
				jdbcTemplate.update(approved,mobileNo );
				
			}

		    public void negativeSendMessageSuccessfully(Long mobileNo) {
				String approved="Update negative_datas set MessageStatus='Send' where MOBILENO=?";
				jdbcTemplate.update(approved,mobileNo );
				
			}
		
		    public void deathUpdate(Model model) throws JsonProcessingException {
		    	String viewappoinment="Select appointregid,AADHARNUMBER,username,age,mobilenumber,Gender,mailid,zoneareaname,postcode,appoinmentrequireddate,SYMPTOMS1,SYMPTOMS2,SYMPTOMS3,SYMPTOMS4,SYMPTOMS5,OTHER_ISSUE,STATENAME from Appointment_Data where not OTHER_ISSUE='none'";
				List<AppointmentPojo>viewReq=jdbcTemplate.query(viewappoinment,new DeathMapper());
				List<Map<String,Object>>appointmentList=new ArrayList<>();
				for(AppointmentPojo appointmentPojo:viewReq) {
					Map<String, Object>appointmentPatientList=new HashMap<>();
					appointmentPatientList.put("Deathappointregid",appointmentPojo.getAppointRegId());
					appointmentPatientList.put("patientAaadharNumber", appointmentPojo.getAadharNumber());
					appointmentPatientList.put("Deathusername",appointmentPojo.getUserName());
	                appointmentPatientList.put("age",appointmentPojo.getAge());
					appointmentPatientList.put("mobilenumber",appointmentPojo.getMobileNo());
					appointmentPatientList.put("Gender",appointmentPojo.getGender());
					appointmentPatientList.put("zoneareaname",appointmentPojo.getZoneAreaName());
					appointmentPatientList.put("stateName", appointmentPojo.getStateName());
					appointmentPatientList.put("postcode",appointmentPojo.getPostCode());
					appointmentPatientList.put("appoinmentrequireddate",appointmentPojo.getAppoinmentRequiredDate());
					appointmentPatientList.put("feverOrChills", appointmentPojo.getFeverorChills());
					appointmentPatientList.put("Cough",appointmentPojo.getCough());
					appointmentPatientList.put("Thoratpain", appointmentPojo.getThoratPain());
					appointmentPatientList.put("fatigue", appointmentPojo.getFatigue());
					appointmentPatientList.put("muscleOrBodyAches", appointmentPojo.getMuscleOrBodyAches());
					appointmentPatientList.put("otherHealthIssue",appointmentPojo.getOtherHealthIssue());
					appointmentList.add(appointmentPatientList);
		}
				ObjectMapper appointments=new ObjectMapper();
		        String pos=appointments.writeValueAsString(appointmentList);
				model.addAttribute("DeathList",pos);
				logger.info(pos); 
		    }
		    
		   public void updateDeath(DeathUpdatePojo deathUpdatePojo) {
			   String deathUpdation="insert into Death_Datas(ADDHARNO,PATIENTNAME,GENDER,PATIENTAGE,MOBILENO,ZONENAME,MUNICIPALITYID,STATENAME,COUNTRYNAME,CASEOCCUREDDATE,TESTRESULT,RESON_For_Death,CONFIRMEDCASE)values(?,?,?,?,?,?,?,?,?,LocalTimestamp,?,?,?)";
			   Object[] updation= {deathUpdatePojo.getDeathPatientAaddharNo(),deathUpdatePojo.getDeathPatientName(),deathUpdatePojo.getDeathPatientGender(),deathUpdatePojo.getDeathPatientAge(),deathUpdatePojo.getDeathPatientMobileNo(),deathUpdatePojo.getZoneName(),
					   deathUpdatePojo.getMunicipalityId(),deathUpdatePojo.getStateName(),deathUpdatePojo.getCountryName(),deathUpdatePojo.getStatus(),deathUpdatePojo.getResonForDeath(),deathUpdatePojo.getConfirmedCase()};
			   jdbcTemplate.update(deathUpdation, updation);
			   }
		   
		    public void reUpdatePatient(Long aadharNumber) {
				String none="Update APPOINTMENT_DATA set OTHER_ISSUE='none' where AADHARNUMBER=?";
				jdbcTemplate.update(none,aadharNumber );
				
			}
		   }
