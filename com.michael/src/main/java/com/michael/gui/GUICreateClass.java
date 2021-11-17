package com.michael.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.michael.database.ClassImplementation;
import com.michael.models.Account;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.awt.event.ActionEvent;

public class GUICreateClass extends JFrame {

	private JPanel contentPane;
	private JTextField tfieldName;
	private JTextField tfieldDescription;
	private JTextField tfieldCategory;
	private JTextField tfieldDate;
	private JTextField tfieldTime;
	private JTextField tfieldNotes;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param loginAccount 
	 */
	public GUICreateClass(Account loginAccount) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Class Name:");
		lblName.setBounds(30, 50, 129, 30);
		contentPane.add(lblName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(30, 91, 129, 30);
		contentPane.add(lblDescription);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(30, 132, 129, 30);
		contentPane.add(lblCategory);
		
		JLabel lblDate = new JLabel("Date (YEAR-MONTH-DAY):");
		lblDate.setBounds(30, 173, 208, 30);
		contentPane.add(lblDate);
		
		JLabel lblTimehourminutesecond = new JLabel("Time (HOUR:MINUTE:SECOND):");
		lblTimehourminutesecond.setBounds(30, 214, 208, 30);
		contentPane.add(lblTimehourminutesecond);
		
		JLabel lblTimeZoomLink = new JLabel("Zoom Link:");
		lblTimeZoomLink.setBounds(30, 255, 208, 30);
		contentPane.add(lblTimeZoomLink);
		
		tfieldName = new JTextField();
		tfieldName.setBounds(242, 55, 184, 20);
		contentPane.add(tfieldName);
		tfieldName.setColumns(10);
		
		tfieldDescription = new JTextField();
		tfieldDescription.setColumns(10);
		tfieldDescription.setBounds(242, 96, 184, 20);
		contentPane.add(tfieldDescription);
		
		tfieldCategory = new JTextField();
		tfieldCategory.setColumns(10);
		tfieldCategory.setBounds(242, 137, 184, 20);
		contentPane.add(tfieldCategory);
		
		tfieldDate = new JTextField();
		tfieldDate.setColumns(10);
		tfieldDate.setBounds(242, 178, 184, 20);
		contentPane.add(tfieldDate);
		
		tfieldTime = new JTextField();
		tfieldTime.setColumns(10);
		tfieldTime.setBounds(242, 219, 184, 20);
		contentPane.add(tfieldTime);
		
		tfieldNotes = new JTextField();
		tfieldNotes.setColumns(10);
		tfieldNotes.setBounds(166, 260, 260, 20);
		contentPane.add(tfieldNotes);
		
		JButton btnCreate = new JButton("Create Class");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String name = tfieldName.getText();
				String description = tfieldDescription.getText();
				String category = tfieldCategory.getText();
				String day = tfieldDate.getText();
				String time = tfieldTime.getText();
				String notes = tfieldNotes.getText();
				
				ClassImplementation ci = new ClassImplementation();
				int max = ci.findMaxInt();
				ci.createClass(max, loginAccount.getAccountid(), name, day, time,
						category, description, notes);
			}
		});
		btnCreate.setBounds(137, 343, 160, 65);
		contentPane.add(btnCreate);
	}

}
