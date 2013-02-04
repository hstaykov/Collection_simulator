/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.java.simulations.collections;

/**
 *
 * @author flyingbear
 */
public class Utils {

    private Utils(){
        //Prevent initialization;
    }

    public static enum ElementStatus{
        MARKED_FOR_DESTRUCTION,
        MARKED_FOR_CREATION,
        NORMAL,
        DESTROYED
    }

    public static enum CollectionTypes{
        STACK,
        QUEUE,
        HASH_TABLE
    }

}
