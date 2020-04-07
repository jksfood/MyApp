package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.R;

public class LightingColorFilterView extends View {

    private Paint mPaint;
    private Bitmap bitmap;
    private ColorFilter colorFilter1, colorFilter2;

    public LightingColorFilterView(Context context) {
        super(context);
        init();
    }

    public LightingColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LightingColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        colorFilter1 = new LightingColorFilter(0x00ffff,0x000000);
        colorFilter2 = new LightingColorFilter(0xffffff,0x003000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColorFilter(colorFilter1);
        canvas.drawBitmap(bitmap,0,0,mPaint);

        mPaint.setColorFilter(colorFilter2);
        canvas.drawBitmap(bitmap,bitmap.getWidth() + 100, 0, mPaint);
    }
}
