/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */


public class SingleList  {
    
   
    Node head, tail;

    public SingleList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print(" " + p.info);
            p = p.next;
        }
        System.out.println();
    }

    void addToHead(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, head);
            head = q;
        }
    }

    void addToTail(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    void addAfter(Node p, int x) {
        Node q = new Node(x, p.next);
        p.next = q;
    }

    int deleteFromHead() {
        Node head1 = head;
        head = head.next;
        return (head1.info);
    }

    int deleteFromTail() {
        Node q = head;
        Node tail1 = q;
        while (q.next != null) {
            tail1 = q;
            q = q.next;
        }
        tail1.next = null;
        tail = tail1;
        return q.info;
    }

    Node search(int x) {
        Node p = head;
        while (p.info != x) {
            p = p.next;
        }
        return p;
    }

    int deleteAfter(Node p) {
        Node q = p.next;
        p.next = q.next;
        return q.info;
    }

    void dele(int x) {
        Node q = search(x);
        Node p = head;
        while (p.next != q) {
            p = p.next;
        }
        deleteAfter(p);
    }

    int count() {
        int c = 0;
        Node p = head;
        while (p.next != null) {
            p = p.next;
            c++;
        }
        c++;
        return c;
    }
    
    void delei(int i){
        Node q = head;
        int index = 2;
        if (i > this.count())
            System.out.println("Node doesn't exist, out of range!");
        else {
            while(index != i){
                q = q.next;
                index++;
            } 
        }
        deleteAfter(q);
    }
    
    Node node(int i){
        int index = 0;
        Node q = head;
        while (index != i){
            q = q.next;
            index++;
        }
        return q;
    }
    
    void swap(int i){
        Node swap = new Node();
        Node hold = new Node();
        Node after = new Node();
        if (node(i).info > node(i+1).info){
            if ( i == 0){
                after = node(i+1).next;
                hold = head;
                head = node(i+1);
                node(i).next = hold;
                node(i+1).next = after;
            }
            else {
            hold = node(i-1).next;
            swap = node(i+1);
            after = node(i+1).next;
            if (i > 0)
                node(i-1).next = swap;
            node(i).next = hold;
            node(i+1).next = after;
            
            head = node(0);
            }
        }
    }
    
    void sort(){
        int i = 0;
        int j = 0;
        Node swap = new Node();
        Node hold = new Node();
        Node after = new Node();
        try {
        for (i = this.count(); i > 0; i--) {
            for (j = 0; j < i-1; j++) {
                  
                    if (node(j).info > node(j+1).info){
                        if ( j == 0){
                            after = node(j+1).next;
                            hold = head;
                            head = node(j+1);
                            node(j).next = hold;
                            node(j+1).next = after;
                        }
                        else {
                        hold = node(j-1).next;
                        swap = node(j+1);
                        after = node(j+1).next;
                        if (j > 0)
                            node(j-1).next = swap;
                        node(j).next = hold;
                        node(j+1).next = after;

                        head = node(0);
                        }
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("i, j = " + i + "," + j);
            }
        }  
    
    
    int [] toArray(){
        int [] a = new int[this.count()];
        int index = 0;
        Node p = head;
        while (p != null){
            a[index] = p.info;
            index++;
            p = p.next;
        }
        
        
        return a;
    }
    
    SingleList merge(SingleList a, SingleList b){
        SingleList c = new SingleList();
        int index = a.count() + b.count();
        int [] array = new int[index];
        for (int i = 0; i < a.count(); i++) {
            array[i] = a.toArray()[i];
        }
        for (int j = 0; j < b.count(); j++) {
            array[j+a.count()] = b.toArray()[j];
        }
        for (int k = 0; k < index; k++) {
            c.addToTail(array[k]);
        }
        return c;
        
        }
    }
   
    
    

