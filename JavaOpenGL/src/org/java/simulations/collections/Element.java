/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java.simulations.collections;

/**
 *
 * @author flyingbear
 */
public abstract class Element implements ElementActions {

    protected float x;
    protected float y;
    protected float z;
    protected String value;
    protected Color color;
    protected float angle;
    protected float speed;
    protected float acceleration;
    protected Utils.ElementStatus status;
    protected static final float DEFAULT_ACCELERATION = 0.001f;
    protected static final float ANGLE_LIMIT = 550.0f;
    protected static final float OFFSET = 2.0f;
    protected static final float CUBE_SIZE = 2 * OFFSET;
    protected static final float SPHERE_RADIUS = OFFSET;

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public Color getColor() {
        return color;
    }

    public float getAngle() {
        return angle;
    }

    public float getSpeed() {
        return speed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public Utils.ElementStatus getStatus() {
        return status;
    }

    public void setStatus(Utils.ElementStatus status) {
        this.status = status;
    }

    public Element(float x, float y, float z, Color color, String value) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
        this.value = value;
        this.angle = 0.0f;
        this.speed = 0.0f;
        this.status = Utils.ElementStatus.NORMAL;
        this.acceleration = DEFAULT_ACCELERATION;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
