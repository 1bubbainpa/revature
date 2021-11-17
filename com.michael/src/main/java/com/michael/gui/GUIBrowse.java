package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.michael.database.AccountImplementation;
import com.michael.database.ClassImplementation;
import com.michael.models.Account;
import com.michael.models.Classes;

public class GUIBrowse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @param loginAccount 
	 */
	public GUIBrowse(Account loginAccount) 
	
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 //headers for the table this.accountid = accountid;
        String[] columns = new String[] {"Class Name", "Description", "Teacher", "Category", "Class Date", "Time Start", "Link", "ID"};
         
        //actual data for the table in a 2d array
        ClassImplementation ci = new ClassImplementation();
        List<Classes> ls = ci.selectAll();
        int count = ls.size();
        System.out.println(count);
        Object[][] data = new Object[count][8];
        
        for(int i = 0; i < count; i++)
        { 	
        	data[i][0] = ls.get(i).getClassname();
        	data[i][1] = ls.get(i).getDescription();
        	data[i][2] = ls.get(i).getFk_account();
        	data[i][3] = ls.get(i).getCategory();
        	data[i][4] = ls.get(i).getClassdate();
        	data[i][5] = ls.get(i).getTimestart();
        	data[i][6] = ls.get(i).getNotes();
        	data[i][7] = ls.get(i).getClassid();
        }
        
        System.out.println(data[0][0]);
        //create table with data
        JTable table = new JTable(data, columns);
         
        //add the table to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
         
        this.setTitle("Account Table");
        this.pack();
        this.setVisible(true);
	}

}
