package student;

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

@SuppressWarnings("serial")
public class AttempQuiz2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldStudentName;
	private JTextField textFieldRegNumber;
	private JTextField textFieldCourseID;
	private JTextField textFieldCourseName;
	
	

	
	public AttempQuiz2(String QuizID)
	{
		setTitle("Attempt Quiz 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 388, 289);
		contentPane.add(contentPane_1);
		
		JLabel lblPlEnterData = new JLabel("Please Enter Data :");
		lblPlEnterData.setBounds(10, 11, 113, 28);
		contentPane_1.add(lblPlEnterData);
		
		JLabel lblStuName = new JLabel("Student Name");
		lblStuName.setBounds(10, 50, 113, 28);
		contentPane_1.add(lblStuName);
		
		JLabel lblQuizTitle = new JLabel("Reg No");
		lblQuizTitle.setBounds(10, 104, 113, 28);
		contentPane_1.add(lblQuizTitle);
		
		JLabel lblCourseId = new JLabel("Teacher Name");
		lblCourseId.setBounds(10, 149, 113, 28);
		contentPane_1.add(lblCourseId);
		
		JLabel lblCourseName = new JLabel("Course Code");
		lblCourseName.setBounds(10, 202, 113, 28);
		contentPane_1.add(lblCourseName);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setColumns(10);
		textFieldStudentName.setBounds(133, 50, 221, 38);
		contentPane_1.add(textFieldStudentName);
		
		textFieldRegNumber = new JTextField();
		textFieldRegNumber.setColumns(10);
		textFieldRegNumber.setBounds(133, 99, 221, 38);
		contentPane_1.add(textFieldRegNumber);
		
		textFieldCourseID = new JTextField();
		textFieldCourseID.setColumns(10);
		textFieldCourseID.setBounds(133, 153, 221, 38);
		contentPane_1.add(textFieldCourseID);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.setColumns(10);
		textFieldCourseName.setBounds(133, 206, 221, 38);
		contentPane_1.add(textFieldCourseName);
		
		JButton btnNext = new JButton("Start Quiz");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		String StName =		textFieldStudentName.getText();
		String RegN   =		textFieldRegNumber.getText();
		String CID    =         textFieldCourseID.getText();
		String CName  =		textFieldCourseName.getText();
				
				
				setVisible(false);
				PopulateQuizAttemptTable(QuizID,StName,RegN,CID,CName);
				AttemptQuiz3 atmp3 = new AttemptQuiz3(QuizID,StName,RegN);
				atmp3.setVisible(true);
				
				}
		});
		btnNext.setBounds(289, 255, 89, 23);
		contentPane_1.add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentMenu stdMnu = new StudentMenu();
				stdMnu.setVisible(true);
			}
			
		});
		btnCancel.setBounds(10, 255, 89, 23);
		contentPane_1.add(btnCancel);
	}
	
	
	public static void PopulateQuizAttemptTable(String QuizID,String Stname,String Reg,String Cid,String Cname)
	{
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

	

			Statement s = connection.createStatement();
			s.execute("insert into Quiz_Attempt_" + QuizID
					+ "  (Student_Name ,Student_Reg_No ,Teacher_Name ,Course_Code ) values ('" +Stname+ "','" + Reg + "','" + Cid + "','" + Cname + "')"); 
					
			System.out.println("Quiz Attempt Table Populated sucessfully.");																												
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
