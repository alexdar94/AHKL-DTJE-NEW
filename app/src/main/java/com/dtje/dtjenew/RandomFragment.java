package com.dtje.dtjenew;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.skyfishjy.library.RippleBackground;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class RandomFragment extends Fragment {
    private Restaurant wrestaurant1;

    public RandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView= inflater.inflate(R.layout.fragment_random, container, false);
        ImageButton random=(ImageButton)rootView.findViewById(R.id.random);
        random.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                createRestaurant();
                final RippleBackground rippleBackground=(RippleBackground)rootView.findViewById(R.id.content);
                if(rippleBackground.isRippleAnimationRunning()){
                    rippleBackground.stopRippleAnimation();
                }else{
                    rippleBackground.startRippleAnimation();}
                final Intent intent1=new Intent(getActivity(),RestaurantPageActivity.class);
                Bundle arg = new Bundle();
                arg.putSerializable("RESTAURANT_RANDOM", (Serializable) wrestaurant1);
                intent1.putExtra("BUNDLE_RANDOM", arg);
                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent1);
                    }
                }, 1000L);
            }
        });
        return rootView;
    }

    private void createRestaurant(){
        wrestaurant1 = new Restaurant();
        wrestaurant1.setName("Muzeum Western Cuisine");
        wrestaurant1.setDistance("7.6km");
        wrestaurant1.setRating(5);
        wrestaurant1.setPrice("RM100-RM200");
        wrestaurant1.setContact("017-2532221");
        wrestaurant1.setPicture(R.drawable.muzeum_west);
        wrestaurant1.setDescription("Muzeum Restaurant & Bar was born from the concept of a t¡®gastropub¡® created based on the idea of a ¡®museum¡®. Muzeum offers quality and popular authentic dishes, to an interior with the tiniest details place on making every corner as iconic as possible, relaxing, entertaining and unique experience to dine and booze.");

    }


}
