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
public class Queue extends Collection {

	public Queue(float x, float y, float z) {
		super(x, y, z);
	}

	private void queueElement(String value) {
		if ((!locked) && (elements.size() < MAX_SIZE)) {
			float offset = 2 * elements.size() * StackElement.SPHERE_RADIUS;
			Color c = super.generateRandomColor();
			QueueElement element = new QueueElement(x, y + offset, z, c, value);
			elements.add(element);
		}
	}

	private void dequeElement() {
		if (elements.size() > 0) {
			if (!locked)
				for (Element el : elements) {
					el.y -= 2 * StackElement.SPHERE_RADIUS;
				}

			locked = true;

			elements.get(elements.size() - (elements.size())).setStatus(
					Utils.ElementStatus.MARKED_FOR_DESTRUCTION);
		}
	}

	public void addElement(String value) {
		queueElement(value);
	}

	public void removeElement() {
		dequeElement();
	}

}
