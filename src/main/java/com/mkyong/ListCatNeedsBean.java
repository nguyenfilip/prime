package com.mkyong;
import com.mkyong.entity.CatNeed;
import com.mkyong.entity.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.mkyong.user.bo.UserBo;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="needs") // JSF-managed.
@SessionScoped
public class ListCatNeedsBean implements Serializable {

	int counter =  0 ;

	private Dao dao = null;
	@Autowired
	UserBo userBo;

//	@ManagedProperty("#{cart}")
//	private CartBean cart;
//
//	public CartBean getCart() {
//		return cart;
//	}
//
//	public void setCart(CartBean cart) {
//		this.cart = cart;
//	}

	@PostConstruct
	private void init() {
		dao = new Dao();

		FacesContextUtils
				.getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
				.getAutowireCapableBeanFactory().autowireBean(this);

		// springBeanName is now available.
	}
//	public void setUserBo(UserBo userBo) {
//		this.userBo = userBo;
//	}

//	public String printMsgFromSpring() {
//		System.out.println(userBo);
//		return userBo.getMessage() + counter++ + "CartBean counter: "+ cart.getCounter();
//	}
	public List<CatNeed> getAllNeeds() {
		return dao.listAllNeeds();
	}
}