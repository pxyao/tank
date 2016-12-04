package com.tank.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import com.sun.javafx.tk.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		super();

		setTitle("\u5766\u514B\u5927\u6218");
		setBounds(100, 100, 450, 300);
		setSize(387, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setLocationRelativeTo(null);//窗口居中显示
		{
			JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u767B\u9646\u7F51\u7EDC\u7248\u5766\u514B\u5927\u6218");
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
			lblNewLabel.setBounds(83, 13, 228, 39);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("\u540D\u5B57");
			lblNewLabel_1.setBounds(47, 52, 52, 18);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField = new JTextField();
			textField.setBounds(112, 49, 164, 24);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("\u767B\u5165");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(textField.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(Login.this,"请输入名字");
						return;
					}
					String myname=textField.getText();
					new Client().setVisible(true);
					Login.this.setVisible(false);
					Login.this.dispose();
				}
			});
			btnNewButton.setBounds(128, 109, 113, 27);
			contentPanel.add(btnNewButton);
		}
		
		JLabel lbip = new JLabel("IP\u5730\u5740");
		lbip.setBounds(47, 83, 52, 18);
		contentPanel.add(lbip);
		{
			textField_1 = new JTextField();
			textField_1.setText("192.168.1.1");
			textField_1.setBounds(112, 80, 164, 24);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
	}
}
