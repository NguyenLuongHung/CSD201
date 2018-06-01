/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luong
 */
public class Reader {
    private String rcode;
    private String name;
    private int byear;
    
    public Reader(String rcode, String name, int byear){
        this.rcode = rcode;
        this.name = name;
        this.byear = byear;
    }
    
    void setRcode(String rcode){
        this.rcode = rcode;
    }
    void setName(String name){
        this.name = name;
    }
    void setByear(int byear){
        this.byear = byear;
    }
    String getRcode(){
        return this.rcode;
    }
    String getName(){
        return this.name;
    }
    int getByear(){
        return this.byear;
    }
}
