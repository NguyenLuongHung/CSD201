
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
public class StackLink {
    Node head;
    public StackLink(){
        head = null;
    }
    public boolean isEmpty(){
        return (head == null); 
    }
    public void clear(){
        head = null;
    }
    public void push(int x){
        head = new Node(x, head);
    }
    public int pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        else {
            int x = head.info;
            head = head.next;
            return(x);
        }
        
    }
    public int top() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        else {
            return head.info;
        }
    }
    public void traverse(){
        Node q = head;
        while (q!=null){
            System.out.println(q.info + " ");
            q = q.next;
        }
    }
}
