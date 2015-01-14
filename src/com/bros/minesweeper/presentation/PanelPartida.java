package com.bros.minesweeper.presentation;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;

public class PanelPartida extends JPanel {
	
	private JPanel llocTaulell;
	private ImageGrid joc;
	/**
	 * Create the panel.
	 * @param JPV 
	 */
	public PanelPartida(final JugarPartidaView JPV) {
		
		JLabel lblMessageArea = new JLabel("Comencem?");
		lblMessageArea.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JButton btnSortir = new JButton("Sortir");
		btnSortir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPV.tancar();
			}
		});
		
		llocTaulell = new JPanel();
		
		JButton btnInstruccions = new JButton("Instruccions");
		btnInstruccions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Instruccions();
			}
		});
		btnInstruccions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		Box horizontalBox = Box.createHorizontalBox();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(llocTaulell, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnSortir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnInstruccions, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(24))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMessageArea)
									.addGap(43))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(llocTaulell, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addComponent(lblMessageArea)
							.addGap(56)
							.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
							.addComponent(btnInstruccions, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSortir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		setLayout(groupLayout);

	}
	
	private void Instruccions() {
		JOptionPane.showMessageDialog(null, "Instruccions:\n\n"
                + "  Doble Boto Dret --> Descobrir Casella\n"
                + "  Boto Esquerre 	 --> Marcar Casella\n"
                + "  Boto Dret 		 --> Demarcar Casella\n"
                + "  (nomes es poden desmarcar aquelles caselles que estaven marcades previament)"
                + " ", "Instruccions", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setTaulellJoc(int files, int columnes){
		joc = new ImageGrid(files, columnes, llocTaulell.getSize().width, llocTaulell.getSize().height);
		llocTaulell = joc.getPanel();
		//llocTaulell.add(joc.getPanel());
	}
}
