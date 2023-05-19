package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddharValidationException extends Exception {
	 private static final Logger logger = LoggerFactory.getLogger(DigitsValidationException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void AddharalidationException()
	    {
	        logger.error("Only Conatins Disgits only 12 Digits Only!");
	    }
}
