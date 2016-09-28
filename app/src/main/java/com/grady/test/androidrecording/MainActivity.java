package com.grady.test.androidrecording;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


import com.google.gson.GsonBuilder;
import com.grady.test.adapter.CityAdapter;
import com.grady.test.adapter.ProvinceAdapter;
import com.grady.test.bean.AddrBean;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    private Spinner mProvince,mCity;
    private AddrBean addrBean;
    private ProvinceAdapter mProvinceAdapter;
    private CityAdapter mCityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
        register();
    }

    private void loadData() {
        try {
            InputStream is = getApplicationContext().getAssets().open("addr_china.json");
            addrBean = new GsonBuilder().create().fromJson(new InputStreamReader(is),AddrBean.class);
            mProvinceAdapter.setProvinceBeanList(addrBean.getProvinceList());
            mCityAdapter.setMcityBeanList(addrBean.getProvinceList().get(0).getCityList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        mProvinceAdapter = new ProvinceAdapter(this);
        mCityAdapter = new CityAdapter(this);
        mProvince = (Spinner) findViewById(R.id.province_list);
        mProvince.setAdapter(mProvinceAdapter);
        mCity = (Spinner) findViewById(R.id.city_list);
        mCity.setAdapter(mCityAdapter);

    }

    private void register(){
        mProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (BuildConfig.DEBUG) Log.d("MainActivity", "setOnItemSelectedListener");
                mCityAdapter.setMcityBeanList(addrBean.getProvinceList().get(position).getCityList());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
