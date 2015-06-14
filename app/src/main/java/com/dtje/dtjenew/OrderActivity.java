package com.dtje.dtjenew;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class OrderActivity extends ActionBarActivity {
private List<RestaurantMenuItem> menuItems= new ArrayList<RestaurantMenuItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ListView lv=(ListView)findViewById(R.id.listView_menu);
        createList();
        lv.setAdapter(new OrderListAdapter(this, menuItems));
    }

    public void createList(){
        RestaurantMenuItem r1=new RestaurantMenuItem();
        r1.setName("Teriyaki Chicken Bento");
        r1.setPrice("RM 15.90");
        r1.setPicture(R.drawable.teriyaki);

        RestaurantMenuItem r2=new RestaurantMenuItem();
        r2.setName("Salmon Bento");
        r2.setPrice("RM 13.90");
        r2.setPicture(R.drawable.salmon);

        RestaurantMenuItem r3=new RestaurantMenuItem();
        r3.setName("Saba Bento");
        r3.setPrice("RM 14.90");
        r3.setPicture(R.drawable.saba);

        RestaurantMenuItem r4=new RestaurantMenuItem();
        r4.setName("Soft Shell Crab Bento");
        r4.setPrice("RM 12.90");
        r4.setPicture(R.drawable.softshellcrab);

        RestaurantMenuItem r5=new RestaurantMenuItem();
        r5.setName("Ten-Don");
        r5.setPrice("RM 9.90");
        r5.setPicture(R.drawable.tendon);

        RestaurantMenuItem r6=new RestaurantMenuItem();
        r6.setName("Chicken Katsu-Don");
        r6.setPrice("RM 16.90");
        r6.setPicture(R.drawable.chickenkatsu);

        RestaurantMenuItem r7=new RestaurantMenuItem();
        r7.setName("Unagi-Don");
        r7.setPrice("RM 12.90");
        r7.setPicture(R.drawable.unagidon);

        RestaurantMenuItem r8=new RestaurantMenuItem();
        r8.setName("Tororo Soba");
        r8.setPrice("RM 20.50");
        r8.setPicture(R.drawable.tororosoba);

        RestaurantMenuItem r9=new RestaurantMenuItem();
        r9.setName("Zaru Soba");
        r9.setPrice("RM 25.00");
        r9.setPicture(R.drawable.zarusoba);

        RestaurantMenuItem r10=new RestaurantMenuItem();
        r10.setName("Sesame Soba");
        r10.setPrice("RM 5.90");
        r10.setPicture(R.drawable.sesamesoba);

        menuItems.add(r1);
        menuItems.add(r2);
        menuItems.add(r3);
        menuItems.add(r4);
        menuItems.add(r5);
        menuItems.add(r6);
        menuItems.add(r7);
        menuItems.add(r8);
        menuItems.add(r9);
        menuItems.add(r10);
    }

    public void order(View view){
     Toast.makeText(this,"We have received you order! Please wait for your meal to be served. Thank you!",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }
}
