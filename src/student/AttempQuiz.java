package student;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AttempQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_TryA;

	
	public AttempQuiz() 
	
	{
		setResizable(false);
		setTitle("Attemp Quiz_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuizID = new JLabel("Please Enter Quiz ID");
		lblQuizID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblQuizID.setBounds(10, 11, 118, 40);
		contentPane.add(lblQuizID);
		
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(78, 76, 187, 40);
		contentPane.add(textField);
		
	
		lblNewLabel_TryA = new JLabel("");
		lblNewLabel_TryA.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_TryA.setBounds(210, 18, 130, 27);
		contentPane.add(lblNewLabel_TryA);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				Boolean decesion = false;
				String QuizID =textField.getText();
				
				String Query ="Select Quiz_ID From Quiz_About";

				String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

				try (Connection connection = DriverManager.getConnection(databaseURL)) 
				{

					System.out.println("COnnection Exstablished");

					Statement statement = connection.createStatement();
					 ResultSet rs = statement.executeQuery(Query);
					 
			       		      
			         while(rs.next())
			         {
			        	 if(rs.getString("Quiz_ID").trim().equalsIgnoreCase(QuizID) ) 
			        	 
			        		 decesion = true;
			        	 }
			        	
			         }
			       
				
					
				 catch (SQLException ex) {
					ex.printStackTrace();
				}

				if(decesion==true)
				{
					setVisible(false);
					AttempQuiz2 atmpQz2 = new AttempQuiz2(QuizID);
					atmpQz2.setVisible(true);
				
				}
				
				else
				{
					textField.setText("");
					lblNewLabel_TryA.setText("Wrong ID Try Again");
				}
							
				
			}
		});

		btnNext.setBounds(239, 141, 89, 23);
		contentPane.add(btnNext);
		
		
		JButton btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				StudentMenu stdMnu2 = new StudentMenu();
				stdMnu2.setVisible(true);
			}
		});
		
		btnBack.setBounds(10, 141, 89, 23);
		contentPane.add(btnBack);
		
		
		
	}
}
	
	

