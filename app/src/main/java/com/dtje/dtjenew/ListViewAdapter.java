package com.dtje.dtjenew;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 6/13/2015.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Restaurant> restaurants;

    public ListViewAdapter(Context c, List<Restaurant> restaurants){
        mContext=c;
        inflater = LayoutInflater.from(c);
        this.restaurants=restaurants;
    }

    @Override
    public int getCount(){
        return restaurants.size();
    }

    @Override
    public Object getItem(int position){
        return restaurants.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public class ViewHolder{
        public TextView name,distance,price_range;
        public ImageView icon,star1, star2,star3,star4,star5;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View v=convertView;
        ViewHolder holder;

        if(v==null){
            v = inflater.inflate(R.layout.listitem_restaurant, parent,false);

            holder=new ViewHolder();
            holder.name=(TextView)v.findViewById(R.id.name);
            holder.distance=(TextView)v.findViewById(R.id.distance);
            holder.price_range=(TextView)v.findViewById(R.id.price_range);

            holder.icon=(ImageView)v.findViewById(R.id.icon);
            holder.star1=(ImageView)v.findViewById(R.id.star1);
            holder.star2=(ImageView)v.findViewById(R.id.star2);
            holder.star3=(ImageView)v.findViewById(R.id.star3);
            holder.star4=(ImageView)v.findViewById(R.id.star4);
            holder.star5=(ImageView)v.findViewById(R.id.star5);
            v.setTag(holder);
        }else{
            holder=(ViewHolder)v.getTag();
        }


        holder.icon.setImageResource(restaurants.get(position).getPicture());
        Log.e("asdasd", restaurants.get(position).getName());
        holder.name.setText(restaurants.get(position).getName());
        holder.distance.setText(restaurants.get(position).getDistance());
        holder.price_range.setText(restaurants.get(position).getPrice());

        switch(restaurants.get(position).getRating()){
            case 1:
                holder.star1.setVisibility(View.VISIBLE);
                break;
            case 2:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                break;
            case 3:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                break;
            case 4:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                holder.star4.setVisibility(View.VISIBLE);
                break;
            case 5:
                holder.star1.setVisibility(View.VISIBLE);
                holder.star2.setVisibility(View.VISIBLE);
                holder.star3.setVisibility(View.VISIBLE);
                holder.star4.setVisibility(View.VISIBLE);
                holder.star5.setVisibility(View.VISIBLE);
                break;

        }
        return v;
    }

}
