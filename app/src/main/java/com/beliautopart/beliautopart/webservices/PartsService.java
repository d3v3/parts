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
        params.put("keyword", option.getKeyword());
        params.put("kat", "" + option.getKat());
        params.put("jenis", "" + option.getJenis());
        params.put("merk", "" + option.getMerk());
        params.put("tipe", "" + option.getTipe());
        params.put("kat_item", "" + option.getKatItem());
        sendData.SendData(params, AppConfig.URL_PARTS_GET, 1, callback);
    }
}
