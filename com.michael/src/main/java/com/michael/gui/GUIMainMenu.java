package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.models.Account;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUIMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param loginAccount 
	 */
	public GUIMainMenu(Account loginAccount) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAttend = new JButton("Attend");
		btnAttend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIBrowse br = new GUIBrowse(loginAccount);
				br.setVisible(true);
			}
		});
		btnAttend.setBounds(72, 100, 89, 23);
		contentPane.add(btnAttend);
		
		JButton btnTeach = new JButton("Teach");
		btnTeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUICreateClass cr = new GUICreateClass(loginAccount);
				cr.setVisible(true);
			}
		});
		btnTeach.setBounds(266, 100, 89, 23);
		contentPane.add(btnTeach);
		
		JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIOptions opt = new GUIOptions(loginAccount);
				opt.setVisible(true);
				dispose();
			}
		});
		btnOptions.setBounds(169, 151, 89, 23);
		contentPane.add(btnOptions);
		
		JButton btnReturn = new JButton("<");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Return to the previous JFrame and logout.
				GUIMain title = new GUIMain();
				title.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(10, 227, 41, 23);
		contentPane.add(btnReturn);
		
		JLabel lblHeader = new JLabel("Welcome, " + loginAccount.getUsername());
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblHeader.setBounds(72, 11, 283, 85);
		contentPane.add(lblHeader);
	}

}
