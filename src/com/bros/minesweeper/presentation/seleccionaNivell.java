package com.bros.minesweeper.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class seleccionaNivell {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seleccionaNivell window = new seleccionaNivell();
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
	public seleccionaNivell() {
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
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(40, 0));
		horizontalBox_1.add(horizontalStrut_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		horizontalBox_1.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Integer row = table.getSelectedRow();
				int ncells = table.getColumnCount();
				table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				table.setRowSelectionAllowed(true);
				for (int i = 0; i < ncells; i++)
				{
					table.changeSelection(row, i, true, false);
				}
			}
		});
		scrollPane_1.setViewportView(table);
		table.setPreferredSize(new Dimension(358, 120));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setRowHeight(30);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setBorder(UIManager.getBorder("Button.border"));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Facil", "9x9", 10},
				{"Mitja", "18x18", 40},
				{"Dificil", "36x36", 160},
				{"Personalitza", "..", ".."},
			},
			new String[] {
				"Nivell", "Mida", "Mines"
			}
		));
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(40, 0));
		horizontalBox_1.add(horizontalStrut_3);
		
		
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
				menuPrincipal.main(null);
				frame.dispose();
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
