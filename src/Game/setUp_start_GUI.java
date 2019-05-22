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
import javax.swing.ImageIcon;

public class setUp_start_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField text_howManyDays;
	public int user_days_input;
	public static setUp_start_GUI frame = new setUp_start_GUI();
	public ship s = new ship();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(100, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbl_showValidation = new JLabel("");
		lbl_showValidation.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_showValidation.setBounds(145, 287, 335, 28);
		lbl_showValidation.setForeground(Color.RED);
		
		JLabel lbl_displayMissingParts = new JLabel("");
		lbl_displayMissingParts.setFont(new Font("Silom", Font.BOLD, 20));
		lbl_displayMissingParts.setForeground(Color.WHITE);
		lbl_displayMissingParts.setBounds(12, 355, 827, 59);
		
		text_howManyDays = new JTextField();
		text_howManyDays.setBounds(145, 229, 259, 52);
		text_howManyDays.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				lbl_showValidation.setText("");
			}
		});
		text_howManyDays.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		text_howManyDays.setColumns(10);
		
		JButton btn_goNext = new JButton("Next");
		btn_goNext.setBounds(652, 463, 187, 97);
		btn_goNext.setVisible(false);
		btn_goNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				dispose();
				frame.setVisible(false);
				setUp_selectCrew_GUI selectCrewGUI = new setUp_selectCrew_GUI();
				selectCrewGUI.setShip(s);
				selectCrewGUI.setVisible(true);
			}
		});
		
		JButton btn_passDays = new JButton("Confirm");
		btn_passDays.setBounds(457, 230, 118, 51);
		btn_passDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					lbl_showValidation.setText("");
					user_days_input = Integer.parseInt(text_howManyDays.getText());
					int i = s.get_parts_missing(user_days_input);
					lbl_displayMissingParts.setText("Okay, You have to find " + i + " parts. LET'S GO!");
					btn_goNext.setVisible(true);
				} catch(InputSetupException e1)
				{
					lbl_displayMissingParts.setText("");
					lbl_showValidation.setText(e1.getMessage());
					btn_goNext.setVisible(false);
				} catch(NumberFormatException e2)
				{
					lbl_displayMissingParts.setText("");
					lbl_showValidation.setText("Pick a number between 3 and 10!");
					btn_goNext.setVisible(false);
				}
				
			}
		});
		btn_passDays.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Select how many days:");
		lblNewLabel_1.setBounds(248, 139, 766, 41);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Silom", Font.BOLD, 32));
		contentPane.setLayout(null);
		contentPane.add(text_howManyDays);
		contentPane.add(btn_passDays);
		contentPane.add(lbl_showValidation);
		contentPane.add(lbl_displayMissingParts);
		contentPane.add(btn_goNext);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(setUp_start_GUI.class.getResource("/Game/images/space.png")));
		lblNewLabel.setBounds(0, 0, 1337, 932);
		contentPane.add(lblNewLabel);
		
	
	}
}
