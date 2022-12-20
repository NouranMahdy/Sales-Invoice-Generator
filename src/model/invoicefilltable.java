/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author el aGaipy
 */
public class invoicefilltable extends AbstractTableModel{
    
     private ArrayList<Invoicetable> invoicetable1;// fill table from array
     
     private String []  titles ={"No.","Date","customer","Total"};   //titles of table 

    public invoicefilltable(ArrayList<Invoicetable> invoicetable1) {
        this.invoicetable1 = invoicetable1;
    }

   // public ArrayList<Invoicetable> getInvoicetable1() {
     //   return invoicetable1;
    //}

   // public void setInvoicetable1(ArrayList<Invoicetable> invoicetable1) {
     //   this.invoicetable1 = invoicetable1;
    //}

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }
    

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
   
        return invoicetable1.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return titles.length;
    }

    @Override
    public String getColumnName(int column) {
        return titles[column];
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Invoicetable intable1 =   invoicetable1.get(rowIndex);
    switch (columnIndex)
    {
            case 0:
            return intable1.getNo();
            case 1:
            return intable1.getDate();
            case 2:
            return intable1.getCustomer();
            case 3:
            return intable1.totaltable1();
            default : 
                return "";
    
    }
        
    
    
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
    
    
}
