package com.minangwisatasumbar.asywalulfikri.wisatasumbar.ui.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Toshiba on 3/12/2016.
 */
public class BaseActivity extends AppCompatActivity {

    protected SQLiteDatabase mSqLite;
    protected SharedPreferences mSharedPref;
    protected SharedPreferences mSharedPrefSession;
    private boolean mIsDbOpen = false;
    private boolean mEnableDb = false;


    public BaseActivity getActivity() {
        return this;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }





}
