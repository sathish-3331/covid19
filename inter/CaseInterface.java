package com.project.covidtracker.inter;

import org.springframework.ui.Model;

public interface CaseInterface {

	public Integer positiveData();
	public Integer negetiveData();
	public Integer recoveredData();
	 public String positiveStateData(String stateName,Model model);
	 public String negativeStateData(String stateName);
	 public String recoveredStateData(String stateName);
	 public Integer male();
	 public Integer female();
	 public Integer age15To25();
	 public Integer age25To45();
	   public Integer age45To70();
	   public Integer age70To90();
	   public Integer age90To110();
}
