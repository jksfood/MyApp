package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class StrokeJoinView extends View {
    private Paint mPaint;
    private Path mPath;
    public StrokeJoinView(Context context) {
        super(context);
        init();
    }

    public StrokeJoinView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StrokeJoinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(50);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath = new Path();

        mPath.rLineTo(200,0);
        mPath.rLineTo(-160,120);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.translate(100,100);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(mPath,mPaint);

        canvas.translate(350, 0);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(mPath, mPaint);
    }
}
