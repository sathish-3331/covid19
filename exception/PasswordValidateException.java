package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordValidateException extends Exception {
	 private static final Logger logger = LoggerFactory.getLogger(PasswordValidateException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void passwordException()
	    {
	        logger.error("Only Conatins Disgits only 6 Digits Only!");
	    }
}
