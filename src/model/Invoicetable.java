/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;



/**
 *
 * @author el aGaipy
 */
public class Invoicetable {
    
    private int no;
    private String date;
    private String customer;
    private double totaltable1;
    private ArrayList<Items> Items;   //array of items for each invoice
    

    public Invoicetable() {
    }

    
    
    public Invoicetable(int no, String date, String customer) {
        this.no = no;
        this.date = date;
        this.customer = customer;
    }
    
    public ArrayList<Items> getItems() {
        if(Items==null){
            Items=new ArrayList<>();}
        return Items;
        }
    

    
    
    
    
    
    
    
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoicetable{" + "no=" + no + ", date=" + date + ", customer=" + customer + ", Items=" + Items + '}';
    }

   
    
    
     
    //function for calculate invoice total

    public double totaltable1()
    {
        
        double t=0.0;
        for(Items ii :getItems())
        {
            t += ii.itemtotal();
      
        }
    return t;
    }

    public String getdatasavetofile() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return no + "," + date + "," + customer ;
    }
    
   
}
