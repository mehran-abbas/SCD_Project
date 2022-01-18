package teacher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings("serial")
public class QuizID extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuizId;

	public QuizID(String QuizID ) 
	{
		setVisible(true);
		setTitle("Quiz ID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtQuizId = new JTextField();
		txtQuizId.setToolTipText("Please remember this Quiz ID as it will be used to populate,attemp,seacrh and get results of quiz\r\n\r\n* Write it Down\r\n* Take Screenshot");
		txtQuizId.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuizId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtQuizId.setEditable(false);
		txtQuizId.setBounds(38, 63, 323, 78);
		contentPane.add(txtQuizId);
		txtQuizId.setColumns(10);
		
		txtQuizId.setText(QuizID);
		
		JLabel lblNewLabel = new JLabel("Please note the below given Quiz ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(38, 11, 328, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblItWillBe = new JLabel("It will be used to populate,attemp,search and get results of quiz");
		lblItWillBe.setHorizontalAlignment(SwingConstants.CENTER);
		lblItWillBe.setBounds(21, 209, 365, 27);
		contentPane.add(lblItWillBe);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				CreateQuiz crtQuz = new CreateQuiz(QuizID);
				crtQuz.setVisible(true);
			}
		});
		btnNewButton.setBounds(154, 152, 100, 46);
		contentPane.add(btnNewButton);
	}
}
