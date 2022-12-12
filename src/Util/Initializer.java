/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Controllers.CntrlTableView;
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
public class Initializer {
    private Object Cntrl;
    private String CntrlName;
    public void initClass(){
         JSONObject obj = new JSONObject();
        try{
            String content = Files.readString(Paths.get("src/gsn/MVCConfig.json"));
            obj = new JSONObject(content);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        this.CntrlName = obj.getString("controlador");
         
        try {
            Class<?> model = Class.forName(this.CntrlName);
            Constructor<?> constructor = model.getConstructor();
            this.Cntrl = constructor.newInstance();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
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
