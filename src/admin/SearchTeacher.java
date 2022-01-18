package admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SearchTeacher extends JFrame {

	private JPanel contentPane;
	private JTextField textField_GetUserName;

	public SearchTeacher() {
		
		setTitle("Search Teacher Data");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_GetUserName = new JTextField();
		textField_GetUserName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_GetUserName.setHorizontalAlignment(SwingConstants.CENTER);
		textField_GetUserName.setBounds(54, 70, 319, 52);
		contentPane.add(textField_GetUserName);
		textField_GetUserName.setColumns(10);

		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Uname = textField_GetUserName.getText();
				System.out.println(Uname);
				setVisible(false);
				ShowSingleTeacherData ssT = new ShowSingleTeacherData();
				ssT.showData(Uname);
						
			}
		});
		btnSearch.setToolTipText("For Searching individual Teacher");
		btnSearch.setBounds(166, 143, 89, 34);
		contentPane.add(btnSearch);
		
		JLabel lblTeacherUName = new JLabel("Please Enter Teacher Username");
		lblTeacherUName.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTeacherUName.setBounds(116, 31, 187, 40);
		contentPane.add(lblTeacherUName);
		
		
		JButton btnAllTeachersData = new JButton("Show All Teachers Data");
		btnAllTeachersData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				ShowTeacherData shTD = new ShowTeacherData();
				shTD.setVisible(true);
				
			}
		});
		btnAllTeachersData.setToolTipText("To get data for all teachers");
		btnAllTeachersData.setBounds(116, 194, 187, 40);
		contentPane.add(btnAllTeachersData);
		
		
	
		JButton btnBack = new JButton("Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				AdminMenu adMnu = new AdminMenu();
				adMnu.setVisible(true);
		}
		});
		btnBack.setBounds(10, 227, 89, 23);
		contentPane.add(btnBack);
		
		
	}
	

}
