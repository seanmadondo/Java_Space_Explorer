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
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class ship_gui extends JFrame {

	private JPanel contentPane;
	private JPanel action_panel;
	private JPanel outpost_panel;
	private JPanel fly_panel;
	private JPanel eat_panel;
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
		ship s = new ship();
		Character_1 char_1 = new Character_1();
		Character_2 char_2 = new Character_2();
		Character_3 char_3 = new Character_3();
		Character_4 char_4 = new Character_4();
		Character_5 char_5 = new Character_5();
		Character_6 char_6 = new Character_6();
		food1 f1 = new food1();
		food2 f2 = new food2();
		food3 f3 = new food3();
		food4 f4 = new food4();
		food5 f5 = new food5();
		food6 f6 = new food6();
		health_potion_1 med1 = new health_potion_1();
		health_potion_2 med2 = new health_potion_2();
		health_potion_3 med3 = new health_potion_3();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 117, 838, 455);
		contentPane.add(layeredPane);
		
		outpost_panel = new JPanel();
		outpost_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(outpost_panel);
		outpost_panel.setLayout(null);
		
		JButton btn_buyFood1 = new JButton("food1");
		btn_buyFood1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btn_buyFood1.setBounds(140, 56, 85, 77);
		outpost_panel.add(btn_buyFood1);
		
		JButton btn_buyFood2 = new JButton("food2");
		btn_buyFood2.setBounds(237, 56, 85, 77);
		outpost_panel.add(btn_buyFood2);
		
		JButton btn_buyFood3 = new JButton("food3");
		btn_buyFood3.setBounds(331, 56, 85, 77);
		outpost_panel.add(btn_buyFood3);
		
		JButton btn_buyFood4 = new JButton("food4");
		btn_buyFood4.setBounds(428, 56, 85, 77);
		outpost_panel.add(btn_buyFood4);
		
		JButton btn_buyFood5 = new JButton("food5");
		btn_buyFood5.setBounds(525, 56, 85, 77);
		outpost_panel.add(btn_buyFood5);
		
		JButton button_14 = new JButton("New button");
		button_14.setBounds(622, 56, 85, 77);
		outpost_panel.add(button_14);
		
		JButton button_15 = new JButton("New button");
		button_15.setBounds(140, 204, 85, 77);
		outpost_panel.add(button_15);
		
		JButton button_16 = new JButton("New button");
		button_16.setBounds(237, 204, 85, 77);
		outpost_panel.add(button_16);
		
		JButton button_17 = new JButton("New button");
		button_17.setBounds(331, 204, 85, 77);
		outpost_panel.add(button_17);
		
		JButton button_18 = new JButton("New button");
		button_18.setBounds(428, 204, 85, 77);
		outpost_panel.add(button_18);
		
		JLabel lblFood = new JLabel("food:");
		lblFood.setBounds(140, 28, 61, 16);
		outpost_panel.add(lblFood);
		
		JLabel lblMeds = new JLabel("meds:");
		lblMeds.setBounds(140, 176, 61, 16);
		outpost_panel.add(lblMeds);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(364, 370, 61, 16);
		outpost_panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("$");
		lblNewLabel_1.setBounds(344, 370, 8, 16);
		outpost_panel.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(141, 130, 85, 29);
		outpost_panel.add(btnNewButton_2);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(238, 130, 85, 29);
		outpost_panel.add(button_9);
		
		JButton button_23 = new JButton("New button");
		button_23.setBounds(332, 130, 85, 29);
		outpost_panel.add(button_23);
		
		JButton button_24 = new JButton("New button");
		button_24.setBounds(429, 130, 85, 29);
		outpost_panel.add(button_24);
		
		JButton button_25 = new JButton("New button");
		button_25.setBounds(526, 130, 85, 29);
		outpost_panel.add(button_25);
		
		JButton button_26 = new JButton("New button");
		button_26.setBounds(623, 130, 85, 29);
		outpost_panel.add(button_26);
		
		JButton button_27 = new JButton("New button");
		button_27.setBounds(140, 278, 85, 29);
		outpost_panel.add(button_27);
		
		JButton button_28 = new JButton("New button");
		button_28.setBounds(237, 278, 85, 29);
		outpost_panel.add(button_28);
		
		JButton button_29 = new JButton("New button");
		button_29.setBounds(331, 278, 85, 29);
		outpost_panel.add(button_29);
		
		JButton button_30 = new JButton("New button");
		button_30.setBounds(428, 278, 85, 29);
		outpost_panel.add(button_30);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 838, 455);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		action_panel = new JPanel();
		action_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(action_panel);
		action_panel.setLayout(null);
		
		JButton btn_charSleep = new JButton("sleep");
		btn_charSleep.setBounds(693, 57, 139, 73);
		action_panel.add(btn_charSleep);
		
		JButton btn_charRepair = new JButton("repair");
		btn_charRepair.setBounds(693, 142, 139, 73);
		action_panel.add(btn_charRepair);
		
		JButton btn_search = new JButton("search");
		btn_search.setBounds(693, 227, 139, 73);
		action_panel.add(btn_search);
		
		JButton btn_currentChar1 = new JButton("New button");
		btn_currentChar1.setBounds(123, 45, 110, 98);
		action_panel.add(btn_currentChar1);
		
		JButton btn_currentChar2 = new JButton("New button");
		btn_currentChar2.setBounds(245, 45, 110, 98);
		action_panel.add(btn_currentChar2);
		
		JButton btn_currentChar3 = new JButton("New button");
		btn_currentChar3.setBounds(367, 45, 110, 98);
		action_panel.add(btn_currentChar3);
		
		JButton btn_currentChar4 = new JButton("New button");
		btn_currentChar4.setBounds(489, 45, 110, 98);
		action_panel.add(btn_currentChar4);
		
		JLabel label = new JLabel("Health:");
		label.setBounds(152, 270, 52, 16);
		action_panel.add(label);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(208, 272, 362, 14);
		action_panel.add(progressBar);
		
		JLabel label_1 = new JLabel("Tiredness:");
		label_1.setBounds(131, 297, 78, 16);
		action_panel.add(label_1);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(208, 298, 362, 14);
		action_panel.add(progressBar_1);
		
		JLabel label_2 = new JLabel("Hunger:");
		label_2.setBounds(145, 322, 61, 16);
		action_panel.add(label_2);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(208, 324, 362, 14);
		action_panel.add(progressBar_2);
		
		JButton btnNewButton_3 = new JButton("eat");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(eat_panel);
			}
		});
		btnNewButton_3.setBounds(693, 312, 139, 73);
		action_panel.add(btnNewButton_3);
		
		fly_panel = new JPanel();
		fly_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(fly_panel);
		fly_panel.setLayout(null);
		
		JButton button_19 = new JButton("New button");
		button_19.setBounds(181, 65, 110, 98);
		fly_panel.add(button_19);
		
		JButton button_20 = new JButton("New button");
		button_20.setBounds(303, 65, 110, 98);
		fly_panel.add(button_20);
		
		JButton button_21 = new JButton("New button");
		button_21.setBounds(425, 65, 110, 98);
		fly_panel.add(button_21);
		
		JButton button_22 = new JButton("New button");
		button_22.setBounds(547, 65, 110, 98);
		fly_panel.add(button_22);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(363, 297, 117, 64);
		fly_panel.add(btnNewButton_1);
		
		eat_panel = new JPanel();
		eat_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(eat_panel);
		eat_panel.setLayout(null);
		
		JLabel label_3 = new JLabel("Health:");
		label_3.setBounds(211, 341, 52, 16);
		eat_panel.add(label_3);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(267, 343, 362, 14);
		eat_panel.add(progressBar_3);
		
		JLabel label_4 = new JLabel("Tiredness:");
		label_4.setBounds(190, 368, 78, 16);
		eat_panel.add(label_4);
		
		JProgressBar progressBar_4 = new JProgressBar();
		progressBar_4.setBounds(267, 369, 362, 14);
		eat_panel.add(progressBar_4);
		
		JLabel label_5 = new JLabel("Hunger:");
		label_5.setBounds(204, 393, 61, 16);
		eat_panel.add(label_5);
		
		JProgressBar progressBar_5 = new JProgressBar();
		progressBar_5.setBounds(267, 395, 362, 14);
		eat_panel.add(progressBar_5);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(137, 39, 85, 77);
		eat_panel.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(234, 39, 85, 77);
		eat_panel.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(328, 39, 85, 77);
		eat_panel.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(425, 39, 85, 77);
		eat_panel.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(522, 39, 85, 77);
		eat_panel.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(619, 39, 85, 77);
		eat_panel.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(234, 191, 85, 77);
		eat_panel.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(331, 191, 85, 77);
		eat_panel.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(428, 191, 85, 77);
		eat_panel.add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(525, 191, 85, 77);
		eat_panel.add(button_8);
		
		JButton btn_fly = new JButton("fly");
		btn_fly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(fly_panel);
			}
		});
		btn_fly.setBounds(43, 6, 117, 64);
		contentPane.add(btn_fly);
		
		JButton btn_outpost = new JButton("outpost");
		btn_outpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(outpost_panel);
			}
		});
		btn_outpost.setBounds(172, 6, 117, 64);
		contentPane.add(btn_outpost);
		
		JButton btn_action = new JButton("action");
		btn_action.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(action_panel);
			}
		});
		btn_action.setBounds(301, 6, 117, 64);
		contentPane.add(btn_action);
		
		JButton btn_nextDay = new JButton("next day");
		btn_nextDay.setBounds(727, 6, 117, 98);
		contentPane.add(btn_nextDay);
		
		JLabel lbl_days = new JLabel("0");
		lbl_days.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lbl_days.setBounds(570, 6, 44, 81);
		contentPane.add(lbl_days);
	}
}
