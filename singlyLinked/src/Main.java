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
        SingleList b = new SingleList();
        SingleList c = new SingleList();
        
        a.addToHead(6);
        a.addToHead(9);
        a.addToHead(8);
        a.addToTail(10);
        a.addToTail(9);
        b.addToTail(2);
        b.addToTail(21);
        b.addToTail(9);
        b.addToTail(1);
        b.addToTail(16);
        
        System.out.println("a:");
        a.traverse();
        System.out.println("b:");
     
        b.traverse();
        c=c.merge(a, b);
        System.out.println("c before sorting:");
        c.sort();
        System.out.println("c after sorting:");
        c.traverse();
        
        
//        System.out.println(a.node(2).info);
        
        
        
        
        
        
        
        
        
    }
}
