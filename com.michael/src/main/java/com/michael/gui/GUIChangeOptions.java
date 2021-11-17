package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.database.AccountImplementation;
import com.michael.database.UsersImplementation;
import com.michael.models.Account;
import com.michael.utilities.ProofReader;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class GUIChangeOptions extends JFrame {

	private JPanel contentPane;
	private JTextField tfieldUsername;
	private JTextField tfieldEmail;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param loginAccount 
	 */
	public GUIChangeOptions(Account loginAccount) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfieldUsername = new JTextField();
		tfieldUsername.setBounds(30, 96, 140, 20);
		contentPane.add(tfieldUsername);
		tfieldUsername.setColumns(10);
		
		JLabel lblUpdater = new JLabel("");
		lblUpdater.setForeground(Color.GREEN);
		lblUpdater.setBounds(127, 184, 227, 20);
		contentPane.add(lblUpdater);
		
		JLabel lblUsername = new JLabel("Change Username");
		lblUsername.setBounds(30, 75, 119, 14);
		contentPane.add(lblUsername);
		
		JButton btnUsername = new JButton("Update");
		btnUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String uchange = tfieldUsername.getText();
				ProofReader read = new ProofReader();
				if(read.checkAll(uchange))
				{
					AccountImplementation ai = new AccountImplementation();
					if(ai.checkAllUsernames(uchange))
					{
						ai.ChangeUsername(uchange, loginAccount);
						loginAccount.setUsername(uchange);
						lblUpdater.setText("Username successfully updated");
					}
				}
			}
		});
		btnUsername.setBounds(60, 127, 89, 23);
		contentPane.add(btnUsername);
		
		JLabel lblEmail = new JLabel("Change Email");
		lblEmail.setBounds(260, 75, 140, 14);
		contentPane.add(lblEmail);
		
		tfieldEmail = new JTextField();
		tfieldEmail.setColumns(10);
		tfieldEmail.setBounds(260, 96, 140, 20);
		contentPane.add(tfieldEmail);
		
		JButton btnEmail = new JButton("Update");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String echange = tfieldEmail.getText();
				ProofReader read = new ProofReader();
				if(read.checkAll(echange))
				{
					UsersImplementation usi = new UsersImplementation();
					if(usi.checkAllEmails(echange))
					{
						//usi.selectUserID(loginAccount.getFk_users());
						usi.ChangeEmail(echange, usi.selectUserID(loginAccount.getFk_users()));
						lblUpdater.setText("Email successfully updated");
					}
				}
			}
		});
		btnEmail.setBounds(287, 127, 89, 23);
		contentPane.add(btnEmail);
		
		JButton btnReturn = new JButton("<");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIOptions opt = new GUIOptions(loginAccount);
				opt.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(10, 227, 41, 23);
		contentPane.add(btnReturn);
	}
}
