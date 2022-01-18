package admin;

import net.proteanit.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ShowTeacherData extends JFrame {


	
	private JPanel contentPane;
	private JTable table_TeacherData;

	
	public ShowTeacherData()
	{

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Teacher Data");
		setBounds(100, 100, 900, 421);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeacherData = new JLabel("Teacher Data");
		lblTeacherData.setBounds(21, 11, 72, 31);
		lblTeacherData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		contentPane.add(lblTeacherData);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(761, 329, 111, 40);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminMenu adMnu = new AdminMenu();
				adMnu.setVisible(true);
			}
		});
		contentPane.add(btnGoBack);
		
		table_TeacherData = new JTable();
		table_TeacherData.setSurrendersFocusOnKeystroke(true);
		table_TeacherData.setShowVerticalLines(true);
		table_TeacherData.setShowHorizontalLines(true);
		table_TeacherData.setFillsViewportHeight(true);
		table_TeacherData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_TeacherData.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN );
		
		JScrollPane scrollPane = new JScrollPane(table_TeacherData);
		scrollPane.setBounds(14, 70, 850, 250);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table_TeacherData);
		table_TeacherData.setModel(new DefaultTableModel(
		
			
		));
	
		showTeacher();
	}  
	
	public void showTeacher()
	{
	String query = "SELECT * FROM Teacher";
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";
		

		try (Connection connection = DriverManager.getConnection(databaseURL)) {
			
			Statement prpStm = connection.createStatement();
			ResultSet rs = prpStm.executeQuery(query);
			table_TeacherData.setModel(DbUtils.resultSetToTableModel(rs));
			System.out.println("ResultsFetched");

		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
