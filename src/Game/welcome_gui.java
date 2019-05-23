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
import javax.swing.border.BevelBorder;
/**
 * @author jle147
 * @author sma297
 *Welcomes the User to the game. Start button allows the user to go to the next gui and start the game.
 */
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
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSpaceExplorer = new JLabel("SPACE EXPLORER");
		lblSpaceExplorer.setForeground(Color.WHITE);
		lblSpaceExplorer.setFont(new Font("Dialog", Font.PLAIN, 55));
		lblSpaceExplorer.setBounds(181, 28, 628, 198);
		contentPane.add(lblSpaceExplorer);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame.setVisible(false);
				setUp_start_GUI window = new setUp_start_GUI();
				window.setVisible(true);
			}
		});
		btnNewButton.setBounds(602, 457, 186, 103);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(welcome_gui.class.getResource("/Game/images/space-dribbble.gif")));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 0, 850, 572);
		contentPane.add(lblNewLabel);
	}
}
