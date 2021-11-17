package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.database.AccountImplementation;
import com.michael.database.UsersImplementation;
import com.michael.utilities.ProofReader;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GUICreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField tfieldFirstname;
	private JTextField tfieldLastname;
	private JTextField tfieldEmail;
	private JTextField tfieldUsername;
	private JPasswordField pfieldPassword;
	private JPasswordField pfieldConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICreateAccount frame = new GUICreateAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame and all the buttons and textfields.
	 */
	public GUICreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 410);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfieldFirstname = new JTextField();
		tfieldFirstname.setBounds(128, 94, 135, 20);
		contentPane.add(tfieldFirstname);
		tfieldFirstname.setColumns(10);
		
		JLabel lblFirstname = new JLabel("First Name:");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(39, 96, 69, 14);
		contentPane.add(lblFirstname);
		
		tfieldLastname = new JTextField();
		tfieldLastname.setColumns(10);
		tfieldLastname.setBounds(128, 151, 135, 20);
		contentPane.add(tfieldLastname);
		
		JLabel lblLastname = new JLabel("Last Name:");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastname.setBounds(39, 153, 69, 14);
		contentPane.add(lblLastname);
		
		tfieldEmail = new JTextField();
		tfieldEmail.setColumns(10);
		tfieldEmail.setBounds(128, 213, 135, 20);
		contentPane.add(tfieldEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(39, 215, 69, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEnterUsername = new JLabel("Enter Username:");
		lblEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterUsername.setBounds(308, 95, 101, 14);
		contentPane.add(lblEnterUsername);
		
		tfieldUsername = new JTextField();
		tfieldUsername.setColumns(10);
		tfieldUsername.setBounds(419, 93, 135, 20);
		contentPane.add(tfieldUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterPassword.setBounds(308, 154, 101, 14);
		contentPane.add(lblEnterPassword);
		
		JLabel lblPasswordConfirm = new JLabel("Confirm Password:");
		lblPasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPasswordConfirm.setBounds(308, 215, 101, 14);
		contentPane.add(lblPasswordConfirm);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblCreateAccount.setBounds(159, 11, 265, 46);
		contentPane.add(lblCreateAccount);
		
		pfieldPassword = new JPasswordField();
		pfieldPassword.setBounds(419, 151, 135, 20);
		contentPane.add(pfieldPassword);
		
		pfieldConfirm = new JPasswordField();
		pfieldConfirm.setBounds(419, 213, 135, 20);
		contentPane.add(pfieldConfirm);
		
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
		btnReturn.setBounds(10, 337, 41, 23);
		contentPane.add(btnReturn);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				//Verifies information and tries to make an account
				String fname = tfieldFirstname.getText();
				String lname = tfieldLastname.getText();
				String email = tfieldEmail.getText();
				
				String username = tfieldUsername.getText();
				String password = pfieldPassword.getText();
				if(pfieldPassword.getText().equals(pfieldConfirm.getText()))
				{
					boolean allgood = true;
					String[] checklist = {fname, lname, email, username, password};
					ProofReader read = new ProofReader();
					for(String s:checklist)
					{
						if(read.checkAll(s) == false)
						{
							System.out.println("For field: " + s);
							allgood = false;
							break;
						}
					}
					if(allgood)
					{
						UsersImplementation usi = new UsersImplementation();
						boolean emailChecked = usi.checkAllEmails(email);
						
						AccountImplementation ai = new AccountImplementation();
						boolean usernameChecked = ai.checkAllUsernames(username);
						
						if(emailChecked && usernameChecked)
						{
							int maxCus = usi.FindMaxInt();
							if(usi.createNewUser(maxCus, fname, lname, email) == true)
							{
								int maxAcc = ai.FindMaxInt();
								if(ai.createNewAccount(maxAcc, maxCus, username, password))
								{
									GUIConfirmed conf = new GUIConfirmed();
									conf.setVisible(true);
									dispose();
								}
								else
								{
									System.out.println("A critical Error has occured making an account");
								}
							}
							else
							{
								System.out.println("A critical Error has occured making a user.");
							}
						}
					}
				}
				else
				{
					System.out.println("Error: Password Fields do not match");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(231, 271, 118, 46);
		contentPane.add(btnNewButton);
	}
}
