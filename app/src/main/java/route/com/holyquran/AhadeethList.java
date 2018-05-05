package route.com.holyquran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import route.com.holyquran.Abstract.HadeethItem;
import route.com.holyquran.Adapters.HadeethRecyclerAdapter;

public class AhadeethList extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadeath_list);


        recyclerView=findViewById(R.id.recyclerview);

        ArrayList<HadeethItem> Ahadeeth;
        Ahadeeth=ReadAhadeth();
        HadeethRecyclerAdapter adapter=new HadeethRecyclerAdapter(Ahadeeth);
        layoutManager=new LinearLayoutManager(this);

        adapter.setOnItemClickListener(new HadeethRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(AhadeethList.this,"item clicked "+position,Toast.LENGTH_LONG).show();
            }
        });

        adapter.setOnLikeClickListener(new HadeethRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {

            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);



    }


    ArrayList<HadeethItem> ReadAhadeth(){

        ArrayList<HadeethItem> AllHadeeth=new ArrayList<>();
        ArrayList<String> hadees= new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("ahadith_arabic.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            int id=0;

            HadeethItem item=null;
            ArrayList<String>HadeathContent=new ArrayList<>();
            while ((mLine = reader.readLine()) != null) {

                if (mLine.equals("#")){
                    item=new HadeethItem(id,HadeathContent);
                    AllHadeeth.add(item);
                    HadeathContent=new ArrayList<>();
                    id++;
                }else {
                    HadeathContent.add(mLine);
                }
                Log.e("line",mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return AllHadeeth;
    }

}

