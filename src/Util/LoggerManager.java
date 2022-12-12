package Util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.Logger;
public class LoggerManager {
    private static LoggerManager loggerManager = null;   
    
   
    public Logger logger;   
    FileHandler fileHandler;
    SimpleFormatter formatter= new SimpleFormatter();
    String filePath = "src/gsn/Logs/Logs.txt";
    int numberFile = 0;
    
    
    
    public LoggerManager(){
        
        this.logger = Logger.getLogger("MyLog");
        try{
            this.fileHandler = new FileHandler(filePath);
            this.fileHandler.setFormatter(formatter);
            logger.addHandler(this.fileHandler);
        }catch(IOException ex){
            Logger.getLogger(LoggerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addNewLog(String logText) throws IOException{
        //aumenta el numero del archivo
        fileHandler.close();
        numberFile++;
        
        //cambia la ruta del archivo
        filePath = "src/gsn/Logs/Logs"+ numberFile +".txt";
        
        //elimina el handler
        logger.removeHandler(fileHandler);
        
        //crea un nuevo handler y se le añade el formatter
        try {
            this.fileHandler = new FileHandler(filePath);
        } catch (IOException ex) {
            Logger.getLogger(LoggerManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(LoggerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        fileHandler.setFormatter(formatter);
        
        //añadimos el handler al logger
        logger.addHandler(fileHandler);
        logger.warning(logText);
        
    }
    public static LoggerManager getTheLogger(){   
        if (loggerManager == null){
            loggerManager = new LoggerManager();   
        }   
        return loggerManager;   
    }  
}
