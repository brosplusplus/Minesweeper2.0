package com.bros.minesweeper.presentation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

public class PanelAux extends JPanel {

	private JugarPartidaView JPV;
	/**
	 * Create the panel.
	 * @param JPV 
	 */
	public PanelAux(final JugarPartidaView JPV) {
		
		this.JPV = JPV;
		
		setForeground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		
		Box verticalBox = Box.createVerticalBox();
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
				JPV.tancar();
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

	}

}
