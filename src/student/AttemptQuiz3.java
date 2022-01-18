package student;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gui.WarningQuiz;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AttemptQuiz3 extends JFrame {

	private JPanel contentPane;
	private static JTextField textFieldGetQuestion;
	private static  JTextField textField_Choice1;
	private static  JTextField textField_Choice2;
	private static  JTextField textField_Choice3;
	private static  JTextField textField_Choice4;
	public  static int i = 1;
	private static int marks =10;
	private final ButtonGroup buttonGroup = new ButtonGroup();	
	private static String SelectedAns;
	private static String CAns;
	
	public AttemptQuiz3(String QuizID,String Sname,String Regn) {
	
	
		setVisible(true);
		setTitle("Attempt Quiz");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setToolTipText("Type your question in empty box");
		lblQuestion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuestion.setBounds(40, 63, 85, 30);
		contentPane.add(lblQuestion);
		
		textFieldGetQuestion = new JTextField();
		textFieldGetQuestion.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldGetQuestion.setColumns(10);
		textFieldGetQuestion.setBounds(150, 59, 444, 60);
		contentPane.add(textFieldGetQuestion);
		
		JLabel lblChoice = new JLabel("Choice 1");
		lblChoice.setToolTipText("Type your choice in empty box");
		lblChoice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice.setBounds(150, 165, 85, 30);
		contentPane.add(lblChoice);
		
		textField_Choice1 = new JTextField();
		textField_Choice1.setColumns(10);
		textField_Choice1.setBounds(260, 166, 319, 30);
		contentPane.add(textField_Choice1);
		
		JLabel lblChoice_2 = new JLabel("Choice 2");
		lblChoice_2.setToolTipText("Type your choice in empty box");
		lblChoice_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice_2.setBounds(150, 232, 85, 30);
		contentPane.add(lblChoice_2);
		
		textField_Choice2 = new JTextField();
		textField_Choice2.setColumns(10);
		textField_Choice2.setBounds(260, 233, 319, 30);
		contentPane.add(textField_Choice2);
		
		JLabel lblChoice_1_1 = new JLabel("Choice 3");
		lblChoice_1_1.setToolTipText("Type your choice in empty box");
		lblChoice_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice_1_1.setBounds(150, 294, 85, 30);
		contentPane.add(lblChoice_1_1);
		
		textField_Choice3 = new JTextField();
		textField_Choice3.setColumns(10);
		textField_Choice3.setBounds(260, 295, 319, 30);
		contentPane.add(textField_Choice3);
		
		JLabel lblChoice_1_1_1 = new JLabel("Choice 4");
		lblChoice_1_1_1.setToolTipText("Type your choice in empty box");
		lblChoice_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoice_1_1_1.setBounds(150, 350, 85, 30);
		contentPane.add(lblChoice_1_1_1);
		
		textField_Choice4 = new JTextField();
		textField_Choice4.setColumns(10);
		textField_Choice4.setBounds(260, 351, 319, 30);
		contentPane.add(textField_Choice4);
		
		JLabel lblDataEnter = new JLabel("Please Enter Data :");
		lblDataEnter.setBounds(40, 11, 110, 30);
		contentPane.add(lblDataEnter);
		
		JCheckBox chckbx1 = new JCheckBox("");
		chckbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SelectedAns = textField_Choice1.getText();
			}
		});
		buttonGroup.add(chckbx1);
		chckbx1.setBounds(47, 170, 97, 23);
		contentPane.add(chckbx1);
		
		JCheckBox chckbx2 = new JCheckBox("");
		chckbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SelectedAns = textField_Choice2.getText();
			}
		});
		buttonGroup.add(chckbx2);
		chckbx2.setBounds(47, 232, 97, 23);
		contentPane.add(chckbx2);
		
		JCheckBox chckbx3 = new JCheckBox("");
		chckbx3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SelectedAns = textField_Choice3.getText();
			}
		});
		buttonGroup.add(chckbx3);
		chckbx3.setBounds(47, 299, 97, 23);
		contentPane.add(chckbx3);
		
		JCheckBox chckbx4 = new JCheckBox("");
		chckbx4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SelectedAns = textField_Choice4.getText();
			}
		});
		buttonGroup.add(chckbx4);
		chckbx4.setBounds(47, 355, 97, 23);
		contentPane.add(chckbx4);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				buttonGroup.clearSelection();

				if(i<10)
				{
				
				if(SelectedAns.trim().equalsIgnoreCase( CAns))
				{
					
				}
				else
				{
					marks--;
				}
				i++;
				
				}
				
				
				
				else if (i==10)
				{
					if(SelectedAns.trim().equalsIgnoreCase( CAns))
					{
						
						
					}
					else
					{
						marks--;
					}
					
					 i=1;
						setVisible(false);
						QuizAttemptSucess QAS = new QuizAttemptSucess();
						QAS.setVisible(true);
						 PopulateResultTable(QuizID,Sname,Regn,marks);
						 marks = 10;
					
				}
				
				else
				{
					 i=1;
					setVisible(false);
					QuizAttemptSucess QAS = new QuizAttemptSucess();
					QAS.setVisible(true);
					 PopulateResultTable(QuizID,Sname,Regn,marks);
					 marks = 10;
				}	
				

				startQuiz(QuizID);

			}
		});
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNext.setBounds(494, 419, 85, 30);
		contentPane.add(btnNext);
		
		JButton btnCancel = new JButton("Finish");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (i<10)
				{
					WarningQuiz wrnQz = new WarningQuiz();
					wrnQz.setVisible(true);
					
				}
				else if(i==10)
				{
					 i=1;
					setVisible(false);
					QuizAttemptSucess QAS = new QuizAttemptSucess();
					QAS.setVisible(true);
					 PopulateResultTable(QuizID,Sname,Regn,marks);
				
					 marks = 10;
				}	
				
				
			}
		});
		btnCancel.setToolTipText("Warning !!!");
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancel.setBounds(40, 419, 85, 30);
		contentPane.add(btnCancel);
		
		startQuiz(QuizID);
		
	}
	
	
	public static void startQuiz(String QuizID) 
	{
		
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

		Statement s = connection.createStatement();
		ResultSet rst =	s.executeQuery("Select Question_Number,Question,Answer_1,Answer_2,Answer_3,Answer_4,Correct_Answer from  Quiz_" + QuizID+" where Question_Number ='"+ i+"'"); 
	
		while(rst.next())
		{
			textFieldGetQuestion.setText(rst.getString("Question"));
			textField_Choice1.setText(rst.getString("Answer_1")); 
			textField_Choice2.setText(rst.getString("Answer_2"));
			textField_Choice3.setText(rst.getString("Answer_3"));
			textField_Choice4.setText(rst.getString("Answer_4"));
			
		  CAns =rst.getString("Correct_Answer");
			
		
		}
		
			
			

		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
		}
		
	}
	
	

	public static void PopulateResultTable(String QuizID,String SName,String RegN, int marks) 
	{
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";

		try (Connection connection = DriverManager.getConnection(databaseURL)) {

			Statement s = connection.createStatement();
			s.execute("insert into Result_" + QuizID+ "  (Student_Name,Student_Reg_No ,Student_Marks_Obtained ) values ('" +SName+ "','" + RegN + "','" + marks + "' )");
			System.out.println("Result Table Populated Sucessfully");
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
