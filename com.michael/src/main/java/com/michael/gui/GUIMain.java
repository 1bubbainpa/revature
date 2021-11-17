package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class GUIMain extends JFrame {

	private JPanel paneMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					GUIMain frame = new GUIMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIMain() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		paneMain = new JPanel();
		paneMain.setBackground(SystemColor.activeCaption);
		paneMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(paneMain);
		paneMain.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				GUILogin login = new GUILogin();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(175, 110, 90, 35);
		paneMain.add(btnLogin);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUICreateAccount create = new GUICreateAccount();
				create.setVisible(true);
				dispose();
			}
		});
		btnCreateAccount.setBounds(160, 155, 125, 35);
		paneMain.add(btnCreateAccount);
		
		JLabel lblTitle = new JLabel("LiveBrary");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Sitka Text", Font.BOLD, 51));
		lblTitle.setBounds(85, 15, 265, 85);
		paneMain.add(lblTitle);
	}
}
