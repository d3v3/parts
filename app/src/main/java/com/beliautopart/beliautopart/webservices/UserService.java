package com.beliautopart.beliautopart.webservices;

import android.content.Context;

import com.beliautopart.beliautopart.app.AppConfig;
import com.beliautopart.beliautopart.helper.SendDataHelper;
import com.beliautopart.beliautopart.model.UserModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brandon on 12/05/16.
 */
public class UserService {
    private final Context context;
    private SendDataHelper sendData;
    private String response;

    public UserService(Context context) {
        this.context = context;
        sendData = new SendDataHelper(context);
    }


    public void RegisterUser(final UserModel user, SendDataHelper.VolleyCallback callback) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("namadpn", user.getNamaDepan());
        params.put("namablk", user.getNamaBelakang());
        params.put("email", user.getEmail());
        params.put("hp", "" + user.getHp());
        params.put("password", user.getPassword());
        sendData.SendData(params, AppConfig.URL_USER_REGISTER, 1, callback);
    }

    public void LoginUser(final UserModel user, SendDataHelper.VolleyCallback callback) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("email", user.getEmail());
        params.put("password", user.getPassword());
        sendData.SendData(params, AppConfig.URL_USER_LOGIN, 1, callback);
    }
}
