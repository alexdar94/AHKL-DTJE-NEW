package com.dtje.dtjenew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 6/13/2015.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context mContext;
    String[] web = {
            "Fast Food",
            "Indian",
            "Japanese",
            "Noodles",
            "Burger",
            "Seafood",
            "Soup",
            "Vegetarian",
            "Western"
    } ;

    int[] imageId = {
            R.drawable.fastfood,
            R.drawable.indian,
            R.drawable.japanese,
            R.drawable.noodle,
            R.drawable.burger,
            R.drawable.seafood,
            R.drawable.soup,
            R.drawable.vegeterian,
            R.drawable.western
    };

    public GridViewAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object getItem(int position) {
        return imageId[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(web[position]);
            imageView.setImageResource(imageId[position]);
        } else {
            grid = (View) convertView;
        }
        return grid;
    }


}