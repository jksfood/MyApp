package com.info.aegis.myapplication.view.canvas_order;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;


public class AppImageView extends ImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public AppImageView(Context context) {
        super(context);
    }

    public AppImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        paint.setColor(Color.YELLOW);
        paint.setTextSize(72);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String value = getWidth()+"x"+getHeight();
        canvas.drawText(value,10,paint.measureText(value) + 100,paint);
    }
}
