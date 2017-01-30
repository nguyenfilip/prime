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
public class DestroyCustomScope implements ActionListener {

    @Override
    public void processAction(final ActionEvent event) throws AbortProcessingException {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();

        TabScope customScope = (TabScope) sessionMap.get(TabScope.SCOPE_NAME);
        customScope.notifyDestroy(facesContext);

        sessionMap.remove(TabScope.SCOPE_NAME);

    }

}