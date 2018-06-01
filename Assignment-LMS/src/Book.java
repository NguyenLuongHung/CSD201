/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class Book {
    private String bcode;
    private String title;
    private int quantity;
    private int lended;
    private double price;
    public Book(){}
    
    public Book(String bcode, String title, int quantity, int lended, double price){
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
    }
    
    void setBcode(String bcode){
        this.bcode = bcode;
    }
    void setTitle(String title){
        this.title = title;
    }
    void setQuantity(int quantity){
        this.quantity = quantity;
    }
    void setLended(int lended){
        this.lended = lended;
    }
    void setPrice(double price){
        this.price = price;
    }
    String getBcode(){
        return this.bcode;
    }
    String getTitle(){
        return this.title;
    }
    int getQuantity(){
        return this.quantity;
    }
    int getLended(){
        return this.lended;
    }
    double getPrice(){
        return this.price;
    }
    
    void display(){
        double value = price * quantity;
        System.out.printf("%-15s%-2s%-30s%-2s%-15d%-2s%-15d%-2s%-15.1f%-2s%-15.1f\n",bcode,"|",title,"|",quantity,"|",lended,"|",price,"|",value);
       
    }
    
}
