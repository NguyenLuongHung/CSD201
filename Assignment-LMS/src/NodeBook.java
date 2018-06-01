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
    NodeBook next;
    public NodeBook(){
      
    }
    public NodeBook(Book book, NodeBook next){
        this.book = book;
        this.next = next;
    }
}
