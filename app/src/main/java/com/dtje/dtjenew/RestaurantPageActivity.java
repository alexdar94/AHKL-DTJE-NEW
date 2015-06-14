package com.dtje.dtjenew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class RestaurantPageActivity extends ActionBarActivity {
Restaurant restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_page);


        Intent intent=getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE1");
        if(args!=null){
        restaurant = (Restaurant)args.getSerializable("RESTAURANT");}

        Intent intent1=getIntent();
        Bundle args1 = intent.getBundleExtra("BUNDLE_RANDOM");
        if(args1!=null){
        restaurant = (Restaurant)args1.getSerializable("RESTAURANT_RANDOM");}

        ImageView pic=(ImageView)findViewById(R.id.restaurantImage);
        TextView name=(TextView)findViewById(R.id.name_textview);
        TextView distance=(TextView)findViewById(R.id.output_distance_textview);
        TextView price=(TextView)findViewById(R.id.output_price_textview);
        TextView contact=(TextView)findViewById(R.id.output_contact_textview);
        TextView description=(TextView)findViewById(R.id.output_description_textview);
        ImageView star1=(ImageView)findViewById(R.id.detail_star1);
        ImageView star2=(ImageView)findViewById(R.id.detail_star2);
        ImageView star3=(ImageView)findViewById(R.id.detail_star3);
        ImageView star4=(ImageView)findViewById(R.id.detail_star4);
        ImageView star5=(ImageView)findViewById(R.id.detail_star5);

        pic.setImageResource(restaurant.getPicture());
        name.setText(restaurant.getName());
        distance.setText(restaurant.getDistance());
        price.setText(restaurant.getPrice());
        contact.setText(restaurant.getContact());
        description.setText(restaurant.getDescription());

        switch(restaurant.getRating()){
            case 1:
                star1.setVisibility(View.VISIBLE);
                break;
            case 2:
                star1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.VISIBLE);
                break;
            case 3:
                star1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.VISIBLE);
                break;
            case 4:
                star1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.VISIBLE);
                break;
            case 5:
                star1.setVisibility(View.VISIBLE);
                star2.setVisibility(View.VISIBLE);
                star3.setVisibility(View.VISIBLE);
                star4.setVisibility(View.VISIBLE);
                star5.setVisibility(View.VISIBLE);
                break;

        }

    }

    public void order(View view){
        Intent intent= new Intent(this,OrderActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurant_page, menu);
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
