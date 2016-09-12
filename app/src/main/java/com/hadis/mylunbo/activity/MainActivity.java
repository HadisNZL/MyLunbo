package com.hadis.mylunbo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hadis.mylunbo.R;
import com.hadis.mylunbo.adapter.PicAdapter;
import com.hadis.mylunbo.carrousel.CircleIndicator;
import com.hadis.mylunbo.carrousel.LoopViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Map<String, Object>> list = new ArrayList<>();
    private int[] icon = {R.mipmap.aa, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e};
    private String[] iconName = {"禁地之王", "老九门，再探古墓", "红色通道，刘烨归来", "神犬小七第二季", "灭罪师"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    public List<Map<String, Object>> initData() {
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            list.add(map);
        }
        return list;
    }


    private void initView() {
        setContentView(R.layout.activity_main);
        LoopViewPager viewpager = (LoopViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        viewpager.setAdapter(new PicAdapter(getApplicationContext(), list));
        viewpager.setLooperPic(true);//自动轮播
        indicator.setViewPager(viewpager);
    }
}
