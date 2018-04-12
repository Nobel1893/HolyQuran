package route.com.holyquran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import route.com.holyquran.Abstract.SuraContent;
import route.com.holyquran.Adapters.SurasAdapter;

public class SurasList extends AppCompatActivity {

    ListView Suras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Suras=findViewById(R.id.listview);

        String arr[]=MyData.ArSuras;

        ArrayList<SuraContent> myData=new ArrayList<>(114);
        for (int i=0;i<arr.length;i++){
            myData.add(new SuraContent(i,arr[i]));
        }

        SurasAdapter adapter=new SurasAdapter(myData,getLayoutInflater());
        Suras.setAdapter(adapter);
        Suras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(SurasList.this,ShowSura.class);
                i.putExtra("id",""+(position+1));
                startActivity(i);
            }
        });


    }

}
