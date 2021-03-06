package route.com.holyquran.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import route.com.holyquran.Abstract.HadeethItem;
import route.com.holyquran.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class HadeethRecyclerAdapter extends RecyclerView.Adapter <HadeethRecyclerAdapter.ViewHolder> {

    ArrayList data;

    OnItemClickListener onItemClickListener;
    OnItemClickListener onLikeClickListener;
    OnItemClickListener onShareClickListener;

    public void setOnLikeClickListener(OnItemClickListener onLikeClickListener) {
        this.onLikeClickListener = onLikeClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public HadeethRecyclerAdapter(ArrayList data){
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView itemView =(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_verse, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        HadeethItem item=(HadeethItem) data.get(position);
        holder.name.setText(item.getHadeethLines().get(0));


        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onItemClickListener!=null)
                    onItemClickListener.OnItemClick(position);
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

        public ViewHolder(CardView cv){
            super(cv);
            this.cv=cv;
            name=cv.findViewById(R.id.name);

        }
    }
}
