package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.R;

public class ColorMatrixColorFilterView extends View {

    private Paint mPaint;

    public ColorMatrixColorFilterView(Context context) {
        super(context);
        init();
    }

    public ColorMatrixColorFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorMatrixColorFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(-20);
        ColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        mPaint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap,0,0,mPaint);
    }
}
