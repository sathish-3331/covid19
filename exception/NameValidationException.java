package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NameValidationException extends Exception{
	 private static final Logger logger = LoggerFactory.getLogger(NameValidationException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void nameException()
	    {
	        logger.error("Only Conatins Disgits only 2 Digits Only!");
	    }
}
