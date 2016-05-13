package com.beliautopart.beliautopart.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.beliautopart.beliautopart.app.AppController;

import java.util.Map;

/**
 * Created by brandon on 12/05/16.
 */
public class SendDataHelper {
    private Context context;
    private ProgressDialog pDialog;

    public SendDataHelper(Context context) {
        this.context = context;
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Loading");
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    public void SendData(final Map<String, String> params, String url, int dialog, final VolleyCallback callback) {
        if (dialog == 1) {
            showDialog();
            Log.d("loading = ", String.valueOf(pDialog.isShowing()));
        }

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                hideDialog();
                Log.d("register response", response);
                callback.onSuccess(response);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                if (error instanceof TimeoutError) {
                    Log.e("Volley ", "Login Error: " + "Waktu Habis");
                    Toast.makeText(context,
                            "Waktu Habis", Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    Log.e("Volley ", "AuthFailureError " + error);
                    Toast.makeText(context,
                            "AuthFailureError", Toast.LENGTH_LONG).show();
                } else if (error instanceof ServerError) {
                    Log.e("Volley ", "AuthFailureError " + error);
                    Toast.makeText(context,
                            "AuthFailureError", Toast.LENGTH_LONG).show();
                } else if (error instanceof NetworkError) {
                    Log.e("Volley ", "NetworkError " + error);
                    Toast.makeText(context,
                            "AuthFailureError", Toast.LENGTH_LONG).show();
                } else if (error instanceof ParseError) {
                    Log.e("Volley ", "ParseError " + error);
                    Toast.makeText(context,
                            "AuthFailureError", Toast.LENGTH_LONG).show();
                } else if (error instanceof NoConnectionError) {
                    Log.e("Volley ", "ParseError " + error);
                    Toast.makeText(context,
                            "AuthFailureError", Toast.LENGTH_LONG).show();
                }
                callback.onError(error);
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Log.e("params :", params.toString());
                return params;
            }

        };
        strReq.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, url);
    }


    public interface VolleyCallback {
        String onSuccess(String result);

        String onError(VolleyError result);
    }

    private void showDialog() {
        if (pDialog != null && !pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog != null && pDialog.isShowing())
            pDialog.dismiss();
    }
}
