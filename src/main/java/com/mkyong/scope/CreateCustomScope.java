package com.mkyong.scope;

import com.mkyong.TabScope;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import java.util.Map;

/**
 * Created by maslo on 30.1.17.
 */
public class CreateCustomScope implements ActionListener {

    @Override
    public void processAction(final ActionEvent event) throws AbortProcessingException {

        System.out.println("Custom scope listener running");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();

        TabScope customScope = new TabScope("0");
        sessionMap.put(TabScope.SCOPE_NAME, customScope);

        customScope.notifyCreate(facesContext);

    }

}