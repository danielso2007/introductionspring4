package br.com.estudo.introductionspring4.web.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public void message(String msg, Severity severity) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, null));
    }
    
    public void messageErro(String msg) {
        message(msg, FacesMessage.SEVERITY_ERROR);
    }
    
    public void messageInfo(String msg) {
        message(msg, FacesMessage.SEVERITY_INFO);
    }
    
    public void messageWarn(String msg) {
        message(msg, FacesMessage.SEVERITY_WARN);
    }
    
    public void messageClear() {
        if (FacesContext.getCurrentInstance().getMessages().hasNext()) {
            FacesContext.getCurrentInstance().getMessages().remove();
        }
        if (!FacesContext.getCurrentInstance().getMessageList().isEmpty()) {
            FacesContext.getCurrentInstance().getMessageList().clear();
        }
    }
}
