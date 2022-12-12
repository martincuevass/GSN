/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Util.GlobalController;
import Util.LoggerManager;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;

/**
 *
 * @author polil
 */
public class CntrlTableView extends GlobalController implements ActionListener{
    private JButton button;
    private JFrame jframe;
    private Class<?> clazz;
    private LoggerManager logger;
    
    
    public CntrlTableView() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
        logger = LoggerManager.getTheLogger();
        initModel();
        initView();
        clazz = this.view.getClass();
        Method method = clazz.getDeclaredMethod("getCsvButton");
        
        this.button =(JButton)method.invoke(this.view);
        this.button.addActionListener(this);
        this.jframe = (JFrame) this.view;
       
        jframe.setVisible(true);
        logger.addNewLog("Vista y modelo vinculados correctamente al controlador");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(this.button.equals(e.getSource())){
            try {
                String methodName = method();
                Method method = clazz.getDeclaredMethod("getjTable1");
                Class<?> modelClass = this.model.getClass();
                Method method2 = modelClass.getDeclaredMethod(methodName);
                JTable tabla = (JTable) method.invoke(this.view);
                DefaultTableModel model = (DefaultTableModel) method2.invoke(this.model);
                tabla.setModel(model);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CntrlTableView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    

}
