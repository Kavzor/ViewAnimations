package nu.rolandsson.jakob.animations;

/**
 * Created by Martin on 2018-04-09.
 */

public class Ball {
    private float x, y, radius;
    private int bounceCounter;

    public Ball(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.bounceCounter = 0;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void incrementBounceCounter() {
        bounceCounter++;
    }
    public int getBounceCounter() {
        return bounceCounter;
    }
}
