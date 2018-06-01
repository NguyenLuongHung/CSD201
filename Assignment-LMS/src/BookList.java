/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class BookList {
    NodeBook head, tail;
    
    public BookList(){
        head = tail = null;
    }
    boolean isEmpty(){
        return (head == null);
    }
    public void clear(){
        head = tail = null;
    }
    public void add(Book q){
        if(isEmpty()) head = tail = new NodeBook(q,null);
        else {
           NodeBook p = new NodeBook(q,null);
           tail.next = p;
           tail = p;  
        }
    }
    
    public NodeBook searchBefore(Book q){
        NodeBook a = head;
        NodeBook b = new NodeBook();
        while(a!= null){
            if(a.book == q){
                return b;
            }
            b = a;
            a = a.next;
                
        }
        return null;
    }
    
    public NodeBook searchByBcode(String bcode){
        NodeBook a = head;
        while (a != null){
            if(a.book.getBcode().equals(bcode))
                return a;
            a = a.next;
        }
        return null;
    }
    
    public void deleteByBcode(String bcode){
        NodeBook a = head;
        while (a != null){
            if (head.book.getBcode().equals(bcode)){
                head = head.next;
                return;
            }
            if (a.book.getBcode().equals(bcode)){
                NodeBook b = searchBefore(a.book);
                b.next = a.next;
            }
            a = a.next;
        }
    }
    
    public void traverse(){
        NodeBook a = head;
        System.out.printf("%-15s%-2s%-30s%-2s%-15s%-2s%-15s%-2s%-15s%-2s%-15s\n","bcode","|","title","|","quantity","|","lended","|","price","|","value");
        while (a != null){
            a.book.display();
            a = a.next;
        }
    }
    public int count(){
        NodeBook a = head;
        int count = 0;
        while (a != null){
            a = a.next;
            count++;
        }
        return count;
    }
    
    public NodeBook node(int i){
        int index = 0;
        NodeBook q = head;
        while (index != i){
            q = q.next;
            index++;
        }
        return q;
    }
    
    void sort(){
        int i = 0;
        int j = 0;
        NodeBook swap = new NodeBook();
        NodeBook hold = new NodeBook();
        NodeBook after = new NodeBook();
        try {
        for (i = this.count(); i > 0; i--) {
            for (j = 0; j < i-1; j++) {
                  
                    if (node(j).book.getBcode().compareTo(node(i+j).book.getBcode()) > 0){
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
    
}
