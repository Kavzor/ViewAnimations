package nu.rolandsson.jakob.animations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Martin on 2018-04-08.
 */

public class InteractionView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float x, y;
    private boolean touched = false;

    public InteractionView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.setOnTouchListener((v, event) -> {
            x = event.getX();
            y = event.getY();
            touched = true;
            invalidate();
            return true;
        });
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(touched) {
            float radius = 50;
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(x, y, radius, paint);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(x, y, 2 * radius, paint);
        }
    }
}
