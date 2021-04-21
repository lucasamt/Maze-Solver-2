/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author RGrupos
 */
public class Node<T> {
    private Object data;
    private Node<T> next;

    public void setData(T data) {
        this.data = data;
    }
    
    public T getData() {
        return (T)this.data;
    }
    
    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }
}
