package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings("serial")
public class ResetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField_NewPassword;
	private JTextField textField_ConfirmNewPass;

public ResetPassword ()

               {
	                 }
	
	public ResetPassword(String tableName, String Uname) {
		setVisible(true);
		setTitle("Reset Password");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Required Data");
		lblNewLabel.setBounds(10, 11, 188, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_NewPassword = new JLabel("New Password");
		lbl_NewPassword.setBounds(10, 66, 110, 31);
		contentPane.add(lbl_NewPassword);
		
		JLabel lbl_ConfirmPassword = new JLabel("Confirm Password");
		lbl_ConfirmPassword.setBounds(10, 129, 110, 31);
		contentPane.add(lbl_ConfirmPassword);
		
		textField_NewPassword = new JTextField();
		textField_NewPassword.setColumns(10);
		textField_NewPassword.setBounds(166, 71, 240, 31);
		contentPane.add(textField_NewPassword);
		
		textField_ConfirmNewPass = new JTextField();
		textField_ConfirmNewPass.setColumns(10);
		textField_ConfirmNewPass.setBounds(166, 134, 240, 31);
		contentPane.add(textField_ConfirmNewPass);
		
		JButton btn_ResetPass = new JButton("Reset Password");
		if(tableName =="Administrator")
		{
		btn_ResetPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pass, cnpass;
				pass = textField_NewPassword.getText(); 
				cnpass = textField_ConfirmNewPass.getText(); 
				
				if(pass.equals(cnpass))
				{
						
				String Query ="update Administrator set Password ='" +pass+"' where Username = '"+Uname+"'";
				

				String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

				try (Connection connection = DriverManager.getConnection(databaseURL))
				{

					System.out.println("COnnection Exstablished");

					Statement statement = connection.createStatement();
					  statement.executeUpdate(Query);
					 System.out.println("Password Reset Sucess");
					
				}
				
				 catch (SQLException ex) {
						ex.printStackTrace();
					}
				 setVisible(false);
				 ResetPassSucess rstPsuc = new ResetPassSucess(tableName);
				 rstPsuc.setVisible(true);				 }
				else
				{
					 setVisible(false);
					 ResetPassError rstPerr = new ResetPassError(tableName, Uname);
					 rstPerr.setVisible(true);
				}
			}
		});
		
		}
		
		else
		{
		btn_ResetPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pass, cnpass;
				pass = textField_NewPassword.getText(); 
				cnpass = textField_ConfirmNewPass.getText(); 
				
				if(pass.equals(cnpass))
				{

				String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

				try (Connection connection = DriverManager.getConnection(databaseURL))
				{
					String Query ="update Teacher set Password ='" +pass+"' where Username = '"+Uname+"'";
					System.out.println("Connection Exstablished");

					Statement statement = connection.createStatement();
					  statement.execute(Query);
					 System.out.println("Password Reset Sucess");
					
					 
				}
				
				 catch (SQLException ex) {
						ex.printStackTrace();
					}
			
				 setVisible(false);
				 ResetPassSucess rstPsuc = new ResetPassSucess(tableName);
				 rstPsuc.setVisible(true);				 }
				else
				{
					 setVisible(false);
					 ResetPassError rstPerr = new ResetPassError(tableName,Uname);
					 rstPerr.setVisible(true);
				}
			}
		});
		}
		btn_ResetPass.setBounds(284, 205, 140, 31);
		contentPane.add(btn_ResetPass);
	}

}
