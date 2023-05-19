package com.project.covidtracker.applicationproperties;

import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class Tiwlioinitializer {
	
	
	public Tiwlioinitializer()
	{
		
		Twilio.init("AC329bbddc6da15997dbeca30209737256", "308926a00f2d42423deb59c9759c5b32");
	}

}
