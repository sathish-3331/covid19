
package com.project.covidtracker.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.covidtracker.dao.PositiveDAO;
import com.project.covidtracker.model.PositivePojo;

@Controller
public class PositiveContoller {
	Logger logger = LoggerFactory.getLogger(PositiveContoller.class);

	PositiveDAO userDao=new PositiveDAO();

	@RequestMapping("/home")
	public String home() {
		logger.info("hi Home Page");
		return "jsp/Home.jsp";
	}

	@GetMapping("/register")
	public String saveUser(@RequestParam("id") Integer id, @RequestParam("userName") String name) {

		PositivePojo user = new PositivePojo();
		user.setPatientId(id);
		user.setPatientName(name);

		logger.info(user.getPatientId() + user.getPatientName());
		return "success.jsp";
	}

	@GetMapping("/update")
	public String updateUser(@RequestParam("userid") Integer userId, @RequestParam("name") String name, Model model) {
		logger.info("******" + userId + name);
		PositivePojo user = new PositivePojo();
		user.setPatientId(userId);
		user.setPatientName(name);
		int updateRows = userDao.update(user);
		model.addAttribute(updateRows);
		model.addAttribute("USER_LIST", user);
		return "redirect:listofusers";
	}

//displaying the data from DB
	@GetMapping("/listofusers")
	public String getAllUser(Model model) {
		logger.info("getting datas");
		List<PositivePojo> users = userDao.listUsers();// listofUsers
		model.addAttribute("USER_LIST", users);
		return "listofUsers.jsp";
	}
    //to find the user by id
	@GetMapping("/findUserbyId")
	public String findUserById(@RequestParam("stateName") String stateName, Model model) {
		logger.info("finding");
		String total = userDao.findById(stateName);
		logger.info(total);
		if (total==(null)) {
			throw new EmptyResultDataAccessException(stateName, 0);
		} else {
			model.addAttribute("TotalCases", total);
		}
		return "jsp/DashBorad.jsp";
	}
	@GetMapping("/chart")
	public String totalCases(Model model) {
		logger.info("Fetch");
		String cases = userDao.find();
		if (cases==(null)) {
			throw new EmptyResultDataAccessException(0);
		} else {
			logger.info("TotalCases:" + cases);
			model.addAttribute("overalDB",cases);
		}return "jsp/chart.jsp";
		
	}	
}