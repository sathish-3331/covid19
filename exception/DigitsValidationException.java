package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DigitsValidationException extends Exception {
	  private static final Logger logger = LoggerFactory.getLogger(DigitsValidationException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void digitsValidationException()
	    {
	        logger.error("Only Conatins Disgits only ID");
	    }
}
