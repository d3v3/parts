package com.beliautopart.beliautopart.webservices;

import android.content.Context;

import com.beliautopart.beliautopart.app.AppConfig;
import com.beliautopart.beliautopart.helper.SendDataHelper;
import com.beliautopart.beliautopart.model.SearchOptionModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brandon on 12/05/16.
 */
public class PartsService {
    private final Context context;
    private SendDataHelper sendData;
    private String response;

    public PartsService(Context context) {
        this.context = context;
        sendData = new SendDataHelper(context);
    }


    public void SearchParts(final SearchOptionModel option, SendDataHelper.VolleyCallback callback) {
        Map<String, String> params = new HashMap<String, String>();
        if (!option.getKeyword().equals("")) {
            params.put("keyword", option.getKeyword());
        } else if (option.getKat() != null) {
            params.put("kat", "" + option.getKat());
        } else if (option.getJenis() != null) {
            params.put("jenis", "" + option.getJenis());
        } else if (option.getMerk() != null) {
            params.put("merk", "" + option.getMerk());
        } else if (option.getTipe() != null) {
            params.put("tipe", "" + option.getTipe());
        } else if (option.getKatItem() != null) {
            params.put("kat_item", "" + option.getKatItem());
        }
        sendData.SendData(params, AppConfig.URL_PARTS_GET, 0, callback);
    }
}
