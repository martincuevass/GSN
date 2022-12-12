/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Pablo
 */
public class TxtReader extends Reader{
    
   private String[] values;
   
   @Override
   public Object documentReader() {
      String line = "";
      try{
         
         BufferedReader br = new BufferedReader(new FileReader(""));
         while((line = br.readLine()) != null){
            this.values = line.split(",");
         }
         br.close();
      }catch(FileNotFoundException e){

      }catch(IOException e){

      }
      return this.values;

   }
   
   public static final String SEPARADOR = ",";
 
}

