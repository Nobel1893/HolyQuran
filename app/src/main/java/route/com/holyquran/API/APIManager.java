package route.com.holyquran.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 5/5/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class APIManager {

    private static Retrofit retrofitInstance;

    public static Retrofit getRetrofitInstance(){


        if (retrofitInstance==null)
        {
            retrofitInstance= new Retrofit.Builder()
                    .baseUrl("https:/mp3quran.net/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }

        return retrofitInstance;

    }

}
