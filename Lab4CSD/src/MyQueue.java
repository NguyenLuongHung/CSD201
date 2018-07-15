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
    Node head, tail;
    public MyQueue(){
        head = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void clear(){
        head = null;
    }
    
    public void enqueue(Node p){
        if (isEmpty()){
            head = tail = p;
            head.next = tail.next = null;
        
        }
        else {
            
            tail.next = p;
            tail = p;
            tail.next = null;
        }
    }
    
    
    public Node dequeue() throws Exception {
        if (isEmpty()) throw new Exception();
        else {
            Node q = head;
            head = head.next;
            return q;
        }
    }
    public int first() throws Exception{
        if (isEmpty()) throw new Exception();
        else {
            return head.info;
        }
    }
    
    public Node search(int x){
        Node q = head;
        while (q != null){
            if (q.info == x )
                return q;
        }
        return null;
    }
    
    public void traverse(){
        Node q = head;
        while(q != null){
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
