package com.minangwisatasumbar.asywalulfikri.wisatasumbar.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.minangwisatasumbar.asywalulfikri.wisatasumbar.R;
import com.minangwisatasumbar.asywalulfikri.wisatasumbar.util.Constanta;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by asywalulfikri on 9/20/16.
 */

public class HasilLogin extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);

        Intent i=getIntent();
        String avatar  =i.getStringExtra("avatar");
        String fullName = i.getStringExtra("fullName");
        String gender = i.getStringExtra("gender");
        String email = i.getStringExtra("email");

        TextView xx = (TextView)findViewById(R.id.aa);
        ImageView yy = (ImageView)findViewById(R.id.bb) ;

        xx.setText(fullName);
        Glide.with(HasilLogin.this)
                                        .load(avatar)
                                        .into((ImageView) findViewById(R.id.bb));

    }
}