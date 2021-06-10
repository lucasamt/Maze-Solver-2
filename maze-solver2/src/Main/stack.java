package Main;

import java.util.Arrays;

/**
 * Classe que armazena qualquer tipo de pilha devido ao método Stack <Type>;
 * Ele também define um construtor padrão para uma pilha de qualquer tamanho e com o topo sempre sendo -1;
 * A pilha deve ser maior que zero, com os métodos push (Adicionar um item da pilha), pop (remover um item da pilha)
 * e top (Retorna o topo da pilha), verifica se a pilha está vazia e finalmente redimensiona a pilha que causa isso
 * aumenta de tamanho de acordo com a necessidade do usuário.
 * 
 * @param <type> 
 */

public class stack<type> {
    private Object elements[];
	private int top;

	/**
         * Construtor de classe padrão
         */
	public stack() {
		int size = 10;
		elements = new Object[size];
		top = -1;
	}

	/**
         * Construtor de classe com tamanho
         * 
         * @param size
         */
	public stack(int size) throws Exception {
		if (size <= 0)
			throw new IllegalArgumentException("Constructor size must be greater than 0");

		elements = new Object[size];
		top = -1;
	}

	/**
         * Método que envia um valor para o elemento
         * 
         * @param value 
         */
	public void push(type value) {
		if ((top + 1) >= elements.length)
			autoSize(2); // Increases the element size to double
		top++;
		elements[top] = value;
	}

	/**
         * Método que remove o último valor do elemento
         * 
         * @return value
         */
	public type pop() throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to pop");

		Object value = elements[top];
		top--; // Element continua na pilha, mas o topo é alterado e ele se torna inacessivel.
				// Isso é um problema?
		return (type) value;
	}

	/**
         * Método que verifica se está vazio
         * 
         * @return top
         */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
         * Método que obtém o elemento top
         * 
         * @return elements[top]
         */
	public type getTop() throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to get");
		return (type) elements[top];
	}

        /**
         * Método que verifica se o elemento top esta vazio e retorna mensagem de valor ilegal
         * 
         * @param value
         * @return elements[value]
         */
	public type getTop(int value) throws Exception {
		if (isEmpty())
			throw new IllegalStateException("There isn't elements to get");
		if(value>top)
			throw new IllegalStateException("Ilegal value");
		
		return (type) elements[value];
	}

	/**
         * Método que redimensiona a pilha
         * 
         * @param factor 
         */
	public void autoSize(float factor) {
		Object[] newElement = new Object[Math.round(elements.length * factor)];

		for (int i = 0; i <= this.top; i++)
			newElement[i] = elements[i];

		elements = newElement;
	}
	
        /**
         * Obtém o topo da pilha
         * 
         * @return top
         */
	public int getTopIndex() {
		return top;
	}

    /**
     * Obtém o hashcode
     * 
     * @return result;
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Arrays.deepHashCode(this.elements);
        hash = 97 * hash + this.top;
        return hash;
    }

    /**
     * Verifica se outra classe é igual a esta
     * 
     * @param obj
     * @return true
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final stack<?> other = (stack<?>) obj;
        if (this.top != other.top) {
            return false;
        }
        if (!Arrays.deepEquals(this.elements, other.elements)) {
            return false;
        }
        return true;
    }
    

    /** 
     * Returns class data in string
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "stack{" + "elements=" + elements + ", top=" + top + '}';
    }   
    
}
