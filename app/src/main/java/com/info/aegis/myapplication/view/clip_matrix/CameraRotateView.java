package com.info.aegis.myapplication.view.clip_matrix;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.R;

public class CameraRotateView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    public CameraRotateView(Context context) {
        super(context);
    }

    public CameraRotateView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraRotateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int center1X = point1.x + bitmapWidth / 2;
        int center1Y = point1.y + bitmapHeight / 2;
        int center2X = point2.x + bitmapWidth / 2;
        int center2Y = point2.y + bitmapHeight / 2;

        camera.save();
        matrix.reset();
        camera.rotateX(60);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-center1X,-center1Y);
        matrix.postTranslate(center1X,center1Y);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap,point1.x,point1.y,paint);
        canvas.restore();

        camera.save();
        matrix.reset();
        camera.rotateY(30);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-center2X,-center2Y);
        matrix.postTranslate(center2X,center2Y);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
