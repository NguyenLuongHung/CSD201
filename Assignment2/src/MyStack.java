
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
    NodeBook head;
    
    boolean isEmpty(){
        return (head == null);
    }
    
    public MyStack(){
        head = null;
    }
    public void clear(){
        head = null;
    }
    
    public void push(NodeBook x){
        x.next = head;
        head = x;
    }
    
    public NodeBook pop() throws EmptyStackException{
        if (isEmpty()) throw new EmptyStackException();
        else {
            NodeBook x = head;
            head = head.next;
            return (x);
        }
    }
    
    public NodeBook top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        else {
            return head;
        }
    }
    
    public void traverse(){
        NodeBook q = head;
        while (q!=null){
            System.out.println(q.book.getBcode() + " ");
            q = q.next;
        }
    }
    
    public int size(){
        NodeBook  q = head;
        int size = 0;
        while (q != null){
            size++;
            q = q.next;
        }
        return size;
    }
}
