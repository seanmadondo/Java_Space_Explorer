package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class welcome_gui extends JFrame {

	private JPanel contentPane;
	public static welcome_gui frame = new welcome_gui();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					welcome_gui frame = new welcome_gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public welcome_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSpaceExplorer = new JLabel("SPACE EXPLORER 2.0");
		lblSpaceExplorer.setForeground(Color.WHITE);
		lblSpaceExplorer.setFont(new Font("Phosphate", Font.PLAIN, 48));
		lblSpaceExplorer.setBounds(158, 77, 440, 268);
		contentPane.add(lblSpaceExplorer);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				setUp_start_GUI window = new setUp_start_GUI();
				window.setVisible(true);
			}
		});
		btnNewButton.setBounds(602, 345, 117, 68);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(welcome_gui.class.getResource("/Game/images/space.png")));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 745, 437);
		contentPane.add(lblNewLabel);
	}
}