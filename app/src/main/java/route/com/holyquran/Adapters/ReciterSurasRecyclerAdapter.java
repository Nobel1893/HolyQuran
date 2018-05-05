package route.com.holyquran.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import route.com.holyquran.MyData;
import route.com.holyquran.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class ReciterSurasRecyclerAdapter extends RecyclerView.Adapter <ReciterSurasRecyclerAdapter.ViewHolder> {

    ArrayList data;

    OnItemClickListener onPlayClick;
    OnItemClickListener onStopClick;

    public void setOnPlayClick(OnItemClickListener onPlayClick) {
        this.onPlayClick = onPlayClick;
    }

    public void setOnStopClick(OnItemClickListener onStopClick) {
        this.onStopClick = onStopClick;
    }

    public ReciterSurasRecyclerAdapter(ArrayList data){
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView itemView =(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_play_sura, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        int item=(int) data.get(position);
        holder.name.setText(MyData.ArSuras[item-1]);
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onPlayClick!=null)
                    onPlayClick.OnItemClick(position);
            }
        });

        holder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onStopClick!=null)
                    onStopClick.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener{

        void OnItemClick(int position);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView name;
        Button play,stop;

        public ViewHolder(CardView cv){
            super(cv);
            this.cv=cv;
            name=cv.findViewById(R.id.name);
            play=cv.findViewById(R.id.play);
            stop=cv.findViewById(R.id.stop);

        }
    }
}
