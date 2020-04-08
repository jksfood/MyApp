package com.info.aegis.myapplication.view.paint_usage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class LinearGradientView extends View {

    private Paint mPaint;

    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(AUTOFILL_TYPE_NONE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = width*10/16;

        mPaint.setTextSize(72);
        canvas.drawText("CLAMP",
                0, -mPaint.ascent() + mPaint.descent(), mPaint);


        Shader shader = new LinearGradient(0,0,canvas.getWidth()/2,canvas.getHeight()/2, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawRect(0,100,width,height,mPaint);

        canvas.drawText("MIRROR",
                0, -mPaint.ascent() + mPaint.descent()+height + 100, mPaint);
        Shader shader2 = new LinearGradient(0,-mPaint.ascent() + mPaint.descent()+height + 100,canvas.getWidth()/8,canvas.getHeight()/8 + -mPaint.ascent() + mPaint.descent()+height + 100, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
        mPaint.setShader(shader2);
        canvas.drawRect(0,-mPaint.ascent() + mPaint.descent()+height + 100,width,-mPaint.ascent() + mPaint.descent()+height + 100 + height,mPaint);

        canvas.drawText("REPEAT",
                0, (-mPaint.ascent() + mPaint.descent())*2+height*2 + 200, mPaint);
        Shader shader3 = new LinearGradient(0,(-mPaint.ascent() + mPaint.descent())*2+height*2 + 200,canvas.getWidth()/8,canvas.getHeight()/8 + (-mPaint.ascent() + mPaint.descent())*2+height*2 + 100, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        mPaint.setShader(shader3);
        canvas.drawRect(0,(-mPaint.ascent() + mPaint.descent())*2+height*2 + 200,width,(-mPaint.ascent() + mPaint.descent())*2+height*2 + 100 + height,mPaint);




    }
}
