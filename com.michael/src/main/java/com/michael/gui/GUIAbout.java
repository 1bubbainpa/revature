package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.database.AccountImplementation;
import com.michael.database.UsersImplementation;
import com.michael.models.Account;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAbout extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUIAbout(Account acc) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblHeader = new JLabel("My Account");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHeader.setBounds(168, 11, 151, 35);
		contentPane.add(lblHeader);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(94, 53, 90, 23);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(94, 87, 90, 23);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(94, 121, 90, 23);
		contentPane.add(lblUsername);
		
		JLabel lblReputation = new JLabel("Reputation:");
		lblReputation.setBounds(94, 155, 90, 23);
		contentPane.add(lblReputation);
		
		JLabel lblID = new JLabel("Account ID:");
		lblID.setBounds(94, 189, 90, 23);
		contentPane.add(lblID);
		
		UsersImplementation usi = new UsersImplementation();
		AccountImplementation ai = new AccountImplementation();
		
		int cuskey = acc.getFk_users();
		String NameField = usi.GetFullName(cuskey);
		JLabel lblNameField = new JLabel(NameField);
		lblNameField.setBounds(255, 53, 169, 23);
		contentPane.add(lblNameField);
		
		String EmailField = usi.selectUserID(cuskey).getEmail();
		JLabel lblEmailField = new JLabel(EmailField);
		lblEmailField.setBounds(255, 87, 169, 23);
		contentPane.add(lblEmailField);
		
		String UserField = acc.getUsername();
		JLabel lblUsernameField = new JLabel(UserField);
		lblUsernameField.setBounds(255, 121, 169, 23);
		contentPane.add(lblUsernameField);
		
		String RepField = String.valueOf(acc.getReputation());
		JLabel lblReputationField = new JLabel(RepField);
		lblReputationField.setBounds(255, 155, 169, 23);
		contentPane.add(lblReputationField);
		
		String IDField = String.valueOf(acc.getAccountid());
		JLabel lblIDField = new JLabel(IDField);
		lblIDField.setBounds(255, 189, 169, 23);
		contentPane.add(lblIDField);
		
		JButton btnReturn = new JButton("<");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIOptions opt = new GUIOptions(acc);
				opt.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(10, 227, 41, 23);
		contentPane.add(btnReturn);
	}

}
