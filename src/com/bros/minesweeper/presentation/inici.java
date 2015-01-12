package com.bros.minesweeper.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class inici {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inici window = new inici();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public inici() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 457, 274);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box verticalBox = Box.createVerticalBox();
		frame.getContentPane().add(verticalBox, BorderLayout.CENTER);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JLabel lblTitle = new JLabel("Minesweeper");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblTitle);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		JLabel lblCompany = new JLabel("Bros++ \u00AE 2014");
		lblCompany.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCompany.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblCompany);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		Component horizontalStrut = Box.createHorizontalStrut(40);
		horizontalStrut.setMaximumSize(new Dimension(40, 0));
		horizontalBox.add(horizontalStrut);
		
		JButton btnExit = new JButton("Sortir");
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.dispose();
			}
		});
		btnExit.setPreferredSize(new Dimension(118, 46));
		btnExit.setMinimumSize(new Dimension(118, 46));
		btnExit.setMaximumSize(new Dimension(118, 30));
		btnExit.setMnemonic('s');
		horizontalBox.add(btnExit);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		JButton btnEntry = new JButton("Entrar");
		btnEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				identificacio.main(null);
				frame.dispose();
			}
		});
		btnEntry.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEntry.setMaximumSize(new Dimension(118, 30));
		btnEntry.setPreferredSize(new Dimension(118, 46));
		horizontalBox.add(btnEntry);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(40);
		horizontalStrut_1.setMaximumSize(new Dimension(40, 0));
		horizontalBox.add(horizontalStrut_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);

	}

}
