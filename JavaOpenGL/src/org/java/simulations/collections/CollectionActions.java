/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java.simulations.collections;

import javax.media.opengl.GL;

/**
 *
 * @author flyingbear
 */
public interface CollectionActions {

    public void draw(GL gl);
    public void addElement(String value);

    public void removeElement();
}
