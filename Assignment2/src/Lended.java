/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class Lended {
    private String bcode;
    private String rcode;
    private int state;
    
    public Lended(String bcode, String rcode, int state){
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }
    
    void setBcode(String bcode){
        this.bcode = bcode;
    }
    void setRcode(String rcode){
        this.rcode = rcode;
    }
    void setState(int state){
        this.state = state;
    }
    
    String getBcode(){
        return this.bcode;
    }
    String getRcode(){
        return this.rcode;
    }
    int getState(){
        return this.state;
    }
    
 
    
   
    void display(){
        
        System.out.printf("%-15s%-2s%-30s%-2s%-15d\n",bcode,"|",rcode,"|",state);
        System.out.println("--------------------------------------------------------");
       
    }
}
