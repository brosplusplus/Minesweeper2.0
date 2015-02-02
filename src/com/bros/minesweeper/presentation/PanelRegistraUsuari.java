package com.bros.minesweeper.presentation;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class PanelRegistraUsuari extends JPanel implements IPanelAplicacio {
	private JTextField fieldName;
	private JTextField fieldSurname;
	private JTextField fieldEmail;
	private JTextField fieldUser;
	private JPasswordField passwordField;
	private JLabel lblMessageArea;
	
	
	/**
	 * Create the application.
	 */
	public PanelRegistraUsuari(final JugarPartidaView JPV) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component LeftStrut = Box.createHorizontalStrut(20);
		LeftStrut.setMaximumSize(new Dimension(20, 0));
		add(LeftStrut);
		
		Box generalVBox = Box.createVerticalBox();
		add(generalVBox);
		
		Component TopStrut = Box.createVerticalStrut(20);
		TopStrut.setMaximumSize(new Dimension(0, 20));
		generalVBox.add(TopStrut);
		
		Box FieldsHBox = Box.createHorizontalBox();
		generalVBox.add(FieldsHBox);
		
		Box FieldLeftBox = Box.createVerticalBox();
		FieldsHBox.add(FieldLeftBox);
		
		Box NameHBox = Box.createHorizontalBox();
		FieldLeftBox.add(NameHBox);
		
		JLabel lblNameField = new JLabel("Nom:");
		lblNameField.setPreferredSize(new Dimension(46, 14));
		lblNameField.setMaximumSize(new Dimension(46, 14));
		lblNameField.setMinimumSize(new Dimension(46, 14));
		NameHBox.add(lblNameField);
		
		fieldName = new JTextField();
		fieldName.setMaximumSize(new Dimension(2147483647, 25));
		NameHBox.add(fieldName);
		fieldName.setColumns(10);
		
		Component fieldSeparator1 = Box.createVerticalStrut(20);
		fieldSeparator1.setMinimumSize(new Dimension(0, 10));
		fieldSeparator1.setMaximumSize(new Dimension(0, 10));
		FieldLeftBox.add(fieldSeparator1);
		
		Box SurnameHBox = Box.createHorizontalBox();
		FieldLeftBox.add(SurnameHBox);
		
		JLabel label = new JLabel("Cognom: ");
		SurnameHBox.add(label);
		
		fieldSurname = new JTextField();
		fieldSurname.setMaximumSize(new Dimension(2147483647, 25));
		fieldSurname.setColumns(10);
		SurnameHBox.add(fieldSurname);
		
		Component fieldSeparator2 = Box.createVerticalStrut(20);
		fieldSeparator2.setMinimumSize(new Dimension(0, 10));
		fieldSeparator2.setMaximumSize(new Dimension(0, 10));
		FieldLeftBox.add(fieldSeparator2);
		
		Box EmailHBox = Box.createHorizontalBox();
		FieldLeftBox.add(EmailHBox);
		
		JLabel label_1 = new JLabel("Email:");
		label_1.setPreferredSize(new Dimension(46, 14));
		label_1.setMinimumSize(new Dimension(46, 14));
		label_1.setMaximumSize(new Dimension(46, 14));
		EmailHBox.add(label_1);
		
		fieldEmail = new JTextField();
		fieldEmail.setMaximumSize(new Dimension(2147483647, 25));
		fieldEmail.setColumns(10);
		EmailHBox.add(fieldEmail);
		
		Component fieldSeparator3 = Box.createVerticalStrut(20);
		fieldSeparator3.setMaximumSize(new Dimension(0, 10));
		FieldLeftBox.add(fieldSeparator3);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		FieldsHBox.add(horizontalStrut);
		
		Box FieldRightBox = Box.createVerticalBox();
		FieldsHBox.add(FieldRightBox);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		FieldRightBox.add(horizontalBox_1);
		
		JLabel lblUser = new JLabel("User: ");
		horizontalBox_1.add(lblUser);
		
		fieldUser = new JTextField();
		fieldUser.setMaximumSize(new Dimension(2147483647, 25));
		fieldUser.setColumns(10);
		horizontalBox_1.add(fieldUser);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setMinimumSize(new Dimension(0, 10));
		verticalStrut_1.setMaximumSize(new Dimension(0, 10));
		FieldRightBox.add(verticalStrut_1);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		FieldRightBox.add(horizontalBox_2);
		
		JLabel lblPassword = new JLabel("Pass:");
		lblPassword.setPreferredSize(new Dimension(46, 14));
		lblPassword.setMinimumSize(new Dimension(46, 14));
		lblPassword.setMaximumSize(new Dimension(46, 14));
		horizontalBox_2.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setMaximumSize(new Dimension(2147483647, 25));
		horizontalBox_2.add(passwordField);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setMaximumSize(new Dimension(0, 10));
		FieldRightBox.add(verticalStrut_2);
		
		lblMessageArea = new JLabel(" ");
		lblMessageArea.setForeground(Color.RED);
		lblMessageArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		generalVBox.add(lblMessageArea);
		
		Box ButtonHBox = Box.createHorizontalBox();
		generalVBox.add(ButtonHBox);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMinimumSize(new Dimension(118, 46));
		btnCancelar.setMaximumSize(new Dimension(118, 30));
		btnCancelar.setPreferredSize(new Dimension(118, 46));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPV.mostrarIdentificacio();
			}
		});
		ButtonHBox.add(btnCancelar);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		ButtonHBox.add(horizontalGlue);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setMinimumSize(new Dimension(118, 46));
		btnEnviar.setMaximumSize(new Dimension(118, 30));
		btnEnviar.setPreferredSize(new Dimension(118, 46));
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPV.getJPVC().newUser(fieldName.getText(), fieldSurname.getText(),
						fieldUser.getText(), passwordField.getPassword(), fieldEmail.getText());
			}
		});
		ButtonHBox.add(btnEnviar);
		
		Component BottomStrut = Box.createVerticalStrut(20);
		BottomStrut.setMaximumSize(new Dimension(0, 20));
		generalVBox.add(BottomStrut);
		
		Component RightStrut = Box.createHorizontalStrut(20);
		RightStrut.setMaximumSize(new Dimension(20, 0));
		add(RightStrut);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	}

	@Override
	public void escriuMissatge(String txt) {
		lblMessageArea.setText(txt);
	}

}
