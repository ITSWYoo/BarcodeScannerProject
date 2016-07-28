package com.example.yoo.barcodescannerproject.common;

/**
 * Created by Yoo on 2016-07-01.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.ArrayList;

public class DrawImageView extends ImageView {
    Paint mPaint;
    public ArrayList<Vertex> arVertex;

    public DrawImageView(Context context) {
        super(context);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);//색깔은 검정색
        mPaint.setStrokeWidth(3);//두께는 3
        mPaint.setAntiAlias(true);//선을 부드럽게 함
        arVertex = new ArrayList<>();
    }

    public DrawImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);//색깔은 검정색
        mPaint.setStrokeWidth(3);//두께는 3
        mPaint.setAntiAlias(true);//선을 부드럽게 함
        arVertex = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);//배경색을 회색으로 지정함
        if(arVertex !=null) {
            //그리는 부분
            for (int i = 0; i < arVertex.size(); i++) {
                if (arVertex.get(i).Draw) {//Draw가 true면 즉 계속 연결해서 그리는것이면
                    //false면 사용자가 다른곳으로 이동해서 그리는것
                    //canvas.drawLine(startX, startY, stopX, stopY, paint)
                    //즉 이전 좌표에서 다음좌표까지 그린다
                    canvas.drawLine(arVertex.get(i - 1).x, arVertex.get(i - 1).y,
                            arVertex.get(i).x, arVertex.get(i).y, mPaint);
                }
            }
        }
    }
    public class Vertex{
        float x;
        float y;
        boolean Draw;

        Vertex(float ax, float ay, boolean ad){
            x = ax;
            y = ay;
            Draw = ad;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){//사용자가 터치를 하면
            arVertex.add(new Vertex(event.getX(), event.getY(), false));//Draw는 false
            return true;
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE){//사용자가 터치를 한 상태에서 움직이면
            arVertex.add(new Vertex(event.getX(), event.getY(), true));//Draw는 true
            invalidate();//이 메소드가 간접적으로 onDraw메소드를 호출함
            return true;
        }

        return false;
    }
}

