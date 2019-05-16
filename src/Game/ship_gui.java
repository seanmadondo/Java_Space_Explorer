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
import java.awt.Color;

public class ship_gui extends JFrame {

	private JPanel contentPane;
	private JPanel action_panel;
	private JPanel outpost_panel;
	private JPanel fly_panel;
	private JPanel eat_panel;
	private JLayeredPane layeredPane;
	
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
	
	characters_Command current_char;

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
		
		action_panel = new JPanel();
		action_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(action_panel);
		action_panel.setLayout(null);
		
		JLabel lbl_actionError = new JLabel("");
		lbl_actionError.setForeground(Color.RED);
		lbl_actionError.setBounds(208, 199, 362, 16);
		action_panel.add(lbl_actionError);
		
		JButton btn_charSleep = new JButton("sleep");
		btn_charSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.sleep(current_char);
				}catch(NullPointerException e1)
				{
					lbl_actionError.setText("Choose a pilot!");
				}
			}
		});
		btn_charSleep.setBounds(693, 57, 139, 73);
		action_panel.add(btn_charSleep);
		
		JButton btn_charRepair = new JButton("repair");
		btn_charRepair.setBounds(693, 142, 139, 73);
		action_panel.add(btn_charRepair);
		
		JButton btn_search = new JButton("search");
		btn_search.setBounds(693, 227, 139, 73);
		action_panel.add(btn_search);
		
		JButton btnNewButton_3 = new JButton("eat");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(eat_panel);
			}
		});
		btnNewButton_3.setBounds(693, 312, 139, 73);
		action_panel.add(btnNewButton_3);
		
		JLabel lbl_Health = new JLabel("Health:");
		lbl_Health.setBounds(152, 270, 52, 16);
		action_panel.add(lbl_Health);
		
		JProgressBar bar_Health = new JProgressBar();
		bar_Health.setBounds(208, 272, 362, 14);
		action_panel.add(bar_Health);
		
		JLabel label_1 = new JLabel("Tiredness:");
		label_1.setBounds(131, 297, 78, 16);
		action_panel.add(label_1);
		
		JProgressBar bar_Tiredness = new JProgressBar();
		bar_Tiredness.setBounds(208, 298, 362, 14);
		action_panel.add(bar_Tiredness);
		
		JLabel label_2 = new JLabel("Hunger:");
		label_2.setBounds(145, 322, 61, 16);
		action_panel.add(label_2);
		
		JProgressBar bar_Hunger = new JProgressBar();
		bar_Hunger.setBounds(208, 324, 362, 14);
		action_panel.add(bar_Hunger);
		
		JButton btn_currentChar1 = new JButton("New button");
		btn_currentChar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					current_char = s.pilots.get(0);
					//current_char = char_1;
					bar_Health.setValue(current_char.pilot_health);
					bar_Tiredness.setValue(current_char.pilot_tired);
					bar_Hunger.setValue(current_char.pilot_hunger);
					
				} catch(IndexOutOfBoundsException e1)
				{
					lbl_actionError.setText("The slot is empty!");
				}
			}
		});
		btn_currentChar1.setBounds(123, 45, 110, 98);
		action_panel.add(btn_currentChar1);
		
		JButton btn_currentChar2 = new JButton("New button");
		btn_currentChar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					current_char = s.pilots.get(1);
				} catch(IndexOutOfBoundsException e1)
				{
					lbl_actionError.setText("The slot is empty!");
				}
			}
		});
		btn_currentChar2.setBounds(245, 45, 110, 98);
		action_panel.add(btn_currentChar2);
		
		JButton btn_currentChar3 = new JButton("New button");
		btn_currentChar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					current_char = s.pilots.get(2);
				} catch(IndexOutOfBoundsException e1)
				{
					lbl_actionError.setText("The slot is empty!");
				}
			}
		});
		btn_currentChar3.setBounds(367, 45, 110, 98);
		action_panel.add(btn_currentChar3);
		
		JButton btn_currentChar4 = new JButton("New button");
		btn_currentChar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					current_char = s.pilots.get(3);
				} catch(IndexOutOfBoundsException e1)
				{
					lbl_actionError.setText("The slot is empty!");
				}
			}
		});
		btn_currentChar4.setBounds(489, 45, 110, 98);
		action_panel.add(btn_currentChar4);
		
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
		
		fly_panel = new JPanel();
		fly_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(fly_panel);
		fly_panel.setLayout(null);
		
		JLabel lbl_flyError = new JLabel("");
		lbl_flyError.setBounds(363, 23, 295, 16);
		fly_panel.add(lbl_flyError);
		
		JButton btn_tofly1 = new JButton("");
		btn_tofly1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (s.flying_pilots.size() >= 2)
				{
					lbl_flyError.setText("you need to choose 2!");
				} else
				{
					try
					{
						s.flying_pilots.add(s.pilots.get(0));
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_flyError.setText("This slot is empty!");
					}
				}
			}
		});
		btn_tofly1.setBounds(181, 65, 110, 98);
		fly_panel.add(btn_tofly1);
		
		JButton btn_tofly2 = new JButton("");
		btn_tofly2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (s.flying_pilots.size() >= 2)
				{
					lbl_flyError.setText("you need to choose 2!");
				} else
				{
					try
					{
						s.flying_pilots.add(s.pilots.get(1));
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_flyError.setText("This slot is empty!");
					}
				}
			}
		});
		btn_tofly2.setBounds(303, 65, 110, 98);
		fly_panel.add(btn_tofly2);
		
		JButton btn_tofly3 = new JButton("");
		btn_tofly3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (s.flying_pilots.size() >= 2)
				{
					lbl_flyError.setText("you need to choose 2!");
				} else
				{
					try
					{
						s.flying_pilots.add(s.pilots.get(2));
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_flyError.setText("This slot is empty!");
					}
				}
			}
		});
		btn_tofly3.setBounds(425, 65, 110, 98);
		fly_panel.add(btn_tofly3);
		
		JButton btn_tofly4 = new JButton("");
		btn_tofly4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (s.flying_pilots.size() >= 2)
				{
					lbl_flyError.setText("you need to choose 2!");
				} else
				{
					try
					{
						s.flying_pilots.add(s.pilots.get(3));
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_flyError.setText("This slot is empty!");
					}
				}
			}
		});
		btn_tofly4.setBounds(547, 65, 110, 98);
		fly_panel.add(btn_tofly4);
		
		JButton btn_fly = new JButton("Fly!");
		btn_fly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (s.flying_pilots.size() > 2 || s.flying_pilots.size() < 2)
				{
					lbl_flyError.setText("you need to choose 2!");
				} else
				{
					s.fly(s.flying_pilots.get(0), s.flying_pilots.get(1));
				}
			}
		});
		btn_fly.setBounds(363, 297, 117, 64);
		fly_panel.add(btn_fly);
		
		outpost_panel = new JPanel();
		outpost_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(outpost_panel);
		outpost_panel.setLayout(null);
		
		JLabel lbl_quantity1 = new JLabel("");
		lbl_quantity1.setForeground(Color.RED);
		lbl_quantity1.setBounds(203, 56, 22, 16);
		outpost_panel.add(lbl_quantity1);
		
		JLabel lbl_crewCurrentMoney = new JLabel("");
		lbl_crewCurrentMoney.setBounds(322, 370, 61, 16);
		lbl_crewCurrentMoney.setText(Integer.toString(s.crew_money));
		outpost_panel.add(lbl_crewCurrentMoney);
		
		
		JLabel lbl_dollarSign = new JLabel("$");
		lbl_dollarSign.setBounds(302, 370, 8, 16);
		outpost_panel.add(lbl_dollarSign);
		
		JLabel lbl_dollarSignRed = new JLabel("$");
		lbl_dollarSignRed.setForeground(Color.RED);
		lbl_dollarSignRed.setBounds(415, 370, 8, 16);
		outpost_panel.add(lbl_dollarSignRed);
		
		JLabel lbl_foodPrice = new JLabel("");
		lbl_foodPrice.setForeground(Color.RED);
		lbl_foodPrice.setBounds(428, 370, 61, 16);
		lbl_foodPrice.setText(Integer.toString(s.total_item_price));
		outpost_panel.add(lbl_foodPrice);
		
		JLabel lbl_buyItemError = new JLabel("");
		lbl_buyItemError.setForeground(Color.RED);
		lbl_buyItemError.setBounds(182, 28, 155, 16);
		outpost_panel.add(lbl_buyItemError);
		
		JButton btn_buyFood1 = new JButton("food1");
		btn_buyFood1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					s.add_foods(f1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
				
			}
		});
		btn_buyFood1.setBounds(140, 56, 85, 77);
		outpost_panel.add(btn_buyFood1);
		
		JButton btn_cancelF1 = new JButton("x");
		btn_cancelF1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
//					s.quantity1 = 0;
//					lbl_quantity1.setText(Integer.toString(s.quantity1));
					s.remove_foods(f1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF1.setBounds(141, 130, 85, 29);
		outpost_panel.add(btn_cancelF1);
		
		JButton btn_buyFood2 = new JButton("food2");
		btn_buyFood2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(f2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyFood2.setBounds(237, 56, 85, 77);
		outpost_panel.add(btn_buyFood2);
		
		JButton btn_cancelF2 = new JButton("x");
		btn_cancelF2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(f2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF2.setBounds(238, 130, 85, 29);
		outpost_panel.add(btn_cancelF2);
		
		JButton btn_buyFood3 = new JButton("food3");
		btn_buyFood3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(f3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyFood3.setBounds(331, 56, 85, 77);
		outpost_panel.add(btn_buyFood3);
		
		JButton btn_cancelF3 = new JButton("x");
		btn_cancelF3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(f3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF3.setBounds(332, 130, 85, 29);
		outpost_panel.add(btn_cancelF3);
		
		JButton btn_buyFood4 = new JButton("food4");
		btn_buyFood4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					s.add_foods(f4);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyFood4.setBounds(428, 56, 85, 77);
		outpost_panel.add(btn_buyFood4);
		
		JButton btn_cancelF4 = new JButton("x");
		btn_cancelF4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(f4);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF4.setBounds(429, 130, 85, 29);
		outpost_panel.add(btn_cancelF4);
		
		JButton btn_buyFood5 = new JButton("food5");
		btn_buyFood5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(f5);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyFood5.setBounds(525, 56, 85, 77);
		outpost_panel.add(btn_buyFood5);
		
		JButton btn_cancelF5 = new JButton("x");
		btn_cancelF5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(f5);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF5.setBounds(526, 130, 85, 29);
		outpost_panel.add(btn_cancelF5);
		
		JButton btn_buyFood6 = new JButton("food6");
		btn_buyFood6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					s.add_foods(f6);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyFood6.setBounds(622, 56, 85, 77);
		outpost_panel.add(btn_buyFood6);
		
		JButton btn_cancelF6 = new JButton("x");
		btn_cancelF6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(f6);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF6.setBounds(623, 130, 85, 29);
		outpost_panel.add(btn_cancelF6);
		
		JButton btn_buyMed1 = new JButton("med1");
		btn_buyMed1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(med1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyMed1.setBounds(140, 204, 85, 77);
		outpost_panel.add(btn_buyMed1);
		
		JButton btn_cancelM1 = new JButton("x");
		btn_cancelM1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(med1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelM1.setBounds(140, 278, 85, 29);
		outpost_panel.add(btn_cancelM1);
		
		JButton btn_buyMed2 = new JButton("med2");
		btn_buyMed2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(med2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyMed2.setBounds(237, 204, 85, 77);
		outpost_panel.add(btn_buyMed2);
		
		JButton btn_cancelM2 = new JButton("x");
		btn_cancelM2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(med2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelM2.setBounds(237, 278, 85, 29);
		outpost_panel.add(btn_cancelM2);
		
		JButton btn_buyMed3 = new JButton("med3");
		btn_buyMed3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(med3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_buyMed3.setBounds(331, 204, 85, 77);
		outpost_panel.add(btn_buyMed3);
		
		JButton btn_cancelM3 = new JButton("x");
		btn_cancelM3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.remove_foods(med3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelM3.setBounds(331, 278, 85, 29);
		outpost_panel.add(btn_cancelM3);
		
		JLabel lblFood = new JLabel("food:");
		lblFood.setBounds(140, 28, 61, 16);
		outpost_panel.add(lblFood);
		
		JLabel lblMeds = new JLabel("meds:");
		lblMeds.setBounds(140, 176, 61, 16);
		outpost_panel.add(lblMeds);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(395, 370, 8, 16);
		outpost_panel.add(lblNewLabel_2);
		
		JLabel lbl_purchased = new JLabel("");
		lbl_purchased.setForeground(Color.GREEN);
		lbl_purchased.setBounds(556, 308, 127, 16);
		outpost_panel.add(lbl_purchased);
		
		JButton btn_buyItems = new JButton("buy");
		btn_buyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (s.foodsBuyList.isEmpty())
				{
					lbl_buyItemError.setText("You have to choose what you want!");
				}else
				{
					for (Food_and_Med_Command i : s.foodsBuyList)
					{
						s.foods.add(i);
					}
					s.crew_money -= s.total_item_price;
					s.total_item_price = 0;
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_crewCurrentMoney.setText(Integer.toString(s.crew_money));
					lbl_purchased.setText("Purchased");
					lbl_buyItemError.setText("");
				}
			}
		});
		btn_buyItems.setBounds(556, 365, 127, 67);
		outpost_panel.add(btn_buyItems);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 838, 455);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_flyPanel = new JButton("fly");
		btn_flyPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(fly_panel);
				for (characters_Command i : s.pilots)
				{
					
				}
			}
		});
		btn_flyPanel.setBounds(43, 6, 117, 64);
		contentPane.add(btn_flyPanel);
		
		JButton btn_outpostPanel = new JButton("outpost");
		btn_outpostPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				switchPanels(outpost_panel);
				lbl_purchased.setText("");
			}
		});
		btn_outpostPanel.setBounds(172, 6, 117, 64);
		contentPane.add(btn_outpostPanel);
		
		JButton btn_actionPanel = new JButton("action");
		btn_actionPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(action_panel);
			}
		});
		btn_actionPanel.setBounds(301, 6, 117, 64);
		contentPane.add(btn_actionPanel);
		
		JButton btn_nextDay = new JButton("next day");
		btn_nextDay.setBounds(727, 6, 117, 98);
		contentPane.add(btn_nextDay);
		
		JLabel lbl_days = new JLabel("0");
		lbl_days.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lbl_days.setBounds(570, 6, 44, 81);
		contentPane.add(lbl_days);
	}
}
