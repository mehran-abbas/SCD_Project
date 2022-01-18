package teacher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


/**
 *
 * @author Mehran Abbas
 */

@SuppressWarnings("serial")
public class QuizCreateSucess extends JFrame {

	private JPanel contentPane;
	


		
		public QuizCreateSucess() {
			
			setVisible(true);
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setBounds(100, 100, 450, 237);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			    JButton btnContinue = new JButton("Continue");
			    btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				setVisible(false);
				TeachersMenu tchMnu = new TeachersMenu();
				tchMnu.setVisible(true);		
				}
			});
			btnContinue.setBounds(174, 118, 89, 23);
			contentPane.add(btnContinue);
			
			JLabel lblPasswordResestSuccessfully = new JLabel("Quiz Created Successfully");
			lblPasswordResestSuccessfully.setHorizontalAlignment(SwingConstants.CENTER);
			lblPasswordResestSuccessfully.setFont(new Font("Times New Roman", Font.BOLD, 13));
			lblPasswordResestSuccessfully.setBounds(84, 45, 298, 62);
			contentPane.add(lblPasswordResestSuccessfully);
		}

	}


