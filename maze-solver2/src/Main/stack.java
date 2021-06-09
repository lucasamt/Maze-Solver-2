/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 * Classe que armazena qualquer tipo de pilha devido ao método Stack <Type>;
 * Ele também define um construtor padrão para uma pilha de qualquer tamanho e com o topo sempre sendo -1;
 * A pilha deve ser maior que zero, com os métodos push (Adicionar um item da pilha), pop (remover um item da pilha) 
 * e top (Retorna o topo da pilha), verifica se a pilha está vazia e finalmente redimensiona a pilha que causa isso 
 * aumenta de tamanho de acordo com a necessidade do usuário.
 *
 * @param   top                 Declara uma variável privada de todo o tipo que deve ser sempre a parte superior;
 * @param   size		Demonstra o tamanho da pilha;
 * @param   value		Demonstra os valores que estão na pilha;
 * @param   factor		Demonstra o valor máximo a ser alocado na pilha;
 * @param   getTopIndex		Leia o topo da pilha e volte ao índice;
 * @return  value 		Retorna os valores que estão na pilha;
 * @return  top == -1           Returns whether the stack is empty or not, after checking if the top is -1;
 * @return  elements[top]	Returns the element at the top of the stack;
 * @return  elements[value]	Returns the elements at the values of the stack;
 * @return  top                 Returns the top of the stack after it has been resized;
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
