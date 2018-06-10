/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Node {
    int info;
    Node left, right;
    Node next;
    
    public Node(){}
    public Node(int info, Node left, Node right){
        this.info = info;
        this.left = left;
        this.right = right;
    }
    
    public Node(int info, Node next){
        this.info = info;
        this.next = next;
    }
}
