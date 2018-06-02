
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class LendedList {
    NodeLended head, tail;
    
     public LendedList() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        return (head == null);
    }
    
    public void clear() {
        head = tail = null;
    }
    
    public void add(Lended q){
        if(isEmpty()) head = tail = new NodeLended(q, null);
        else{
            NodeLended p = new NodeLended(q,null);
            tail.next = p;
            tail = p;
        }
    }
    
    public void input(BookList q, ReaderList p){
        Scanner in = new Scanner(System.in);
        String bcode = "";
        String rcode = "";
        int state = 0;
        int lended;
        int check0 = 0;
        int check1 = 0;
        int check2 = 0;
        int accept1 = 0;
        int accept2 = 0;
        int accept3 = 0;

        
        do{
            try{
            bcode = "";
            check0 = 0; 
            System.out.print("Enter bcode: ");
            bcode = in.nextLine();
            }
            catch (Exception ex){
                check0 = 1;
            }
            if (check0 == 1)
                System.out.println("Invalid data, please re-enter");
            
        } while (check0 == 1 );
        do{
            try{
            System.out.print("Enter rcode: ");
            rcode = in.nextLine();
            }
            catch (Exception ex){
                check1 = 1;
            }
            if (check1 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check1 == 1);
        do{
            try{
            System.out.print("Enter state: ");
            state = Integer.parseInt(in.nextLine());
            check2 = 0;
            }
            catch (Exception ex){
                check2 = 1;
            }
            if (check2 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check2 == 1);
       
        
        
        NodeBook a = q.head;
        while (a != null){
            int i = 0;
            
            if(a.book.getBcode().equals(bcode)){
                accept1 = 1;
                break;
            }
            accept1 = 0;
            a = a.next;
            System.out.println("i = " + i);
        }
        NodeReader b = p.head;
        
        while(b != null){
            int i = 0;
            if(b.reader.getRcode().equals(rcode)){
                accept2 = 1;
                break;
            }
            b = b.next;
            accept2 = 0;
            System.out.println("j = " + i);
        }
        NodeLended c = head;
        while (c != null){
            if(c.lended.getBcode().equals(bcode) && c.lended.getRcode().equals(rcode)){
                accept3 = 1;
                break;
            }
            c = c.next;
        }
 
        
        
        
        
        
        if (accept1 == 0 || accept2 == 0){
            System.out.println("Data is not accepted, bcode or rcode is available!");
        }
        
        else if(accept3 == 1 && state == 1){
            System.out.println("Data is not accepted, the book still at the reader!");
        }
        else if(accept1 == 1 && accept2 == 1 && a.book.getLended() < a.book.getQuantity()){
            a.book.setLended(a.book.getLended() + 1);
            this.add(new Lended(a.book.getBcode(),b.reader.getRcode(),1));
        }
        else if (accept1 == 1 && accept2 == 1 && a.book.getLended() == a.book.getQuantity()){
            this.add(new Lended(bcode, rcode,0));
        }
        
        
        
        
        
    }
    
   public void traverse(){
       NodeLended q = head;
       System.out.printf("%-15s%-2s%-30s%-2s%-15s\n","bcode","|","rcode","|","state");
       System.out.println("--------------------------------------------------------");
       while (q != null){
            q.lended.display();
            q = q.next;
       }
   }
   
   public int count() {
        NodeLended a = head;
        int count = 0;
        while (a != null) {
            a = a.next;
            count++;
        }
        return count;
    }

    public NodeLended node(int i) {
        int index = 0;
        NodeLended q = head;
        while (index != i) {
            q = q.next;
            index++;
        }
        return q;
    }
   
   
   public void sort(){
       int i = 0;
        int j = 0;
        NodeLended swap = new NodeLended();
        NodeLended hold = new NodeLended();
        NodeLended after = new NodeLended();

        for (i = this.count(); i > 0; i--) {
            for (j = 0; j < i - 1; j++) {

                if (node(j).lended.getBcode().compareTo(node(1 + j).lended.getBcode()) > 0) {
                    if (j == 0) {
                        after = node(j + 1).next;
                        hold = head;
                        head = node(j + 1);
                        node(j).next = hold;
                        node(j + 1).next = after;
                    } else {
                        hold = node(j - 1).next;
                        swap = node(j + 1);
                        after = node(j + 1).next;
                        if (j > 0) {
                            node(j - 1).next = swap;
                        }
                        node(j).next = hold;
                        node(j + 1).next = after;

                        head = node(0);
                    }
                }
                else if (node(j).lended.getBcode().compareTo(node(1 + j).lended.getBcode()) == 0){
                    if (node(j).lended.getRcode().compareTo(node(1 + j).lended.getRcode()) > 0){
                        if (j == 0) {
                        after = node(j + 1).next;
                        hold = head;
                        head = node(j + 1);
                        node(j).next = hold;
                        node(j + 1).next = after;
                    } else {
                        hold = node(j - 1).next;
                        swap = node(j + 1);
                        after = node(j + 1).next;
                        if (j > 0) {
                            node(j - 1).next = swap;
                        }
                        node(j).next = hold;
                        node(j + 1).next = after;

                        head = node(0);
                    }
                    }
                }
            }
        }
   }
}
