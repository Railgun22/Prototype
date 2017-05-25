package com.prototype.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class PrototypeMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5386873504734840988L;
	private JPanel mainPanel;
	private JTextField textField;
	private int iCounterForTextField = 0;
	private int iTextYAxis = 0;
	private int iButtonYAxis = 0;
	private JButton btnAddField;
	private JButton btnPaste;
	private JButton btnPathSpecify;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrototypeMain frame = new PrototypeMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrototypeMain() {
		
		setTitle("Tool for Work");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 329);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		btnAddField = new JButton("Add Fields");
		
		btnAddField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (iCounterForTextField == 0) {
					textField.setEditable(true);
					textField.setEnabled(true);
					textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					System.out.println(textField.getBounds().y);
					iCounterForTextField++;
				} else {
					if (iCounterForTextField <= 4) {
						if (iCounterForTextField >= 4) {
							iButtonYAxis = btnPaste.getBounds().y + 20;
							btnPaste.setBounds(137, iButtonYAxis, 150, 23);
						}
						String sNewTextFieldName = "textField";
						iTextYAxis = textField.getBounds().y + 30;
						System.out.println(iTextYAxis);
						System.out.println(sNewTextFieldName);
						sNewTextFieldName = 
								sNewTextFieldName.replaceAll("[0-9]", sNewTextFieldName);
						textField = new JTextField();
						sNewTextFieldName += 
								Integer.toString(iCounterForTextField);
						textField.setName(sNewTextFieldName);
						System.out.println(sNewTextFieldName);
						textField.setBounds(20, iTextYAxis, 300, 18);
						textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						textField.setColumns(10);
						mainPanel.add(textField);
						mainPanel.revalidate();
						mainPanel.repaint();
						iCounterForTextField++;
					}
				}
			}
		});
		btnAddField.setBounds(137, 46, 150, 23);
		mainPanel.add(btnAddField);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBounds(20, 90, 300, 18);
		textField.setBorder(UIManager.getBorder(mainPanel));
		mainPanel.add(textField);
		textField.setColumns(10);
		
		btnPaste = new JButton("Paste Now");
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPaste.setBounds(137, 231, 150, 23);
		mainPanel.add(btnPaste);
		
		btnPathSpecify = new JButton("Specify the Paths");
		btnPathSpecify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileBrowserDialog dialog 
				= new FileBrowserDialog(mainPanel);
				dialog.setLocationRelativeTo(mainPanel);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnPathSpecify.setBounds(137, 9, 148, 23);
		mainPanel.add(btnPathSpecify);
	}
}
