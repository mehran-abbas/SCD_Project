package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginError extends JFrame {

	private JPanel contentPane;

	
	public LoginError(String tableName) {
		setTitle("Login Error");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sorry couldn't get you logged In. Would you like to Sign up instead!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 399, 75);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("No Try Again");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Sign_In sgnIn = new Sign_In();
				sgnIn.SignInScreen(tableName);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(29, 114, 126, 23);
		contentPane.add(btnNewButton);
		
		JButton btnYesPlease = new JButton("Yes Please !");
		btnYesPlease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setVisible(false);
				Signup sgnUp = new Signup();
				sgnUp.SignUpScreen(tableName);
			}
		});
		btnYesPlease.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnYesPlease.setBounds(262, 114, 126, 23);
		contentPane.add(btnYesPlease);
	}

}
