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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

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
	public end_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGameOver = new JLabel("");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Silom", Font.BOLD, 58));
		lblGameOver.setBounds(153, 37, 461, 158);
		contentPane.add(lblGameOver);
		
		JLabel lblYourScore = new JLabel("Your Score:");
		lblYourScore.setForeground(Color.WHITE);
		lblYourScore.setBackground(new Color(238, 238, 238));
		lblYourScore.setFont(new Font("Dialog", Font.BOLD, 28));
		lblYourScore.setBounds(176, 284, 183, 56);
		contentPane.add(lblYourScore);
		
		JLabel scoreLabel = new JLabel("");
		scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(371, 284, 158, 56);
		contentPane.add(scoreLabel);
		
		
		
		
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				frame.setVisible(false);
			}
		});
		btnQuit.setBounds(603, 424, 137, 56);
		contentPane.add(btnQuit);
		
		JButton btnStartOver = new JButton("CONTINUE");
		btnStartOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				frame.setVisible(false);
				welcome_gui window = new welcome_gui();
				window.setVisible(true);
			}
		});
		btnStartOver.setBounds(454, 424, 137, 56);
		contentPane.add(btnStartOver);
		
		JLabel lbl_info_label = new JLabel("");
		lbl_info_label.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info_label.setForeground(Color.RED);
		lbl_info_label.setFont(new Font("DialogInput", Font.BOLD, 23));
		lbl_info_label.setBounds(12, 229, 744, 56);
		contentPane.add(lbl_info_label);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if (s.parts_missing <= 0)
				{
					lblGameOver.setForeground(Color.GREEN);
					if ( s.score <= 0) {
						scoreLabel.setText("0");
						lbl_info_label.setText("You are back on earth!");
					} else {
						scoreLabel.setText(" " + s.score);
						lbl_info_label.setText("You are back on earth!");
					}
					lblGameOver.setText("YOU WON!");
				}else
				{
					lblGameOver.setForeground(Color.RED);
					if ( s.score <= 0) {
						
						scoreLabel.setText("0");
						lbl_info_label.setText("Ooops, you ran out of days with " + s.parts_missing + " parts left to find!");
					} else {
						scoreLabel.setText(" " + s.score);
						lbl_info_label.setText("Ooops, you ran out of days with " + s.parts_missing + " parts left to find!");
					}
					lblGameOver.setText("GAME OVER!");
				}
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(end_gui.class.getResource("/Game/images/space.png")));
		lblNewLabel.setBounds(0, 0, 768, 509);
		contentPane.add(lblNewLabel);
	}
}
