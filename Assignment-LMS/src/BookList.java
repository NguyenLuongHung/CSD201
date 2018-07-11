    
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.in;
import java.util.Scanner;

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

    public BookList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void add(Book q){
        if(isEmpty()) head = tail = new NodeBook(q, null);
        else{
            NodeBook p = new NodeBook(q,null);
            tail.next = p;
            tail = p;
        }
    }
    
    public Book input(){
        Scanner in = new Scanner(System.in);
        String bcode = "";
        String title = "";
        int quantity = 0;
        double price = 0;
        int check0 = 0;
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        
        do{
            try{
            bcode = "";
            check0 = 0; 
            System.out.print("Enter bcode: ");
            bcode = in.nextLine();
            NodeBook p = head;
            while (p != null){
            if(p.book.getBcode().equals(bcode)){
                check0 = 2;
                break;
            }
            p = p.next;
             
            }
            
            }
            catch (Exception ex){
                check0 = 1;
            }
            if (check0 == 1)
                System.out.println("Invalid data, please re-enter");
            if (check0 == 2)
                System.out.println("Bcode has already exist, please re-enter");
        } while (check0 == 1 || check0 == 2);
        do{
            try{
            System.out.print("Enter title: ");
            title = in.nextLine();
            }
            catch (Exception ex){
                check1 = 1;
            }
            if (check1 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check1 == 1);
        do{
            try{
            System.out.print("Enter Quantity: ");
            quantity = Integer.parseInt(in.nextLine());
            check2 = 0;
            }
            catch (Exception ex){
                check2 = 1;
            }
            if (check2 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check2 == 1);
        do{
            try{
            System.out.print("Enter price: ");
            price = Double.parseDouble(in.nextLine());
            check3 = 0;
            }
            catch (Exception ex){
                check3 = 1;
            }
            if (check3 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check3 == 1);
        
        Book q = new Book(bcode,title,quantity,0,price);
        
        
        return q;
    }
    
    public void addToEnd() {
        Book q = input();
        
        if (isEmpty()) {
            head = tail = new NodeBook(q, null);
        } else {
            NodeBook p = new NodeBook(q, null);
            tail.next = p;
            tail = p;
        }
    }

    public NodeBook searchBefore(Book q) {
        NodeBook a = head;
        NodeBook b = new NodeBook();
        while (a != null) {
            if (a.book == q) {
                return b;
            }
            b = a;
            a = a.next;

        }
        return null;
    }

    public void searchByBcode(String bcode) {
        NodeBook a = head;
        while (a != null) {
            if (a.book.getBcode().equals(bcode)) {
                System.out.printf("%-15s%-2s%-30s%-2s%-15s%-2s%-15s%-2s%-15s%-2s%-15s\n", "bcode", "|", "title", "|", "quantity", "|", "lended", "|", "price", "|", "value");
                System.out.println("------------------------------------------------------------------------------------------------------------------");
                a.book.display();
                return;
            }
            a = a.next;
        }
        System.out.println("Book not Found");
    }

    public void deleteByBcode(String bcode) {
        NodeBook a = head;
        while (a != null) {
            if (head.book.getBcode().equals(bcode)) {
                head = head.next;
                System.out.println("Deleted!");
                return;
            }
            if (a.book.getBcode().equals(bcode)) {
                NodeBook b = searchBefore(a.book);
                b.next = a.next;
                System.out.println("Deleted!");
                return;
            }
            a = a.next;
        }
        System.out.println("Book not Found");
       
    }

    public void traverse() {
        NodeBook a = head;
        System.out.printf("%-15s%-2s%-30s%-2s%-15s%-2s%-15s%-2s%-15s%-2s%-15s\n", "bcode", "|", "title", "|", "quantity", "|", "lended", "|", "price", "|", "value");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        while (a != null) {
            a.book.display();
            a = a.next;
        }
    }

    public int count() {
        NodeBook a = head;
        int count = 0;
        while (a != null) {
            a = a.next;
            count++;
        }
        return count;
    }

    public NodeBook node(int i) {
        int index = 0;
        NodeBook q = head;
        while (index != i) {
            q = q.next;
            index++;
        }
        return q;
    }

    void sort() {
        int i = 0;
        int j = 0;
        NodeBook swap = new NodeBook();
        NodeBook hold = new NodeBook();
        NodeBook after = new NodeBook();

        for (i = this.count(); i > 0; i--) {
            for (j = 0; j < i - 1; j++) {

                if (node(j).book.getBcode().compareTo(node(1 + j).book.getBcode()) > 0) {
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

    public void addToBegin() {
        Book q = input();
        if (isEmpty()) {
            head = tail = new NodeBook(q, null);
        } else {
            NodeBook p = new NodeBook(q, head);
            head = p;
        }
    }

    public void addAfter() {
        Scanner in = new Scanner(System.in);
        int i= 0 ;
        Book a = input();
        System.out.print("Enter position: ");
        i = Integer.parseInt(in.nextLine());
        NodeBook p = new NodeBook(a,null);
        NodeBook q = node(i);
        NodeBook hold = q.next;
        q.next = p;
        p.next = hold;
    }

    public void deleteAt() {
        Scanner in = new Scanner(System.in);
        int i= 0 ;
        System.out.print("Enter position: ");
        i = Integer.parseInt(in.nextLine());
        if (i == 0) {
            head = head.next;
        } else {
            NodeBook p = node(i);
            NodeBook q = node(i - 1);
            q.next = p.next;

        }

    }

    public void inputFromFile(String filename){
        
        int index = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            int c;
            String bcode = "";
            String name = "";
            String number = "";
            int quantity = 0;
            String price1 = "";
            double price = 0;
            
            while((c=bf.read()) != -1){
                char b = (char)c;
               
                if(index == 0){

                    if(b == '|'){
                        index++;
                        continue;
                    }
                    else
                        bcode += b;
                }
                if(index == 1){
                    
                    if(b == '|'){
                        index++;
                        continue;
                    }
                    else
                        name += b;
                }
                if (index == 2){
                    
                    if(b == '|'){
                       
                        quantity = Integer.parseInt(number);
                        
                        index++;
                        continue;
                    }
                    else
                        number += b;
                }
                if (index == 3){
                    
                    
                    if (b == '\n'){
                        price = Double.parseDouble(price1);
                        this.add(new Book(bcode,name,quantity,0,price));
                        index = 0;
                        bcode = "";
                        name = "";
                        number = "";
                        quantity = 0;
                        price1 = "";
                        price = 0;
                    }
                    else
                        price1 += b;
                }
                
            }
            bf.close();
            fr.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Unable to open file " + "'" + filename + "'");
        }
        catch (IOException ex){
            System.out.println("Error reading file '" + "'");
        }
    }
    
    public void saveToFile(String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            NodeBook q = head;
            while (q != null){
                bw.write(q.book.getBcode());
                bw.write('|');
                bw.write(q.book.getTitle());
                bw.write('|');
                String quantity = ""+q.book.getQuantity();
                bw.write(quantity);
                bw.write('|');
                String price = ""+q.book.getPrice();
                bw.write(price);
                bw.newLine();
                q = q.next;
            }
            bw.close();
            fw.close();
        } catch (IOException ex){
            System.out.println("Error writing to file '" + filename + "'");
        }
    }
    
    
    
}
