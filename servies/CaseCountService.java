package com.project.covidtracker.servies;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.covidtracker.dao.CaseDAO;

@Service
public class CaseCountService {

	CaseDAO casedao = new CaseDAO();
	Integer positive = null;
	Integer negative = null;
	Integer recovered = null;
	Integer male = null;
	Integer female = null;
	Integer youngAge = null;
	Integer middleAge = null;
	Integer normalAge = null;
	Integer grandaAge = null;
	Integer ultraAge = null;
	Integer total = null;

	public void caseCount(Model model) {
		positive = casedao.positiveData();
		negative = casedao.negetiveData();
		recovered = casedao.recoveredData();
		total = positive + negative + recovered;
		male = casedao.male();
		female = casedao.female();
		youngAge = casedao.age15To25();
		middleAge = casedao.age25To45();
		normalAge = casedao.age45To70();
		grandaAge = casedao.age70To90();
		ultraAge = casedao.age90To110();
		model.addAttribute("PositiveData", positive);
		model.addAttribute("NegativeData", negative);
		model.addAttribute("RecoveredData", recovered);
		model.addAttribute("totalData", total);
	}

	public String chart(Model model) {
		model.addAttribute("PositiveData", positive);
		model.addAttribute("NegativeData", negative);
		model.addAttribute("RecoveredData", recovered);
		// Positive Cases In Male Or Female
		model.addAttribute("Male", male);
		model.addAttribute("Female", female);
		// Positive Cases Based on Data
		model.addAttribute("age", youngAge);
		model.addAttribute("age1", middleAge);
		model.addAttribute("age2", normalAge);
		model.addAttribute("age3", grandaAge);
		model.addAttribute("age4", ultraAge);
		return "chart.html";
	}

	public void statWiseCount(String stateName, Model model) {
		String positiveCaesCount;
		String negativeCaseCount;
		String recoveredCaseCount;
		if (positive!= null) {
			positiveCaesCount = casedao.positiveStateData(stateName, model);
			if(positiveCaesCount==null) {
				positive=0;
			}else
				positive = Integer.parseInt(positiveCaesCount);
		}
		if (negative != null) {
			negativeCaseCount = casedao.negativeStateData(stateName);
			if(negativeCaseCount==null) {
				negative=0;
			}else
		negative = Integer.parseInt(negativeCaseCount);
		} 

		if (recovered != null) {
			recoveredCaseCount = casedao.recoveredStateData(stateName);
			if(recoveredCaseCount==null) {
				recovered=0;
			}else
				recovered = Integer.parseInt(recoveredCaseCount);
				} 
		total = positive + negative + recovered;
		model.addAttribute("positiveCaseCount", positive);
		model.addAttribute("negativeCaseCount", negative);
		model.addAttribute("recoveredCaseCount", recovered);
		model.addAttribute("totalData", total);

	}
}