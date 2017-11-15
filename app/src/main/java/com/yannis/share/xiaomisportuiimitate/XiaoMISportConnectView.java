package com.yannis.share.xiaomisportuiimitate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yannis on 2017/11/11.
 * 小米运动，首页，手环连接UI仿写
 */

public class XiaoMISportConnectView extends View {
    private final static int CIRCLE_WID = 2;
    private final static int CIRCLE_MARGIN_LEFT = 250;
    private final static int CIRCLE_COUNT = 8;
    //扫描渐变圆环画笔
    private Paint circlePaint;
    //背景图
    private Bitmap backgroudBitmap;

    private int[][] circlesMatrix = {{-15,10},{-10,10},{-5,10},{0,10},{0,-10},{5,-10},{10,-10},{15,-10}};

    public XiaoMISportConnectView(Context context) {
        super(context);
        init(context, null);
    }

    public XiaoMISportConnectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public XiaoMISportConnectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        backgroudBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.bg_step_law);
        initPaint(context);
    }

    private void initPaint(Context context) {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);//抗锯齿打开
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(CIRCLE_WID);
        circlePaint.setColor(ContextCompat.getColor(context,R.color.white));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawSweepGradientCircle(canvas);
    }

    private void drawBackground(Canvas canvas) {
        float scaleX = (float)getWidth()/backgroudBitmap.getWidth();
        float scaleY = (float)getHeight() /backgroudBitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(scaleX,scaleY);
        Bitmap bitmap = Bitmap.createBitmap(backgroudBitmap,0,0,backgroudBitmap.getWidth(),backgroudBitmap.getHeight(),matrix,true);
        canvas.drawBitmap(bitmap,0,0,null);
    }

    /**
     * 画扫描渐变圆
     * @param canvas
     */
    private void drawSweepGradientCircle(Canvas canvas) {
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        int tempRaduis = getWidth()/2 - CIRCLE_MARGIN_LEFT;
        for(int i = 0 ; i < CIRCLE_COUNT ; i ++){
            canvas.drawCircle(centerX+circlesMatrix[i][0],centerY+circlesMatrix[i][0],tempRaduis+circlesMatrix[i][1],circlePaint);
        }
    }
}
