package com.beliautopart.beliautopart.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.android.volley.VolleyError;
import com.beliautopart.beliautopart.R;
import com.beliautopart.beliautopart.adapter.DividerItemDecoration;
import com.beliautopart.beliautopart.adapter.ItemListAdapter;
import com.beliautopart.beliautopart.helper.SendDataHelper;
import com.beliautopart.beliautopart.model.ItemProduk;
import com.beliautopart.beliautopart.model.SearchOptionModel;
import com.beliautopart.beliautopart.webservices.PartsService;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CircularProgressView progressView;
    private PartsService partsService;
    private RelativeLayout loadingView;
    private List<ItemProduk> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemListAdapter mAdapter;
    private String kat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                kat = "1";
            } else {
                kat = extras.getString("kat");
            }
        } else {
            kat = (String) savedInstanceState.getSerializable("page");
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        loadingView = (RelativeLayout) findViewById(R.id.loadingLayout);
        progressView = (CircularProgressView) findViewById(R.id.progress_view);
        progressView.startAnimation();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new ItemListAdapter(itemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        onSearch();


    }

    private void onSearch() {
        partsService = new PartsService(this);
        SearchOptionModel searchOption = new SearchOptionModel();
        searchOption.setKat(Integer.parseInt(kat));
        partsService.SearchParts(searchOption, new SendDataHelper.VolleyCallback() {
            @Override
            public String onSuccess(String result) {
                JSONObject resultData = null;
                try {
                    resultData = new JSONObject(result);
                    boolean error = resultData.getBoolean("error");
                    if (!error) {
                        JSONArray dataArray = resultData.getJSONArray("content");
                        int sizeDataArray = dataArray.length();
                        for (int a = 0; a < sizeDataArray; a++) {
                            JSONObject dataItem = dataArray.getJSONObject(a);
                            int idItem = dataItem.getInt("id_item");
                            String namaItem = dataItem.getString("nama_item");
                            int sts = dataItem.getInt("id_item");
                            double harga = dataItem.getDouble("harga");
                            String kompatibel = dataItem.getString("kompatibel");
                            String kode = dataItem.getString("kode");
                            String foto = dataItem.getString("foto");
                            ItemProduk itemProduk = new ItemProduk(idItem, namaItem, sts, harga, kompatibel, kode, foto);
                            itemList.add(itemProduk);
                        }


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mAdapter.notifyDataSetChanged();
                loadingView.setVisibility(View.GONE);
                return result;
            }

            @Override
            public String onError(VolleyError error) {
                progressView.stopAnimation();
                return null;
            }
        });
    }
}
