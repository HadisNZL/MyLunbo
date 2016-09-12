package com.hadis.mylunbo.bili;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/**
 * 自定义比例的 ImageView
 * @author hadis on 16.9.09.
 */
public class CustomScaleView extends ImageView {

    public CustomScaleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public CustomScaleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public CustomScaleView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = 0;
        float scale = 2.1f / 1; // 图片 宽、高 比
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
