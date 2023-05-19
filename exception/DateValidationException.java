package com.project.covidtracker.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.covidtracker.controller.StaffController;

public class DateValidationException extends Exception{
    private static final Logger logger = LoggerFactory.getLogger(DateValidationException.class);
    
    private static final long serialVersionUID = 1L; 
    
    public void dateValidationException()
    {
        logger.error("Already Exists Mail ID");
    }
}
