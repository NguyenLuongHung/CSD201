/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class NodeReader {
    Reader reader;
    NodeReader next;
    public NodeReader(){}
    public NodeReader(Reader reader, NodeReader next){
        this.reader = reader;
        this.next = next;
    }
}
