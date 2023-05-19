package com.project.covidtracker.inter;

import java.util.List;

import com.project.covidtracker.model.PositivePojo;


public interface PositiveInterface {
	public void insertPoitivePatient(PositivePojo saveUser) ;
	public int update(PositivePojo u1);
	public List<PositivePojo> listUsers() ;
	public PositivePojo findOne(Integer userId) ;
	public String findById(String stateName);
	public String find();
	

}
