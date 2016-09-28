package com.grady.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.grady.test.bean.AddrBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoliang.wgl on 2016/9/23.
 */

public class CityAdapter extends BaseAdapter {

    private Context context;





    private List<AddrBean.ProvinceBean.CityBean> mcityBeanList = new ArrayList<>();

    public  CityAdapter(Context context){
        this.context = context;
    }
    public void setMcityBeanList(List<AddrBean.ProvinceBean.CityBean> mcityBeanList) {
        this.mcityBeanList = mcityBeanList;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mcityBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mcityBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv= new TextView(context);
        tv.setText(mcityBeanList.get(position).getCityName());
        return tv;
    }
}
