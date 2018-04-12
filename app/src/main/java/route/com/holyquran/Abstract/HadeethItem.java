package route.com.holyquran.Abstract;

import java.util.ArrayList;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class HadeethItem {

    int id;
    ArrayList<String> hadeethLines;


    public HadeethItem(int id, ArrayList<String> hadeethLines) {
        this.id = id;
        this.hadeethLines = hadeethLines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getHadeethLines() {
        return hadeethLines;
    }

    public void setHadeethLines(ArrayList<String> hadeethLines) {
        this.hadeethLines = hadeethLines;
    }
}
