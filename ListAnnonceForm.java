/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Annonce;
import com.mycompany.myapp.services.ServiceAnnonce;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mewa
 */
public class ListAnnonceForm extends Form {
    
    final EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(getWidth()/5, getWidth() / 5, 0xffff0000), true);
    
     Form current;
    public ListAnnonceForm(Form previous)
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
            Container ctn = new Container(BoxLayout.x());
            Container ctn1 = new Container(BoxLayout.y());
            
            
            
            URLImage background = URLImage.createToStorage(placeholder, a.getImage(),"http://localhost:8001/images/annonces/"+a.getImage());
            background.fetch();
            Button b = new Button(background);
            b.getAllStyles().setMarginBottom(30);
            b.addActionListener((e) -> new SingleAnnonce(current,a).show());
            
            ctn1.add(b);
            ctn.add(ctn1);
            ctn.add(l);
            //l.setIcon(b);
            
           
           add(ctn);            
        }

                
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
                
    }
    
}
