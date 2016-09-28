package com.grady.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.grady.test.bean.AddrBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoliang.wgl on 2016/9/23.
 */

public class ProvinceAdapter extends BaseAdapter {
    private Context mContext;
    private List<AddrBean.ProvinceBean> provinceBeanList = new ArrayList<>();
    public ProvinceAdapter (Context context){
        mContext = context;
    }

    public void setProvinceBeanList(List<AddrBean.ProvinceBean> provinceBeanList) {
        this.provinceBeanList = provinceBeanList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return provinceBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return provinceBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(mContext);
        tv.setText(provinceBeanList.get(position).getProvince());
        return tv;
    }
}
