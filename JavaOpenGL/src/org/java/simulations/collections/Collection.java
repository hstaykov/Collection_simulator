/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java.simulations.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.media.opengl.GL;

/**
 *
 * @author flyingbear
 */
public abstract class Collection implements CollectionActions {


    protected List<Element> elements;
    protected List<Color> colors;
    protected float x;
    protected float y;
    protected float z;
    private Random generator;
    protected boolean locked;
    protected static final int MAX_SIZE = 13;

    public List<Element> getElements() {
        return elements;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public static int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public Collection(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.locked = false;
        this.generator = new Random();
        this.elements = new ArrayList<Element>();
        this.colors = new ArrayList<Color>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);
        colors.add(Color.PURPLE);
        colors.add(Color.CYAN);
        colors.add(Color.WHITE);
    }

    public void draw(GL gl) {
        for (int i = 0; i < elements.size(); ++i) {
            Element element = elements.get(i);
            if (!element.getStatus().equals(Utils.ElementStatus.DESTROYED)) {
                element.draw(gl);
            } else {
                elements.remove(element);
                locked = false;
            }
        }
    }

    protected Color generateRandomColor() {
        int index = generator.nextInt(colors.size());
        return colors.get(index);
    }

    @Override
    public String toString() {
        String result = "";

        for (Element element : elements) {
            if (element.getStatus() == Utils.ElementStatus.NORMAL) {
                result += element.toString() + System.getProperty("line.separator");
            }
        }

        return result;
    }
}
