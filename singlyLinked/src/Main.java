/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        SingleList a = new SingleList();
        
        a.addToHead(6);
        a.addToHead(9);
        a.addToHead(8);
        a.addToTail(10);
        a.addToTail(9);
        a.addAfter(a.search(6), 7);
        a.traverse();
     
        a.traverse();
        System.out.println(a.count());
        
        
//        System.out.println(a.node(2).info);
        a.sort();
        a.traverse();
        
        
    }
}
