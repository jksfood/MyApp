package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class RadiationGradientView extends View {

    private Paint mPaint;

    public RadiationGradientView(Context context) {
        super(context);
        init();
    }

    public RadiationGradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadiationGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(72);

        canvas.drawText("CLAMP",0,-mPaint.ascent() + mPaint.descent(),mPaint);
        Shader shader = new RadialGradient(canvas.getWidth()/2, canvas.getWidth()*10/16/2 + -mPaint.ascent() + mPaint.descent(), 200,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawRect(0,-mPaint.ascent() + mPaint.descent(),canvas.getWidth(),-mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16,mPaint);

        canvas.drawText("MIRROR",0,canvas.getWidth()*10/16 + 200,mPaint);
        Shader shader2 = new RadialGradient(canvas.getWidth()/2, 100 -mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16 + canvas.getWidth()*10/16/2 + -mPaint.ascent() + mPaint.descent(), 200,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
        mPaint.setShader(shader2);
        canvas.drawRect(0,50-mPaint.ascent() + mPaint.descent() + -mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16,canvas.getWidth(),-mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16  -mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16,mPaint);

        canvas.drawText("REPEAT",0,150-mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16  -mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16,mPaint);
        Shader shader3 = new RadialGradient(canvas.getWidth()/2, 150-mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16  -mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16 + canvas.getWidth()*10/16/2, 200,
                Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        mPaint.setShader(shader3);
        canvas.drawRect(0,170-mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16  -mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16,canvas.getWidth(),150-mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16  -mPaint.ascent() + mPaint.descent()+ canvas.getWidth()*10/16+ canvas.getWidth()*10/16,mPaint);
    }
}
