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
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;

public class PanelPartida extends JPanel implements IPanelAplicacio{
	
	private JPanel llocTaulell;
	private ImageGrid joc;
	private JLabel lblMessageArea;
	/**
	 * Create the panel.
	 * @param JPV 
	 */
	public PanelPartida(final JugarPartidaView JPV) {
		
		lblMessageArea = new JLabel("Comencem?");
		lblMessageArea.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JButton btnSortir = new JButton("Sortir");
		btnSortir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPV.tancar();
			}
		});
		
		llocTaulell = new JPanel();
		llocTaulell.setSize(new Dimension(540, 540));
		llocTaulell.setMinimumSize(new Dimension(160, 160));
		
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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(llocTaulell, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnInstruccions, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
								.addComponent(btnSortir, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(96)
							.addComponent(lblMessageArea)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(llocTaulell, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(180)
							.addComponent(lblMessageArea)
							.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
							.addComponent(btnInstruccions, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSortir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(23))
		);
		GroupLayout gl_llocTaulell = new GroupLayout(llocTaulell);
		gl_llocTaulell.setHorizontalGroup(
			gl_llocTaulell.createParallelGroup(Alignment.LEADING)
				.addGap(0, 390, Short.MAX_VALUE)
		);
		gl_llocTaulell.setVerticalGroup(
			gl_llocTaulell.createParallelGroup(Alignment.LEADING)
				.addGap(0, 349, Short.MAX_VALUE)
		);
		llocTaulell.setLayout(gl_llocTaulell);
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
		llocTaulell.add(joc.getPanel());
	}

	@Override
	public void escriuMissatge(String txt) {
		lblMessageArea.setText(txt);
	}
}
