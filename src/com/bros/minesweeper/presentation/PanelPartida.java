package com.bros.minesweeper.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

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
					.addComponent(llocTaulell, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
							.addComponent(lblMessageArea)
							.addGap(64))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnSortir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnInstruccions, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(240, Short.MAX_VALUE)
					.addComponent(lblMessageArea)
					.addGap(201)
					.addComponent(btnInstruccions, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSortir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(llocTaulell, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		GroupLayout gl_llocTaulell = new GroupLayout(llocTaulell);
		gl_llocTaulell.setHorizontalGroup(
			gl_llocTaulell.createParallelGroup(Alignment.LEADING)
				.addGap(0, 627, Short.MAX_VALUE)
		);
		gl_llocTaulell.setVerticalGroup(
			gl_llocTaulell.createParallelGroup(Alignment.LEADING)
				.addGap(0, 555, Short.MAX_VALUE)
		);
		llocTaulell.setLayout(gl_llocTaulell);
		setLayout(groupLayout);

	}
	
	private void Instruccions() {
		JOptionPane.showMessageDialog(null, "Instruccions:\n\n"
                + "  Doble Boto Esquerre --> Descobrir Casella\n"
                + "  Boto Dret 	 		 --> Marcar Casella\n"
                + "  Boto Esquerre 		 --> Demarcar Casella\n"
                + "  (nomes es poden desmarcar aquelles caselles que estaven marcades previament)"
                + " ", "Instruccions", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setTaulellJoc(int files, int columnes){
		joc = new ImageGrid(files, columnes, llocTaulell.getSize().width, llocTaulell.getSize().height);
		llocTaulell.add(joc.getPanel());
		this.setPreferredSize(llocTaulell.getPreferredSize());
	}

	@Override
	public void escriuMissatge(String txt) {
		lblMessageArea.setText(txt);
	}

	public void actualitzaCasella(ImageIcon icon, Integer casella, Color color) {
		
		JButton btn = joc.getButton(casella);
		if (icon == null) {
			btn.setIcon(null);
			btn.setOpaque(color != null);
			btn.setContentAreaFilled(color != null);
			btn.setBackground(color);
		}
		else{
			btn.setIcon(icon);
			btn.setOpaque(false);
			btn.setContentAreaFilled(false);
		}
	}

}
