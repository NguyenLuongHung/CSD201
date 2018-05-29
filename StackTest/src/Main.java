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
        StackLink a = new StackLink();
        a.push(1);
        a.push(4);
        a.push(7);
        a.push(2);
        a.push(9);
       
        System.out.println(a.pop());
    }
}
