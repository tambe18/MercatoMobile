/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.Storage;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.mycompany.myapp.entities.Annonce;

/**
 *
 * @author mewa
 */
public class SingleAnnonce extends Form{
    
    final EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(getWidth(), getWidth()/2, 0xffff0000), true);
    public SingleAnnonce(Form previous,Annonce a){
        //Storage.getInstance().deleteStorageFile("currentimage");
        
        URLImage background = URLImage.createToStorage(placeholder, a.getImage()+"currentimage","http://localhost:8001/images/annonces/"+a.getImage());
        background.fetch();
        
        SpanLabel title = new SpanLabel(a.getTitre());
        title.getAllStyles().setMarginBottom(30);
        
        SpanLabel contenu = new SpanLabel(a.getContenu());
        contenu.getAllStyles().setMarginBottom(30);
        
        add(background);
        add(title);
        add(contenu);
        
        
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }
    
}
