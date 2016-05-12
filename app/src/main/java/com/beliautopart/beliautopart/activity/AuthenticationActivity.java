package com.beliautopart.beliautopart.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.beliautopart.beliautopart.R;
import com.beliautopart.beliautopart.fragment.LoginFragment;
import com.beliautopart.beliautopart.fragment.RegisterFragment;

public class AuthenticationActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        String page;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                page = "login";
            } else {
                page = extras.getString("page");
            }
        } else {
            page = (String) savedInstanceState.getSerializable("page");
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(page);
        if (page.equals("login")) {
            loginFragment = new LoginFragment();
            changeFragment(loginFragment);
        } else {
            registerFragment = new RegisterFragment();
            changeFragment(registerFragment);
        }
    }


    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.frameAuth, fragment);
        fragmentTransaction.commit();
    }
}
