package com.nosin.wr.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.nosin.wr.R;

public class MainActivity extends AppCompatActivity {


    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFragment home = new homeFragment();

       FragmentManager fm = getSupportFragmentManager();
       fm.beginTransaction().add(R.id.fragment_container,home).commit();
    }


}