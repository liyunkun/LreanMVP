package com.liyunkun.week8_3mvp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liyunkun.week8_3mvp.R;
import com.liyunkun.week8_3mvp.module.bean.FoodBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by liyunkun on 2016/10/12 0012.
 */
public class MyAdapter extends BaseAdapter{
    private List<FoodBean> list;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<FoodBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.listview_item_layout,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        FoodBean food = list.get(position);
        holder.keywords.setText(food.getKeywords());
        holder.des.setText(food.getDescription());
        Picasso.with(context).load(food.getImg()).into(holder.img);
        return convertView;
    }
    private class ViewHolder{
        TextView keywords;
        TextView des;
        ImageView img;

        public ViewHolder(View itemView) {
            keywords= (TextView) itemView.findViewById(R.id.tv_keysword);
            des= (TextView) itemView.findViewById(R.id.tv_des);
            img= (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
