package com.info.aegis.myapplication.view.paint_usage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.R;

public class ComposeShaderView extends View {

    private Paint mPaint;

    public ComposeShaderView(Context context) {
        super(context);
    }

    public ComposeShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ComposeShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.batman);
        Shader shader1 = new BitmapShader(bitmap1,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.batman_logo);
        Shader shader2 = new BitmapShader(bitmap2,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);

        Shader shader = new ComposeShader(shader1,shader2, PorterDuff.Mode.DST_IN);
        mPaint.setShader(shader);

        canvas.drawCircle(200,200,200,mPaint);
    }
}
