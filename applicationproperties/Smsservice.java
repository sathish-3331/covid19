package com.project.covidtracker.applicationproperties;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@Service
public class Smsservice {

	Logger logger = LoggerFactory.getLogger(Smsservice.class);
	
	public String sendSms(String to,String from,String body) {
		
		try {
		 Twilio.init("AC329bbddc6da15997dbeca30209737256","308926a00f2d42423deb59c9759c5b32");
	     Message.creator( new PhoneNumber(to), new PhoneNumber(from),body).create();
          

	}catch(Exception e) {
			
		logger.info(e.toString());
			
		}
		return body;
		
	}
	
	
}	
