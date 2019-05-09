package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ship_gui extends JFrame {

	private JPanel contentPane;
	private JPanel action_panel;
	private JPanel outpost_panel;
	private JPanel fly_panel;
	private JPanel status_panel;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ship_gui frame = new ship_gui();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public ship_gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 117, 838, 455);
		contentPane.add(layeredPane);
		
		status_panel = new JPanel();
		status_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(status_panel);
		
		fly_panel = new JPanel();
		fly_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(fly_panel);
		
		outpost_panel = new JPanel();
		outpost_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(outpost_panel);
		
		action_panel = new JPanel();
		action_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(action_panel);
		
		JButton btn_nextDay = new JButton("next day");
		btn_nextDay.setBounds(727, 6, 117, 98);
		contentPane.add(btn_nextDay);
		
		JButton btn_status = new JButton("status");
		btn_status.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(status_panel);
			}
		});
		btn_status.setBounds(6, 6, 117, 64);
		contentPane.add(btn_status);
		
		JButton btn_fly = new JButton("fly");
		btn_fly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(fly_panel);
			}
		});
		btn_fly.setBounds(135, 6, 117, 64);
		contentPane.add(btn_fly);
		
		JButton btn_outpost = new JButton("outpost");
		btn_outpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(outpost_panel);
			}
		});
		btn_outpost.setBounds(264, 6, 117, 64);
		contentPane.add(btn_outpost);
		
		JButton btn_action = new JButton("action");
		btn_action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(action_panel);
			}
		});
		btn_action.setBounds(393, 6, 117, 64);
		contentPane.add(btn_action);
	}
}
