package Model;

import Util.JsonReader;
import org.json.JSONObject;

import Util.Reader;

public class JsonTool {
    private Reader reader;

    public JsonTool() {
        this.reader = new JsonReader();
    }

    public void jsonReader(){
        Object json = this.reader.documentReader();
        System.out.println(json);
    }
}
