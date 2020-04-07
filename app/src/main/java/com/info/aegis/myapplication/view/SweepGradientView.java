package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

public class SweepGradientView extends View {

    private Paint mPaint;

    public SweepGradientView(Context context) {
        super(context);
        init();
    }

    public SweepGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SweepGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Shader shader = new SweepGradient(canvas.getWidth()/2,canvas.getHeight()/2, Color.parseColor("#E91E63"),Color.parseColor("#2196F3"));
        mPaint.setShader(shader);
        canvas.drawCircle(canvas.getWidth()/2,canvas.getHeight()/2,canvas.getWidth()/2*0.8f,mPaint);
    }
}
