package route.com.holyquran.Abstract;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class VerseItem {
    int id;
    String name;

    public VerseItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
