package nu.rolandsson.jakob.animations;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Martin on 2018-04-09.
 */

public class BallPainter {

    private Paint paint;
    private Ball ball;
    private static final Random random = new Random();
    private Paint textPaint;

    public BallPainter(Ball ball, Paint paint) {
        this.paint = paint;
        this.ball = ball;
        this.textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(16);
    }

    public BallPainter(Ball ball) {
        this(ball, createRandomPaint());
    }

    public void paintBall(Canvas canvas) {
        canvas.drawCircle(ball.getX(), ball.getY(), ball.getRadius(), paint);
        canvas.drawText(String.valueOf(ball.getBounceCounter()),
                ball.getX(), ball.getY(), textPaint);
    }

    private static Paint createRandomPaint() {
        byte[] params = new byte[4];
        random.nextBytes(params);
        Paint paint = new Paint();
        paint.setColor(Color.argb(params[0], params[1], params[2], params[3]));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        return paint;
    }
}
