package route.com.holyquran.API;

import retrofit2.Call;
import retrofit2.http.GET;
import route.com.holyquran.Abstract.RecitersResponse;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 5/5/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public interface APICalls {

    @GET("_arabic.json")
   Call<RecitersResponse> getReciters();
}
