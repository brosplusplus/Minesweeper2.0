package com.bros.minesweeper.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class menuPrincipal {

	private JFrame frame;
	private static String missatge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (args != null && args.length == 1)
		{
			missatge = args[0];
		}
		else {
			missatge = "";
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuPrincipal window = new menuPrincipal();
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
	public menuPrincipal() {
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
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JButton btnPlay = new JButton("Jugar");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * TODO afegir funci� comprovar nivells
				 */
				seleccionaNivell.main(null);
				frame.dispose();
			}
		});
		btnPlay.setMaximumSize(new Dimension(118, 46));
		btnPlay.setPreferredSize(new Dimension(118, 46));
		btnPlay.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnPlay);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		JButton btnExit = new JButton("Logout");
		btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				identificacio.main(null);
				frame.dispose();
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setPreferredSize(new Dimension(118, 46));
		btnExit.setMinimumSize(new Dimension(118, 46));
		btnExit.setMaximumSize(new Dimension(118, 30));
		btnExit.setMnemonic('s');
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		
		final JLabel lblMessageArea = new JLabel(missatge);
		//lblMessageArea.setForeground(new Color(165, 42, 42));
		lblMessageArea.setFont(new Font("Arial", Font.ITALIC, 12));
		lblMessageArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblMessageArea);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
	}

}
