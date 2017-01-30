package com.mkyong;

import javax.faces.context.FacesContext;
import javax.faces.event.PostConstructCustomScopeEvent;
import javax.faces.event.PreDestroyCustomScopeEvent;
import javax.faces.event.ScopeContext;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by maslo on 30.1.17.
 */
public class TabScope  extends ConcurrentHashMap<String, Object> {

    private static final long serialVersionUID = 6013804747421198557L;
    private String tabId = null;
    public static final String SCOPE_NAME = "tab_scope";

    public TabScope(String tabId){

        super();
        this.tabId = tabId;
    }

    public void notifyCreate(final FacesContext ctx) {
        ScopeContext context = new ScopeContext(SCOPE_NAME, this);
        ctx.getApplication().publishEvent(ctx, PostConstructCustomScopeEvent.class, context);

    }

    public void notifyDestroy(final FacesContext ctx) {
        ScopeContext scopeContext = new ScopeContext(SCOPE_NAME,this);
        ctx.getApplication().publishEvent(ctx, PreDestroyCustomScopeEvent.class, scopeContext);

    }

}