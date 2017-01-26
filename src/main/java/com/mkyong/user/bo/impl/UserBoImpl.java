package com.mkyong.user.bo.impl;


import com.mkyong.user.bo.UserBo;
import org.springframework.stereotype.Component;

@Component
public class UserBoImpl implements UserBo{
 
	public String getMessage() {
		
		return "JSF 2 + Spring Integration";
	
	}
 
}