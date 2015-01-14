package com.bros.minesweeper.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.util.Random;

public class PanelAux extends JPanel {

	private JugarPartidaView JPV;
	
	private JTextField textUser;
	private JPasswordField textPass;
	/**
	 * Create the panel.
	 * @param JPV 
	 */
	public PanelAux(final JugarPartidaView JPV) {
		
		this.JPV = JPV;
		
		Box verticalBox = Box.createVerticalBox();
		
		Component verticalStrut = Box.createVerticalStrut(40);
		verticalBox.add(verticalStrut);
		
		Box userField = Box.createHorizontalBox();
		verticalBox.add(userField);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(40);
		horizontalStrut_3.setMaximumSize(new Dimension(40, 0));
		userField.add(horizontalStrut_3);
		
		JLabel lblUser = new JLabel("Usuari:", SwingConstants.RIGHT);
		lblUser.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUser.setPreferredSize(new Dimension(118, 14));
		userField.add(lblUser);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setMaximumSize(new Dimension(40, 0));
		userField.add(horizontalStrut_4);
		
		textUser = new JTextField();
		textUser.setAlignmentX(Component.LEFT_ALIGNMENT);
		textUser.setFont(new Font("Arial", Font.PLAIN, 12));
		textUser.setMaximumSize(new Dimension(2147483647, 20));
		userField.add(textUser);
		textUser.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(40);
		horizontalStrut_2.setMaximumSize(new Dimension(40, 0));
		userField.add(horizontalStrut_2);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		Box passField = Box.createHorizontalBox();
		verticalBox.add(passField);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(40);
		horizontalStrut_5.setMaximumSize(new Dimension(40, 0));
		passField.add(horizontalStrut_5);
		
		JLabel lblPass = new JLabel("Password:", SwingConstants.RIGHT);
		lblPass.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPass.setPreferredSize(new Dimension(118, 14));
		passField.add(lblPass);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setMaximumSize(new Dimension(40, 0));
		passField.add(horizontalStrut_6);
		
		textPass = new JPasswordField();
		textPass.setAlignmentX(Component.LEFT_ALIGNMENT);
		textPass.setFont(new Font("Arial", Font.PLAIN, 12));
		textPass.setMaximumSize(new Dimension(2147483647, 20));
		textPass.setColumns(10);
		passField.add(textPass);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(40);
		horizontalStrut_7.setMaximumSize(new Dimension(40, 0));
		passField.add(horizontalStrut_7);
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		
		final JLabel lblMessageArea = new JLabel("");
		lblMessageArea.setForeground(new Color(165, 42, 42));
		lblMessageArea.setFont(new Font("Arial", Font.ITALIC, 12));
		lblMessageArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblMessageArea);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		Component horizontalStrut = Box.createHorizontalStrut(40);
		horizontalStrut.setMaximumSize(new Dimension(40, 0));
		horizontalBox.add(horizontalStrut);
		
		JButton btnExit = new JButton("Sortir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inici.main(null);
				//frame.dispose();
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setPreferredSize(new Dimension(118, 46));
		btnExit.setMinimumSize(new Dimension(118, 46));
		btnExit.setMaximumSize(new Dimension(118, 30));
		btnExit.setMnemonic('s');
		horizontalBox.add(btnExit);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue_2);
		
		JButton btnEntry = new JButton("Entrar");
		btnEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * TODO substituir random login per autenticaci� 
				 */
				Random r = new Random();
				float ok = r.nextFloat();
				if (ok > 0.5) {
					String[] user = new String[1];
					user[0] = "Welcome "+textUser.getText();
					menuPrincipal.main(user);
					//frame.dispose();
				}
				else {
					lblMessageArea.setText("Convinacio usuari i contraseya incorrectes");
				}
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
