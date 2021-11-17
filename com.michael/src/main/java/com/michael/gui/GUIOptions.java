package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.database.AccountImplementation;
import com.michael.database.UsersImplementation;
import com.michael.models.Account;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Window;

public class GUIOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param loginAccount 
	 */
	public GUIOptions(Account loginAccount) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditAccount = new JButton("Edit Account");
		btnEditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIChangeOptions chan = new GUIChangeOptions(loginAccount);
				chan.setVisible(true);
				dispose();
			}
		});
		btnEditAccount.setBounds(142, 110, 120, 23);
		contentPane.add(btnEditAccount);
		
		final JRadioButton rbtnConfirmdelete = new JRadioButton("Are you sure?");
		rbtnConfirmdelete.setBackground(SystemColor.activeCaption);
		rbtnConfirmdelete.setEnabled(false);
		rbtnConfirmdelete.setBounds(148, 200, 110, 23);
		contentPane.add(rbtnConfirmdelete);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Makes the confirmation accessible if hit once
				//Once that is confirmed, deletes the account.
				//And then returns to the opening screen.
				if(rbtnConfirmdelete.isSelected())
				{
					UsersImplementation usi = new UsersImplementation();
					AccountImplementation ai = new AccountImplementation();
					int f = loginAccount.getFk_users();
					ai.DeleteAccount(loginAccount.getAccountid());
					usi.deleteUser(f);
					
					GUIMain title = new GUIMain();
					title.setVisible(true);
					dispose();
				}
				else
				{
					rbtnConfirmdelete.setEnabled(true);
				}
			}
		});
		btnDeleteAccount.setForeground(Color.RED);
		btnDeleteAccount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeleteAccount.setBounds(142, 160, 120, 23);
		contentPane.add(btnDeleteAccount);
		
		JButton btnReturn = new JButton("<");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIMainMenu menu = new GUIMainMenu(loginAccount);
				menu.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(10, 227, 41, 23);
		contentPane.add(btnReturn);
		
		JButton btnView = new JButton("About Account");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GUIAbout ab = new GUIAbout(loginAccount);
				ab.setVisible(true);
				dispose();
			}
		});
		btnView.setBounds(142, 60, 120, 23);
		contentPane.add(btnView);
	}
}
