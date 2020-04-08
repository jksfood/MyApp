package com.info.aegis.myapplication.view.canvas_camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.R;

public class CanvasClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    public CanvasClipRectView(Context context) {
        super(context);
    }

    public CanvasClipRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasClipRectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - bitmap.getWidth())/2;
        int top = (getHeight() - bitmap.getHeight())/2;

        canvas.save();
        canvas.clipRect(left +bitmap.getWidth()*0.2f,top+bitmap.getHeight()*0.2f,left+bitmap.getWidth()*0.8f,top+bitmap.getHeight()*0.8f);
        canvas.drawBitmap(bitmap,left,top,paint);
        canvas.restore();
    }
}
