package route.com.holyquran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import route.com.ReciterSuras;
import route.com.holyquran.Abstract.RecitersResponse;
import route.com.holyquran.Adapters.RecitersRecyclerAdapter;
import route.com.holyquran.Base.MyBaseActivity;

public class ShowReciters extends MyBaseActivity{

    RecyclerView RecitersList;
    RecitersRecyclerAdapter adapter;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reciters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecitersList=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        RecitersList.setLayoutManager(layoutManager);


        getRecitersfromAPI();

    }

    public void getRecitersfromAPI() {

        ShowProgressDialoge();

        apiCalls.getReciters().enqueue(new Callback<RecitersResponse>() {
            @Override
            public void onResponse(Call<RecitersResponse> call, Response<RecitersResponse> response) {
                HideProgressDialog();
                SetData(response.body());
            }

            @Override
            public void onFailure(Call<RecitersResponse> call, Throwable t) {
                HideProgressDialog();
                ShowMessage("",t.getMessage());
            }
        });

    }

    public void SetData(final RecitersResponse response){

        adapter=new RecitersRecyclerAdapter(response.getReciters());
        RecitersList.setAdapter(adapter);
        adapter.setOnItemClickListener(
                new RecitersRecyclerAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(int position) {
                      String ss=  response.getReciters().get(position).getSuras();
                        Intent i=new Intent(activity, ReciterSuras.class);
                        i.putExtra("suras",ss);
                        i.putExtra("server",response.getReciters().get(position).getServer());
                        startActivity(i);
                    }
                });
        for (int i=0;i<response.getReciters().size();i++){
            Log.e("name",response.getReciters().get(i).getName());
        }

    }

}
