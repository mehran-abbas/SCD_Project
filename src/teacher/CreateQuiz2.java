package teacher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings("serial")
public class CreateQuiz2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldQuestion;
	private JTextField textFieldChoice1;
	private JTextField textFieldChoice2;
	private JTextField textFieldChoice3;
	private JTextField textFieldChoice4;
	private JTextField textFieldCorrectChoice;
	private int qno = 1;

	
	public CreateQuiz2(String QuizID) {
		
		setVisible(true);
		setResizable(false);
		setTitle("Create Quiz Q/A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataEnter = new JLabel("Please Enter Data :");
		lblDataEnter.setBounds(25, 24, 110, 30);
		contentPane.add(lblDataEnter);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuestion.setToolTipText("Type your question in empty box");
		lblQuestion.setBounds(25, 81, 85, 30);
		contentPane.add(lblQuestion);
		
		textFieldQuestion = new JTextField();
		textFieldQuestion.setBounds(135, 65, 404, 64);
		contentPane.add(textFieldQuestion);
		textFieldQuestion.setColumns(10);
		
		
		JLabel lblChoice = new JLabel("Choice 1");
		lblChoice.setToolTipText("Type your choice in empty box");
		lblChoice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice.setBounds(25, 158, 85, 30);
		contentPane.add(lblChoice);
		
		JLabel lblChoice_2 = new JLabel("Choice 2");
		lblChoice_2.setToolTipText("Type your choice in empty box");
		lblChoice_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice_2.setBounds(25, 211, 85, 30);
		contentPane.add(lblChoice_2);
		
		JLabel lblChoice_1 = new JLabel("Choice 3");
		lblChoice_1.setToolTipText("Type your choice in empty box");
		lblChoice_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice_1.setBounds(25, 259, 85, 30);
		contentPane.add(lblChoice_1);
		
		JLabel lblChoice_1_1 = new JLabel("Choice 4");
		lblChoice_1_1.setToolTipText("Type your choice in empty box");
		lblChoice_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice_1_1.setBounds(25, 313, 85, 30);
		contentPane.add(lblChoice_1_1);
		
		JLabel lblChoice_1_2 = new JLabel("Correct Choice");
		lblChoice_1_2.setToolTipText("Type your choice in empty box");
		lblChoice_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice_1_2.setBounds(25, 367, 110, 30);
		contentPane.add(lblChoice_1_2);
		
		textFieldChoice1 = new JTextField();
		textFieldChoice1.setBounds(135, 159, 337, 39);
		contentPane.add(textFieldChoice1);
		textFieldChoice1.setColumns(10);
		
		textFieldChoice2 = new JTextField();
		textFieldChoice2.setColumns(10);
		textFieldChoice2.setBounds(135, 212, 337, 39);
		contentPane.add(textFieldChoice2);
		
		textFieldChoice3 = new JTextField();
		textFieldChoice3.setColumns(10);
		textFieldChoice3.setBounds(135, 260, 337, 39);
		contentPane.add(textFieldChoice3);
		
		textFieldChoice4 = new JTextField();
		textFieldChoice4.setColumns(10);
		textFieldChoice4.setBounds(135, 313, 337, 39);
		contentPane.add(textFieldChoice4);
		
		textFieldCorrectChoice = new JTextField();
		textFieldCorrectChoice.setColumns(10);
		textFieldCorrectChoice.setBounds(135, 368, 337, 39);
		contentPane.add(textFieldCorrectChoice);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(460, 444, 89, 23);
		contentPane.add(btnCancel);
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Question = textFieldQuestion.getText();
				String A1= textFieldChoice1.getText(); 
				String A2= textFieldChoice2.getText();
				String A3= textFieldChoice3.getText();
				String A4= textFieldChoice4.getText(); 
				String CA= textFieldCorrectChoice.getText();
				
				if(qno<=10)
				{
					PopulateQuizTable(QuizID,qno,Question,A1,A2,A3, A4, CA);
					textFieldQuestion.setText("");
					textFieldChoice1.setText(""); 
					textFieldChoice2.setText("");
					textFieldChoice3.setText("");
					textFieldChoice4.setText(""); 
					textFieldCorrectChoice.setText("");
				qno++;
				}
				
				else
				{
					setVisible(false);
					QuizCreateSucess QCS = new QuizCreateSucess();
					QCS.setVisible(true);
					
				}
			}
		});
		btnNext.setBounds(356, 444, 89, 23);
		contentPane.add(btnNext);
		
		CreateQuizTable(QuizID);
		CreateQuizAttemptTable(QuizID);
		CreateResultTable(QuizID);
	}
	
	public static void CreateQuizTable(String QuizID) {
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

		
			Statement s = connection.createStatement();
			s.execute("create table Quiz_" + QuizID
					+ "  (Question_Number integer, Question Text(1000),Answer_1 Text(1000),Answer_2 Text(1000),Answer_3 Text(1000),Answer_4 Text(1000),Correct_Answer Text(1000) )"); 
			
			System.out.println("Bank Quiz Table created");

			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	

	public static void PopulateQuizTable(String QuizID, int a, String Question, String A1, String A2, String A3,String A4, String CA) {
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

	

			Statement s = connection.createStatement();
			s.execute("insert into Quiz_" + QuizID+ "(Question_Number,Question,Answer_1,Answer_2,Answer_3,Answer_4,Correct_Answer) values('" +
			a+ "','" + Question + "','" + A1 + "','" + A2 + "','" + A3 + "','" + A4 + "','" + CA + "')"); 
			
			System.out.println("Quiz Populated sucessfully");
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	public static void CreateQuizAttemptTable(String QuizID) {
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

	

			Statement s = connection.createStatement();
			s.execute("create table Quiz_Attempt_" + QuizID
					+ "  (Student_Name Text(1000),Student_Reg_No Text(1000),Teacher_Name Text(1000),Course_Code Text(1000) )"); 
					
			System.out.println("Quiz Attempt Table created sucessfully.");																												
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	
	
	public static void CreateResultTable(String QuizID) {
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

	

			Statement s = connection.createStatement();
			s.execute("create table Result_" + QuizID+ "  (Student_Name Text(1000),Student_Reg_No Text(1000),Student_Marks_Obtained integer)"); 
			
			System.out.println("Resut Table sucessfully");
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
	

}
