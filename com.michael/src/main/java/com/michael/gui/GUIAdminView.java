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
import com.michael.models.Account;
import com.michael.models.Admin;
import javax.swing.JButton;

public class GUIAdminView extends JFrame 
{

	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param ad 
	 */
	public GUIAdminView(Admin ad) 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		 //headers for the table this.accountid = accountid;
        String[] columns = new String[] {"Id", "Username", "Reputation", "Activated?", "User_id"};
         
        //actual data for the table in a 2d array
        AccountImplementation ai = new AccountImplementation();
        List<Account> ls = ai.SelectAll();
        int count = ls.size();
        Object[][] data = new Object[count][5];
        {
            //{1, "John", 40.0, false, 5 },
            //{2, "Rambo", 70.0, false, 5 },
            //{3, "Zorro", 60.0, true, 5 },
        };
        
        for(int i = 0; i < count; i++)
        {
        	data[i][0] = ls.get(i).getAccountid();
        	data[i][1] = ls.get(i).getUsername();
        	data[i][2] = ls.get(i).getReputation();
        	data[i][3] = ls.get(i).isActivated();
        	data[i][4] = ls.get(i).getFk_users();
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
