package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings("serial")
public class SignUpSucess extends JFrame {

	private JPanel contentPane;

	
	public SignUpSucess() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		
		
		setTitle("Sign Up Sucessfully");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 390, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Signed Up sucessfully Please click continue");
		lblNewLabel.setBounds(99, 48, 245, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				MainScreen manScr = new MainScreen();
				manScr.setVisible(true);
			}
		});
		btnContinue.setBounds(133, 107, 116, 32);
		contentPane.add(btnContinue);
	}
}
