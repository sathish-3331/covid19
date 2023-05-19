package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YesNoValidateException extends Exception {
	 private static final Logger logger = LoggerFactory.getLogger(YesNoValidateException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void yesNoValidateException()
	    {
	        logger.error("You Choose Only Yes/No option");
	    }
}
