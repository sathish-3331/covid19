package com.project.covidtracker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.covidtracker.servies.CaseCountService;



@Controller
public class CasesCountController {
          
      
           CaseCountService casecountservice=new CaseCountService();
       //Landing Page Start Count    
           @RequestMapping("/Start")
           public String home(Model model){
           casecountservice.caseCount(model);
           casecountservice.chart(model);
  		   return "EndUser.html";
  	}
           @GetMapping("/About")
           public String about(Model model) {
			return "jsp/About.jsp";
        	   
           }
           
           
           //Chart Count
           @GetMapping("/Analytics")
           public String anlaytical(Model model){
        	   //Cases Data In Record
        	   casecountservice.chart(model);
  		      return "chart.html";
         }
          //CommenChart
           @GetMapping("/CommanAnalytics")
           public String commanChart(Model model){
        	   //Cases Data In Record
        	   casecountservice.chart(model);
        	   casecountservice.caseCount(model);
  		      return "CommenChart.html";
         }
   
           
           /*--Search StateName Cases Count*/
        	@GetMapping("/search")
         	public String find(@RequestParam("stateName")String stateName ,Model model) {
               casecountservice.statWiseCount(stateName, model);
    			return "EndUser.html";
         		
         	}
        	
 
}
