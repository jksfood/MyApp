package com.info.aegis.myapplication.view.text_paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Sample07SetUnderlineTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello Jksfood";

    public Sample07SetUnderlineTextView(Context context) {
        super(context);
    }

    public Sample07SetUnderlineTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample07SetUnderlineTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(60);

        paint.setUnderlineText(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text, 50, 100, paint);
    }
}
