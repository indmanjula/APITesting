package com.pojo;

import java.util.Map;

import com.google.gson.Gson;


public class AllPojo {
	
	public String addNewUser(Map<String,String> data) {
		
		
		Register reg = new Register();
		reg.setEmail(data.get("Email"));
		reg.setPassword(data.get("Password"));
		reg.setFirstname(data.get("FirstName"));
		reg.setLastname(data.get("LastName"));
		reg.setAge(data.get("Age"));
    	 
		 //upDateId.setItemType(data.get("itemType"));
		 
		 Gson Josnbody = new Gson();
		 return Josnbody.toJson(reg);		
	}


}
