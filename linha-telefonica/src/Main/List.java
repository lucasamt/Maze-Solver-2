/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

public class List<T> {
    // create global top reference variable global
    Node top;
    // Constructor
    List(){
        this.top = null;
    }
 
    public void push(T x) {
        Node temp = new Node<T>();
 
        if (temp == null) {
            System.out.print("\nHeap Overflow");
            return;
        }

        temp.setData(x);
        temp.setNext(top);
        top = temp;
    }
 
    public boolean isEmpty(){
        return top == null;
    }
 
    public T peek() throws Exception{
        if (!isEmpty()) {
            return (T)top.getData();
        }
        else {
            throw new Exception("No items");
        }
    }
 
    public T pop() throws Exception{
        T data = (T)top.getData();
        if (top == null)
            throw new Exception("No items");
        top = (top).getNext();
        return data;
    }
 
    public void display(){
        if (top == null) {
            return;
        }
        else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.getData()+"->");
                temp = temp.getNext();
            }
        }
    }
}
