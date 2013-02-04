/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java.simulations.collections;

import com.sun.opengl.util.GLUT;

import javax.lang.model.util.Elements;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author flyingbear
 */
public class QueueElement extends Element {

    public QueueElement(float x, float y, float z, Color color, String value) {
        super(x, y, z, color, value);
    }

    private void drawSphere(GL gl) {
        GLUT glut = new GLUT();
     
        gl.glColor3f(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue());
        glut.glutWireSphere(Element.SPHERE_RADIUS, 15, 6);
        gl.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        glut.glutSolidSphere(Element.SPHERE_RADIUS, 10, 6);
    }

    public void draw(GL gl) {
        if (!status.equals(Utils.ElementStatus.DESTROYED)) {
            gl.glTranslatef(x, y, z);
            if (status.equals(Utils.ElementStatus.MARKED_FOR_DESTRUCTION)) {
            	drawSphereDestruction(gl);	 
            } else {
                drawSphere(gl);
            }
            gl.glTranslatef(-x, -y , -z);
        }
    }

    private void drawSphereDestruction(GL gl) {
        speed += getAcceleration();
        angle += getSpeed();
        gl.glPushMatrix();
        gl.glRotatef(getAngle(), 0.0f, 1.0f, 0.0f);
        drawSphere(gl);
        if (getAngle() > ANGLE_LIMIT) {
            status = Utils.ElementStatus.DESTROYED;
        }
        gl.glPopMatrix();
    }
}
