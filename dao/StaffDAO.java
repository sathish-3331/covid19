package com.project.covidtracker.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.project.covidtracker.connection.ConnectionUtil;
import com.project.covidtracker.exception.DublicateMailIdException;
import com.project.covidtracker.inter.StaffInteface;
import com.project.covidtracker.mapper.MailIdMapper;
import com.project.covidtracker.mapper.StaffLoginMapper;
import com.project.covidtracker.mapper.StaffView;
import com.project.covidtracker.model.StaffPojo;




public class StaffDAO implements StaffInteface {
	Logger logger=LoggerFactory.getLogger(StaffDAO.class);
	JdbcTemplate jdbcTemplate= ConnectionUtil.getJdbcTemplate();
	StaffPojo staff=new StaffPojo();

	public void save(StaffPojo saveUser) {
		String sql = "insert into medicalStaff(user_name,user_mail_id, user_password,mobile_number, address ) values (?,?,?,?,?)";
		Object[] params = {saveUser.getUserName(), saveUser.getMailId(),saveUser.getPassword(),
				saveUser.getMobileNumber(),saveUser.getAddress() };
		jdbcTemplate.update(sql, params);
		logger.info("in DAO - save");
	}
	public Integer positive() {  
		String sql = "select SUM(ConfirmedCase)as total_Cases from Positive_Datas";
		logger.info("Connection");
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}

	public boolean emailExist(StaffPojo user) {
		String mail=user.getMailId();
		boolean status = false;
		String query="select user_mail_id from medicalStaff where user_mail_id=? ";
		List<StaffPojo>staffpojo=jdbcTemplate.query(query, new MailIdMapper(),mail);
		for(StaffPojo staffpojo1:staffpojo) {
			String email=staffpojo1.getMailId();
			if(email.equals(mail)) {
				status = false;
			}
			else {
				status= true;

			}
		}
		return status;

	}
	public void existingMailId(StaffPojo user) throws DublicateMailIdException{
        String mail=user.getMailId();
        String email="select USER_MAIL_ID  from medicalStaff";
        List<StaffPojo> user1 = jdbcTemplate.query(email, new MailIdMapper());

        for (StaffPojo user2 : user1)
        {
            String mailId = user2.getMailId();
            if(mailId.equals(mail))
            {
                throw new DublicateMailIdException();
            }
            else {
                logger.info("valid mail Id");
            }
        }
    }

	public Boolean satffLogin(StaffPojo user, HttpSession session, Model model) {
		logger.info("StaffLogin");
		String status;
		Integer userId =user.getUserId();
		String pass =user.getPassword();
		try {
			String loginQuery = "SELECT user_name,user_password FROM medicalStaff where user_Id=?";
			List<StaffPojo> staffPassword = jdbcTemplate.query(loginQuery, new StaffLoginMapper(), userId);
			for (StaffPojo staffpass : staffPassword) {

				if (staffpass != null) {
					String dbPassWord = staffpass.getPassword();
					if (pass.equals(dbPassWord)) {
						status="Success";
						String staffName = staffpass.getUserName();
						session.setAttribute("userName", staffName);
						model.addAttribute("userName",staffName);
						model.addAttribute("loginstatus",status);
						String mangerPro="SELECT user_Id,mobile_number,user_mail_id from medicalStaff where user_name=? ";
						List<StaffPojo>staffView=jdbcTemplate.query(mangerPro,new StaffView(),staffName);
						for (StaffPojo staffDetails :staffView ) {
							Integer satffId=staffDetails.getUserId();
							Long mob=staffDetails.getMobileNumber();
							String mail=staffDetails.getMailId();
							session.setAttribute("Id", satffId);
							session.setAttribute("Phone", mob);
							session.setAttribute("Email",mail);
							
						}
						return true;

					} else {
						status = "invalidCredentials";
						model.addAttribute("loginStatus", status);
						return false;
					}

				}

			}
			status = "invalidCredentials";
			model.addAttribute("loginStatus", status);
		} catch (NullPointerException e) {
			logger.info(e.toString());
		}
		return false;
	}
	
	public int forgetPassword(String eMail, String passWord) {
		
		String sql = "update medicalStaff set user_password=? where user_mail_id=?";
		Object[] params = { passWord, eMail};
		return jdbcTemplate.update(sql, params);
	}
	
	
	public String staffLogin(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,String userMailId,String password,HttpSession session) {
		String userId=userMailId;
		String userPassword=password;
		String loginQuery = "SELECT  user_password,USER_MAIL_ID,USER_NAME FROM medicalStaff where USER_MAIL_ID=?";
		List<StaffPojo> logins = jdbcTemplate.query(loginQuery, new StaffLoginMapper(),userId);
		
		String msg = null;
		for(StaffPojo learning:logins) {
            if(learning!=null) {
                String id=learning.getMailId();
                if(id.equals(userId)) {
                   String staffPassword=learning.getPassword();
                    if(staffPassword.equals(userPassword)) {
                    	String nameOfTheUser=learning.getUserName();
                    	session.setAttribute("userName",nameOfTheUser);
                    	System.out.println(nameOfTheUser);
                    	msg ="Your Session Will Be Activate";
                    }else {
                    	msg ="Invalid MailId(or) Password";
                    }
            }else {
            	msg ="UserMailId Invalid";
            }

		}
} if(msg == null) {
	msg="Credentials Invalid!";
}
		return msg;
		
	}
}