package route.com.holyquran.Abstract;

import java.util.ArrayList;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 5/5/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class RecitersResponse {


    /**
     * reciters : [{"id":"205","name":"أحمد الحذيفي","Server":"https://server8.mp3quran.net/ahmad_huth","rewaya":"حفص عن عاصم","count":"65","letter":"أ","suras":"1,14,15,17,18,19,21,22,23,26,27,29,32,35,38,44,45,49,50,55,56,57,62,63,64,65,66,72,73,74,75,76,77,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114"}]
     */

    private ArrayList<RecitersEntity> reciters;

    public void setReciters(ArrayList<RecitersEntity> reciters) {
        this.reciters = reciters;
    }

    public ArrayList<RecitersEntity> getReciters() {
        return reciters;
    }

    public static class RecitersEntity {
        /**
         * id : 205
         * name : أحمد الحذيفي
         * Server : https://server8.mp3quran.net/ahmad_huth
         * rewaya : حفص عن عاصم
         * count : 65
         * letter : أ
         * suras : 1,14,15,17,18,19,21,22,23,26,27,29,32,35,38,44,45,49,50,55,56,57,62,63,64,65,66,72,73,74,75,76,77,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114
         */

        private String id;
        private String name;
        private String Server;
        private String rewaya;
        private String count;
        private String letter;
        private String suras;

        public void setId(String id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setServer(String Server) {
            this.Server = Server;
        }

        public void setRewaya(String rewaya) {
            this.rewaya = rewaya;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public void setSuras(String suras) {
            this.suras = suras;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getServer() {
            return Server;
        }

        public String getRewaya() {
            return rewaya;
        }

        public String getCount() {
            return count;
        }

        public String getLetter() {
            return letter;
        }

        public String getSuras() {
            return suras;
        }
    }
}
