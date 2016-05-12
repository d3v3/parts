package com.beliautopart.beliautopart.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.beliautopart.beliautopart.R;
import com.beliautopart.beliautopart.helper.SendDataHelper;
import com.beliautopart.beliautopart.model.UserModel;
import com.beliautopart.beliautopart.webservices.UserService;

/**
 * Created by brandon on 12/05/16.
 */
public class RegisterFragment extends Fragment {
    private EditText inputEmail;
    private EditText inputPassword;
    private UserService userService;
    private Button btnRegister;
    private EditText inputNamaDepan;
    private EditText inputNamaBelakang;
    private EditText inputHp;
    private EditText inputRePassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.register_fragment, container, false);

        inputEmail = (EditText) v.findViewById(R.id.inputEmail);
        inputPassword = (EditText) v.findViewById(R.id.inputPassword);
        inputNamaDepan = (EditText) v.findViewById(R.id.inputNamaDepan);
        inputNamaBelakang = (EditText) v.findViewById(R.id.inputNamaBelakang);
        inputHp = (EditText) v.findViewById(R.id.inputHp);
        inputRePassword = (EditText) v.findViewById(R.id.inputRePassword);
        btnRegister = (Button) v.findViewById(R.id.btnregister);
        userService = new UserService(getContext());
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("pass :", inputPassword.getText() + " " + inputRePassword.getText());
                if (inputEmail.getText().toString().equals(""))
                    Toast.makeText(getContext(), "Email belum diisi", Toast.LENGTH_SHORT).show();
                else if (inputPassword.getText().toString().equals(""))
                    Toast.makeText(getContext(), "Password belum diisi", Toast.LENGTH_SHORT).show();
                else if (inputNamaDepan.getText().toString().equals(""))
                    Toast.makeText(getContext(), "Nama Depan belum diisi", Toast.LENGTH_SHORT).show();
                else if (inputNamaBelakang.getText().toString().equals(""))
                    Toast.makeText(getContext(), "Nama belakang belum diisi", Toast.LENGTH_SHORT).show();
                else if (inputHp.getText().toString() == "")
                    Toast.makeText(getContext(), "No Hp belum diisi", Toast.LENGTH_SHORT).show();
                else if (!inputPassword.getText().toString().equals(inputRePassword.getText().toString()))
                    Toast.makeText(getContext(), "Password Tidak Sama", Toast.LENGTH_SHORT).show();
                else
                    onRegister();
            }
        });
        return v;
    }

    private void onRegister() {
        String namaDepan = inputNamaDepan.getText().toString().trim();
        String namaBelakang = inputNamaBelakang.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        int hp = Integer.parseInt(inputHp.getText().toString());
        String password = inputPassword.getText().toString().trim();
        UserModel user = new UserModel(0, namaDepan, namaBelakang, email, hp, password);
        userService.RegisterUser(user, new SendDataHelper.VolleyCallback() {
            @Override
            public String onSuccess(String result) {
                Toast.makeText(getContext(), result, Toast.LENGTH_LONG);
                return result;
            }
        });
    }
}
