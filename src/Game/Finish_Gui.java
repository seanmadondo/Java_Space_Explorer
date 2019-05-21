package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Finish_Gui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finish_Gui frame = new Finish_Gui();
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
	public Finish_Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_won = new JLabel("You Sruvived!");
		lbl_won.setFont(new Font("Lucida Grande", Font.PLAIN, 55));
		lbl_won.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_won.setBounds(74, 25, 699, 98);
		contentPane.add(lbl_won);
		
		JLabel lbl_lost = new JLabel("Game Over");
		lbl_lost.setFont(new Font("Lucida Grande", Font.PLAIN, 55));
		lbl_lost.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_lost.setBounds(74, 25, 699, 98);
		contentPane.add(lbl_lost);
		
		JLabel lblNewLabel_1 = new JLabel("Score:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(183, 256, 158, 60);
		contentPane.add(lblNewLabel_1);
		
		JButton btn_startAgain = new JButton("Play Again?");
		btn_startAgain.setBounds(226, 449, 195, 98);
		contentPane.add(btn_startAgain);
		
		JButton btn_Finish = new JButton("Finish and Close");
		btn_Finish.setBounds(460, 449, 195, 98);
		contentPane.add(btn_Finish);
		
		JLabel lbl_score = new JLabel("");
		//lbl_score.setText(Integer.toString());
		lbl_score.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lbl_score.setBounds(413, 256, 277, 60);
		contentPane.add(lbl_score);
	}
}
