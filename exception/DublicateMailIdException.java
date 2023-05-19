package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DublicateMailIdException extends Exception{
	  private static final Logger logger = LoggerFactory.getLogger(DublicateMailIdException.class);
	    
	    private static final long serialVersionUID = 1L; 
	    
	    public void dublicateMailIdException()
	    {
	        logger.error("Only Conatins Disgits only ID");
	    }
}
