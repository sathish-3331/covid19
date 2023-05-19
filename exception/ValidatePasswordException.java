package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidatePasswordException extends Exception{
	 private static final Logger logger = LoggerFactory.getLogger(ValidatePasswordException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void passwordException()
	    {
	        logger.error("Only Conatins Disgits only 6 Digits Only!");
	    }
}
