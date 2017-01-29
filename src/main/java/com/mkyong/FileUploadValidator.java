package com.mkyong;

import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by maslo on 29.1.17.
 */

@FacesValidator("com.mkyong.FileUploadValidator")
public class FileUploadValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        UploadedFile file = (UploadedFile) value;
        System.out.println("File name: "+ file.getFileName());
        System.out.println("File size: "+ file.getSize());
        if (file.getFileName() == null || file.getFileName().equals("")) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Provide file!");
            FacesContext.getCurrentInstance().addMessage(component.getClientId(), message);
        }
    }
}
