package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.database.AccountImplementation;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAdminApprove extends JFrame {

	private JPanel contentPane;
	private JComboBox cbxSelecter;
	/**
	 * Create the frame.
	 */
	public GUIAdminApprove() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 216, 215);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbxSelecter = new JComboBox();
		cbxSelecter.setBounds(73, 21, 50, 22);
		contentPane.add(cbxSelecter);
		
		AccountImplementation ai = new AccountImplementation();
		List<Integer> ls = ai.SelectAllUnapproved();
		for(int i:ls)
		{
			cbxSelecter.addItem(i);
		}
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(cbxSelecter.getSelectedItem() instanceof Integer)
				{
					int approveNumber = (int) cbxSelecter.getSelectedItem();
					ai.ApproveAccount(approveNumber);
					ai.selectAccountID(approveNumber).setActivated(true);
				}
			}
		});
		btnApprove.setBounds(55, 92, 89, 23);
		contentPane.add(btnApprove);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(cbxSelecter.getSelectedItem() instanceof Integer)
				{
					int approveNumber = (int) cbxSelecter.getSelectedItem();
					ai.DeleteAccount(approveNumber);
				}
			}
		});
		btnDelete.setBounds(55, 126, 89, 23);
		contentPane.add(btnDelete);
	}
}
