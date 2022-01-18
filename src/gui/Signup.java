package gui;


import java.sql.*;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Mehran Abbas
 */



@SuppressWarnings("serial")
public class Signup extends javax.swing.JFrame {
	
	public 	String Gender;
	private JTextField textField_FirstName;
	private JTextField textField_lastName;
	private JTextField textField_Username;
	private JTextField textField_Email;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup_Gender = new ButtonGroup();
	private JTextField textField_User_Phne;
	private JTextField textField_SecurityQuestionAns;
	private JTextField textFieldYear;
	private JTextField textFieldMonth;
	private JTextField textFieldDay;
	
	
	public Signup() 
	{
		
	}	
public void SignUpScreen(String tableName) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		setVisible(true);
		setResizable(false);
		getContentPane().setFont(new Font("Calibri Light", Font.PLAIN, 13));
		getContentPane().setForeground(Color.LIGHT_GRAY);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Sign Up");
		getContentPane().setLayout(null);
		setSize(440,570);
		
		//Labels
		
		JLabel lbl_FirstName = new JLabel("First Name"); 
		lbl_FirstName.setBackground(Color.WHITE);
		lbl_FirstName.setBounds(31, 19, 92, 31);
		getContentPane().add(lbl_FirstName);
		
		JLabel lbl_LastName = new JLabel("Last Name");
		lbl_LastName.setBounds(31, 64, 92, 31);
		getContentPane().add(lbl_LastName);
		
		JLabel lbl_Gender = new JLabel("Gender");
		lbl_Gender.setBounds(31, 114, 46, 14);
		getContentPane().add(lbl_Gender);
		
		JLabel lbl_DOB = new JLabel("Date of Birth");
		lbl_DOB.setBounds(31, 150, 92, 31);
		getContentPane().add(lbl_DOB);
		
		JLabel lbl_UserName = new JLabel("User Name");
		lbl_UserName.setBounds(31, 192, 92, 31);
		getContentPane().add(lbl_UserName);
		
		JLabel lbl_UserPass = new JLabel("Password");
		lbl_UserPass.setBounds(31, 234, 92, 31);
		getContentPane().add(lbl_UserPass);
		
		JLabel lbl_User_Email = new JLabel("Email Address");
		lbl_User_Email.setBounds(31, 287, 92, 31);
		getContentPane().add(lbl_User_Email);
		
		JLabel lbl_securityQuestion = new JLabel("Please enter something  you  love. Please enter your answer below ");
		lbl_securityQuestion.setBackground(Color.WHITE);
		lbl_securityQuestion.setBounds(31, 384, 385, 35);
		getContentPane().add(lbl_securityQuestion);
		
		JLabel lbl_SecurityQuestinNote = new JLabel(" (This will be used incase of password forgotten and recovery)");
		lbl_SecurityQuestinNote.setBackground(Color.WHITE);
		lbl_SecurityQuestinNote.setBounds(31, 441, 364, 35);
		getContentPane().add(lbl_SecurityQuestinNote);
		
		JLabel lbl_DOB_1 = new JLabel("Year");
		lbl_DOB_1.setBounds(149, 150, 26, 31);
		getContentPane().add(lbl_DOB_1);
		
		JLabel lbl_DOB_1_1 = new JLabel("Month");
		lbl_DOB_1_1.setBounds(231, 150, 36, 31);
		getContentPane().add(lbl_DOB_1_1);
		
		JLabel lbl_DOB_1_2 = new JLabel("Day");
		lbl_DOB_1_2.setBounds(322, 150, 26, 31);
		getContentPane().add(lbl_DOB_1_2);
		
		JLabel lbl_User_Phn = new JLabel("Phone Number");
		lbl_User_Phn.setBounds(31, 342, 92, 31);
		getContentPane().add(lbl_User_Phn);
		
		//text fields
		
		textField_FirstName = new JTextField();
		textField_FirstName.setBounds(176, 19, 192, 25);
		getContentPane().add(textField_FirstName);
		textField_FirstName.setColumns(10);
		
		
		
		textField_lastName = new JTextField();
		textField_lastName.setColumns(10);
		textField_lastName.setBounds(176, 69, 192, 25);
		getContentPane().add(textField_lastName);
		
		textField_Username = new JTextField();
		textField_Username.setColumns(10);
		textField_Username.setBounds(176, 197, 192, 25);
		getContentPane().add(textField_Username);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(176, 290, 192, 35);
		getContentPane().add(textField_Email);
		
		textField_SecurityQuestionAns = new JTextField();
		textField_SecurityQuestionAns.setColumns(10);
		textField_SecurityQuestionAns.setBounds(31, 417, 337, 25);
		getContentPane().add(textField_SecurityQuestionAns);
		
		
		textFieldYear = new JTextField();
		textFieldYear.setColumns(10);
		textFieldYear.setBounds(176, 153, 46, 25);
		getContentPane().add(textFieldYear);
		
		textFieldMonth = new JTextField();
		textFieldMonth.setColumns(10);
		textFieldMonth.setBounds(271, 153, 46, 25);
		getContentPane().add(textFieldMonth);
		
		textFieldDay = new JTextField();
		textFieldDay.setColumns(10);
		textFieldDay.setBounds(349, 153, 46, 25);
		getContentPane().add(textFieldDay);
	
		
		//password fields
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 239, 192, 26);
		getContentPane().add(passwordField);
		
		
		textField_User_Phne = new JTextField();
		textField_User_Phne.setColumns(10);
		textField_User_Phne.setBounds(176, 343, 192, 25);
		getContentPane().add(textField_User_Phne);
		
		//Check box gender
		
		JCheckBox chckbxMale = new JCheckBox("Male");
		chckbxMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gender = "Male";
				}
		});
		buttonGroup_Gender.add(chckbxMale);
		chckbxMale.setBounds(176, 110, 54, 23);
		getContentPane().add(chckbxMale);
		

		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gender = "Female";
				
			}
		});
		buttonGroup_Gender.add(chckbxFemale);
		chckbxFemale.setBounds(232, 110, 67, 23);
		getContentPane().add(chckbxFemale);
		
		JCheckBox chckbxOther = new JCheckBox("Other");
		chckbxOther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gender = "other";
				
			}
		});
		buttonGroup_Gender.add(chckbxOther);
		chckbxOther.setBounds(301, 110, 67, 23);
		getContentPane().add(chckbxOther);
		
		
		//Buttons
		
		JButton btn_Finish = new JButton("Finish");
		if(tableName=="Teacher") 
		{
		btn_Finish.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String TF, TL, DOB, userName,  password, email, phoneNumber, sqAnswer;
				
				TF = textField_FirstName.getText();
				TL = textField_lastName.getText();
				email = textField_Email.getText();
				userName =textField_Username.getText();
			    phoneNumber =textField_User_Phne.getText();
			    sqAnswer = textField_SecurityQuestionAns.getText();
			    password   = passwordField.getText();
			    DOB = textFieldDay.getText() +"-"+textFieldMonth.getText()+"-"+textFieldYear.getText();
			    
				{
					String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

					try (Connection connection = DriverManager.getConnection(databaseURL)) {

				

						Statement s = connection.createStatement();
						s.execute("insert into Teacher (First_Name, Last_Name, Gender,DOB,UserName,Password,Email_Address,Phone_number,Security_Answer) values('" +
						TF+ "','" + TL + "','" + Gender + "','" + DOB + "','" + userName + "','" +password + "','"+email +"','" + phoneNumber + "','"+ sqAnswer+"')"); 
						
						System.out.println("Teacher Populated sucessfully");
						
						
						connection.close();

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					
					setVisible(false);
					SignUpSucess sgnUscs = new SignUpSucess();
					sgnUscs.setVisible(true);

				}
				
			}
		});
		}
		
		
		else
		{
		btn_Finish.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String TF, TL, DOB, userName,  password, email, phoneNumber, sqAnswer;
				
				TF = textField_FirstName.getText();
				TL = textField_lastName.getText();
				email = textField_Email.getText();
				userName =textField_Username.getText();
			    phoneNumber =textField_User_Phne.getText();
			    sqAnswer = textField_SecurityQuestionAns.getText();
			    password   = passwordField.getText();
			    DOB = textFieldDay.getText() +"-"+textFieldMonth.getText()+"-"+textFieldYear.getText();
			    
				{
					String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

					try (Connection connection = DriverManager.getConnection(databaseURL)) {

				

						Statement s = connection.createStatement();
						s.execute("insert into Administrator (First_Name, Last_Name, Gender,DOB,UserName,Password,Email_Address,Phone_number,Security_Answer) values('" +
						TF+ "','" + TL + "','" + Gender + "','" + DOB + "','" + userName + "','" +password + "','"+email +"','" + phoneNumber + "','"+ sqAnswer+"')"); 
						
						System.out.println("Administrator Data Populated sucessfully");
						
						connection.close();

					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					setVisible(false);
					SignUpSucess sgnUscs = new SignUpSucess();
					sgnUscs.setVisible(true);

				}
				
			}
		});
		}
		
		btn_Finish.setBackground(Color.WHITE);
		btn_Finish.setBounds(290, 487, 90, 28);
		getContentPane().add(btn_Finish);
		
		JButton btn_Cancel = new JButton("Cancel");
		btn_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
				MainScreen mnScr = new MainScreen();
				mnScr.setVisible(true);
			}
		});
		btn_Cancel.setBackground(Color.WHITE);
		btn_Cancel.setBounds(31, 487, 90, 28);
		getContentPane().add(btn_Cancel);
		
		
		}
	
	
	
}
