package com.dtje.dtjenew;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();
        final ImageView dtje = (ImageView) findViewById(R.id.dtje_name);
        final LinearLayout LoginBox = (LinearLayout) findViewById(R.id.LoginBox);
        LoginBox.setVisibility(View.GONE);
        dtje.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Animation animTranslate = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate);
                animTranslate.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation arg0) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation arg0) {
                    }

                    @Override
                    public void onAnimationEnd(Animation arg0) {
                        LoginBox.setVisibility(View.VISIBLE);
                        Animation animFade = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.fade);
                        animFade.setFillEnabled(true);
                        animFade.setFillAfter(true);
                        LoginBox.startAnimation(animFade);
                    }
                });
                dtje.startAnimation(animTranslate);
            }
        });
    }

    public void login(View view) {
        Intent intent = new Intent(LoginActivity.this,SelectCuisineActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
