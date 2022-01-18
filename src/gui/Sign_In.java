package gui;
import admin.*;
import teacher.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings("serial")
public class Sign_In extends JFrame {
	
	private JPanel contentPane;
	
	
	public Sign_In() {
		setAlwaysOnTop(true);
	}	
	
	
	public void SignInScreen(String tableName) {

		setVisible(true);
		setResizable(false);
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		setFont(new Font("Calibri Light", Font.PLAIN, 13));
		setForeground(SystemColor.textHighlight);
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textField_UserName = new TextField();
		textField_UserName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_UserName.setBackground(Color.WHITE);
		textField_UserName.setBounds(130, 31, 275, 29);
		contentPane.add(textField_UserName);
		
		JPasswordField	passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setEchoChar('*');
		passwordField.setBounds(130, 86, 275, 29);
		contentPane.add(passwordField);
		
		Label label_Username = new Label("User Name");
		label_Username.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_Username.setAlignment(Label.CENTER);
		label_Username.setBounds(10, 31, 77, 29);
		contentPane.add(label_Username);
		
		Label label_Password = new Label("Password");
		label_Password.setFont(new Font("Calibri", Font.PLAIN, 13));
		label_Password.setAlignment(Label.CENTER);
		label_Password.setBounds(10, 86, 77, 29);
		contentPane.add(label_Password);
		//contentPane.setVisible(true);
		
		
		JButton btnLogIn = new JButton("Login");
		if(tableName.equals("Administrator"))
		{
			setTitle("Log In Admin");
							
		btnLogIn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			
				String Uname =textField_UserName.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				Boolean decesion=false;				

				String Query ="Select Username, Password From Administrator ";

				String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

				try (Connection connection = DriverManager.getConnection(databaseURL)) {

					System.out.println("COnnection Exstablished");

					Statement statement = connection.createStatement();
					 ResultSet rs = statement.executeQuery(Query);
					 
			       		      
			         while(rs.next())
			         {
		        	
			        	 if(Uname.trim().equals(rs.getString("Username")) && pass.trim().equals(rs.getString("Password"))) 
			        	 {
			        		 decesion = true;
			        	 }
			        	 
			        	
			         }
			       
				}
					
				
				 catch (SQLException ex) {
					ex.printStackTrace();
				}
		
				if(decesion)
				{
				setVisible(false);
				System.out.println("Login Successfull");
				AdminMenu admMnuu = new AdminMenu();
				admMnuu.setVisible(true);
				}
				
				else
				{
					setVisible(false);
			System.out.println("Login Unsuccessful");
					LoginError lgnEr = new LoginError("Administrator");
					lgnEr.setVisible(true);
				}
			}
		});
		}
		
		
		else
		{
			setTitle("Log In Teacher"); 
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					
					String Uname =textField_UserName.getText();
					@SuppressWarnings("deprecation")
					String pass = passwordField.getText();
					Boolean decesion= false;
					String Query ="Select Username, Password From Teacher ";

					String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

					try (Connection connection = DriverManager.getConnection(databaseURL)) {

						System.out.println("COnnection Exstablished");

						Statement statement = connection.createStatement();
						 ResultSet rs = statement.executeQuery(Query);
						 
				       	      
				         while(rs.next())
				         {
				        	 System.out.println(rs.getString("Username"));
				        	 System.out.println(rs.getString("Password"));
				        	 
				        	 if(Uname.trim().equals(rs.getString("Username")) && pass.trim().equals(rs.getString("Password")))
				        	 {
				        		 decesion = true;
				        	 }
				        	 
				        	 
				         }
				       
					}
						
					
					 catch (SQLException ex) {
						ex.printStackTrace();
					}
			
					if(decesion)
					{
					setVisible(false);
					System.out.println("Login Successfull");
					TeachersMenu tchMnu = new TeachersMenu();
					tchMnu.setVisible(true);
					
					}
					
					else
					{
						setVisible(false);
				System.out.println("Login Unsuccessfull");
						LoginError lgnEr = new LoginError("Teacher");
						lgnEr.setVisible(true);
					}
				}
			});
		}
		
		btnLogIn.setBounds(115, 159, 106, 23);
		contentPane.add(btnLogIn);
		
		
		
		JButton btnSign_Up = new JButton("Sign up");
		btnSign_Up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signup sgnUp = new Signup();
				
				sgnUp.SignUpScreen(tableName);
			}
		});
		btnSign_Up.setBounds(299, 227, 106, 23);
		contentPane.add(btnSign_Up);
		
	
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				setVisible(false);
				ForgotPassword frgPass = new ForgotPassword(tableName);
				frgPass.setVisible(true);
			}
		});
		btnForgotPassword.setBounds(267, 159, 138, 23);
		contentPane.add(btnForgotPassword);
		
		
		JButton btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				MainScreen mnScr = new MainScreen();
				mnScr.setVisible(true);
				
				
			}
		});
		btnBack.setBounds(115, 227, 89, 23);
		contentPane.add(btnBack);
		
		
		
	}
	

}
