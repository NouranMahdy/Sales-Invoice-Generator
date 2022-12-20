/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author el aGaipy
 */
public class Items {
    
  //  private int no;
    private String itemname;
    private double itemprice;
    private int count;
    
    private Invoicetable obj;      //obj from class invoicetable

    public Invoicetable getObj() {
        return obj;
    }
    

    public Items() {
    }

    public Items( String itemname, double itemprice, int count) {
        //this.no = no;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.count = count;
    }

    public Items( String itemname, double itemprice, int count, Invoicetable obj) {
       // this.no = no;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.count = count;
        this.obj = obj;
    }

    
    
    
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

  //  public int getNo() {
    //    return no;
    //}

    //public void setNo(int no) {
     //   this.no = no;
    //}

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }
//function for calculate itemstotal
    
    public double itemtotal()
    {
    return itemprice*count;
    }
    
    
    
    @Override
    public String toString() {
        return "Items{"+"num="+obj.getNo()+ "itemname=" + itemname + ", itemprice=" + itemprice + ", count=" + count +'}';
    }
    
    

    public String getdatasavetofile() {
        return obj.getNo() + "," + itemname + "," + itemprice + "," + count ;
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
}
