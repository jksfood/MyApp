package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class StrokeCapView extends View {

    private Paint mPaint;

    public StrokeCapView(Context context) {
        super(context);
        init();
    }

    public StrokeCapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StrokeCapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(50);
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(50,50,300,50,mPaint);

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50,120,300,120,mPaint);

        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50,220,300,220,mPaint);
    }
}
