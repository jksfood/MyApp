package com.info.aegis.myapplication.view.paint_usage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ShadowLayerView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public ShadowLayerView(Context context) {
        super(context);
    }

    public ShadowLayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowLayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(72);
        paint.setColor(Color.BLACK);
        paint.setShadowLayer(10,0,0,Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Hello Jksfood",80,300,paint);
    }
}
