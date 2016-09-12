package com.hadis.mylunbo.bili;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 自定义比例的viewpager
 * @author hadis on 16.9.09.
 */
public class MyScaleViewPager extends ViewPager {

    public MyScaleViewPager(Context context) {
        super(context);
    }

    public MyScaleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = 0;
        float scale = 2.1f / 1; //
        if (widthMode == MeasureSpec.EXACTLY) {
            heightSize = (int) (widthMode * scale + 0.5f);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
                    MeasureSpec.EXACTLY);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth / (measuredHeight + 0.0f) != scale) {
            measuredHeight = (int) (measuredWidth / scale + 0.5f);
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }
}
