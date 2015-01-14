package com.bros.minesweeper.presentation;

import javax.swing.JPanel;
import javax.swing.Box;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.bros.minesweeper.utils.debug;

public class PanelLogin extends JPanel implements IPanelAplicacio{
	
	public JLabel lblMessageArea;
	/**
	 * Create the panel.
	 * @param JPV 
	 */
	public PanelLogin(final JugarPartidaView JPV) {
		
		Box verticalBox = Box.createVerticalBox();
		
		Component verticalStrut = Box.createVerticalStrut(40);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		Component horizontalStrut = Box.createHorizontalStrut(40);
		horizontalStrut.setMaximumSize(new Dimension(40, 0));
		horizontalBox.add(horizontalStrut);
		
		JLabel label = new JLabel("Usuari:", SwingConstants.RIGHT);
		label.setPreferredSize(new Dimension(118, 14));
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		horizontalBox.add(label);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setMaximumSize(new Dimension(40, 0));
		horizontalBox.add(horizontalStrut_1);
		
		final JTextField textField = new JTextField();
		textField.setMaximumSize(new Dimension(2147483647, 20));
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setAlignmentX(0.0f);
		horizontalBox.add(textField);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(40);
		horizontalStrut_2.setMaximumSize(new Dimension(40, 0));
		horizontalBox.add(horizontalStrut_2);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(40);
		horizontalStrut_3.setMaximumSize(new Dimension(40, 0));
		horizontalBox_1.add(horizontalStrut_3);
		
		JLabel label_1 = new JLabel("Password:", SwingConstants.RIGHT);
		label_1.setPreferredSize(new Dimension(118, 14));
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		horizontalBox_1.add(label_1);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setMaximumSize(new Dimension(40, 0));
		horizontalBox_1.add(horizontalStrut_4);
		
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setMaximumSize(new Dimension(2147483647, 20));
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 12));
		passwordField.setColumns(10);
		passwordField.setAlignmentX(0.0f);
		horizontalBox_1.add(passwordField);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(40);
		horizontalStrut_5.setMaximumSize(new Dimension(40, 0));
		horizontalBox_1.add(horizontalStrut_5);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		lblMessageArea = new JLabel("");
		lblMessageArea.setForeground(new Color(165, 42, 42));
		lblMessageArea.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblMessageArea.setAlignmentX(0.5f);
		verticalBox.add(lblMessageArea);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(40);
		horizontalStrut_6.setMaximumSize(new Dimension(40, 0));
		horizontalBox_2.add(horizontalStrut_6);
		
		JButton btnExit = new JButton("Sortir");
		horizontalBox_2.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPV.tancar();
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setPreferredSize(new Dimension(118, 46));
		btnExit.setMinimumSize(new Dimension(118, 46));
		btnExit.setMaximumSize(new Dimension(118, 30));
		btnExit.setMnemonic('s');
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox_2.add(horizontalGlue);
		
		JButton btnEntry = new JButton("Entrar");
		horizontalBox_2.add(btnEntry);
		btnEntry.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				JPV.getJPVC().PrEntrar(textField.getText(), passwordField.getText());
			}
		});
		btnEntry.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEntry.setMaximumSize(new Dimension(118, 30));
		btnEntry.setPreferredSize(new Dimension(118, 46));
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(40);
		horizontalStrut_7.setMaximumSize(new Dimension(40, 0));
		horizontalBox_2.add(horizontalStrut_7);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(verticalBox, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
	
	@Override
	public void escriuMissatge(String txt) {
		lblMessageArea.setText(txt);
	}
}
