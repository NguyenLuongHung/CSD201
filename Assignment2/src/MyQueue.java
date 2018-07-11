/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

public class MyQueue {
    NodeBook head, tail;
    public MyQueue(){
        head = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void clear(){
        head = null;
    }
    
    public void enqueue(NodeBook p){
        if (isEmpty()) head = tail = p;
        else {
            
            tail.next = p;
            tail = p;
        }
    }
    
    
    public NodeBook dequeue() throws Exception {
        if (isEmpty()) throw new Exception();
        else {
            NodeBook q = head;
            head = head.next;
            return q;
        }
    }
    public String first() throws Exception{
        if (isEmpty()) throw new Exception();
        else {
            return head.book.getBcode();
        }
    }
    
    public NodeBook search(String code){
        NodeBook q = head;
        while (q != null){
            if (q.book.getBcode().equals(code))
                return q;
        }
        return null;
    }
    
    public void traverse(){
        NodeBook q = head;
        while(q != null){
            System.out.println(q.book.getBcode() + " ");
            q = q.next;
        }
    }
    
}
