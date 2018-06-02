
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
public class Main {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        BookList a = new BookList();
        ReaderList b = new ReaderList();
        LendedList c = new LendedList();

        System.out.println("Welcome to the Library Management System, Mrs.Chi");
        System.out.println("Please follow the following instruction and we'll be fine!");
        System.out.println("Have fun!");
        
        int tc = 0;
        int tc1 = 0;
        int tc2 = 0;
        int tc3 = 0;
        
        int check = 0;
        int check1 = 0;
        int check2 = 0;
        int check3 = 0;
        do {
        check = 0;
        System.out.println("-----------------------------");
        System.out.println("1. Go to BookList Menu");
        System.out.println("2. Go to ReaderList Menu");
        System.out.println("3. Go to LendedList Menu");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
        try{
        tc = Integer.parseInt(in.nextLine());
        }
        catch (Exception e){
            check = 1;
        }
        System.out.println("-----------------------------");
        
        if (tc == 1){
            do{
                check1 = 0;
                System.out.println("-----------------------------");
                System.out.println("1.1. Load data from file");
                System.out.println("1.2 Input & add to the end");
                System.out.println("1.3. Display data");
                System.out.println("1.4. Save book list to file");
                System.out.println("1.5. Search by code");
                System.out.println("1.6. Delete by bcode");
                System.out.println("1.7. Sort by bcode");
                System.out.println("1.8. Input & add to beginning");
                System.out.println("1.9. Add after position k");
                System.out.println("1.10. Delete position k");
                System.out.println("1.11. Return to main menu");
                System.out.print("Your choide: ");
                try {
                tc1 = Integer.parseInt(in.nextLine());
                } catch (Exception e){
                    check1 = 1;
                }
                System.out.println("-----------------------------");
                if (tc1 == 1){
                    String filename = "";
                    System.out.print("Enter your filename: ");
                    filename = in.nextLine();
                    a.inputFromFile(filename);
                }
                else if (tc1 == 2){
                    a.addToEnd();
                }
                else if (tc1 == 3){
                    a.traverse();
                }
                else if (tc1 == 4){
                    String filename = "";
                    System.out.print("Enter your filename: ");
                    filename = in.nextLine();
                    a.saveToFile(filename);
                }
                else if (tc1 == 5){
                    String bcode = "";
                    System.out.print("Enter bcode to search: ");
                    bcode = in.nextLine();
                    a.searchByBcode(bcode);
                }
                else if (tc1 == 6){
                    String bcode = "";
                    System.out.print("Enter bcode to delete: ");
                    bcode = in.nextLine();
                    a.deleteByBcode(bcode);
                }
                else if (tc1 == 7){
                    BookList h = a;
                    h.sort();
                    h.traverse();
                }
                else if (tc1 == 8){
                    a.addToBegin();
                }
                else if (tc1 == 9){ 
                    a.addAfter();
                }
                else if (tc1 == 10){
                    a.deleteAt();
                }
                if(check1 == 1)
                    System.out.println("Invalid choice, choose again!");
            } while (tc1 != 11 || check1 == 1);
        }
        
        if (tc == 2){
            do{
                check2 = 0;
                System.out.println("-----------------------------");
                System.out.println("2.1. Load data from file");
                System.out.println("2.2. Input & add to the end");
                System.out.println("2.3. Display Data");
                System.out.println("2.4. Save reader list to file");
                System.out.println("2.5. Search by rcode");
                System.out.println("2.6. Delete by rcode");
                System.out.println("2.7. Return to main menu");
                System.out.print("Your choice: ");
                try {
                tc2 = Integer.parseInt(in.nextLine());
                } catch (Exception e){
                    check2 = 1;
                }
                System.out.println("-----------------------------");
                if (tc2 == 1){
                    String filename = "";
                    System.out.print("Enter your filename: ");
                    filename = in.nextLine();
                    b.inputFromFile(filename);
                }
                else if (tc2 == 2){
                    b.addToEnd();
                }
                else if (tc2 == 3){
                    b.traverse();
                }
                else if (tc2 == 4){
                    String filename = "";
                    System.out.print("Enter your filename: ");
                    filename = in.nextLine();
                    b.saveToFile(filename);
                }
                else if (tc2 == 5){
                    String rcode = "";
                    System.out.print("Enter rcode to search: ");
                    rcode = in.nextLine();
                    b.searchByRcode(rcode);
                }
                else if (tc2 == 6){
                    String rcode = "";
                    System.out.print("Enter rcode to delete: ");
                    rcode = in.nextLine();
                    b.deleteByRcode(rcode);
                }
                if(check2 == 1)
                    System.out.println("Invalid choice, choose again!");
            } while (tc2 != 7 || check2 == 1);
        }
        
        if (tc == 3){
            do{
                check3 = 0;
                System.out.println("-----------------------------");
                System.out.println("3.1. Input data");
                System.out.println("3.2. Display data");
                System.out.println("3.3. Sort by bcode + rcode");
                System.out.println("3.4. Return to main menu");
                System.out.print("Your choide: ");
                try{
                tc3 = Integer.parseInt(in.nextLine());
                } catch (Exception e){
                    check3 = 1;
                }
                System.out.println("-----------------------------");
                if (tc3 == 1){
                    c.input(a, b);
                }
                else if (tc3 == 2){
                    c.traverse();
                }
                else if (tc3 == 3){
                    LendedList e = c;
                    e.sort();
                    e.traverse();
                }
                if(check3 == 1)
                    System.out.println("Invalid choice, choose again!");
            } while (tc3 != 4 || check3 == 1);
        }

        if(check == 1)
                System.out.println("Invalid choice, choose again!");
    }
        while (tc != 4 || check == 1);
}
}
