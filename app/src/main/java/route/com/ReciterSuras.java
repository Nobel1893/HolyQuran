package route.com;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import route.com.holyquran.Adapters.ReciterSurasRecyclerAdapter;
import route.com.holyquran.Base.MyBaseActivity;
import route.com.holyquran.R;

public class ReciterSuras extends MyBaseActivity {

    RecyclerView suras;
    LinearLayoutManager layoutManager;
    ReciterSurasRecyclerAdapter adapter;
    ArrayList<Integer>data;
    MediaPlayer mediaPlayer;
     String server;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciter_suras);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       String ss= getIntent().getStringExtra("suras");
      server = getIntent().getStringExtra("server");

      String []arr= ss.split(",");
        data=new ArrayList<>(114);
      for (int i=0;i<arr.length;i++){
          data.add(Integer.valueOf(arr[i]));
      }
      suras=findViewById(R.id.recyclerview);
        adapter=new ReciterSurasRecyclerAdapter(data);
        layoutManager=new LinearLayoutManager(this);
        suras.setLayoutManager(layoutManager);
        suras.setAdapter(adapter);
        adapter.setOnPlayClick(new ReciterSurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                PlaySura(position);
            }
        });
        adapter.setOnStopClick(new ReciterSurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                StopSura();
            }
        });

    }

    void PlaySura(int position){
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String sura=data.get(position)+"";
        while(sura.length()!=3)sura="0"+sura;

        try {
            String url=server+"/"+sura+".mp3";
            Log.e("url",url);
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void StopSura(){
        if (mediaPlayer!=null&&mediaPlayer.isPlaying())
            mediaPlayer.stop();
    }

}
