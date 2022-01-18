package teacher;

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
public class CreateQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTName;
	private JTextField textFieldQzTitle;
	private JTextField textFieldCourseID;
	private JTextField textFieldCourseName;
	
	String Tname = null;
	String Qtitle =null;
	String CID = null;
	String CName = null;
	


	public CreateQuiz(String QuizID) {
		setResizable(false);
		setTitle("Quiz Introduction 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlEnterData = new JLabel("Please Enter Data :");
		lblPlEnterData.setBounds(10, 11, 113, 28);
		contentPane.add(lblPlEnterData);
		
		JLabel lblTName = new JLabel("Teacher Name");
		lblTName.setBounds(10, 50, 113, 28);
		contentPane.add(lblTName);
		
		JLabel lblQuizTitle = new JLabel("Quiz Title");
		lblQuizTitle.setBounds(10, 89, 113, 28);
		contentPane.add(lblQuizTitle);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setBounds(10, 147, 113, 28);
		contentPane.add(lblCourseId);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(10, 186, 113, 28);
		contentPane.add(lblCourseName);
		
		textFieldTName = new JTextField();
		textFieldTName.setBounds(133, 50, 206, 32);
		contentPane.add(textFieldTName);
		textFieldTName.setColumns(10);
		
		textFieldQzTitle = new JTextField();
		textFieldQzTitle.setColumns(10);
		textFieldQzTitle.setBounds(133, 93, 206, 32);
		contentPane.add(textFieldQzTitle);
		
		textFieldCourseID = new JTextField();
		textFieldCourseID.setColumns(10);
		textFieldCourseID.setBounds(133, 145, 206, 32);
		contentPane.add(textFieldCourseID);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setColumns(10);
		textFieldCourseName.setBounds(133, 190, 206, 32);
		contentPane.add(textFieldCourseName);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			     Tname = textFieldTName.getText();
				 Qtitle = textFieldQzTitle.getText();
				 CID = textFieldCourseID.getText();
				 CName = textFieldCourseName.getText();
				PopulateAboutQuizTable(QuizID,Tname,Qtitle,CID,CName);
				setVisible(false);
				
			@SuppressWarnings("unused")
			CreateQuiz2 crtQiz2 = new CreateQuiz2(QuizID);
				
			}
		});
		btnNext.setBounds(178, 276, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TeachersMenu tchMnu = new TeachersMenu();
				tchMnu.setVisible(true);
			}
		});
		btnCancel.setBounds(285, 276, 89, 23);
		contentPane.add(btnCancel);
		
}
	
	
	public  void PopulateAboutQuizTable(String QuizID, String teacherName, String quizTitle, String courseID, String courseName) {
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

	

			Statement s = connection.createStatement();
			s.execute("insert into Quiz_About (Teacher_Name ,Quiz_Title ,Course_ID , Course_Name , Quiz_ID) values('" +teacherName
			+ "','" +quizTitle  + "','" + courseID + "','" + courseName + "','"+QuizID+"')"); 
			
			System.out.println("About Quiz Populated sucessfully");
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
}
