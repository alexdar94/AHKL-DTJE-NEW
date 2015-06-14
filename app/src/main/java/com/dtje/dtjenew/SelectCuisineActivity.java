package com.dtje.dtjenew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SelectCuisineActivity extends ActionBarActivity {

    public List<Restaurant> restaurants= new ArrayList<Restaurant>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cuisine);

        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new GridViewAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch(position){
                    case 0:
                        fastFood();
                        Intent intent= new Intent(SelectCuisineActivity.this,RestaurantListActivity.class);
                        Bundle arg = new Bundle();
                        arg.putSerializable("RECOMMENDED_LIST", (Serializable) restaurants);
                        intent.putExtra("BUNDLE", arg);
                        startActivity(intent);
                        Log.e("asdasd",restaurants.size()+"");
                        break;
                    case 2:
                        japaneseFood();
                        Intent intent1= new Intent(SelectCuisineActivity.this,RestaurantListActivity.class);
                        Bundle arg1 = new Bundle();
                        arg1.putSerializable("RECOMMENDED_LIST", (Serializable) restaurants);
                        intent1.putExtra("BUNDLE", arg1);
                        startActivity(intent1);
                        Log.e("asdasd", "asdasdasdasd");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void fastFood() {
        Restaurant wrestaurant1 = new Restaurant();
        wrestaurant1.setName("Muzeum Western Cuisine");
        wrestaurant1.setDistance("7.6km");
        wrestaurant1.setRating(5);
        wrestaurant1.setPrice("RM100-RM200");
        wrestaurant1.setContact("017-2532221");
        wrestaurant1.setPicture(R.drawable.muzeum_west);
        wrestaurant1.setDescription("Muzeum Restaurant & Bar was born from the concept of a ¡®gastropub¡® created based on the idea of a ¡®museum¡®. Muzeum offers quality and popular authentic dishes, to an interior with the tiniest details place on making every corner as iconic as possible, relaxing, entertaining and unique experience to dine and booze.");

        Restaurant wrestaurant2 = new Restaurant();
        wrestaurant2.setName("Yeolde English Western Cuisine");
        wrestaurant2.setDistance("4.8km");
        wrestaurant2.setRating(5);
        wrestaurant2.setPrice("RM10-RM20");
        wrestaurant2.setContact("017-8743633");
        wrestaurant2.setPicture(R.drawable.yeolde_west);
        wrestaurant2.setDescription("Yeolde English Restaurant was established on 25th November 2000 at Greentown Business Centre. In year 2001, we are added a branch at Ipoh Garden!\n" +
                "We are offered more than 200 types of foods and beverages for our valued customer. We are also offer a variety of cakes which can be sold in slices or in half kilogram for choice.\n");

        Restaurant wrestaurant3 = new Restaurant();
        wrestaurant3.setName("Maria's Steak House");
        wrestaurant3.setDistance("6km");
        wrestaurant3.setRating(5);
        wrestaurant3.setPrice("RM50-RM70");
        wrestaurant3.setContact("018-5632177");
        wrestaurant3.setPicture(R.drawable.maria_west);
        wrestaurant3.setDescription("Maria's is a dream come true for Maria Tan and her late husband Philip Tan, Both shared a passion for good food to eat, and cook to eat. At a time when Ipoh had a little to shout of in terms of fine western restaurants, Maria and Philip would scour the world in their travels to discover delightful kitchen secrets. Whatever they chanced upon they would learn and replicate in their own home kitchen, and share their joy, much to the delight of friends and fellow gourmands in Ipoh.");

        Restaurant wrestaurant4 = new Restaurant();
        wrestaurant4.setName("James Foo Western Cusine");
        wrestaurant4.setDistance("9.8km");
        wrestaurant4.setRating(4);
        wrestaurant4.setPrice("RM100-RM200");
        wrestaurant4.setContact("018-9532285");
        wrestaurant4.setPicture(R.drawable.james_west);
        wrestaurant4.setDescription("The restaurant has great lighting and it come with a juice bar at the center of the restaurant. If you drop by James Foo western food during the weekend for dinner, you will always found that this restaurant is pack with customer. In other word, it will always be full house. Sometimes, the customer is force to wait at the main entrance while waiting to be served. ");

        Restaurant wrestaurant5 = new Restaurant();
        wrestaurant5.setName("Plan B Cafe");
        wrestaurant5.setDistance("13km");
        wrestaurant5.setRating(4);
        wrestaurant5.setPrice("RM10-RM25");
        wrestaurant5.setContact("016-2312589");
        wrestaurant5.setPicture(R.drawable.planb_west);
        wrestaurant5.setDescription("Plan B is a creative space specifically designed to encourage people to eat, linger and to get inspired. Offering an edgy alternative to the cookie-cutter coffee places, Plan B is a culture caf¨¦ that focuses on artisan coffee and global flavours. ");

        restaurants=new ArrayList<Restaurant>();
        restaurants.add(wrestaurant1);
        restaurants.add(wrestaurant2);
        restaurants.add(wrestaurant3);
        restaurants.add(wrestaurant4);
        restaurants.add(wrestaurant5);
    }

    public void japaneseFood(){
        Restaurant jrestaurant1=new Restaurant();
        jrestaurant1.setName("Bikkuri Japanese Cuisine");
        jrestaurant1.setDistance("0.7km");
        jrestaurant1.setRating(5);
        jrestaurant1.setPrice("RM100-RM200");
        jrestaurant1.setContact("017-5269878");
        jrestaurant1.setPicture(R.drawable.bikkuri_jp);
        jrestaurant1.setDescription("Bikkuri is located in the heart of Toronto's financial district, just steps from the King subway station. Bikkuri provides full range of daily fresh sushi, as well as authentic Japanese dishes. With over 3,800 square feet, Bikkuri seats 200 patrons, it has traditional Japanese Tatami (private booths), sushi bar and a summer patio. Bikkuri opens 7 days a week and it provides other services like catering, take-out and delivery. ");

        Restaurant jrestaurant2=new Restaurant();
        jrestaurant2.setName("Kabuki Japanese Cuisine");
        jrestaurant2.setDistance("1.2km");
        jrestaurant2.setRating(5);
        jrestaurant2.setPrice("RM25-RM30");
        jrestaurant2.setContact("018-7895462");
        jrestaurant2.setPicture(R.drawable.kabuki_jp);
        jrestaurant2.setDescription("Welcome to Kabuki Japanese Restaurant, the people behind sushi for all mankind. Never tried sushi or Japanese cuisine? Try us and we guarantee you will walk out hooked on our food. That¡¯s what we do best; making non-believers into believers that Japanese cuisine is the new comfort food.");

        Restaurant jrestaurant3=new Restaurant();
        jrestaurant3.setName("Gion Japanese Cuisine ");
        jrestaurant3.setDistance("2.6km");
        jrestaurant3.setRating(4);
        jrestaurant3.setPrice("RM40-RM50");
        jrestaurant3.setContact("016-7846215");
        jrestaurant3.setPicture(1);
        jrestaurant3.setDescription("Named after an ancient district in Kyoto, Gion Japanese Restaurant gives an ambience of the old Japan. Served by kimona clad ladies, customers are welcomed with a serving of green tea.");

        Restaurant jrestaurant4=new Restaurant();
        jrestaurant4.setName("Kizuna Japanese Cuisine ");
        jrestaurant4.setDistance("4.7km");
        jrestaurant4.setRating(4);
        jrestaurant4.setPrice("RM15-RM20");
        jrestaurant4.setContact("018-5478120");
        jrestaurant4.setPicture(R.drawable.kizuna_jp);
        jrestaurant4.setDescription("At Kizuna Japanese Restaurant, we offer the rich traditions of Japanese cuisine with modern approach to Washoku, a relaxed style of dining centered around a procession of small plates. We've brought a modern Tokyo aesthetic with the restaurant¡¯s soaring ceilings, oversized windows and lights that remind you of lanterns at Japanese shrines, providing you with a warm pathway guiding you to your tables. We've packed in our know-how for Japanese restaurant to ensure you'll feel like you're dining in Japan. All aspects of the restaurant were designed so the atmosphere of Kizuna will bring you pleasant time with your partners, friends or family.");

        Restaurant jrestaurant5=new Restaurant();
        jrestaurant5.setName("Hokkaido Ichiba Japanese Cuisine");
        jrestaurant5.setDistance("7km");
        jrestaurant5.setRating(4);
        jrestaurant5.setPrice("RM20-RM50");
        jrestaurant5.setContact("016-5413222");
        jrestaurant5.setPicture(R.drawable.hokkaido_jp);
        jrestaurant5.setDescription("Hokkaido Ichiba in The Gardens Mall houses 3 brands under one roof ¨C Kita no Zen Japanese Restaurant, Hokkaido Ice Cream & Shojikiya, Japanese Food Specialty Store. The word ¡°ichiba¡± means ¡°marketplace¡± in Japanese. We aspire to bring the best pleasures of Japan to you. ");

        restaurants=new ArrayList<Restaurant>();
        restaurants.add(jrestaurant1);
        restaurants.add(jrestaurant2);
        restaurants.add(jrestaurant3);
        restaurants.add(jrestaurant4);
        restaurants.add(jrestaurant5);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_cuisine, menu);
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
        }else if(id == R.id.action_profile){
            Intent intent= new Intent(this,ProfileActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
