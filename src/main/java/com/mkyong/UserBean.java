package com.mkyong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.mkyong.user.bo.UserBo;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name="user") // JSF-managed.
@SessionScoped
public class UserBean implements Serializable {

	@Autowired
	UserBo userBo;

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
		return userBo.getMessage();
//		return "AHOJ";
	}

}