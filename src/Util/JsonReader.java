package Util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;

public class JsonReader extends Reader{
    
    public Object documentReader(){
        
        JSONObject obj = new JSONObject();
        try{
            String content = Files.readString(Paths.get(""));
            obj = new JSONObject(content);
            return obj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return obj;
    }
    
    
    public void JsonWriter(String path2, JSONObject content){
     
        String path = path2;

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }


    
   
    
}

