package route.com.holyquran.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import route.com.holyquran.Abstract.VerseItem;
import route.com.holyquran.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class VersesRecyclerAdapter extends RecyclerView.Adapter <VersesRecyclerAdapter.ViewHolder> {

    ArrayList data;

    public VersesRecyclerAdapter(ArrayList data){
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView itemView =(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_verse, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        VerseItem item=(VerseItem)data.get(position);
        holder.name.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView name;

        public ViewHolder(CardView cv){
            super(cv);
            this.cv=cv;
            name=cv.findViewById(R.id.name);

        }
    }
}
