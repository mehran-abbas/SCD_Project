package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ResetPassError extends JFrame {

	private JPanel contentPane;

	
	public ResetPassError(String tableName, String Uname) {
		
		setVisible(true);
		setResizable(false);
		setTitle("Reset Password Error");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTryAgain = new JButton("Try Again");
		btnTryAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				@SuppressWarnings("unused")
				ResetPassword rstPass = new ResetPassword (tableName, Uname);
				
				
			}
		});
		btnTryAgain.setBounds(154, 106, 89, 23);
		contentPane.add(btnTryAgain);
		
		JLabel lblNewLabel = new JLabel("Sorry Both passwords didn't matched!try again");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(91, 33, 259, 62);
		contentPane.add(lblNewLabel);
	}

}
