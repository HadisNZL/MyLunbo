package com.hadis.mylunbo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hadis.mylunbo.R;
import com.hadis.mylunbo.bili.CustomScaleView;

import java.util.List;
import java.util.Map;

public class PicAdapter extends PagerAdapter {
    private List<Map<String, Object>> list;
    private Context context;

    public PicAdapter(Context context, List<Map<String, Object>> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_page_item, container, false);
        CustomScaleView imageView = (CustomScaleView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.image_desc);
        textView.setText((String) list.get(position).get("text"));
        imageView.setImageResource((Integer) list.get(position).get("image"));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, (String) list.get(position).get("text"), Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;
    }

}
