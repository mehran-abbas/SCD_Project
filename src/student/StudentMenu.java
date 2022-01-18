package student;
import gui.*;
import results.GetSingleResult;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;

@SuppressWarnings({ "unused", "serial" })
public class StudentMenu extends JFrame {

	private JPanel contentPane;


/**
 *
 * @author Mehran Abbas
 */
	
	public StudentMenu() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
	
			e.printStackTrace();
		}
		setResizable(false);
		setForeground(SystemColor.textHighlight);
		setTitle("Students Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGetResult = new JButton("Get Result of a Quiz");
		btnGetResult.setBounds(0, 0, 0, 0);
		contentPane.add(btnGetResult);
		
		JLabel lblTeacherActions = new JLabel("Please Select an action from below ");
		lblTeacherActions.setBounds(0, 0, 0, 0);
		lblTeacherActions.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblTeacherActions);
		
		JButton btnAttemptQuiz = new JButton("Attempt Quiz");
		btnAttemptQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AttempQuiz atmp1 = new AttempQuiz(); 
				atmp1.setVisible(true);
			}
		});
		btnAttemptQuiz.setBounds(116, 95, 195, 40);
		contentPane.add(btnAttemptQuiz);
		
		JLabel lblTeacherActions_1 = new JLabel("Please Select an action from below ");
		lblTeacherActions_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTeacherActions_1.setBounds(117, 25, 194, 40);
		contentPane.add(lblTeacherActions_1);
		
		JButton btnGetresult = new JButton("Get Result");
		btnGetresult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
				GetSingleResult sngRlst = new GetSingleResult();
				
				sngRlst.setVisible(true);
				
			}
		});
		btnGetresult.setBounds(117, 182, 195, 40);
		contentPane.add(btnGetresult);
		
		JButton btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				MainScreen mnScr = new MainScreen();
				mnScr.setVisible(true);
				
				
			}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
	}
}
