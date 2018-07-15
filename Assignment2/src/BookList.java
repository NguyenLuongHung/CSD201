
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class BookList {

    NodeBook root;

    public BookList() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    public void clear() {
        root = null;
    }

    public void add(Book q){
        
        if(isEmpty()){
            root = new NodeBook(q,null,null);
            return;
        }
        NodeBook p = root;
        NodeBook f= null;
        
        while (p != null){
            if(p.book.getBcode().equals(q.getBcode())){
                System.out.println("The Book code is already existed!");
            }
            f = p;
            if (q.getBcode().compareTo(p.book.getBcode()) < 0)
                p = p.left;
            else
                p = p.right;
        }
        if (q.getBcode().compareTo(f.book.getBcode()) < 0)
            f.left = new NodeBook(q,null,null);
        else
            f.right = new NodeBook(q,null,null);
    }
    
    public void insert(){
        Book q = input();
        if(isEmpty()){
            root = new NodeBook(q,null,null);
            return;
        }
        NodeBook p = root;
        NodeBook f= null;
        
        while (p != null){
            if(p.book.getBcode().equals(q.getBcode())){
                System.out.println("The Book code is already existed!");
            }
            f = p;
            if (q.getBcode().compareTo(p.book.getBcode()) < 0)
                p = p.left;
            else
                p = p.right;
        }
        if (q.getBcode().compareTo(f.book.getBcode()) < 0)
            f.left = new NodeBook(q,null,null);
        else
            f.right = new NodeBook(q,null,null);
    }
    
    public NodeBook search(String code){
        if (isEmpty()) return null;
        
        else {
            NodeBook p = root;
            while (p != null){
                if (p.book.getBcode().equals(code))
                    return p;
                if (code.compareTo(p.book.getBcode()) < 0)
                    p = p.left;
                else
                    p = p.right;
            }
            return null;
        }
    }
    
     public MyQueue breadth() throws Exception{
        MyQueue a = new MyQueue();
        MyQueue b = new MyQueue();
        a.enqueue(root);
        
        NodeBook p = null;
        System.out.printf("%-15s%-2s%-30s%-2s%-15s%-2s%-15s%-2s%-15s%-2s%-15s\n", "bcode", "|", "title", "|", "quantity", "|", "lended", "|", "price", "|", "value");
        while (!a.isEmpty()){
            p = a.dequeue();
            if (p.left != null){
                a.enqueue(p.left);
                b.enqueue(p.left);

            }
            if (p.right != null){
                a.enqueue(p.right);
                b.enqueue(p.right);

                    
            }
            p.book.display();
            
        }
        return b;

    }
     public void inorder() throws Exception {
        System.out.printf("%-15s%-2s%-30s%-2s%-15s%-2s%-15s%-2s%-15s%-2s%-15s\n", "bcode", "|", "title", "|", "quantity", "|", "lended", "|", "price", "|", "value");
        MyStack a = new MyStack();
       
        NodeBook q = root;
        while (q != null){
            a.push(q);
            
            q = q.left;
        }
        
        while (!a.isEmpty()){
            q = a.pop();
            q.book.display();
            if (q.right != null){
                q = q.right;
                while (q != null){
                    a.push(q);
                    
                    q = q.left;
                }
            }
        }
        
        
       
    }
     
     void inorder2(NodeBook p, ArrayList a)
   {if(p==null) return;
    inorder2(p.left,a);
    a.add(p);
    inorder2(p.right,a);
   }
    
    public Book input(){
        Scanner in = new Scanner(System.in);
        String bcode = "";
        String title = "";
        int quantity = 0;
        double price = 0;
        int check0 = 0;
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        
        do{
            try{
            bcode = "";
            check0 = 0; 
            System.out.print("Enter bcode: ");
            bcode = in.nextLine();
            NodeBook p = root;
            NodeBook f = null;
            while (p != null){
            if(p.book.getBcode().equals(bcode)){
                check0 = 2;
                break;
            }
            f = p;
            if (bcode.compareTo(p.book.getBcode()) < 0)
                p = p.left;
            else
                p = p.right;
             
            }
            
            }
            catch (Exception ex){
                check0 = 1;
            }
            if (check0 == 1)
                System.out.println("Invalid data, please re-enter");
            if (check0 == 2)
                System.out.println("Bcode has already exist, please re-enter");
        } while (check0 == 1 || check0 == 2);
        do{
            try{
            System.out.print("Enter title: ");
            title = in.nextLine();
            }
            catch (Exception ex){
                check1 = 1;
            }
            if (check1 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check1 == 1);
        do{
            try{
            System.out.print("Enter Quantity: ");
            quantity = Integer.parseInt(in.nextLine());
            check2 = 0;
            }
            catch (Exception ex){
                check2 = 1;
            }
            if (check2 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check2 == 1);
        do{
            try{
            System.out.print("Enter price: ");
            price = Double.parseDouble(in.nextLine());
            check3 = 0;
            }
            catch (Exception ex){
                check3 = 1;
            }
            if (check3 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check3 == 1);
        
        Book q = new Book(bcode,title,quantity,0,price);
        
        
        return q;
    }
    
    void copyDele(String code)
   {if(root==null)
       {System.out.println(" The tree is empty, no deletion");
        return;
       }
    NodeBook f,p; // f will be the father of p
    p=root;f=null;
    while(p!=null)
     {if(p.book.getBcode().equals(code)) break;//Found key x
      if(code.compareTo(p.book.getBcode()) < 0)
        {f=p;p=p.left;}
        else
        {f=p;p=p.right;}
     }
    if(p==null)
     {System.out.println(" The Book code does not exist, no deletion");
      return;
     }
    if(p.left==null && p.right==null) // p is a leaf node
     {if(f==null) // The tree is one node
       root=null; 
        else
        {if(f.left==p)
          f.left=null;
           else
            f.right=null;
        }
      return;
     }

    if(p.left!=null && p.right==null) // p has only left child
     {if(f==null) // p is a root
       root=p.left; 
        else
        {if(f.left==p) // p is a left child
           f.left=p.left;
            else 
             f.right=p.left;
        }
      return;
     }

    if(p.left==null && p.right!=null) // p has only right child
     {if(f==null) // p is a root
       root=p.right; 
        else
        {if(f.left==p) // p is aleft child
           f.left=p.right;
            else 
             f.right=p.right;
        }
      return;
     }

    if(p.left!=null && p.right!=null) // p has both left and right children
     {NodeBook rp; // p's key will be replaced by rp's one
      f=null;
      rp = p.left;
      while(rp.right!=null) 
       {f=rp; rp = rp.right;}// Find the right most node on the left sub-tree
      p.book.setBcode(rp.book.getBcode());
      p.book.setLended(rp.book.getLended());
      p.book.setPrice(rp.book.getPrice());
      p.book.setQuantity(rp.book.getQuantity());
      p.book.setTitle(rp.book.getTitle());
      
      if(f==null) // rp is just a left son of p 
        p.left=rp.left;
        else
         f.right=rp.left;
     }
     
   }
    
  

   

    public int count() throws Exception {
        MyQueue a = breadth();
        return a.size();
    }

   

 


 

 

    public void inputFromFile(String filename){
        
        int index = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            int c;
            String bcode = "";
            String name = "";
            String number = "";
            int quantity = 0;
            String price1 = "";
            double price = 0;
            
            while((c=bf.read()) != -1){
                char b = (char)c;
               
                if(index == 0){

                    if(b == '|'){
                        index++;
                        continue;
                    }
                    else
                        bcode += b;
                }
                if(index == 1){
                    
                    if(b == '|'){
                        index++;
                        continue;
                    }
                    else
                        name += b;
                }
                if (index == 2){
                    
                    if(b == '|'){
                       
                        quantity = Integer.parseInt(number);
                        
                        index++;
                        continue;
                    }
                    else
                        number += b;
                }
                if (index == 3){
                    
                    
                    if (b == '\n'){
                        price = Double.parseDouble(price1);
                        this.add(new Book(bcode,name,quantity,0,price));
                        index = 0;
                        bcode = "";
                        name = "";
                        number = "";
                        quantity = 0;
                        price1 = "";
                        price = 0;
                    }
                    else
                        price1 += b;
                }
                
            }
            bf.close();
            fr.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("Unable to open file " + "'" + filename + "'");
        }
        catch (IOException ex){
            System.out.println("Error reading file '" + "'");
        }
    }
    void balance(ArrayList a, int lower, int upper)
   {if(lower>upper) return;
    int middle = (lower + upper)/2;
    Book x = ((NodeBook) a.get(middle)).book;
    add(x);
    balance(a,lower, middle-1);
    balance(a,middle+1,upper);
   }
    
    void balance()
   {ArrayList a = new ArrayList();
    inorder2(root,a);
    int n = a.size();
    BookList g = new BookList();
    g.balance(a,0,n-1);
    root=g.root;
   }
    
    public void saveToFile(String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            NodeBook q = root;
            MyStack a = new MyStack();
            
            while (q != null){
            a.push(q);
            q = q.left;
        }
            while (!a.isEmpty()){
                q = a.pop();
                bw.write(q.book.getBcode());
                bw.write('|');
                bw.write(q.book.getTitle());
                bw.write('|');
                String quantity = ""+q.book.getQuantity();
                bw.write(quantity);
                bw.write('|');
                String price = ""+q.book.getPrice();
                bw.write(price);
                bw.newLine();
                
            
                if (q.right != null){
                    q = q.right;
                    while (q != null){
                        a.push(q);
                    
                        q = q.left;
                    }
                }
                }
            bw.close();
            fw.close();
        } catch (IOException ex){
            System.out.println("Error writing to file '" + filename + "'");
        }
    }
    
    
    
}
