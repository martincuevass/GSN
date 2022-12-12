/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Controllers.CntrlTableView;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author polil
 */
public abstract class GlobalController {
    private String modelName;
    private String viewName;
    public Object model;
    public Object view;
    LoggerManager logger = LoggerManager.getTheLogger();
    public String method() throws IOException{
        JSONObject obj = new JSONObject();
        String content = Files.readString(Paths.get("src/gsn/MVCConfig.json"));
        obj = new JSONObject(content);
        String methodName = obj.getString("nombreTransaccion");
        return methodName;
    }
  
    public void initModel() throws IOException {
        JSONObject obj = new JSONObject();
        try{
            String content = Files.readString(Paths.get("src/gsn/MVCConfig.json"));
            obj = new JSONObject(content);
        }catch(Exception ex){
            logger.addNewLog("no se encontró el archivo de configuracion" + ex);
        }
        this.modelName = obj.getString("modelo");
        try {
            Class<?> model = Class.forName(this.modelName);
            Constructor<?> constructor = model.getConstructor();
            this.model = constructor.newInstance();
            
            
        } catch (ClassNotFoundException ex) {
           logger.addNewLog("no se encontró el modelo" + ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
    public void initView() throws IOException {
        JSONObject obj = new JSONObject();
        try{
            String content = Files.readString(Paths.get("src/gsn/MVCConfig.json"));
            obj = new JSONObject(content);
        }catch(Exception ex){
            logger.addNewLog("no se encontró el archivo de configuracion" + ex);
        }
        this.viewName = obj.getString("vistas");
        
        try {
            Class<?> model = Class.forName(this.viewName);
            Constructor<?> constructor = model.getConstructor();
            this.view = constructor.newInstance();
            
            
        } catch (ClassNotFoundException ex) {
            logger.addNewLog("no se encontró la vista" + ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
