package com.mkyong;
import com.mkyong.entity.CatNeed;
import com.mkyong.entity.Dao;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import com.mkyong.user.bo.UserBo;
import org.springframework.stereotype.Component;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="needs") // JSF-managed.
@SessionScoped
public class ListCatNeedsBean implements Serializable {
	int counter =  0 ;

	private Dao dao = null;
	private CatNeed toDelete;

	public CatNeed getToDelete() {
		return toDelete;
	}

	public void setToDelete(CatNeed toDelete) {
		this.toDelete = toDelete;
	}

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	@Autowired
	UserBo userBo;

	private CatNeed newNeed = new CatNeed();
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

	public CatNeed getNewNeed() {
		return newNeed;
	}

	public void setNewNeed(CatNeed newNeed) {
		this.newNeed = newNeed;
	}

	public String submitNewNeed() {
		if(file != null) {
			System.out.println("FILE ISNT NULL!");
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage("ERROR", "ERROR");
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println("File is null!");
		}

		dao.save(newNeed);
		newNeed = new CatNeed();
//		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.putNow("xx", "FLASH SCOPED VALUE!");

		return "default?faces-redirect=true";

//		return "default";
	}


	public String delete() {
		dao.delete(toDelete);
		return null;
	}
}