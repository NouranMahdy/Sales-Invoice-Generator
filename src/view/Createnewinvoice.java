/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author el aGaipy
 */
public class Createnewinvoice extends JDialog
{
    private JTextField custNameField;
    private JTextField invDateField;
    private JLabel custNameLbl;
    private JLabel invDateLbl;
    private JButton Btnok;
    private JButton Btncancel;

    public Createnewinvoice(DesignFrame d) {
        custNameLbl = new JLabel("Customer Name:");
        custNameField = new JTextField(30);
        invDateLbl = new JLabel("Invoice Date:");
        invDateField = new JTextField(30);
        Btnok = new JButton("OK");
        Btncancel = new JButton("Cancel");
        
        Btnok.setActionCommand("invoiceoK");
        Btncancel.setActionCommand("invoicecancel");
        
        Btnok.addActionListener(d.getListener());
        Btncancel.addActionListener(d.getListener());
        setLayout(new GridLayout(3, 4));
        
        add(invDateLbl);
        add(invDateField);
        add(custNameLbl);
        add(custNameField);
        add(Btnok);
        add(Btncancel);
        
        pack();
        
    }

    public JTextField getCustNameField() {
        return custNameField;
    }

    public JTextField getInvDateField() {
        return invDateField;
    }
    
}
