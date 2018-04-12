package route.com.holyquran.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import route.com.holyquran.R;
import route.com.holyquran.Abstract.SuraContent;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class SurasAdapter  extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<SuraContent> data;
   public SurasAdapter(ArrayList<SuraContent> data, LayoutInflater inflater){
        this.data=data;
        this.inflater=inflater;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView=convertView;
        ViewHolder viewHolder;
        if (rowView==null){
            rowView= inflater.inflate(R.layout.sura_item,null);
            viewHolder=new ViewHolder();
            viewHolder.name=rowView.findViewById(R.id.name);
            rowView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }

        SuraContent dataitem=data.get(position);
        viewHolder.name.setText(dataitem.getName());

        return rowView;
    }

    public static class ViewHolder{
      public  TextView name;


    };
}
