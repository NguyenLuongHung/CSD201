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
    
    int countHeight(Node p){
        int dept = 0;
        
        MyStack a = new MyStack();
        MyStack b = new MyStack();
        
        a.push(p);
        while (!a.isEmpty()){
            p = a.top();
            if (!b.isEmpty() && p == b.top()){
                if (b.size() > dept){
                    dept = b.size();
                }
                a.pop();
                b.pop();
            }
            else {
                b.push(p);
                if(p.right != null)
                    a.push(p.right);
                if(p.left != null)
                    a.push(p.left);
                
            }
        }
        return dept;
    }
    
    int balanceFactor(Node p){
        int left = 0; int right = 0;
        //Balance-factor(Node) = Height(left subtree) - Height (right subtree)
        if(p.left!= null)
            left = countHeight(p.left);
        if(p.right!= null)
            right = countHeight(p.right);
        return left - right;
    }
    
    int countNode(Node p) throws Exception{
        int count = 0;
        MyQueue a = new MyQueue();
        MyQueue b = new MyQueue();
        Node q;
        a.enqueue(p);
        b.enqueue(p);
        while (!a.isEmpty()) {
            q = a.dequeue();
            if(q.left != null){
                a.enqueue(q.left);
                b.enqueue(q.left);
            }
            if(q.right != null){
                a.enqueue(q.right);
                b.enqueue(q.right);
            }
        }
        return b.size();
    }
    
    Node findMax(Node p){
        while (p.right != null){
            p = p.right;
        }
        return p;
    }
    
    Node findMint(Node p){
        while (p.left != null){
            p = p.left;
        }
        return p;
    }
    
    Node findParent(Node q){
        Node p = root;
        while (p != null){
            
            if (p.left == q){
                return p;
            }
            else if (p.right == q){
                return p;
            }
            
            if (q.info < p.info)
                p = p.left;
            else
                p = p.right;
        }
        return null;
    }
    
    void deleteLeaft(Node q){
        Node p = root;
        while (p != null){
            if (p.left == q){
                p.left = null;
                return;
            }
            else if (p.right == q){
             p.right = null;
                return;
        }
            if (q.info < p.info)
                p = p.left;
            else
                p = p.right;
        }
    }
    
    void deleteOne(Node q){
        Node p = root;
        while (p != null){
            if (p.left == q){
                if (q.left != null)
                    p.left = q.left;
                else
                    p.left = q.right;
            }
            else if (p.right == q){
                if (q.right != null)
                    p.right = q.right;
                else
                    p.right = q.left;
            }
               
            if(q.info < p.info)
                p = p.left;
            else 
                p = p.right;
        }
        
    }    
    
    
    void deleteByCopy(Node q){
        
        if (q.left == null && q.right == null){
            deleteLeaft(q);
        }
        else if (q.left != null && q.right == null){
            deleteOne(q);
        }
        
        else if (q.left == null && q.right != null){
            deleteOne(q);
        }
        else {
            Node p = root;
            while (p != null){
                if (p.left == q){
                    Node temp = findMax(q.left);
                    
                    if (temp.left == null && temp.right == null)
                        deleteLeaft(temp);
                    else
                        deleteOne(temp);
                    p.left = temp;
                    temp.left = q.left;
                    temp.right = q.right;
                }
                if (p.right == q){
                    Node temp = findMint(q.right);
                    
                    if(temp.left == null && temp.right == null)
                        deleteLeaft(temp);
                    else
                        deleteOne(temp);
                    p.right = temp;
                    temp.left = q.left;
                    temp.right = q.right;
                    
                }

                if (q.info < p.info)
                    p = p.left;
                else
                    p = p.right;
            }
        }
    }
}
