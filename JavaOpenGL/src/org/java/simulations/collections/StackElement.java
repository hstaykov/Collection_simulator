/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java.simulations.collections;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;


public class StackElement extends Element {

    public StackElement(float x, float y, float z, Color color, String value) {
        super(x, y, z, color, value);
    }

    public void drawCube(GL gl) {

//        gl.glBegin(gl.GL_LINE_LOOP);
//
//        gl.glColor3f(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue());
//
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z + OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z + OFFSET);
//
//        gl.glEnd();
//
//        gl.glBegin(gl.GL_QUADS);
//
//        gl.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
//        //Draw front side
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z + OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z + OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z + OFFSET);
//
//        //Draw right side
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z + OFFSET);
//
//        //Draw back side
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z - OFFSET);
//
//        //Draw left side
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z + OFFSET);
//
//        //Draw top side
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y + OFFSET, z + OFFSET);
//
//        //Draw down side
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z + OFFSET);
//        gl.glVertex3f(x + OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z - OFFSET);
//        gl.glVertex3f(x - OFFSET, y - OFFSET, z + OFFSET);
//
//        gl.glEnd();
    	GLUT glut = new GLUT();
        
        gl.glColor3f(Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue());
        glut.glutWireCube(Element.CUBE_SIZE);
        gl.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
        glut.glutSolidCube(Element.CUBE_SIZE);
    }

    public void draw(GL gl) {
        if (!status.equals(Utils.ElementStatus.DESTROYED)) {
        	gl.glTranslatef(x, y, z);
        	if (status.equals(Utils.ElementStatus.MARKED_FOR_DESTRUCTION)) {
                drawDestruction(gl);
            } else {
                drawCube(gl);
            }
        	gl.glTranslatef(-x, -y, -z);
        }
    }
    public void drawDestruction(GL gl) {
    	
        speed += getAcceleration();
        angle += getSpeed();
                
        gl.glRotatef(getAngle(), 0.0f, 1.0f, 0.0f);
        drawCube(gl);
        if (getAngle() > ANGLE_LIMIT) {
            status = Utils.ElementStatus.DESTROYED;
        }
    }
}
