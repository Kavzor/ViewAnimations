package nu.rolandsson.jakob.animations;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Martin on 2018-04-09.
 */

public class AnimationView extends View {
    private ArrayList<BallPainter> ballPainters = new ArrayList<>();
    private ArrayList<BallMover> ballMovers = new ArrayList<>();
    private static final Random random = new Random();
    private int count = 0;
    private Handler ballHandler = new Handler();

    public AnimationView(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.setOnTouchListener((v, event) -> {
            count++;
            if(count < 10) {
                createAndInsertBall(event.getX(), event.getY());
            }
            invalidate();
            return true;
        });
    }

    private void createAndInsertBall(float x, float y) {
        float dir = (float) (random.nextFloat() * 2.0 * Math.PI);
        float speed = (float) (1.0 + random.nextFloat() * 20.0);
        float size = (float) (5.0 + random.nextFloat() * 20.0);
        Ball ball = new Ball(x, y, size);
        BallPainter painter = new BallPainter(ball);
        BallMover ballMover = new BallMover(ball, dir, speed);

        ballMovers.add(ballMover);
        ballPainters.add(painter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(BallPainter ballPainter : ballPainters) {
            ballPainter.paintBall(canvas);
        }
        for(BallMover ballMover : ballMovers) {
            ballMover.moveBallWithin(0, 0, getWidth(), getHeight());
        }
        ballHandler.postDelayed(this::invalidate, 20L);
    }
}
