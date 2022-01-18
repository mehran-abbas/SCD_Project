package admin;
import gui.*;
import results.GetResults;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminMenu extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @return 
	 */
	
	public AdminMenu() {
	
	
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}
		setVisible(true);
		setResizable(false);
		setForeground(SystemColor.textHighlight);
		setTitle("Administrator Menu");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminAction = new JLabel("Please Select an action from below ");
		lblAdminAction.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAdminAction.setBounds(116, 21, 194, 40);
		contentPane.add(lblAdminAction);
		
		JButton btnManagTeacher = new JButton("Manage Teachers");
		btnManagTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				SearchTeacher scrTch = new SearchTeacher();
				scrTch.setVisible(true);
			}
		});
		
		btnManagTeacher.setBounds(115, 91, 195, 40);
		contentPane.add(btnManagTeacher);
		
		JButton btnCheckResultsQuiz = new JButton("Check Results of Quizs");
		btnCheckResultsQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				GetResults gtRlst = new GetResults();
				gtRlst.GetResultsScreen("Administrator");
				
			}
		});
		btnCheckResultsQuiz.setBounds(116, 178, 195, 40);
		contentPane.add(btnCheckResultsQuiz);
		
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
