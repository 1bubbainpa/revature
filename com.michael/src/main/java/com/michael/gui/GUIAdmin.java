package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.models.Admin;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class GUIAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUIAdmin(Admin ad) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnView = new JButton("View Accounts");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIAdminView adv = new GUIAdminView(ad);
				adv.setVisible(true);
				//dispose();
			}
		});
		btnView.setBounds(149, 90, 130, 23);
		contentPane.add(btnView);
		
		JButton btnApprove = new JButton("Approve Accounts");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIAdminApprove ap = new GUIAdminApprove();
				ap.setVisible(true);
				//dispose();
			}
		});
		btnApprove.setBounds(149, 140, 130, 23);
		contentPane.add(btnApprove);
		
		JButton btnReturn = new JButton("<");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIMain title = new GUIMain();
				title.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(10, 227, 41, 23);
		contentPane.add(btnReturn);
	}

}
