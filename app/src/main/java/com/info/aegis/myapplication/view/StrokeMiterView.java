package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;

public class StrokeMiterView extends View {

    private Paint mPaint;
    private Path mPath;

    public StrokeMiterView(Context context) {
        super(context);
        init();
    }

    public StrokeMiterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StrokeMiterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPath = new Path();

        mPath.rLineTo(200,0);
        mPath.rLineTo(-160,50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.translate(100,100);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        mPaint.setStrokeMiter(1);
        canvas.drawPath(mPath,mPaint);
    }
}
