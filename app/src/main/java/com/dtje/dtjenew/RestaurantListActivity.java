package com.dtje.dtjenew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RestaurantListActivity extends ActionBarActivity {
    public List<Restaurant> restaurants= new ArrayList<Restaurant>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        Intent intent=getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        restaurants = (ArrayList<Restaurant>) args.getSerializable("RECOMMENDED_LIST");

        ListView lv=(ListView)findViewById(R.id.listView_restaurant);
        lv.setAdapter(new ListViewAdapter(this,restaurants));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent1=new Intent(getApplicationContext(),RestaurantPageActivity.class);
                Bundle arg = new Bundle();
                arg.putSerializable("RESTAURANT", (Serializable) restaurants.get(position));
                intent1.putExtra("BUNDLE1", arg);
                startActivity(intent1);
            }
        });

        ImageButton editImageButton = (ImageButton) findViewById(R.id.edit_fab_button);
        editImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(getApplicationContext(), AutoSelectRestaurantActivity.class);
                startActivity(ii);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_gps){
            Intent intent= new Intent(RestaurantListActivity.this,MapsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
