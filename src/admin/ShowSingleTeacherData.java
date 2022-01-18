package admin;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ShowSingleTeacherData extends JFrame {

	
	public 	String Gender;
	private JTextField textField_FirstName;
	private JTextField textField_lastName;
	private JTextField textField_Username;
	private JTextField textField_Email;
	private JTextField textField_User_Phne;
	private JTextField textField_SecurityQuestionAns;
	private JTextField textFieldDOB;
	private JTextField textField_Gender;
	private JTextField textField_Pass;

	public ShowSingleTeacherData() {
		setResizable(false);
		
		
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		setVisible(true);
		getContentPane().setFont(new Font("Calibri Light", Font.PLAIN, 13));
		getContentPane().setForeground(Color.LIGHT_GRAY);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Single Teacher Data");
		getContentPane().setLayout(null);
		setSize(413,528);
		
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
		lbl_UserPass.setBounds(31, 244, 92, 31);
		getContentPane().add(lbl_UserPass);
		
		JLabel lbl_User_Email = new JLabel("Email Address");
		lbl_User_Email.setBounds(31, 287, 92, 31);
		getContentPane().add(lbl_User_Email);
		
		JLabel lbl_securityQuestion = new JLabel("Security Answer");
		lbl_securityQuestion.setBackground(Color.WHITE);
		lbl_securityQuestion.setBounds(31, 384, 92, 35);
		getContentPane().add(lbl_securityQuestion);
		
		JLabel lbl_User_Phn = new JLabel("Phone Number");
		lbl_User_Phn.setBounds(31, 342, 92, 31);
		getContentPane().add(lbl_User_Phn);
		
		//text fields
		
		textField_FirstName = new JTextField();
		textField_FirstName.setEditable(false);
		textField_FirstName.setBounds(176, 11, 192, 39);
		getContentPane().add(textField_FirstName);
		textField_FirstName.setColumns(10);
		
		
		
		textField_lastName = new JTextField();
		textField_lastName.setEditable(false);
		textField_lastName.setColumns(10);
		textField_lastName.setBounds(176, 61, 192, 39);
		getContentPane().add(textField_lastName);
		
		textField_Username = new JTextField();
		textField_Username.setEditable(false);
		textField_Username.setColumns(10);
		textField_Username.setBounds(176, 197, 192, 39);
		getContentPane().add(textField_Username);
		
		textField_Email = new JTextField();
		textField_Email.setEditable(false);
		textField_Email.setColumns(10);
		textField_Email.setBounds(176, 290, 192, 40);
		getContentPane().add(textField_Email);
		
		textField_SecurityQuestionAns = new JTextField();
		textField_SecurityQuestionAns.setEditable(false);
		textField_SecurityQuestionAns.setColumns(10);
		textField_SecurityQuestionAns.setBounds(176, 394, 192, 40);
		getContentPane().add(textField_SecurityQuestionAns);
		
		
		textFieldDOB = new JTextField();
		textFieldDOB.setEditable(false);
		textFieldDOB.setColumns(10);
		textFieldDOB.setBounds(176, 153, 192, 35);
		getContentPane().add(textFieldDOB);
	
		
		//phone
		
		textField_User_Phne = new JTextField();
		textField_User_Phne.setEditable(false);
		textField_User_Phne.setColumns(10);
		textField_User_Phne.setBounds(176, 342, 192, 40);
		getContentPane().add(textField_User_Phne);
		
		textField_Gender = new JTextField();
		textField_Gender.setEditable(false);
		textField_Gender.setColumns(10);
		textField_Gender.setBounds(176, 111, 192, 31);
		getContentPane().add(textField_Gender);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SearchTeacher srchTch = new SearchTeacher();
				srchTch.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(139, 444, 92, 39);
		getContentPane().add(btnNewButton);
		
		textField_Pass = new JTextField();
		textField_Pass.setEditable(false);
		textField_Pass.setColumns(10);
		textField_Pass.setBounds(176, 238, 192, 40);
		getContentPane().add(textField_Pass);

	}
	
	public void showData(String Uname)
	{
		Boolean Decesion = false;
		String TF = null , TL = null, Dob= null, userName= null,  password= null, email= null, phoneNumber= null, sqAnswer = null;
		
		String query = "SELECT * FROM Teacher where Username ='"+Uname+"'";
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";
		
		try (Connection connection = DriverManager.getConnection(databaseURL)) 
		{
			
			Statement prpStm = connection.createStatement();
			ResultSet rs = prpStm.executeQuery(query);
				
		
		while(rs.next())
		{
			if(Uname.trim().equalsIgnoreCase(rs.getString("Username")))
			{
			Decesion = true;
			TF = rs.getString("First_Name");
			TL = rs.getString("Last_Name");
			Gender = rs.getString("Gender");
			Dob = rs.getString("DOB");
			userName = rs.getString("Username");
			password = rs.getString("Password");
			email = rs.getString("Email_Address");
			phoneNumber = rs.getString("Phone_number");
			sqAnswer = rs.getString("Security_Answer");
			}
			
		}
		
		if(Decesion)
		{

			
			textField_FirstName.setText(TF);
			textField_lastName.setText(TL);
			textField_Username.setText(userName);
			textField_Email.setText(email);
			textField_User_Phne.setText(phoneNumber);
			textField_SecurityQuestionAns.setText(sqAnswer);
			textFieldDOB.setText(Dob);
			textField_Gender.setText(Gender);
			textField_Pass.setText(password);
		}
		
		else
		{
			setVisible(false);
			SearchTeacher srchTch = new SearchTeacher();
			srchTch.setVisible(true);
			
		}
			System.out.println("ResultsFetched");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
