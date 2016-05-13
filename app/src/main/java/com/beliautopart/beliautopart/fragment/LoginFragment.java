package com.beliautopart.beliautopart.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.beliautopart.beliautopart.R;
import com.beliautopart.beliautopart.helper.SendDataHelper;
import com.beliautopart.beliautopart.model.UserModel;
import com.beliautopart.beliautopart.webservices.UserService;

/**
 * Created by brandon on 12/05/16.
 */
public class LoginFragment extends Fragment {
    private EditText inputEmail;
    private EditText inputPassword;
    private Button btnLogin;
    private UserService userService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.login_fragment, container, false);
        inputEmail = (EditText) v.findViewById(R.id.inputEmail);
        inputPassword = (EditText) v.findViewById(R.id.inputPassword);
        btnLogin = (Button) v.findViewById(R.id.btnLogin);
        userService = new UserService(getContext());


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputEmail.equals(null))
                    Toast.makeText(getContext(), "Email belum diisi", Toast.LENGTH_SHORT).show();
                else if (inputPassword.equals(null))
                    Toast.makeText(getContext(), "Password belum diisi", Toast.LENGTH_SHORT).show();
                else
                    onLogin();
            }
        });
        return v;
    }

    private void onLogin() {
        String email = inputEmail.getText().toString().trim();
        Log.d("email :", email);
        String password = inputPassword.getText().toString().trim();
        UserModel user = new UserModel(email, password);
        userService.LoginUser(user, new SendDataHelper.VolleyCallback() {
            @Override
            public String onSuccess(String result) {
                Toast.makeText(getContext(), result.toString(), Toast.LENGTH_LONG).show();
                return result;
            }

            @Override
            public String onError(VolleyError result) {
                return null;
            }
        });
    }

    public void onRegisterButtonClick(View v) {
        RegisterFragment registerFragment = new RegisterFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
        fragmentTransaction.replace(R.id.frameAuth, registerFragment);
        fragmentTransaction.commit();
    }


}
