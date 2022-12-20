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
public class Itemsfilltable extends AbstractTableModel {
    
    
    private ArrayList<Items> items ;  //array carry items
    private String []  itemstitle ={"No.","Item Name","Item Price","Count","Item Total"};

    public Itemsfilltable(ArrayList<Items> items) {
        this.items = items;
    }

    public ArrayList<Items> getItems() {
        return items;
    }
    
    

    @Override
    public int getRowCount() {
       return items.size();
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
 return itemstitle.length;       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
Items initems =   items.get(rowIndex);


switch (columnIndex)
    {
            case 0:
            return initems.getObj().getNo();
            case 1:
            return initems.getItemname();
            case 2:
            return initems.getItemprice();
            case 3:
            return initems.getCount();
            case 4:
            return initems.getItemprice();
            default : 
                return "";
    
    }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return itemstitle[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
