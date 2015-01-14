package com.bros.minesweeper.presentation;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelProva extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelProva() {
		
		JLabel lblProva = new JLabel("Prova");
		lblProva.setFont(new Font("Dialog", Font.BOLD, 40));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(lblProva, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addGap(94))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(131, Short.MAX_VALUE)
					.addComponent(lblProva, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(100))
		);
		setLayout(groupLayout);

	}
}
