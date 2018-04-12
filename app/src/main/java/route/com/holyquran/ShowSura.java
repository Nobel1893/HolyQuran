package route.com.holyquran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import route.com.holyquran.Abstract.VerseItem;
import route.com.holyquran.Adapters.VersesRecyclerAdapter;

public class ShowSura extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sura);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String filename=getIntent()
                .getStringExtra("id");
        if (filename!=null){
            filename=filename+".txt";
        }

        Log.e("filename",filename);

        recyclerView=findViewById(R.id.recyclerview);

        ArrayList<VerseItem> verses;
        verses=ReadSura(filename);
        VersesRecyclerAdapter adapter=new VersesRecyclerAdapter(verses);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }


    ArrayList<VerseItem> ReadSura(String filename){

        ArrayList<VerseItem> alllines=new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            int id=0;
            while ((mLine = reader.readLine()) != null) {
                alllines.add(new VerseItem(id,mLine));
                Log.e("line",mLine);
                id++;
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

        return alllines;
    }

}
