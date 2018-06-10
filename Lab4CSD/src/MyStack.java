
import java.util.EmptyStackException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class MyStack {
    Node head;
    
    boolean isEmpty(){
        return (head == null);
    }
    
    public MyStack(){
        head = null;
    }
    public void clear(){
        head = null;
    }
    
    public void push(Node x){
        x.next = head;
        head = x;
    }
    
    public Node pop() throws EmptyStackException{
        if (isEmpty()) throw new EmptyStackException();
        else {
            Node x = head;
            head = head.next;
            return (x);
        }
    }
    
    public Node top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        else {
            return head;
        }
    }
    
    public void traverse(){
        Node q = head;
        while (q!=null){
            System.out.println(q.info + " ");
            q = q.next;
        }
    }
    
    public int size(){
        Node  q = head;
        int size = 0;
        while (q != null){
            size++;
            q = q.next;
        }
        return size;
    }
}
