/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;
import javafx.scene.image.ImageView;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author mewa
 */
public class Annonce {
    
 private int id ;
 private String titre ;
 private String contenu ;
 private String image ;
 private Date dateajout ; 
 private Date datemodif ; 

 
 
 
  public Annonce(int id, String titre, String contenu, String image, Date dateajout, Date datemodif) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.image = image;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
        
    }

    public Annonce(String titre, String contenu, String image, Date dateajout, Date datemodif) {
        this.titre = titre;
        this.contenu = contenu;
        this.image = image;
        this.dateajout = dateajout;
        this.datemodif = datemodif;
    }
    
    
     public Annonce(String titre, String contenu) {
        this.titre = titre;
        this.contenu = contenu;
        
    }
    public Annonce() {
        
    }

   

   

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * @param contenu the contenu to set
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the dateajout
     */
    public Date getDateajout() {
        return dateajout;
    }

    /**
     * @param dateajout the dateajout to set
     */
    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    /**
     * @return the datemodif
     */
    public Date getDatemodif() {
        return datemodif;
    }

    /**
     * @param datemodif the datemodif to set
     */
    public void setDatemodif(Date datemodif) {
        this.datemodif = datemodif;
    }

    
    
     public String toString() {
        return "actualite{" + "id=" + id + ", titre=" + titre + ", contenu=" + contenu ;
    }

    
}
