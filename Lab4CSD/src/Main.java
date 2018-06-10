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
    public static void main(String[] args) throws Exception{
        
        
        BSTree t = new BSTree();
        
        t.insert(4);
        t.insert(2);
        t.insert(7);
        t.insert(1);
        t.insert(5);
        t.insert(9);
        t.postorder();
        
       
        
        
    }
}
