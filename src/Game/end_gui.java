package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class end_gui extends JFrame {

	private JPanel contentPane;
	public static end_gui frame = new end_gui();
	public ship s = new ship();
	
	public void setShip (ship s) {
		this.s = s;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					end_gui frame = new end_gui();
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
	public end_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameOver = new JLabel("GAME OVER!");
		lblGameOver.setForeground(Color.WHITE);
		lblGameOver.setFont(new Font("Silom", Font.BOLD, 58));
		lblGameOver.setBounds(183, 88, 401, 158);
		contentPane.add(lblGameOver);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setForeground(Color.WHITE);
		lblYourScore.setBackground(new Color(238, 238, 238));
		lblYourScore.setFont(new Font("Silom", Font.PLAIN, 28));
		lblYourScore.setBounds(196, 284, 171, 56);
		contentPane.add(lblYourScore);
		
		JLabel scoreLabel = new JLabel("");
		scoreLabel.setBounds(368, 284, 158, 56);
		scoreLabel.setText(Integer.toString(s.score));
		contentPane.add(scoreLabel);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frame.setVisible(false);
			}
		});
		btnQuit.setBounds(625, 447, 137, 56);
		contentPane.add(btnQuit);
		
		JButton btnStartOver = new JButton("CONTINUE");
		btnStartOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frame.setVisible(false);
				welcome_gui window = new welcome_gui();
				window.setVisible(true);
			}
		});
		btnStartOver.setBounds(467, 447, 137, 56);
		contentPane.add(btnStartOver);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(end_gui.class.getResource("/Game/images/space.png")));
		lblNewLabel.setBounds(0, 0, 768, 509);
		contentPane.add(lblNewLabel);
	}
}
