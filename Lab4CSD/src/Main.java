

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

    public static void main(String[] args) throws Exception {

        BSTree t = new BSTree();

        t.insert(0);
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);
        
       
       
        
        
//        t.insert(5);
//        t.insert(9);
//       
//        t.insert(7);
//        t.insert(20);

//        t.postorder();

//        Node p = t.search(4);
//        System.out.println("Searched: " + p.info);
//
//        System.out.println("Height: " + t.countHeight(t.search(4)));
//
////        System.out.println("BF: "+ t.balanceFactor(t.search(2)));
////       System.out.println("Count: "+t.countNode(t.search(0)));
//        Node q = t.findMax(t.root);
//        System.out.println("MAX: " + q.info);
//
////       q = t.findMint(t.search(7));
//        System.out.println("MIN: " + q.info);
//
//            
//        for (int i = 0; i < t.countNode(t.root); i++) {
//            
//        
//        System.out.println(t.findMint(t.root).info);
//        t.deleteByCopy(t.findMint(t.root));
//        
           t.rebuild(t.simpleBalance());
           t.breadth();
        
        
    }
}
