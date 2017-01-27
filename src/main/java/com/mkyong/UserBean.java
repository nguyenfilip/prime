package com.mkyong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.mkyong.user.bo.UserBo;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name="user") // JSF-managed.
@SessionScoped
public class UserBean implements Serializable {

	int counter =  0 ;
	@Autowired
	UserBo userBo;

	@ManagedProperty("#{cart}")
	private CartBean cart;

	public CartBean getCart() {
		return cart;
	}

	public void setCart(CartBean cart) {
		this.cart = cart;
	}

	@PostConstruct
	private void init() {
		FacesContextUtils
				.getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
				.getAutowireCapableBeanFactory().autowireBean(this);

		// springBeanName is now available.
	}
//	public void setUserBo(UserBo userBo) {
//		this.userBo = userBo;
//	}

	public String printMsgFromSpring() {
		System.out.println(userBo);
		return userBo.getMessage() + counter++ + "CartBean counter: "+ cart.getCounter();
//		return "AHOJ";
	}

}