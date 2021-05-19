/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author mewa
 */
public class HomeForm extends Form{
    Form current; // recuperation de l' interface(Form) en cours;
    public HomeForm(){
        current=this;
        setTitle("Gestion des Annonces");
        setLayout(BoxLayout.y());
        add(new Label("choisir une option"));
        Button btnAjoutAnnonce= new Button("Ajouter une annonce","btnAjoutAnnonce");
         Button btnListAnnonce= new Button("Lister les annonce","btnListAnnonce");
         Button btnModifierAnnonce= new Button("Administration","btnModifierAnnonce");
         
         
         btnAjoutAnnonce.addActionListener(e-> new AjoutAnnonceForm(current).show());
         btnListAnnonce.addActionListener(e-> new ListAnnonceForm(current).show());
         btnModifierAnnonce.addActionListener(e-> new AdminAnnonceForm(current).show());
         addAll(btnAjoutAnnonce,btnListAnnonce, btnModifierAnnonce);
         
         
         
        
    }
    
}
