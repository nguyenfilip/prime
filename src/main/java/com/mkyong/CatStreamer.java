package com.mkyong;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by maslo on 29.1.17.
 */
@ManagedBean(name="catStreamer")
@RequestScoped
public class CatStreamer {

    public StreamedContent getCat() throws FileNotFoundException {
        System.out.println("Retrieving CAT");
        StreamedContent content = new DefaultStreamedContent(
                getClass().getResourceAsStream("/home-cat.jpg"),"image/jpeg");


//        StreamedContent content = new DefaultStreamedContent(
//                new FileInputStream("/home/maslo/prime/src/main/resources/home-cat.jpg"),"image/jpeg");




        return content;
    }

    public String getText(){
        return "A";
    }
}
