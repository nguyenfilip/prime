package com.mkyong.user.bo.impl;


import com.mkyong.user.bo.UserBo;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserBoImpl implements UserBo, Serializable {
 
	public String getMessage() {
		
		return "JSF 2 + Spring Integration";
	
	}
 
}