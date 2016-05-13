package com.beliautopart.beliautopart.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.beliautopart.beliautopart.R;
import com.beliautopart.beliautopart.helper.SessionManager;

public class HomeActivity extends AppCompatActivity {

    private SessionManager sesssionmanager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sesssionmanager = new SessionManager(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void onLoginClick(View v) {
        Intent i = new Intent(this, AuthenticationActivity.class);
        i.putExtra("page", "login");
        startActivity(i);
    }

    public void onRegisterClick(View v) {
        Intent i = new Intent(this, AuthenticationActivity.class);
        i.putExtra("page", "register");
        startActivity(i);
    }

    public void onSearchPartMobilClick(View v) {
        Intent i = new Intent(this, SearchActivity.class);
        i.putExtra("kat", "2");
        startActivity(i);
    }

    public void onSearchPartMotorClick(View v) {
        Intent i = new Intent(this, SearchActivity.class);
        i.putExtra("kat", "1");
        startActivity(i);
    }


}
