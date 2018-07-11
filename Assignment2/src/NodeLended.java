/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class NodeLended {
    Lended lended;
    NodeLended next;
    public NodeLended(){}
    public NodeLended(Lended lended, NodeLended next){
        this.lended = lended;
        this.next = next;
    }
}
