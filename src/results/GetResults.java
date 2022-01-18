package results;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import admin.AdminMenu;
import teacher.TeachersMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.sql.*;

@SuppressWarnings("serial")
public class GetResults extends JFrame {
	

	private JPanel contentPane;
	private JTextField textFieldGetQuizID;

	public GetResults() {
	
	}
	
	public void GetResultsScreen(String userName) {
		
		setVisible(true);
		setResizable(false);
		setTitle("Get Result 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please Enter Quiz ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(106, 25, 118, 40);
		contentPane.add(lblNewLabel);
		
		textFieldGetQuizID = new JTextField();
		textFieldGetQuizID.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGetQuizID.setBounds(72, 76, 187, 40);
		contentPane.add(textFieldGetQuizID);
		textFieldGetQuizID.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				
				Boolean decesion = false;
				String QuizID =textFieldGetQuizID.getText();
				
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
					Results results = new Results(userName,QuizID);
					results.setVisible(true);
					
				
				}
				
				else
			{
					
			NotFound ntFud = new NotFound();
			ntFud.setVisible(true);
			textFieldGetQuizID.setText("");
			
				
			}
			}
		});
		
		btnSearch.setBounds(221, 139, 89, 23);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Go Back");
		
		if(userName.equals("Administrator"))
		{
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				AdminMenu admMnu = new AdminMenu();
				admMnu.setVisible(true);
				
				
			}
		});
		}
		
		else
		{
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
					TeachersMenu tchMnu = new TeachersMenu();
					tchMnu.setVisible(true);
			}
			});
		}
		btnBack.setBounds(10, 139, 89, 23);
		contentPane.add(btnBack);
	}
}
