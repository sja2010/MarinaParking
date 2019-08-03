package psu.edu.IST311.TeamProject;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.example.tika.UIMain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame{    
	private Login frame;
	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField tfPassword;


	public Login() {
		super("Chesapeake Bay Marina Login");
		setSize(1000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1650,1080);
		//setBounds(100, 100, 643, 522);
	
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChesapeakeBayMarina = new JLabel("Chesapeake Bay Marina");
		lblChesapeakeBayMarina.setFont(new Font("Sitka Text", Font.BOLD, 42));
		lblChesapeakeBayMarina.setForeground(new Color(139, 69, 19));
		lblChesapeakeBayMarina.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		lblChesapeakeBayMarina.setBounds(295, 73, 579, 60);
		contentPane.add(lblChesapeakeBayMarina);
		
		JLabel lblImage = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/CB_Logoupdated.png")).getImage();
		lblImage.setIcon(new ImageIcon(img));
		lblImage.setBounds(393, 155, 204, 180);
		contentPane.add(lblImage);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(359, 412, 92, 14);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(461, 399, 183, 32);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(359, 449, 79, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  /*String uname=tfUsername.getText();
				  String password=tfPassword.getText();*/
				  
				  String uname=tfUsername.getText();
				  String password=tfPassword.getText();
				  if (uname.equals("baymarina") && password.equals("baymarina")) 
				  {
					  InterfaceMain mainGui=new InterfaceMain();
					  mainGui.setVisible(true);
					  mainGui.setLocationRelativeTo(null);
					  dispose();
				  }
				  else{
					  JOptionPane.showMessageDialog(null, "Invalid Userrname and/or Password. Please try again.", "", JOptionPane.INFORMATION_MESSAGE);
				  }
			}
		});
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(461, 496, 79, 36);
		contentPane.add(btnLogin);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(461, 442, 183, 32);
		contentPane.add(tfPassword);
	}
	
	public static void main(String[] args) {
		
		Login frame = new Login();
		frame.setSize(1000,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
}
