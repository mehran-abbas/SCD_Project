package gui;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField_UName;
	private JTextField textField_SQAnswer;

	public ForgotPassword()
	{
		
	}
	
	public ForgotPassword(String tableName) 
	{
		
		setVisible(true);
		setResizable(false);
		setTitle("ForgotPassword");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Required Data");
		lblNewLabel.setBounds(28, 27, 195, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_UserName = new JLabel("User Name");
		lbl_UserName.setBounds(28, 82, 162, 31);
		contentPane.add(lbl_UserName);
		
		JLabel lbl_UserName_1 = new JLabel("Please enter something you love");
		lbl_UserName_1.setBounds(28, 145, 195, 31);
		contentPane.add(lbl_UserName_1);
		
		textField_UName = new JTextField();
		textField_UName.setBounds(257, 82, 212, 31);
		contentPane.add(textField_UName);
		textField_UName.setColumns(10);
		
		textField_SQAnswer = new JTextField();
		textField_SQAnswer.setColumns(10);
		textField_SQAnswer.setBounds(257, 145, 212, 31);
		contentPane.add(textField_SQAnswer);
		
		JButton btn_ResetPass = new JButton("Reset Password");
		
		if(tableName=="Administrator")
		{
			
		btn_ResetPass.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				
				
					Boolean decesion = false;
					String Uname =textField_UName.getText();
					String SqAns = textField_SQAnswer.getText();
					
					String Query ="Select Username, Security_Answer From Administrator ";

					String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

					try (Connection connection = DriverManager.getConnection(databaseURL)) {

						System.out.println("COnnection Exstablished");

						Statement statement = connection.createStatement();
						 ResultSet rs = statement.executeQuery(Query);
						 
				       {		      
				         while(rs.next())
				         {
				        	 if(rs.getString("Username").trim().equalsIgnoreCase(Uname) && rs.getString("Security_Answer").trim().equals(SqAns) ) 
				        	 {
				        		 decesion = true;
				        	 }
				        	
				         }
				       }
					}
						
					
					 catch (SQLException ex) {
						ex.printStackTrace();
					}
			
					if(decesion==true)
					{
						setVisible(false);
						@SuppressWarnings("unused")
						ResetPassword rstPass = new ResetPassword(tableName,Uname);
						
					
					}
					
					else
					{
						textField_UName.setText("");
						textField_SQAnswer.setText("");
						ErrorForgetPass efp = new ErrorForgetPass();
						efp.setVisible(true);
					}
									
			}
		});
		}
		
		else
		{
			
		btn_ResetPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					Boolean decesion = false;
					String Uname =textField_UName.getText();
					String SqAns = textField_SQAnswer.getText();
					
					String Query ="Select Username, Security_Answer From Teacher";

					String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

					try (Connection connection = DriverManager.getConnection(databaseURL)) {

						System.out.println("COnnection Exstablished");

						Statement statement = connection.createStatement();
						 ResultSet rs = statement.executeQuery(Query);
						 
				       {		      
				         while(rs.next())
				         {
				        	 if(rs.getString("Username").trim().equalsIgnoreCase(Uname) && rs.getString("Security_Answer").trim().equals(SqAns) ) 
				        	 {
				        		 decesion = true;
				        	 }
				        	
				         }
				       }
					}
						
					
					 catch (SQLException ex) {
						ex.printStackTrace();
					}
			
					if(decesion==true)
					{
						setVisible(false);
						ResetPassword rstPass = new ResetPassword(tableName,Uname);
						rstPass.setVisible(true);
					
					}
					
					else
					{
						textField_UName.setText("");
						textField_SQAnswer.setText("");
						ErrorForgetPass efp = new ErrorForgetPass();
						efp.setVisible(true);
						
					}
									
			}
		});
		}
		
		btn_ResetPass.setBounds(302, 219, 133, 31);
		contentPane.add(btn_ResetPass);
		
		JButton btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				MainScreen mnScr = new MainScreen();
				mnScr.setVisible(true);
				
				
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
