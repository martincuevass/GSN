/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import javax.swing.JTable;

/**
 *
 * @author polil
 */
public class TableTool {
    
    private String[] tableHeader;
    private String[][] itemArray;

    public TableTool() {
        
    }
    
    public JTable CreateTable(String[] tableHeader, String[][] itemArray){
        JTable table = new JTable(itemArray, tableHeader);
        return table;
    }
    
}
