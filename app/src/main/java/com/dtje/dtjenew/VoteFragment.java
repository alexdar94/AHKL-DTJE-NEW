package com.dtje.dtjenew;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class VoteFragment extends Fragment {
    int windowwidth;
    int screenCenter;
    int x_cord, y_cord;
    int Likes = 0;
    FrameLayout parentView;
    float alphaValue = 0;

    public VoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vote, container, false);

        parentView = (FrameLayout) rootView.findViewById(R.id.yes_no1);
        windowwidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        screenCenter = windowwidth / 2;
        int[] myImageList = new int[]{R.drawable.image1, R.drawable.image2,
                R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};
        for (int i = 0; i < 6; i++) {
            LayoutInflater inflate = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View myRelView = inflate.inflate(R.layout.custom_vote_layout, null);
            ImageView imageView=(ImageView)myRelView.findViewById(R.id.food_image);
            RelativeLayout rl=(RelativeLayout)myRelView.findViewById(R.id.rl_restaurant_image);
            myRelView.setLayoutParams(new RelativeLayout.LayoutParams((windowwidth - 80), 450));
            myRelView.setX(40);
            myRelView.setY(40);
            myRelView.setTag(i);
            imageView.setBackgroundResource(myImageList[i]);

            if (i == 0) {
                myRelView.setRotation(-1);
            } else if (i == 1) {
                myRelView.setRotation(-5);

            } else if (i == 2) {
                myRelView.setRotation(3);

            } else if (i == 3) {
                myRelView.setRotation(7);

            } else if (i == 4) {
                myRelView.setRotation(-2);

            } else if (i == 5) {
                myRelView.setRotation(5);

            }

            final Button imageLike = new Button(rootView.getContext());
            imageLike.setLayoutParams(new RelativeLayout.LayoutParams(100, 50));
            imageLike.setBackgroundDrawable(getResources().getDrawable(R.drawable.stamp_liked));
            imageLike.setX(20);
            imageLike.setY(-250);
            imageLike.setAlpha(alphaValue);
            imageLike.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //your like action code write here
                }
            });
            rl.addView(imageLike);

            final Button imagePass = new Button(rootView.getContext());
            imagePass.setLayoutParams(new ViewGroup.LayoutParams(100, 50));
            imagePass.setBackgroundDrawable(getResources().getDrawable(R.drawable.pass));
            imagePass.setX(260);
            imagePass.setY(-300);
            imagePass.setRotation(45);
            imagePass.setAlpha(alphaValue);
            imagePass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //your pass action code write here
                }
            });
            rl.addView(imagePass);

            myRelView.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    x_cord = (int) event.getRawX();
                    y_cord = (int) event.getRawY();

                    myRelView.setX(x_cord - screenCenter + 40);
                    myRelView.setY(y_cord - 150);
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            break;
                        case MotionEvent.ACTION_MOVE:
                            x_cord = (int) event.getRawX();
                            y_cord = (int) event.getRawY();
                            myRelView.setX(x_cord - screenCenter + 40);
                            myRelView.setY(y_cord - 150);
                            if (x_cord >= screenCenter) {
                                myRelView.setRotation((float) ((x_cord - screenCenter) * (Math.PI / 32)));
                                if (x_cord > (screenCenter + (screenCenter / 2))) {
                                    imageLike.setAlpha(1);
                                    if (x_cord > (windowwidth - (screenCenter / 4))) {
                                        Likes = 2;
                                    } else {
                                        Likes = 0;
                                    }
                                } else {
                                    Likes = 0;
                                    imageLike.setAlpha(0);
                                }
                                imagePass.setAlpha(0);
                            } else {
                                // rotate
                                myRelView.setRotation((float) ((x_cord - screenCenter) * (Math.PI / 32)));
                                if (x_cord < (screenCenter / 2)) {
                                    imagePass.setAlpha(1);
                                    if (x_cord < screenCenter / 4) {
                                        Likes = 1;
                                    } else {
                                        Likes = 0;
                                    }
                                } else {
                                    Likes = 0;
                                    imagePass.setAlpha(0);
                                }

                                imageLike.setAlpha(0);
                            }

                            break;
                        case MotionEvent.ACTION_UP:
                            x_cord = (int) event.getRawX();
                            y_cord = (int) event.getRawY();

                            Log.e("X Point", "" + x_cord + " , Y " + y_cord);
                            imagePass.setAlpha(0);
                            imageLike.setAlpha(0);

                            if (Likes == 0) {
                                Log.e("Event Status", "Nothing");
                                myRelView.setX(40);
                                myRelView.setY(40);
                                myRelView.setRotation(0);
                            } else if (Likes == 1) {
                                Log.e("Event Status", "Passed");
                                parentView.removeView(myRelView);
                            } else if (Likes == 2) {

                                Log.e("Event Status", "Liked");
                                parentView.removeView(myRelView);
                            }
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });

            parentView.addView(myRelView);
        }
        return rootView;
    }


}
