/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class NodeBook {
    Book book;
    NodeBook next,left,right;
    public NodeBook(){
      
    }
    public NodeBook(Book book, NodeBook left, NodeBook right){
        this.book = book;
        this.left = left;
        this.right = right;
    }
    
    public NodeBook(Book book, NodeBook next){
        this.book = book;
        this.next = next;
    }
}
