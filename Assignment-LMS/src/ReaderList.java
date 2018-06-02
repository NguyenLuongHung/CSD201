
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReaderList {
    NodeReader head, tail;
    
    public ReaderList() {
        head = tail = null;
    }
    boolean isEmpty() {
        return (head == null);
    }
     public void clear() {
        head = tail = null;
    }
     
     public void add(Reader q){
        if(isEmpty()) head = tail = new NodeReader(q, null);
        else{
            NodeReader p = new NodeReader(q,null);
            tail.next = p;
            tail = p;
        }
    }
     
     public Reader input(){
        Scanner in = new Scanner(System.in);
        String rcode = "";
        String name = "";
        int byear = 0;
    
        int check0 = 0;
        int check1 = 0;
        int check2 = 0;
   
        
        do{
            try{
            rcode = "";
            check0 = 0; 
            System.out.print("Enter rcode: ");
            rcode = in.nextLine();
            NodeReader p = head;
            while (p != null){
            if(p.reader.getRcode().equals(rcode)){
                check0 = 2;
                break;
            }
            p = p.next;
             
            }
            
            }
            catch (Exception ex){
                check0 = 1;
            }
            if (check0 == 1)
                System.out.println("Invalid data, please re-enter");
            if (check0 == 2)
                System.out.println("Rcode has already exist, please re-enter");
        } while (check0 == 1 || check0 == 2);
        do{
            try{
            System.out.print("Enter name: ");
            name = in.nextLine();
            }
            catch (Exception ex){
                check1 = 1;
            }
            if (check1 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check1 == 1);
        do{
            try{
            System.out.print("Enter Byear: ");
            byear = Integer.parseInt(in.nextLine());
            check2 = 0;
            }
            catch (Exception ex){
                check2 = 1;
            }
            if (check2 == 1)
                System.out.println("Invalid data, please re-enter");
        } while (check2 == 1);
        
        Reader q = new Reader(rcode,name,byear);
        
        
        return q;
    }
     
      public void addToEnd() {
        Reader q = input();
        
        if (isEmpty()) {
            head = tail = new NodeReader(q, null);
        } else {
            NodeReader p = new NodeReader(q, null);
            tail.next = p;
            tail = p;
        }
    }
      
      public void traverse() {
        NodeReader a = head;
        System.out.printf("%-15s%-2s%-30s%-2s%-15s\n", "rcode", "|", "name", "|", "byear");
        System.out.println("--------------------------------------------------------");
        while (a != null) {
            a.reader.display();
            a = a.next;
        }
    }
     
    public NodeReader searchBefore(Reader q) {
        NodeReader a = head;
        NodeReader b = new NodeReader();
        while (a != null) {
            if (a.reader == q) {
                return b;
            }
            b = a;
            a = a.next;

        }
        return null;
    }
      
    public void searchByRcode(String rcode) {
        NodeReader a = head;
        while (a != null) {
            if (a.reader.getRcode().equals(rcode)) {
                System.out.printf("%-15s%-2s%-30s%-2s%-15s\n", "bcode", "|", "title", "|", "byear");
                System.out.println("--------------------------------------------------------");
                a.reader.display();
                return;
            }
            a = a.next;
        }
        System.out.println("Reader not Found");
    }  
    
    public void deleteByRcode(String rcode) {
        NodeReader a = head;
        while (a != null) {
            if (head.reader.getRcode().equals(rcode)) {
                head = head.next;
                System.out.println("Deleted!");
                return;
            }
            if (a.reader.getRcode().equals(rcode)) {
                NodeReader b = searchBefore(a.reader);
                b.next = a.next;
                System.out.println("Deleted!");
                return;
            }
            a = a.next;
        }
        System.out.println("Reader not Found");
       
    }
    
    public void inputFromFile(String filename){
        
        int index = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bf = new BufferedReader(fr);
            int c;
            String rcode = "";
            String name = "";
            String byear1 = "";
            double byear = 0;

            
            while((c=bf.read()) != -1){
                char b = (char)c;
               
                if(index == 0){

                    if(b == '|'){
                        index++;
                        continue;
                    }
                    else
                        rcode += b;
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
                    
                    
                    if (b == '\n'){
                        byear = Double.parseDouble(byear1);
                        this.add(new Reader(rcode,name,byear));
                        index = 0;
                        rcode = "";
                        name = "";
                        byear1 = "";
                        byear = 0;
                     
                    }
                    else{
                        byear1 += b;
                        
                    }
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
    
      public void saveToFile(String filename){
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            NodeReader q = head;
            while (q != null){
                bw.write(q.reader.getRcode());
                bw.write('|');
                bw.write(q.reader.getName());
                bw.write('|');
                String quantity = ""+q.reader.getByear();
                bw.write(quantity);
                bw.newLine();
                q = q.next;
            }
            bw.close();
            fw.close();
        } catch (IOException ex){
            System.out.println("Error writing to file '" + filename + "'");
        }
    }
    
}
