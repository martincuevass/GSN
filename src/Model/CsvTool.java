package Model;

import Util.CsvReader;
import java.util.List;

import Util.Reader;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CsvTool {
    
    private Reader reader;


    public CsvTool(){
        this.reader = new CsvReader();      

    }


    public DefaultTableModel csvReader(){
        DefaultTableModel model = (DefaultTableModel) this.reader.documentReader();
        return model;
    }
}
