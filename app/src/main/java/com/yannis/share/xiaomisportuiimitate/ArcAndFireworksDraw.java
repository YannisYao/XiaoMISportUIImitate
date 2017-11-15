package com.yannis.share.xiaomisportuiimitate;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.security.SecureRandom;

/**
 * Created by yanniszone on 2017/11/15.
 * 烟火，和圆弧绘制类
 */

public class ArcAndFireworksDraw {
    //圆弧的最大偏移量
    private final static float MAX_CX_TRANS = 4.0f;
    private final static float MAX_CY_TRANS = 4.0f;
    private final static float MAX_CR_TRANS = 4.0f;
    private final static float LINE_WID = 0.5f;
    private final static int ARC_COUNT = 8;
    //canvas最大旋转角度
    private final static float MAX_ROTATE_DEGREE = 30;
    //初始圆弧的x坐标
    private float deCx ;
    //初始圆弧的y坐标
    private float deCy ;
    //初始圆弧的半径
    private float deCr;

    private float linePaintWid;

    private SecureRandom random;

    private Context context;

    private ArcArgument[] arcArguments = new ArcArgument[ARC_COUNT];

    private Paint linePaint;

    public ArcAndFireworksDraw(Context context) {
        this.context = context;
        deCx = DensityUtils.dp2px(context,MAX_CX_TRANS);
        deCy = DensityUtils.dp2px(context,MAX_CY_TRANS);
        deCr = DensityUtils.dp2px(context,MAX_CR_TRANS);
        linePaintWid = DensityUtils.dp2px(context,LINE_WID);

        SecureRandom random = new SecureRandom();
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(linePaintWid);

        initArcAgruments();
    }

    private void initArcAgruments() {
        for(ArcArgument argument : arcArguments){

        }
    }

    /**
     * 绘制圆弧，和烟花
     * @param canvas
     */
    public void draw(Canvas canvas){

    }

    public class ArcArgument{
        float cx;
        float cy;
        float cr;
        float cRotate;

        public ArcArgument() {
            cx = atomticRandom() * deCx;
            cy = atomticRandom() * deCy;
            cr = atomticRandom() * deCr;
            cRotate = atomticRandom() * MAX_ROTATE_DEGREE;
        }
    }



    /**
     * 随机产生偏移量
     * @return
     */
    public float atomticRandom(){
        return random.nextBoolean()? -1 : 1 * random.nextFloat();
    }

}
