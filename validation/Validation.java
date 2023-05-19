package com.project.covidtracker.validation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.covidtracker.exception.AddharValidationException;
import com.project.covidtracker.exception.AgeValidateException;
import com.project.covidtracker.exception.DigitsValidationException;
import com.project.covidtracker.exception.EmailValidateException;
import com.project.covidtracker.exception.MobileValidationException;
import com.project.covidtracker.exception.NameValidateException;
import com.project.covidtracker.exception.NameValidationException;
import com.project.covidtracker.exception.PasswordValidateException;
import com.project.covidtracker.exception.ValidatePasswordException;
import com.project.covidtracker.exception.YesNoValidateException;





public class Validation {
    public static boolean nameValidation(String name) throws NameValidationException  {
        
        String regex="[a-zA-Z]+";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(name);
        Boolean b=m.matches();
        if(Boolean.TRUE.equals(b)) {
            return true;
        }
        else {
            throw new NameValidationException();
    }
    }
    public static boolean emailValidation(String email) throws EmailValidateException  {
        String regex="^(.+)@(.+)$";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(email);
        Boolean b=m.matches();
        if(Boolean.TRUE.equals(b)) {
            return true;
        }
        else {
            throw new EmailValidateException();
    }
    }
    public static boolean phoneNoValidation(Long phoneNo) throws MobileValidationException  {
        String regex="\\d{10}";
        String phoneNo1=Long.toString(phoneNo);
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(phoneNo1);
        Boolean b=m.matches();
        if(Boolean.TRUE.equals(b)) {
            return true;
        }
        else {
            throw new  MobileValidationException();
    }
    }
   public static boolean isValidAadhaarNumber(long addharNo) throws  AddharValidationException
    {
	   
	        String regex="^[2-9]{1}//d[0-9]{11}$"; 
	          String adharNo1=Long.toString(addharNo);
	          Pattern pattern=Pattern.compile(regex);
	            Matcher match=pattern.matcher(adharNo1);
	            Boolean b=match.matches();//check matching
	            if(Boolean.TRUE.equals(b)) {
	                return true;
	                
	            }
	            else {
	                throw new  AddharValidationException();
	    }
        
    }
    
    
    public static boolean passWordValid(String password) throws ValidatePasswordException {
    	if(password.length()>8) {
    		return true;
    	}
    	else {
    		throw new  ValidatePasswordException();
    	}
    }
    public static boolean emaiId(String mailId) throws EmailValidateException {
    	if(mailId.length()>=10){  
    	     return true;
    	}
    	else {
    		
    
    	throw new  EmailValidateException();
    }
    }
    public static boolean validatingPassword(String password) throws PasswordValidateException {
        Boolean wname=password.matches(".*[a-z].*")&&password.matches(".*[A-Z].*");//password must include one lower case and upper case
        if(Boolean.TRUE.equals(wname))    {    
        return true;
        }
        else {
            throw new PasswordValidateException();
        }
            
}
    public static boolean validateName(String name) throws NameValidateException {
        if(name != null && !name.trim().isEmpty() && name.length()>=3) {
        return true;
    }
        else {
            throw new  NameValidateException();
}}
    public boolean ageValidation(int age ) throws AgeValidateException {
    	if(age>0) {
    		return true;
    	}else {
		throw new  AgeValidateException();
    	}
    }
    public boolean yesOrNoValidate(String yesNo) throws YesNoValidateException  {
    	if(yesNo.equals("yes")||yesNo.equals("no")) {
    		return true;
    	}else
    		
    		throw new YesNoValidateException();
    	
    }
    public static boolean passwordValidation(String password) throws PasswordValidateException{
        String regex="(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(password);
        Boolean b=m.matches();
        if(Boolean.TRUE.equals(b)) {
            return true;
        
        } else {
            throw new PasswordValidateException();
        }
}
    public static String
    digitsValidation(String str, int n) throws DigitsValidationException
    {
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) < '0'
                || str.charAt(i) > '9') {
                 throw new DigitsValidationException();
            }
        }
        return str;
    }
}

 
