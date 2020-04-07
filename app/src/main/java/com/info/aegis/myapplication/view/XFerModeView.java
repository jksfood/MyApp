package com.info.aegis.myapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.R;

public class XFerModeView extends View {

    private Paint mPaint;
    private Bitmap bitmap1, bitmap2;
    private Xfermode xfermode1,xfermode2,xfermode3;

    public XFerModeView(Context context) {
        super(context);
        init();
    }

    public XFerModeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XFerModeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
        xfermode1 = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        xfermode2 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        xfermode3 = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int saved = canvas.saveLayer(null,null,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(bitmap1,0,0,mPaint);
        mPaint.setXfermode(xfermode1);
        canvas.drawBitmap(bitmap2,0,0,mPaint);
        mPaint.setXfermode(null);

        canvas.drawBitmap(bitmap1,bitmap1.getWidth() + 100,0,mPaint);
        mPaint.setXfermode(xfermode2);
        canvas.drawBitmap(bitmap2,bitmap1.getWidth() + 100,0,mPaint);
        mPaint.setXfermode(null);

        canvas.drawBitmap(bitmap1,0,bitmap1.getHeight()+ 20,mPaint);
        mPaint.setXfermode(xfermode3);
        canvas.drawBitmap(bitmap2,0,bitmap1.getHeight()+ 20,mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(saved);
    }
}
