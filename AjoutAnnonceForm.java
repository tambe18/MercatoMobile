/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Annonce;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.services.ServiceAnnonce;

/**
 *
 * @author mewa
 */
public class AjoutAnnonceForm extends Form{
    
    public AjoutAnnonceForm(Form previous){
        setTitle("ajouter une nouvelle annonce");
        setLayout(BoxLayout.y());
        TextField tfTitre = new TextField("","AnnonceTitre");
        TextField tfContenu= new TextField("","AnnonceContenu");
        ImageViewer img=new ImageViewer();
        Button btnValider =new Button("ajouté une annonce");
        
     btnValider.addActionListener(new ActionListener(){
        
          @Override
           public void actionPerformed(ActionEvent evt){
                if((tfTitre.getText().length()==0)||(tfContenu.getText().length()==0))
                    Dialog.show("Alert", "please fill all the fields", new Command("OK"));
               else {
                    try{
                        Annonce a=new Annonce(tfTitre.getText(), tfContenu.getText());
                        if(new ServiceAnnonce().addAnnonce(a)){
                            Dialog.show("Succès", "Annonce ajouté", new Command("OK"));
                            new HomeForm().show();
                        }
                            
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    }catch (NumberFormatException e){
                    Dialog.show("ERROR","Titre must be a caractère", new Command("OK"));
                }
                }
                
            }
        });
     
        addAll(tfTitre,tfContenu,btnValider);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }
    
    
     public AjoutAnnonceForm(Form previous,Annonce a){
        setTitle("Modifier une annonce");
        setLayout(BoxLayout.y());
        TextField tfTitre = new TextField(a.getTitre(),"AnnonceTitre");
        TextField tfContenu= new TextField(a.getContenu(),"AnnonceContenu");
        ImageViewer img=new ImageViewer();
        Button btnValider =new Button("modifer une annonce");
        
     btnValider.addActionListener(new ActionListener(){
        
          @Override
           public void actionPerformed(ActionEvent evt){
                if((tfTitre.getText().length()==0)||(tfContenu.getText().length()==0))
                    Dialog.show("Alert", "please fill all the fields", new Command("OK"));
               else {
                    try{
                        a.setTitre(tfTitre.getText());
                        a.setContenu(tfContenu.getText());
                        
                        if(new ServiceAnnonce().editAnnonce(a)){
                            Dialog.show("Succès", "Annonce modifié", new Command("OK"));
                            new HomeForm().show();
                        }
                            
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    }catch (NumberFormatException e){
                    Dialog.show("ERROR","Titre must be a caractère", new Command("OK"));
                }
                }
                
            }
        });
     
        addAll(tfTitre,tfContenu,btnValider);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());
    }
} 

