package com.mkyong;

import javax.faces.context.FacesContext;
import javax.faces.el.PropertyNotFoundException;
import javax.el.ELContext;
import javax.el.ELException;
import javax.el.ELResolver;
import javax.el.PropertyNotWritableException;
import java.beans.FeatureDescriptor;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by maslo on 30.1.17.
 */
public class CustomELResolver extends ELResolver {

    @Override
    public Object getValue(final ELContext elContext,
                           final Object base,
                           final Object property) {
        FacesContext facesContext = (FacesContext) elContext.getContext(FacesContext.class);

        if ((null == base) && TabScope.SCOPE_NAME.equals(property.toString())) {
            System.out.println("RESOLVING SCOPE");
            // Scope is referenced directly
            TabScope scope = getScope(facesContext);
            elContext.setPropertyResolved(true);
            return scope;

        } else if ((null != base) && (base instanceof TabScope)) {

            // An object within the scope is referenced

            return resolve(facesContext, (TabScope) base, property.toString());

        } else if (null == base) {

            TabScope customScope = getScope(facesContext);
            return null != customScope ?
                    resolve(facesContext, customScope, property.toString()):null;

        }
        return null;
    }


    /**
     * Resolve the key on the given CustomScope
     */
    public Object resolve(final FacesContext facesContext,
                          final TabScope scope,
                          final String key) {

        Object value = scope.get(key);
        facesContext.getELContext().setPropertyResolved(value != null);
        return value;

    }


    /**
     * Responsible to retrieve the scope
     */
    private TabScope getScope(final FacesContext facesContext) {

        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
        TabScope customScope = (TabScope) sessionMap.get(TabScope.SCOPE_NAME);

        return customScope;
    }


    @Override
    public Class<?> getType(ELContext elContext, Object o, Object o1) {
        return Object.class;
    }

    @Override
    public void setValue(ELContext elContext, Object o, Object o1, Object o2) {
        System.out.println("SET VALUE");
    }

    @Override
    public boolean isReadOnly(ELContext elContext, Object o, Object o1) {
        return true;
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext elContext, Object o) {
        return Collections.<FeatureDescriptor>emptyList().iterator();
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext elContext, Object base) {
        if (base != null) {
            return null;
        }
        return String.class;
    }
}