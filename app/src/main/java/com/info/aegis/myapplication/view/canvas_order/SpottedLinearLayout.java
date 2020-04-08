package com.info.aegis.myapplication.view.canvas_order;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class SpottedLinearLayout extends LinearLayout {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public SpottedLinearLayout(Context context) {
        super(context);
    }

    public SpottedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpottedLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        paint.setColor(Color.parseColor("#AAF948F7"));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);

        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()*0.2f,paint);
    }
}
