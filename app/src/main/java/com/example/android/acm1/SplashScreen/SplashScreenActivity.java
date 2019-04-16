package com.example.android.acm1.SplashScreen;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.acm1.MainActivity;
import com.example.android.acm1.R;
import com.google.android.gms.common.oob.SignUp;
import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        EasySplashScreen easySplashScreen = new EasySplashScreen(SplashScreenActivity.this).withFullScreen()
                .withTargetActivity(MainActivity.class).
                        withSplashTimeOut(5000).
                        withBackgroundColor(Color.parseColor("#232222")).
                        withLogo(R.drawable.acm_logo).withHeaderText("Welcome ^-^").
                        withFooterText("Developed by \n       ACM").
                        withBeforeLogoText("This is ACM app").
                        withAfterLogoText("Cal State LA");

        easySplashScreen.getHeaderTextView().setTextColor(Color.WHITE);
        easySplashScreen.getHeaderTextView().setPaddingRelative(0,50,0,0);

        easySplashScreen.getFooterTextView().setTextColor(Color.WHITE);
        easySplashScreen.getFooterTextView().setPaddingRelative(0,0,0,50);

        easySplashScreen.getAfterLogoTextView().setTextColor(Color.WHITE);
        easySplashScreen.getBeforeLogoTextView().setTextColor(Color.WHITE);

        easySplashScreen.getLogo().setPaddingRelative(0,40,0,50);

        View view = easySplashScreen.create();

        setContentView(view);
    }
}