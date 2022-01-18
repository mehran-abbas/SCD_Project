package results;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import student.StudentMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GetSingleResult extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldGetQuizId;
	private JTextField textFieldGetStudentName;
	private JTextField textFieldGetStuRegNo;

	public GetSingleResult() 
	{
		setTitle("Result Single");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuizID = new JLabel("Please Enter Quiz ID");
		lblQuizID.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblQuizID.setBounds(10, 28, 159, 44);
		contentPane.add(lblQuizID);
		
		JLabel lblStudentName = new JLabel("Please Enter Student Name");
		lblStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStudentName.setBounds(10, 96, 159, 47);
		contentPane.add(lblStudentName);
		
		JLabel lblPleaseEnterStudent = new JLabel("Please Enter Student RegNo.");
		lblPleaseEnterStudent.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPleaseEnterStudent.setBounds(10, 177, 184, 47);
		contentPane.add(lblPleaseEnterStudent);
		
		textFieldGetQuizId = new JTextField();
		textFieldGetQuizId.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGetQuizId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldGetQuizId.setBounds(204, 25, 208, 47);
		contentPane.add(textFieldGetQuizId);
		textFieldGetQuizId.setColumns(10);
		
		textFieldGetStudentName = new JTextField();
		textFieldGetStudentName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGetStudentName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldGetStudentName.setColumns(10);
		textFieldGetStudentName.setBounds(204, 96, 208, 47);
		contentPane.add(textFieldGetStudentName);
		
		textFieldGetStuRegNo = new JTextField();
		textFieldGetStuRegNo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGetStuRegNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldGetStuRegNo.setColumns(10);
		textFieldGetStuRegNo.setBounds(204, 177, 208, 47);
		contentPane.add(textFieldGetStuRegNo);
		
		
		JButton btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				StudentMenu stdMnu2 = new StudentMenu();
				stdMnu2.setVisible(true);
				
				
			}
		});
		btnBack.setBounds(20, 245, 103, 35);
		contentPane.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					Boolean decesion = false;
					String RegNo =textFieldGetStuRegNo.getText();
					String QuizID =textFieldGetQuizId.getText();
					 
					String Name = null;
		        	String RegNumber = null ;
		        	String Marks = null;
					
					String Query ="Select * From Result_"+QuizID+" where Student_Reg_No ="+RegNo;

					String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

					try (Connection connection = DriverManager.getConnection(databaseURL)) 
					{

						System.out.println("COnnection Exstablished");

						Statement statement = connection.createStatement();
						 ResultSet rs = statement.executeQuery(Query);
						 
				       		      
				         while(rs.next())
				         {
				        	 if(rs.getString("Student_Reg_No").trim().equalsIgnoreCase(RegNo) ) 
				        	 
				        		 decesion = true;
				        	 Name = rs.getString("Student_Name");

				        	 RegNumber = rs.getString("Student_Reg_No");

				        	 Marks = rs.getString("Student_Marks_Obtained");
				        	 
				         }
				        	
				         }
				     catch (SQLException ex) {
						ex.printStackTrace();
					}

					if(decesion==true)
					{
						setVisible(false);
						
						@SuppressWarnings("unused")
						SingleResult sngRlt = new SingleResult(Name,RegNumber,Marks);
					}
					
					else
					{
						NotFound ntFnd = new NotFound();
						ntFnd.setVisible(true);
					}
								
					
				}
			
		});
		btnSearch.setBounds(329, 245, 103, 35);
		contentPane.add(btnSearch);
	}
}
