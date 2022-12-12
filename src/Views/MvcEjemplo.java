/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author polil
 */
public class MvcEjemplo extends javax.swing.JFrame {

    /**
     * Creates new form MvcEjemplo
     */
    public MvcEjemplo() {
        initComponents();
        jTable1.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jsonButton = new javax.swing.JButton();
        csvButton = new javax.swing.JButton();
        txtButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jsonButton.setText("CargarJson");
        jsonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsonButtonActionPerformed(evt);
            }
        });

        csvButton.setText("CargarCsv");
        csvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                csvButtonActionPerformed(evt);
            }
        });

        txtButton.setText("CargarTxt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jsonButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(csvButton)
                        .addGap(251, 251, 251)
                        .addComponent(txtButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsonButton)
                    .addComponent(csvButton)
                    .addComponent(txtButton))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsonButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsonButtonActionPerformed

    private void csvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_csvButtonActionPerformed
        //cargarDatosCsv();
        
    }//GEN-LAST:event_csvButtonActionPerformed

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable1() {
        return jTable1;
    }
    
    public JButton getCsvButton() {
        return csvButton;
    }
    
    private void cargarDatosCsv() {
        JFileChooser seleccionarArchivo = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos csv","csv");

        seleccionarArchivo.setFileFilter(filtro);
        
        int seleccionar = seleccionarArchivo.showOpenDialog(this);
        
        if(seleccionar == JFileChooser.APPROVE_OPTION){
            DefaultTableModel model = new DefaultTableModel();
        jTable1.setModel(model);

        // Abre el archivo CSV
        try (BufferedReader br = new BufferedReader(new FileReader(seleccionarArchivo.getSelectedFile()))) {
            // Lee la primera línea del archivo (los encabezados de las columnas)
            String line = br.readLine();

            // Divide la línea en sus valores separados por comas
            String[] columnNames = line.split(",");

            // Agrega las columnas a la tabla a partir de los encabezados del archivo CSV
            for (String columnName : columnNames) {
                model.addColumn(columnName);
            }

            // Lee las siguientes líneas del archivo (los datos)
            while ((line = br.readLine()) != null) {
                // Divide la línea en sus valores separados por comas
                String[] values = line.split(",");

                // Agrega una fila con esos valores a la tabla
                model.addRow(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MvcEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MvcEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MvcEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MvcEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MvcEjemplo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton csvButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jsonButton;
    private javax.swing.JButton txtButton;
    // End of variables declaration//GEN-END:variables
}
