/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java.simulations.collections;

/**
 *
 * @author flyingbear
 */
public class Stack extends Collection {

    public Stack(float x, float y, float z) {
        super(x, y, z);
    }

    private void pushElement(String value) {
        if ((!locked) && (elements.size() < MAX_SIZE)) {
            float offset = elements.size() * StackElement.CUBE_SIZE;
            Color c = super.generateRandomColor();
            StackElement element = new StackElement(x, y + offset, z, c, value);
            elements.add(element);
        }
    }

    private void popElement() {
        if (elements.size() > 0) {
            locked = true;
            elements.get(elements.size() - 1).setStatus(Utils.ElementStatus.MARKED_FOR_DESTRUCTION);
        }
    }

    public void addElement(String value){
        pushElement(value);
    }

    public void removeElement(){
        popElement();
    }


}
