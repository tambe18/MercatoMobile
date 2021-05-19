/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.mycompany.myapp.utils.Statics;


import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.utils.Statics;
import com.mycompany.myapp.entities.Annonce;
import java.util.ArrayList;
import com.codename1.io.JSONParser;
import com.codename1.io.CharArrayReader;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.util.Map;

import java.util.List;

/**
 *
 * @author mewa
 */
public class ServiceAnnonce {
    public ArrayList<Annonce> annonces;
    public static ServiceAnnonce instance;
    private ConnectionRequest req;
     public boolean resultOK;
    
    public ServiceAnnonce()
    {
        req= new ConnectionRequest();
    }
    public static ServiceAnnonce getInstance()
    {
        if(instance==null){
            instance= new ServiceAnnonce();
        }
        return instance;
    }
  
    
   public boolean addAnnonce(Annonce a){
        
    req.setUrl("http://localhost:8001/annonce/create/"+a.getTitre()+"/"+a.getContenu());
    req.setPost(true);
    req.addRequestHeader("Content-Type","application/json");
    

       
    req.addResponseListener(new ActionListener<NetworkEvent>(){

        @Override
        public void actionPerformed(NetworkEvent evt){

            resultOK = req.getResponseCode() == 200;
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);


     return resultOK;
    }

   public boolean editAnnonce(Annonce a){
        
    req.setUrl("http://localhost:8001/annonce/edit/"+Integer.toString(a.getId())+"/"+a.getTitre()+"/"+a.getContenu());
    
    req.setPost(false);
       
    req.addResponseListener(new ActionListener<NetworkEvent>(){

        @Override
        public void actionPerformed(NetworkEvent evt){

            resultOK = req.getResponseCode() == 200;
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);


     return resultOK;
    }
   
    public boolean deleteAnnonce(Annonce a){
        
    req.setUrl("http://localhost:8001/annonce/delete/"+a.getId());
    req.setPost(false);
    
    req.addResponseListener(new ActionListener<NetworkEvent>(){

        @Override
        public void actionPerformed(NetworkEvent evt){

            resultOK = req.getResponseCode() == 200;
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);


     return resultOK;
    }
   
   
   public ArrayList<Annonce> getAllAnnonces(){
       
       
   
       req.setUrl("http://localhost:8001/");
       req.setPost(false);
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           
           @Override
           public void actionPerformed(NetworkEvent evt){
               
               annonces = parseAnnonces(new String(req.getResponseData()));
               req.removeResponseListener(this);
           }
       });
       NetworkManager.getInstance().addToQueueAndWait(req);
       
       return annonces;
   } 


    public ArrayList<Annonce> parseAnnonces (String jsonText){
        try{
            annonces = new ArrayList<>();
            JSONParser j=new JSONParser();
            Map<String, Object> annoncesListJson =j.parseJSON(new CharArrayReader(jsonText.toCharArray()));


            List<Map<String, Object>> list =(List<Map<String, Object>>)annoncesListJson.get("root");
            for (Map<String, Object> obj : list)
            {
               Annonce a =new Annonce();
               float id= Float.parseFloat(obj.get("id").toString());
               a.setId((int)id);

               a.setTitre(obj.get("title").toString());
               a.setContenu(obj.get("contenu").toString());
               
               a.setImage(obj.get("img").toString());
               annonces.add(a);

            }

        }catch(IOException ex){

            
        }

         return annonces;
    }


}

