package com.bros.minesweeper.presentation;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.Box;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class PanelInici extends JPanel {

	/**
	 * Create the panel.
	 * @param JPV 
	 */
	public PanelInici(final JugarPartidaView JPV) {
		
		Box verticalBox = Box.createVerticalBox();
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalBox.add(verticalGlue);
		
		JLabel label = new JLabel("Minesweeper");
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 42));
		label.setAlignmentX(0.5f);
		verticalBox.add(label);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		JLabel label_1 = new JLabel("Bros++ ® 2014");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_1.setAlignmentX(0.5f);
		verticalBox.add(label_1);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		verticalBox.add(verticalGlue_1);
		
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
				JPV.tancar();
			}
		});
		btnExit.setPreferredSize(new Dimension(118, 46));
		btnExit.setMinimumSize(new Dimension(118, 46));
		btnExit.setMaximumSize(new Dimension(118, 30));
		btnExit.setMnemonic('s');
		horizontalBox.add(btnExit);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalBox.add(horizontalGlue);
		
		JButton btnEntry = new JButton("Entrar");
		btnEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JPV.getJPVC().PrJugar();
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
		
		JPanel panel = new JPanel();
		verticalBox.add(panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(verticalBox, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
