package com.example.biketracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bitvale.lightprogress.LightProgress;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Context ctx;
    FirebaseDatabase database ;
    DatabaseReference myRef;
    ImageView imageBike;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;
        imageBike = findViewById(R.id.imageBike);
        imageBike.animate().rotation(360).setDuration(3000);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        myRef.setValue("Hello World");
        frameLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) frameLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        

//        SharedPreferences sharedPreferences = getSharedPreferences("night", 0);
//        Boolean isNightMode = sharedPreferences.getBoolean("night_mode",true);

//        if (isNightMode) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ctx, NavigationDrawerActivity.class));
            }
        },3000);

    }
}