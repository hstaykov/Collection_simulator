	package org.java.simulations.collections;

import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.glu.GLU;

import com.sun.opengl.util.j2d.TextureRenderer;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureData;
import com.sun.opengl.util.texture.TextureIO;
import com.sun.opengl.util.texture.spi.TextureProvider;

/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer implements GLEventListener {
	
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);
      
        float[] lightPos = { 10.0f, 5f, 0.0f, 0.5f};        
        float[] noAmbient = { 0f, 0f, 0f, 0f };     
        float[] diffuse = { 1f, 1f, 1f, 1f };       
        
        //Enable 3D modelling
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_LIGHT1);
        gl.glEnable(GL.GL_NORMALIZE);
        
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, noAmbient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION,lightPos, 0);
        gl.glEnable(GL.GL_COLOR_MATERIAL);
        gl.glColorMaterial(GL.GL_AMBIENT_AND_DIFFUSE, 0);
        gl.glMaterialf(1, 1, 1);

        //OTHER STUFF FOR TESTING ================================================================
       
        //END OF THIS STUFF FOR TESTING ==========================================================

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(100.0f, h, 10.0, 200.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    private Collection collection;

    public void addCollection(Utils.CollectionTypes type) throws Exception {
        switch (type) {
            case STACK:
                collection = new Stack(0.0f, -13.0f, 0.0f);
                break;
            case QUEUE:
                collection = new Queue(0.0f, -13.0f, 0.0f);
                break;
            default:
                throw new Exception("This shoud never happen!!");
        }
    }
    
    
   
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        glu.gluLookAt(15, 0.0, 10.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);

        if (collection != null) {
            collection.draw(gl);
        }

        // Flush all drawing operations to the graphics card
        gl.glFlush();
        //drawable.swapBuffers();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public Collection getCollection() {
        return collection;
    }

	
}

