/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gsn;



import Model.CsvTool;
import Model.JsonTool;
import Model.TxtTool;
import Util.CsvReader;
import Util.Initializer;
import Util.JsonReader;
import Util.LoggerManager;
import Util.TableTool;
import Util.TxtReader;
import java.io.IOException;

/**
 *
 * @author polil
 */
public class GSN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        LoggerManager logger = LoggerManager.getTheLogger();
        Initializer initializer = new Initializer();
        initializer.initClass();
        logger.addNewLog("Controlador inicializado");
    }
    
}
