package com.info.aegis.myapplication.view.clip_matrix;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.info.aegis.myapplication.R;

public class CameraRoateHittingFaceView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point = new Point(200, 50);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    int degree22222;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree22222", 0, 360);

    public CameraRoateHittingFaceView(Context context) {
        super(context);
    }

    public CameraRoateHittingFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraRoateHittingFaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * 2, bitmap.getHeight() * 2, true);
        bitmap.recycle();
        bitmap = scaledBitmap;

        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float newZ = - displayMetrics.density * 6;
        camera.setLocation(0, 0, newZ);
    }

    @SuppressWarnings("unused")
    public void setDegree22222(int degree) {
        Log.d("123",degree+"");
        this.degree22222 = degree;
        invalidate();
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("123","onAttachedToWindow");
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("123","onDetachedFromWindow");
        animator.end();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("123","onDraw");
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = point.x + bitmapWidth / 2;
        int centerY = point.y + bitmapHeight / 2;

        camera.save();
        matrix.reset();
        camera.rotateX(degree22222);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point.x, point.y, paint);
        canvas.restore();
    }
}
