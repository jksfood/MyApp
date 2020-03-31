package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class FiveStarView extends View {

    private float mOutRadius;
    private float mInRadius;
    private Paint mPaint;
    private Path mPath;

    public FiveStarView(Context context) {
        super(context);
        init();
    }

    public FiveStarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FiveStarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mOutRadius = 500f;
        mInRadius = 200f;

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < 5; i++) {
            float outX = 0f,outY = 0f,inX = 0f,inY = 0f;
            float valueOut = (float) ((18 + i*72) / 180f * Math.PI);
            float valueIn = (float) ((54 + i*72) / 180f * Math.PI);

            if (valueOut >0 && valueOut <= 90){
                outX = (float)(Math.cos(valueOut) * mOutRadius + canvas.getWidth()/2);
                outY = (float)(-Math.sin(valueOut) * mOutRadius + canvas.getHeight()/2);
            }else if (valueOut >90 && valueOut <= 180){
                outX = (float)(-Math.cos(valueOut)*mOutRadius + canvas.getWidth()/2);
                outY = (float)(-Math.sin(valueOut)*mOutRadius + canvas.getHeight()/2);
            }else if (valueOut >180 && valueOut <= 270){
                outX = (float)(-Math.cos(valueOut)*mOutRadius + canvas.getWidth()/2);
                outY = (float)(Math.sin(valueOut)*mOutRadius + canvas.getHeight()/2);
            }else if (valueOut >270 && valueOut <= 360){
                outX = (float)(Math.cos(valueOut)*mOutRadius + canvas.getWidth()/2);
                outY = (float)(Math.sin(valueOut)*mOutRadius + canvas.getHeight()/2);
            }
            if (valueIn >0 && valueIn <= 90){
                inX = (float)(Math.cos(valueIn) * mInRadius + canvas.getWidth()/2);
                inY = (float)(-Math.sin(valueIn) * mInRadius + canvas.getHeight()/2);
            }else if (valueIn >90 && valueIn <= 180){
                inX = (float)(-Math.cos(valueIn)*mInRadius + canvas.getWidth()/2);
                inY = (float)(-Math.sin(valueIn)*mInRadius + canvas.getHeight()/2);
            }else if (valueIn >180 && valueIn <= 270){
                inX = (float)(-Math.cos(valueIn)*mInRadius + canvas.getWidth()/2);
                inY = (float)(Math.sin(valueIn)*mInRadius + canvas.getHeight()/2);
            }else if (valueIn >270 && valueIn <= 360){
                inX = (float)(Math.cos(valueIn)*mInRadius + canvas.getWidth()/2);
                inY = (float)(Math.sin(valueIn)*mInRadius + canvas.getHeight()/2);
            }
            Log.d("FiveStar","outX: " + outX + " ,outY: " + outY + ", inX: " + inX + ", inY : " + inY);
            if (i == 0)
                mPath.moveTo(outX,outY);
            mPath.lineTo(outX,outY);
            mPath.lineTo(inX,inY);
        }
        mPath.close();
        canvas.drawPath(mPath,mPaint);
        String url = "https://www.jianshu.com/p/bb27489385bd";
        mPaint.setTextSize(48);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(url,(canvas.getWidth() - mPaint.measureText(url)) / 2, canvas.getHeight()*0.8f, mPaint);
    }
}
