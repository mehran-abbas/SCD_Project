package teacher;


import gui.*;
import results.GetResults;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings({ "serial", "unused" })
public class TeachersMenu extends JFrame {

	private JPanel contentPane;

	 static String getAlphaNumericString(int n)
	    {
	  
	        // length is bounded by 256 Character
	        byte[] array = new byte[256];
	        new Random().nextBytes(array);
	  
	        String randomString
	            = new String(array, Charset.forName("UTF-8"));
	  
	        // Create a StringBuffer to store the result
	        StringBuffer r = new StringBuffer();
	  
	        // Append first 20 alphanumeric characters
	        // from the generated random String into the result
	        for (int k = 0; k < randomString.length(); k++) {
	  
	            char ch = randomString.charAt(k);
	  
	            if (((ch >= 'a' && ch <= 'z')
	                 || (ch >= 'A' && ch <= 'Z')
	                 || (ch >= '0' && ch <= '9'))
	                && (n > 0)) {
	  
	                r.append(ch);
	                n--;
	            }
	        }
	  
	        // return the resultant string
	        return r.toString();
	    }
	
	

	public  TeachersMenu(){	
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
		setVisible(true);
		setResizable(false);
		setForeground(SystemColor.textHighlight);
		setTitle("Teacher's Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeacherActions = new JLabel("Please Select an action from below ");
		lblTeacherActions.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTeacherActions.setBounds(121, 11, 194, 40);
		contentPane.add(lblTeacherActions);
		
		JButton btnGetResult = new JButton("Get Result of a Quiz");
		btnGetResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GetResults gtRlt = new GetResults();
				gtRlt.GetResultsScreen("Teacher");
			}
		});
		btnGetResult.setBounds(120, 81, 195, 40);
		contentPane.add(btnGetResult);
		
		JButton btnCreateQuiz = new JButton("Create a Quiz");
		btnCreateQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = getAlphaNumericString(5);
				setVisible(false);
				QuizID qzId = new QuizID(s);
			}
		});
		btnCreateQuiz.setBounds(121, 168, 195, 40);
		contentPane.add(btnCreateQuiz);
		
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
