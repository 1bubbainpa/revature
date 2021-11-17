package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.database.AccountImplementation;
import com.michael.database.AdminImplementation;
import com.michael.models.Account;
import com.michael.models.Admin;
import com.michael.utilities.ProofReader;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;

public class GUILogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfieldUsername;
	private JPasswordField pfieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					GUILogin frame = new GUILogin();
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
	public GUILogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(34, 50, 68, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(34, 122, 68, 20);
		contentPane.add(lblPassword);
		
		tfieldUsername = new JTextField();
		tfieldUsername.setBounds(112, 50, 251, 20);
		contentPane.add(tfieldUsername);
		tfieldUsername.setColumns(10);
		
		pfieldPassword = new JPasswordField();
		pfieldPassword.setBounds(112, 122, 251, 20);
		contentPane.add(pfieldPassword);
		
		JRadioButton btnAdminLogin = new JRadioButton("Login as admin");
		btnAdminLogin.setBackground(SystemColor.activeCaption);
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAdminLogin.setBounds(349, 231, 79, 23);
		contentPane.add(btnAdminLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Verifies information and tries to login
				String username = tfieldUsername.getText();
				@SuppressWarnings("deprecation")
				String password = pfieldPassword.getText();
				ProofReader read = new ProofReader();
				
				if(read.checkAll(username) == true && read.checkAll(password) == true)
				{
					if(btnAdminLogin.isSelected())
					{
						//Attempt to login as Admin
						AdminImplementation adm = new AdminImplementation();
						Admin adminlogin = adm.adminLogin(username, password);
						if(adminlogin.getUsername().equals(username) && adminlogin.getPassword().equals(password))
						{
							GUIAdmin admin = new GUIAdmin(adminlogin);
							admin.setVisible(true);
							dispose();
						}
						else
						{
							System.out.println("Error: Invalid Credentials");
						}
					}
					else
					{
						//Attempt to login as User
						AccountImplementation ai = new AccountImplementation();
						Account loginAccount = ai.StandardLogin(username, password);
						try
						{
							if(loginAccount.getUsername().equals(username) && loginAccount.getPasscode().equals(password))
							{
								if(loginAccount.isActivated() == true)
								{
									GUIMainMenu menu = new GUIMainMenu(loginAccount);
									menu.setVisible(true);
									dispose();
								}
								else
								{
									GUIConfirmed conf = new GUIConfirmed();
									conf.setVisible(true);
									dispose();
								}
							}
							else
							{
								System.out.println("Error: Invalid Credentials");
							}
						}catch(NullPointerException err) 
						{
							System.out.println("Error: Invalid Credentials");
						}
					}
				}
			}
		});
		
		btnLogin.setBounds(175, 191, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReturn = new JButton("<");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Return to the previous JFrame.
				GUIMain title = new GUIMain();
				title.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(10, 227, 41, 23);
		contentPane.add(btnReturn);
	}
}
