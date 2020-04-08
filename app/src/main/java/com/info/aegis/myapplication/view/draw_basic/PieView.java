package com.info.aegis.myapplication.view.draw_basic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.info.aegis.myapplication.model.PieData;

import java.util.ArrayList;
import java.util.List;

public class PieView extends View {

    private float mRadius;
    private Paint mPaint;
    private RectF mRect;
    private float mTotal;
    private float mMax;
    private List<PieData> pieData = new ArrayList<>();
    private float mStartAngle;
    private float mSweepAngle;
    private float mLineAngle;
    private float mLineStartX;
    private float mLineStartY;
    private float mLineEndX;
    private float mLineEndY;

    public PieView(Context context) {
        super(context);
        init();
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRadius = 300;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(30);
        mPaint.setStrokeWidth(2);

        pieData.add(new PieData("A",10.f, Color.BLUE));
        pieData.add(new PieData("B",12.f, Color.GREEN));
        pieData.add(new PieData("C",30.f, Color.YELLOW));
        pieData.add(new PieData("d",46.f, Color.BLUE));
        pieData.add(new PieData("e",26.f, Color.BLACK));
        pieData.add(new PieData("f",41.f, Color.RED));
        pieData.add(new PieData("g",42.f, Color.GRAY));

        mTotal = 0.0f;

        for (int i = 0; i < pieData.size(); i++) {
            mTotal += pieData.get(i).getNumber();
            mMax = Math.max(mMax, pieData.get(i).getNumber());
        }

        mRect = new RectF(-300,-300,300,300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(canvas.getWidth()/2, canvas.getHeight()/2);

        mStartAngle = 0.0f;

        for (PieData data: pieData){
            mPaint.setColor(data.getColor());
            mPaint.setStyle(Paint.Style.FILL);
            mSweepAngle = data.getNumber() / mTotal * 360f;
            mLineAngle = mStartAngle + mSweepAngle /2;
            mLineStartX = (float) (mRadius * Math.cos(mLineAngle / 180 * Math.PI));
            mLineStartY = (float) (mRadius * Math.sin(mLineAngle / 180 * Math.PI));
            mLineEndX = (float) ((mRadius + 50) * Math.cos(mLineAngle / 180 * Math.PI));
            mLineEndY = (float) ((mRadius + 50) * Math.sin(mLineAngle / 180 * Math.PI));

            if (data.getNumber() == mMax){
                canvas.save();
                canvas.translate(mLineStartX * 0.05f, mLineStartY * 0.05f);
                canvas.drawArc(mRect, mStartAngle, mSweepAngle, true,mPaint);
            }else {
                canvas.drawArc(mRect, mStartAngle, mSweepAngle - 1.0f, true,mPaint);
            }

            mPaint.setColor(Color.GRAY);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawLine(mLineStartX,mLineStartY, mLineEndX, mLineEndY, mPaint);
            if (mLineAngle > 90 && mLineAngle <= 270){
                canvas.drawLine(mLineEndX,mLineEndY, mLineEndX - 50, mLineEndY, mPaint);
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(data.getName(),mLineEndX - 50 -10 -mPaint.measureText(data.getName()),mLineEndY, mPaint);
            }else {
                canvas.drawLine(mLineEndX,mLineEndY, mLineEndX + 50 , mLineEndY, mPaint);
                mPaint.setStyle(Paint.Style.FILL);
                canvas.drawText(data.getName(),mLineEndX + 50 + 10 + mPaint.measureText(data.getName()), mLineEndY,mPaint);
            }

            if (data.getNumber() == mMax){
                canvas.restore();
            }

            mStartAngle += mSweepAngle;
        }
    }
}
