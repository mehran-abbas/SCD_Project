package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings("serial")
public class WarningQuiz extends JFrame {

	private JPanel contentPane;
	private JTextField txtWarning;
	private JTextField txtToContinueQuiz;

	
	public WarningQuiz() {
		setTitle("Warning");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWarning = new JTextField();
		txtWarning.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtWarning.setBackground(Color.LIGHT_GRAY);
		txtWarning.setHorizontalAlignment(SwingConstants.CENTER);
		txtWarning.setEditable(false);
		txtWarning.setText("You can not go back at this stage");
		txtWarning.setBounds(90, 37, 272, 31);
		contentPane.add(txtWarning);
		txtWarning.setColumns(10);
		
		txtToContinueQuiz = new JTextField();
		txtToContinueQuiz.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtToContinueQuiz.setBackground(Color.LIGHT_GRAY);
		txtToContinueQuiz.setHorizontalAlignment(SwingConstants.CENTER);
		txtToContinueQuiz.setEditable(false);
		txtToContinueQuiz.setText("To Continue Quiz click OK");
		txtToContinueQuiz.setColumns(10);
		txtToContinueQuiz.setBounds(90, 96, 272, 31);
		contentPane.add(txtToContinueQuiz);
		
		JButton btnGoBack = new JButton("OK!");
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnGoBack.setBounds(157, 154, 135, 31);
		contentPane.add(btnGoBack);
	}
}
