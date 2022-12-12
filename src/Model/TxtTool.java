package Model;

import Util.Reader;
import Util.TxtReader;

public class TxtTool {
    private Reader reader;

    public TxtTool() {
        this.reader = new TxtReader();
    }

    public void txtReader(){
        Object datos = this.reader.documentReader();
        System.out.println(datos);
    }
}
