package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class HeartView extends View {

    private Paint mPaint;
    private Path mPath;
    private float mRadius;

    public HeartView(Context context) {
        super(context);
        init();
    }

    public HeartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HeartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPath = new Path();
        mPaint  = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);

        mRadius = 500;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPath.addArc(canvas.getWidth()/2 - mRadius, canvas.getHeight()/2 - mRadius, canvas.getWidth()/2,canvas.getHeight()/2, -225,225);
            mPath.arcTo(canvas.getWidth()/2 , canvas.getHeight()/2 - mRadius, canvas.getWidth()/2 + mRadius,canvas.getHeight()/2, -180,225,false);
            mPath.lineTo(canvas.getWidth()/2, canvas.getHeight()/2 +  (float) (mRadius/2 * (Math.sqrt(2) + 1)) - 50 );
            canvas.drawPath(mPath,mPaint);
        }
    }
}
