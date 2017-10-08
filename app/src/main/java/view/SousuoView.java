package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 白玉春 on 2017/10/5.
 */

public class SousuoView extends View{


    //画笔
    private Paint paint;


    public SousuoView(Context context) {
        super(context);
        Init(context);
    }



    public SousuoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public SousuoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }


    //初始化
    private void Init(Context context) {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(35);

    }

    @Override
    protected void onDraw(Canvas ca1nvas) {
        super.onDraw(ca1nvas);
        float  x = getX()/2;
        float  y = getY()/2;

        float width = getWidth()/2;
        float height = getHeight()/2;
        //  ca1nvas.drawPoint(width,height,paint);
        ca1nvas.drawText("努力加载中...",width,height-400,paint);
        ca1nvas.save();
        Path path = new Path();
        path.moveTo(width,height);
        path.lineTo(width,height+5);
        path.lineTo(width+2,height+5);
        path.lineTo(width+2,height);
        path.close();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        ca1nvas.drawPath(path,paint);

        ca1nvas.restore();



    }
}
