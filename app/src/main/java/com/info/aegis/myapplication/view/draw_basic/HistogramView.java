package com.info.aegis.myapplication.view.draw_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.R;
import com.info.aegis.myapplication.model.HistogramData;

import java.util.ArrayList;
import java.util.List;

public class HistogramView extends View {

    private String name = getResources().getString(R.string.histogram);
    private List<HistogramData> mData = new ArrayList<>();
    private Paint mPaint;
    private float mStartX;
    private float mSpace;
    private float mEachWidth;
    private float mMax;
    private float mXLineLength;
    private float mYLineLength;

    public HistogramView(Context context) {
        super(context);
        init();
    }

    public HistogramView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HistogramView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mData.add(new HistogramData("apple",10.f, Color.GREEN));
        mData.add(new HistogramData("banana",12.f, Color.GREEN));
        mData.add(new HistogramData("juice",18.f, Color.GREEN));
        mData.add(new HistogramData("白菜",21.f, Color.GREEN));
        mData.add(new HistogramData("火龙果",18.f, Color.GREEN));
        mData.add(new HistogramData("酸奶",10.f, Color.GREEN));
        mData.add(new HistogramData("饮料",11.f, Color.GREEN));

        mMax = Float.MIN_VALUE;

        for (HistogramData data: mData){
            mMax = Math.max(mMax, data.getNumber());
        }

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(2);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(72);
        canvas.drawText(name,(canvas.getWidth()- mPaint.measureText(name))/2 ,canvas.getHeight() * 0.8f, mPaint);

        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.7f);

        mPaint.setColor(Color.BLUE);

        mXLineLength = canvas.getWidth()* 0.8f;
        mYLineLength = canvas.getWidth()* 0.9f;

        canvas.drawLine(0,0,0, -mYLineLength, mPaint);
        canvas.drawLine(0,0,mXLineLength, 0, mPaint);

        mEachWidth = (mXLineLength - 100) / mData.size() * 0.8f;
        mSpace = (mXLineLength - 100)  / mData.size() * 0.2f;
        mStartX = 0;
        mPaint.setTextSize(36);

        for (HistogramData data: mData){
            mPaint.setColor(data.getColor());
            canvas.drawRect(mStartX + mSpace, - (data.getNumber() / mMax  * mYLineLength * 0.9f), mStartX + mSpace + mEachWidth,0,mPaint);
            canvas.drawText(data.getName(), mStartX + mSpace + (mEachWidth - mPaint.measureText(data.getName()))/2, 40, mPaint );
            mStartX += mSpace + mEachWidth;
        }
    }
}
