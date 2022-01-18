package results;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import student.StudentMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SingleResult extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSName;
	private JTextField textFieldReg;
	private JTextField textFieldMarks;

	public SingleResult(String name, String reg, String marks) 
	{
		setVisible(true);
		setResizable(false);
		setTitle("Student Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(37, 40, 133, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegNumber = new JLabel("Registeration No.");
		lblRegNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRegNumber.setBounds(37, 111, 133, 33);
		contentPane.add(lblRegNumber);
		
		JLabel lblMarksObtained = new JLabel("Marks Obtained");
		lblMarksObtained.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMarksObtained.setBounds(37, 194, 133, 33);
		contentPane.add(lblMarksObtained);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				setVisible(false);
				StudentMenu stdMnu = new StudentMenu();
				stdMnu.setVisible(true);
			}
		});
		btnDone.setBounds(152, 261, 116, 45);
		contentPane.add(btnDone);
		
		textFieldSName = new JTextField();
		textFieldSName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldSName.setBounds(197, 42, 189, 44);
		contentPane.add(textFieldSName);
		textFieldSName.setColumns(10);
		
		textFieldReg = new JTextField();
		textFieldReg.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldReg.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldReg.setColumns(10);
		textFieldReg.setBounds(197, 113, 189, 44);
		contentPane.add(textFieldReg);
		
		textFieldMarks = new JTextField();
		textFieldMarks.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMarks.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textFieldMarks.setColumns(10);
		textFieldMarks.setBounds(197, 196, 189, 44);
		contentPane.add(textFieldMarks);
		
		textFieldSName.setText(name);
		textFieldReg.setText(reg);
		textFieldMarks.setText(marks);
		
	}
}
