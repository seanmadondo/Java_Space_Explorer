package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class setUp_start_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField text_howManyDays;
	public int user_days_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setUp_start_GUI frame = new setUp_start_GUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public setUp_start_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbl_showValidation = new JLabel("");
		lbl_showValidation.setForeground(Color.RED);
		
		JLabel lbl_displayMissingParts = new JLabel("");
		
		text_howManyDays = new JTextField();
		text_howManyDays.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		text_howManyDays.setColumns(10);
		
		JButton btn_goNext = new JButton("New button");
		btn_goNext.setVisible(false);
		btn_goNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		JButton btn_passDays = new JButton("confirm");
		btn_passDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ship s = new ship();
				try
				{
					lbl_showValidation.setText("");
					user_days_input = Integer.parseInt(text_howManyDays.getText());
					int i = s.get_parts_missing(user_days_input);
					lbl_displayMissingParts.setText("You will have to find " + i + " parts.");
					btn_goNext.setVisible(true);
				} catch(InputSetupException e1)
				{
					lbl_displayMissingParts.setText("");
					lbl_showValidation.setText(e1.getMessage());
					btn_goNext.setVisible(false);
				} catch(NumberFormatException e2)
				{
					lbl_displayMissingParts.setText("");
					lbl_showValidation.setText("Only number 2-6!");
					btn_goNext.setVisible(false);
				}
				
			}
		});
		btn_passDays.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("How many days?");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 40));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(text_howManyDays, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(btn_passDays))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(lbl_showValidation, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(140)
					.addComponent(lbl_displayMissingParts, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(647)
					.addComponent(btn_goNext, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(137)
					.addComponent(lblNewLabel_1)
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(text_howManyDays, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btn_passDays, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addComponent(lbl_showValidation)
					.addGap(99)
					.addComponent(lbl_displayMissingParts, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_goNext, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
