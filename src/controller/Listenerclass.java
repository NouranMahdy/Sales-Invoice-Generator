/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import java.awt.List;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.*;

//import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Invoicetable;
import model.Items;
import model.Itemsfilltable;
import model.invoicefilltable;
import view.Createnewinvoice;
import view.DesignFrame;
import view.Save;

//import javax.swing.filechooser.FileFilter;
//import java.awt.event.*;
//import java.awt.*;
//import java.io.*;


/**
 *
 * @author el aGaipy
 */
public class Listenerclass implements ActionListener,ListSelectionListener {

    private Createnewinvoice newin;
    private Save saveitem;
    
    @Override
    public void actionPerformed(ActionEvent e) {
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
    String commandname = e.getActionCommand();

       switch(commandname)
       {
           case"Load from File":
               
               loadfromfile();
           break;
           
           case"Save to file":
              savetofile(); 
           break;
           
           case"create New":
               createnew();
           break;
           
           case"Delete":
               delete();
           break;
           
           case "Create Item":
               createitem();
           break;
           
           case"Delete Item":
               deleteitem();
           break;
           
           
 //create new invoice and new item
           
           
           case "invoicecancel":
                invoicecancel();
                break;
                
           case "invoiceoK":
               invoiceoK();
                break;
           
          case "itemoK":
                itemoK();
                break;
                
            case "itemcancel":
                itemcancel();
                break;
           
    
    }
    
    }
    
    
    
    
    
    //functions for table1
private void createnew() {
    
     newin =new Createnewinvoice(d);
    newin.setVisible(true);
    
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

private void delete() {
    
    int selectedr =d.getInvoicestable().getSelectedRow();
    if(selectedr !=-1 )
    {
        d.getInvoicetable1().remove(selectedr);
        d.getFill().fireTableDataChanged();
        d.getFill().fireTableDataChanged();
    
    }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//functions for table 2 save and cancel buttons
    private void deleteitem() {
        
        int choosen =d.getInvoicestable().getSelectedRow();
        int selectedr =d.getItemstable().getSelectedRow();
    if(choosen !=-1 &&  selectedr !=-1 )
    {
        Invoicetable invv= d.getInvoicetable1().get(choosen);
        invv.getItems().remove(choosen);
        Itemsfilltable fill=new Itemsfilltable(invv.getItems());
        d.getItemstable().setModel(fill);
        fill.fireTableDataChanged();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    private void createitem() {
        
        saveitem = new Save (d);
        saveitem.setVisible(true);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

// functions for save and load from file
    private void savetofile() {
        
         ArrayList <Invoicetable> invoices = d.getInvoicetable1();
         String in = "";
         String it ="";
         for ( Invoicetable obj : invoices)
         {
                  String  csv1 = obj.getdatasavetofile();
                   in  += csv1;
                   in  += "\n";
                  for (  Items item :obj.getItems()){
                       String csv2 = item.getdatasavetofile();
                       it += csv2;
                       it += "\n";
           }
         }
     try{    
         JFileChooser jfc = new JFileChooser();
         int chose = jfc.showSaveDialog(d);
         if (chose ==JFileChooser.APPROVE_OPTION)
         {
               File f1 = jfc.getSelectedFile();
               FileWriter filewriter = new FileWriter(f1);     
         filewriter.write(in);
         filewriter.flush();
         filewriter.close();
         
                 chose=jfc.showSaveDialog(d);
         if(chose == JFileChooser.APPROVE_OPTION)
         {
         File  f2 =jfc.getSelectedFile();
         FileWriter filewriter2 = new FileWriter(f2);
         filewriter2.write(it);
         filewriter2.flush();
         filewriter2.close();
         
         }         
         }
     }  catch (Exception e)
     {
    
         }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     private DesignFrame d;
    public Listenerclass(DesignFrame d){this.d=d;}
   
    
    private void loadfromfile() {
        //To change body of generated methods, choose Tools | Templates.
       JFileChooser choosefromfile = new JFileChooser();
       try{
   int returnvalue = choosefromfile.showOpenDialog(d);
  if(returnvalue== JFileChooser.APPROVE_OPTION)
  {
   File f = choosefromfile.getSelectedFile();
    Path p = Paths.get(f.getAbsolutePath());
    List<String>a;
    a = Files.readAllLines(p);  //list of invoices
    ArrayList <Invoicetable> table1= new ArrayList<>();
    for(String part : a)
    {
    String[] customerinvoice =part.split(",");
    int invoiceno= Integer.parseInt(customerinvoice[0]);
    String indate = customerinvoice[1];
    String name = customerinvoice[2];
     
    Invoicetable eachinvoice= new Invoicetable(invoiceno,indate,name);
    table1.add(eachinvoice);
    }
    returnvalue=choosefromfile.showOpenDialog(d);
    if( returnvalue==JFileChooser.APPROVE_OPTION)
    {
    File items= choosefromfile.getSelectedFile();
    Path i= Paths.get(items.getAbsolutePath());
            List <String> ii;
            ii=Files.readAllLines(i);
            
         for(String partsofparts :ii)
         {
           
             String[] allitem =partsofparts.split(",");
    int invoiceno= Integer.parseInt(allitem[0]);
    String nameofitem = allitem[1];
    double priceofitem = Double.parseDouble(allitem[2]);
    int c = Integer.parseInt(allitem[3]);
    
    
    Invoicetable itm =null;
    for(Invoicetable eachinvoice : table1  )
    {
        if(eachinvoice.getNo()==invoiceno)
        {
            itm=eachinvoice;
            break;
        }
    }   
    Items obje =new Items(  nameofitem,  priceofitem,  c, itm);
            
       itm.getItems().add(obje);
         }
            
            
            
    }
    
      d.setInvoicetable1(table1);
      invoicefilltable model = new invoicefilltable(table1);
      // invoicefilltable ob= new invoicefilltable(table1);
     d.setFill(model);
     d.getInvoicestable().setModel(model);
     d.getFill().fireTableDataChanged();
     
  }
    }catch(IOException x){
    
   x.printStackTrace();
    }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
     
        int selected=d.getInvoicestable().getSelectedRow(); //selected invoice
        if(selected!=-1){
            
        Invoicetable itemselected= d.getInvoicetable1().get(selected);
        d.getInvoiceno().setText(""+itemselected.getNo());
        d.getInvoicedate().setText(itemselected.getDate());
        d.getCustomername().setText(itemselected.getCustomer());
        
       d.getInvoicetotal().setText(""+itemselected.totaltable1());
       
       
       Itemsfilltable itemsfilltable=new Itemsfilltable(itemselected.getItems());
       d.getItemstable().setModel(itemsfilltable);
       itemsfilltable.fireTableDataChanged();
        }
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
   
//2 functions of creating new item
    private void itemoK() {
        
        String n =saveitem.getItemNameField().getText();
        String c =saveitem.getItemCountField().getText();
        int parsec = Integer.parseInt(c);
        String p = saveitem.getItemPriceField().getText();
        double parsep = Double.parseDouble(p);
        //double parsep = Double.parseDouble(p);
        int selected = d.getInvoicestable().getSelectedRow();
        
        if(selected!=-1){
        Invoicetable obj= d.getInvoicetable1().get(selected);
        Items item =new Items( n ,parsep , parsec, obj);
         obj.getItems().add(item);
         
         Itemsfilltable Itemsfill= (Itemsfilltable)d.getItemstable().getModel();
        // Itemsfill.getItems().add(item);
         Itemsfill.fireTableDataChanged();
         d.getFill().fireTableDataChanged();
        }
        saveitem.setVisible(false);
       saveitem.dispose();
     saveitem=null;
     
     
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void itemcancel() {
        
        
        saveitem.setVisible(false);
       saveitem.dispose();
     saveitem=null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
//2 functions for adding new invoice
    private void invoiceoK() {
        
        String date = newin.getInvDateField().getText();
       String name = newin.getCustNameField().getText();
       int number= d.getthehighestnumber();
       
       Invoicetable x = new Invoicetable(number, date, name);
       d.getInvoicetable1().add(x);
       d.getFill().fireTableDataChanged();
       newin.setVisible(false);
       newin.dispose();
       newin=null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     private void invoicecancel() {
        
       newin.setVisible(false);
       newin.dispose();
      newin=null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   }