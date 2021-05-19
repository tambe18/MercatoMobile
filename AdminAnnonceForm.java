/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Annonce;
import com.mycompany.myapp.services.ServiceAnnonce;
import java.util.ArrayList;

/**
 *
 * @author mewa
 */
public class AdminAnnonceForm extends Form{

final EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(getWidth()/5, getWidth() / 5, 0xffff0000), true);
    
     Form current;
    
    public AdminAnnonceForm(Form previous)
             
    {
     
        
         current = this;
        
        setTitle("Liste des Annonces");
       // SpanLabel sp = new SpanLabel();
       // ComboBox list=new ComboBox();
        
        ArrayList<Annonce> annonces = ServiceAnnonce.getInstance().getAllAnnonces();
        
        for(Annonce a:annonces){
            
            //Storage.getInstance().deleteStorageFile(a.getImage());
            SpanLabel l = new SpanLabel(a.getTitre());
            Image img;
            Container ctn = new Container(BoxLayout.x(),"ctnImage");
            Container ctn1 = new Container(BoxLayout.y());
            Container ctnAdmin = new Container(BoxLayout.x(),"ctnAdmin");
            
            
            Button btnModifierAnnonce =new Button("modifié","18");
            Button btnSupprimerAnnonce =new Button("supprimé","19");
            
            btnModifierAnnonce.addActionListener(e-> new AjoutAnnonceForm(current,a).show());
            btnSupprimerAnnonce.addActionListener(e->{
                 if(new ServiceAnnonce().deleteAnnonce(a)){
                     Dialog.show("Succès", "Annonce supprimée", new Command("OK"));
                     new HomeForm().show();
                 }
                 
            });
            
            
            URLImage background = URLImage.createToStorage(placeholder, a.getImage(),"http://localhost:8001/images/annonces/"+a.getImage());
            background.fetch();
            Button b = new Button(background);
            //b.getAllStyles().setMarginBottom(30);
            b.addActionListener((e) -> new SingleAnnonce(current,a).show());
            
            ctnAdmin.add(btnModifierAnnonce);
            ctnAdmin.add(btnSupprimerAnnonce);
            
            ctnAdmin.getAllStyles().setMarginBottom(30);
            
            ctn1.add(b);
            ctn.add(ctn1);
            ctn.add(l);
            //ctn.add(ctnAdmin);
            //l.setIcon(b);
            
           
           add(ctn);
           add(ctnAdmin);
        }
        
        
        
        
        
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
}}
