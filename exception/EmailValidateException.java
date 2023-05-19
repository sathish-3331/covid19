package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailValidateException extends Exception {
	 private static final Logger logger = LoggerFactory.getLogger(EmailValidateException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void mailException()
	    {
	        logger.error("Only Conatins Disgits only 2 Digits Only!");
	    }
}
