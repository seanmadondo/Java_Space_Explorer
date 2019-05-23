package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
/**
 * @author jle147
 * @author sma297
 *This alerts the user of the end result of their game. This class will show 2 panels for the event of a win or a loss
 *This interface follows the ship_gui interface once the user has found all the parts or if the user has ran out of days with parts to find.
 */
public class end_gui extends JFrame {

	private JPanel contentPane;
	public static end_gui frame = new end_gui();
	public ship s = new ship();
	
	/**
	 * Sets the current ship object and its current attribute information.
	 * @param s		The current state of the ship object.
	 */
	
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
		setBounds(100, 100, 800, 600);
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
		
		lblYourScore.setBackground(new Color(238, 238, 238));
		lblYourScore.setFont(new Font("Dialog", Font.BOLD, 28));
		lblYourScore.setBounds(176, 284, 183, 56);
		contentPane.add(lblYourScore);
		
		JLabel scoreLabel = new JLabel("");
		scoreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		
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
		lbl_info_label.setBounds(12, 228, 744, 56);
		contentPane.add(lbl_info_label);
		
		/**
		 * This Gui is triggered by this mouse hover in order to output the end result display.
		 */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if (s.parts_missing <= 0)
				{
					lblNewLabel.setIcon(new ImageIcon(end_gui.class.getResource("/Game/images/rocket-and-planet-gif.gif")));
					lblYourScore.setForeground(Color.GREEN);
					scoreLabel.setForeground(Color.GREEN);
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
					lblNewLabel.setIcon(new ImageIcon(end_gui.class.getResource("/Game/images/lost.gif")));
					lblNewLabel.setForeground(Color.black);
					lblYourScore.setForeground(Color.RED);
					scoreLabel.setForeground(Color.RED);
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
		
		lblNewLabel.setBounds(0, 0, 800, 572);
		contentPane.add(lblNewLabel);
	}
}
