package com.project.covidtracker.inter;
import java.util.List;

import com.project.covidtracker.model.NegativePojo;



public interface DataEntryInterface {
	public void insertNegativePatient(NegativePojo saveUser);
	public List<NegativePojo> listUsers();
	public NegativePojo findOne(Integer userId);
	public String findById(String stateName);
	public String findStateName(Integer convertTrackId);
	public List<Long> dropDownMunicipalityId();
	public String findMunicipalityName(Integer municiplaityId);
	public int removeNegative(Integer id);

}
