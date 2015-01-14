package com.bros.minesweeper.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

public class PanelMenuPrincipal extends JPanel implements IPanelAplicacio{

	JLabel lblBenvingut;
	public JLabel lblMessageArea;
	/**
	 * Create the panel.
	 * @param JPV 
	 */
	public PanelMenuPrincipal(final JugarPartidaView JPV) {
		
		Box verticalBox = Box.createVerticalBox();
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		lblBenvingut = new JLabel("Benvingut, ");
		lblBenvingut.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBenvingut.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblBenvingut);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		lblMessageArea = new JLabel("");
		
		JButton btnPlay = new JButton("Jugar");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPV.getJPVC().PrAccioJugar();
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
				JPV.logout();
			}
		});
		btnExit.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExit.setPreferredSize(new Dimension(118, 46));
		btnExit.setMinimumSize(new Dimension(118, 46));
		btnExit.setMaximumSize(new Dimension(118, 30));
		btnExit.setMnemonic('s');
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_2);
		
		lblMessageArea.setBackground(Color.LIGHT_GRAY);
		lblMessageArea.setForeground(new Color(178, 34, 34));
		//lblMessageArea.setForeground(new Color(165, 42, 42));
		lblMessageArea.setFont(new Font("Arial", Font.ITALIC, 12));
		lblMessageArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		verticalBox.add(lblMessageArea);
		

		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(verticalBox, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	public void setNomUsuari(String usuari) {
		lblBenvingut.setText("Benvingut, "+usuari);
	}

	@Override
	public void escriuMissatge(String txt) {
		lblMessageArea.setText(txt);
	}

}
