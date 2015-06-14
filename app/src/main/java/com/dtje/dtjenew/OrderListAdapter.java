package com.dtje.dtjenew;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 6/13/2015.
 */
public class OrderListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<RestaurantMenuItem> menuItems= new ArrayList<RestaurantMenuItem>();

    public OrderListAdapter(Context c,List<RestaurantMenuItem> m){
        mContext=c;
        inflater = LayoutInflater.from(c);
        menuItems=m;
    }

    @Override
    public int getCount(){
        return menuItems.size();
    }

    @Override
    public Object getItem(int position){
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public class ViewHolder{
        public ImageView img_menu_item;
        public TextView txt_menu_name,txt_menu_item_price;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;

        if (v == null) {
            v = inflater.inflate(R.layout.menu_item_layout, parent, false);

            holder = new ViewHolder();
            holder.img_menu_item = (ImageView) v.findViewById(R.id.img_menu_item);
            holder.txt_menu_name = (TextView) v.findViewById(R.id.txt_menu_item_name);
            holder.txt_menu_item_price = (TextView) v.findViewById(R.id.txt_menu_item_price);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.img_menu_item.setImageResource(menuItems.get(position).getPicture());
        holder.txt_menu_name.setText(menuItems.get(position).getName());
        holder.txt_menu_item_price.setText(menuItems.get(position).getPrice());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                ImageView img= new ImageView(mContext);
                img.setImageResource(menuItems.get(position).getPicture());
                builder.setView(img);
                builder.create();
                builder.show();
            }
        });
        return v;
    }
    }
