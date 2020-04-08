package com.info.aegis.myapplication.view.canvas_order;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class TagImageView extends ImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public TagImageView(Context context) {
        super(context);
    }

    public TagImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TagImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

        canvas.drawRect(0,50,160,145,paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(72);
        canvas.drawText("New",0,124,paint);
    }
}
