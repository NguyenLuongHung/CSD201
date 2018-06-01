/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class Main {
    public static void main(String[] args) {
        
        Book a1 = new Book("0005","The Lord of the ring",10,0,100);
        Book a2 = new Book("0001","Life of pi",5,0,25.2);
        Book a3 = new Book("0003","We all in",10,0,50);
        Book a4 = new Book("0007","Dota 2 is my life",11,0,41);
        
        BookList a = new BookList();
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        BookList b = a;
        b.sort();
        System.out.println(b.count());
        b.traverse();
        
      
        
    }
}
