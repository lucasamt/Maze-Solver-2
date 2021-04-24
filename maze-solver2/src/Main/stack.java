/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Usuario
 */
public class stack<type> {
    private Object elements[];
	private int top;

	/*
	 * Default Class Constructor
	 **/
	public stack() {
		int size = 10;
		elements = new Object[size];
		top = -1;
	}

	/*
	 * Class Constructor with size
	 **/
	public stack(int size) throws Exception {
		if (size <= 0)
			throw new IllegalArgumentException("Constructor size must be greater than 0");

		elements = new Object[size];
		top = -1;
	}

	/*
	 * Method that pushes a value to the element
	 **/
	public void push(type value) {
		if ((top + 1) >= elements.length)
			autoSize(2); // Increases the element size to double
		top++;
		elements[top] = value;
	}

	/*
	 * Method that removes the last value from element
	 **/
	public type pop() throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to pop");

		Object value = elements[top];
		top--; // Element continua na pilha, mas o topo é alterado e ele se torna inacessivel.
				// Isso é um problema?
		return (type) value;
	}

	/*
	 * Method that checks if it is empty
	 **/
	public boolean isEmpty() {
		return top == -1;
	}

	/*
	 * Method that gets top's element
	 **/
	public type getTop() throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to get");
		return (type) elements[top];
	}

	public type getTop(int value) throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to get");
		if(value>top)
			throw new IllegalStateException("Ilegal value");
		
		return (type) elements[value];
	}

	/*
	 * Method that resizes the Stack
	 **/

	public void autoSize(float factor) {
		Object[] newElement = new Object[Math.round(elements.length * factor)];

		for (int i = 0; i <= this.top; i++)
			newElement[i] = elements[i];

		elements = newElement;
	}
	
	public int getTopIndex() {
		return top;
	}
    
}
