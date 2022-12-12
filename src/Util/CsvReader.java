/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CsvReader extends Reader {
   
   public static final String SEPARADOR = ",";
   private String[] values;
   List<List<String>> lines = new ArrayList<>();
   private DefaultTableModel model;
    @Override
    public Object documentReader() {
        JFileChooser seleccionarArchivo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos csv", "csv");
        JTable tabla = new JTable();
        seleccionarArchivo.setFileFilter(filtro);

        int seleccionar = seleccionarArchivo.showOpenDialog(null);

        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            this.model = new DefaultTableModel();
            tabla.setModel(this.model);

            // Abre el archivo CSV
            try ( BufferedReader br = new BufferedReader(new FileReader(seleccionarArchivo.getSelectedFile()))) {
                // Lee la primera línea del archivo (los encabezados de las columnas)
                String line = br.readLine();

                // Divide la línea en sus valores separados por comas
                String[] columnNames = line.split(",");

                // Agrega las columnas a la tabla a partir de los encabezados del archivo CSV
                for (String columnName : columnNames) {
                    this.model.addColumn(columnName);
                }

                // Lee las siguientes líneas del archivo (los datos)
                while ((line = br.readLine()) != null) {
                    // Divide la línea en sus valores separados por comas
                    String[] values = line.split(",");

                    // Agrega una fila con esos valores a la tabla
                    this.model.addRow(values);
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        }
       try {
           ConnectionPool con = ConnectionPool.getInstance();
           Connection conn = con.getConnection();
           if(conn!=null){
               for(int i = 0; i < tabla.getRowCount(); i++){
                   System.out.println(tabla.getValueAt(i, 0));
                   conn.createStatement().execute("INSERT INTO valores VALUES("+"\""+tabla.getValueAt(i, 0)+"\""+"," + "\""+tabla.getValueAt(i, 1)+"\""+")");
                   
               }
               con.closeConnection(conn);
           }else{
               
           }
       } catch (IOException ex) {
           Logger.getLogger(CsvReader.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(CsvReader.class.getName()).log(Level.SEVERE, null, ex);
       }
        return this.model;
        

    }

}
