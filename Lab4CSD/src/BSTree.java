/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class BSTree {
    
    Node root;
    
    public BSTree(){
        root = null;
    }
    
    boolean isEmpty(){
        return (root == null);
    }
    
    public void clear(){
        root = null;
    }
    
    


    
    
    
    
    public void insert(int x){
        if (isEmpty()){
            root = new Node(x, null,null);
            return;
        }
        Node p = root;
        Node f = null;
        while (p != null){
            if (p.info == x){
                System.out.println("The Node'key " + x + " already existed!");
                return;
            }
            f = p;
            if ( x < p.info)
                p = p.left;
            else 
                p = p.right;
        }
        if (x < f.info)
            f.left = new Node(x,null,null);
        else 
            f.right = new Node(x,null,null);
    }
    
    public void visit(Node p){
        System.out.print(p.info + " ");
        
    }
    
    public Node search(int x){
        if (isEmpty()) return null;
        else {
            Node p = root;
            while (p != null){
                if (p.info == x){
                    return p;
                }
                if (x < p.info)
                    p = p.left;
                else
                    p = p.right;
            }
            return null;
        }
        
    }
    
    public void breadth() throws Exception{
        MyQueue a = new MyQueue();
        a.enqueue(root);
        Node p;
        while (!a.isEmpty()){
            p = a.dequeue();
            if (p.left != null){
                a.enqueue(p.left);

            }
            if (p.right != null){
                a.enqueue(p.right);

                
            }
            System.out.println(p.info + " ");
            
        }

    }
    
    public void preorder () throws Exception {
        MyStack a = new MyStack();
        
        a.push(root);
        Node p = new Node();
        
        while (!a.isEmpty()){
            p = a.pop();
            System.out.println(p.info + " ");
            if (p.right != null){
                a.push(p.right);
            }
            if (p.left != null){
                a.push(p.left);
            }
        }
                
        
    }
    
    public void inorder() throws Exception {
        MyStack a = new MyStack();
        Node q = root;
        while (q != null){
            a.push(q);
            q = q.left;
        }
        
        while (!a.isEmpty()){
            q = a.pop();
            System.out.println(q.info + " ");
            if (q.right != null){
                q = q.right;
                while (q != null){
                    a.push(q);
                    q = q.left;
                }
            }
        }
        
        
        
    }
    
    public void postorderDemo() throws Exception {
        MyStack a = new MyStack();
        Node q = root;
        Node p = new Node();
        int count = 0;
        while (q != null){
            a.push(q);
            q = q.left;
        }
        
        
        while (!a.isEmpty()){
            q = a.pop();
            System.out.println(q.info + " ");
           
               
            q = a.top();
             
            if (q.right != null){
                Node f = q.right;
                q.right = null;
                q = f;
                while(q != null){
                    a.push(q);
                    q = q.left;
                }
            }
        }
    }
    
    public void postorder() throws Exception {
        MyStack s1 = new MyStack();
        MyStack s2 = new MyStack();
        
        Node p = root;
        s1.push(root);
        
        while (!s1.isEmpty()){
            Node temp = s1.pop();
            s2.push(temp);
            
            if (temp.left != null){
                s1.push(temp.left);
            }
            if (temp.right != null){
                s1.push(temp.right);
            }
        
        }
        
        while (!s2.isEmpty()){
            Node q = s2.pop();
            System.out.println(q.info + " ");
        }
        
    }
    
}
