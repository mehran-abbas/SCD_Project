package gui;
import admin.*;
import teacher.*;
import student.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class MainScreen extends JFrame {

	private JPanel contentPane;

	public MainScreen() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setForeground(SystemColor.textHighlight);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please select a category from below to continue");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(85, 11, 303, 33);
		contentPane.add(lblNewLabel);
		
		JButton btn_Admn = new JButton("Administrator");
		btn_Admn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
	
				Sign_In signIn = new Sign_In();
				signIn.SignInScreen("Administrator");
		
			}
		});
		btn_Admn.setForeground(SystemColor.desktop);
		btn_Admn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Admn.setBounds(85, 70, 285, 47);
		contentPane.add(btn_Admn);
		
		JButton btn_Teacher = new JButton("Teacher");
		btn_Teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Sign_In signIn = new Sign_In();
				signIn.SignInScreen("Teacher");
				
				
			}
		});
		btn_Teacher.setForeground(SystemColor.desktop);
		btn_Teacher.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Teacher.setBounds(83, 148, 287, 47);
		contentPane.add(btn_Teacher);
		
		JButton btn_Student = new JButton("Student");
		btn_Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				setVisible(false);
				StudentMenu stdMnu = new StudentMenu();
				stdMnu.setVisible(true);
				

			}
		});
		btn_Student.setForeground(SystemColor.desktop);
		btn_Student.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_Student.setBounds(85, 226, 287, 47);
		contentPane.add(btn_Student);
	}
}
