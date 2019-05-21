package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ship_gui extends JFrame {

	private JPanel contentPane;
	private JPanel action_panel;
	private JPanel outpost_panel;
	private JPanel fly_panel;
	private JPanel eat_panel;
	private JLayeredPane layeredPane;
	public static ship_gui frame = new ship_gui();
	public ship s = new ship();
	/**
	 * Launch the application.
	 */
	public void setShip(ship s)
	{
		this.s = s;
	}
	
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
		
		//buttons border settings
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 117, 838, 455);
		contentPane.add(layeredPane);
		
		JProgressBar bar_shipShield = new JProgressBar();
		bar_shipShield.setValue(s.shield_level);
		bar_shipShield.setBounds(6, 97, 838, 20);
		contentPane.add(bar_shipShield);
		
		JLabel lbl_days = new JLabel("0");
		lbl_days.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lbl_days.setBounds(662, 21, 38, 49);
		contentPane.add(lbl_days);
		
		JLabel lbl_missingParts = new JLabel("0");
		lbl_missingParts.setFont(new Font("Lucida Grande", Font.PLAIN, 60));
		lbl_missingParts.setBounds(567, 13, 38, 64);
		contentPane.add(lbl_missingParts);
		
		JButton btn_food1 = new JButton("");
		JButton btn_food2 = new JButton("");
		JButton btn_food3 = new JButton("");
		JButton btn_food4 = new JButton("");
		JButton btn_food5 = new JButton("");
		JButton btn_food6 = new JButton("");
		JButton btn_med1 = new JButton("");
		JButton btn_med2 = new JButton("");
		JButton btn_med3 = new JButton("");
		JButton[] btn_food_and_med = new JButton[]{btn_food1, btn_food2, btn_food3, btn_food4, btn_food5, btn_food6, btn_med1, btn_med2, btn_med3};
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 838, 455);
		layeredPane.add(panel);
		panel.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				lbl_days.setText(Integer.toString(s.numDays));
				lbl_missingParts.setText(Integer.toString(s.parts_missing));
			}
		});
		panel.setLayout(null);
		
		
		
		eat_panel = new JPanel();
		eat_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(eat_panel);
		eat_panel.setLayout(null);
		
		JLabel lbl_food1Q = new JLabel("0");
		lbl_food1Q.setBounds(214, 39, 8, 16);
		eat_panel.add(lbl_food1Q);
		
		JLabel lbl_food2Q = new JLabel("0");
		lbl_food2Q.setBounds(311, 39, 8, 16);
		eat_panel.add(lbl_food2Q);
		
		JLabel lbl_food3Q = new JLabel("0");
		lbl_food3Q.setBounds(405, 39, 8, 16);
		eat_panel.add(lbl_food3Q);
		
		JLabel lbl_food4Q = new JLabel("0");
		lbl_food4Q.setBounds(503, 39, 8, 16);
		eat_panel.add(lbl_food4Q);
		
		JLabel lbl_food5Q = new JLabel("0");
		lbl_food5Q.setBounds(599, 39, 8, 16);
		eat_panel.add(lbl_food5Q);
		
		JLabel lbl_food6Q = new JLabel("0");
		lbl_food6Q.setBounds(696, 39, 8, 16);
		eat_panel.add(lbl_food6Q);
		
		JLabel lbl_med1Q = new JLabel("0");
		lbl_med1Q.setBounds(311, 191, 8, 16);
		eat_panel.add(lbl_med1Q);
		
		JLabel lbl_med2Q = new JLabel("0");
		lbl_med2Q.setBounds(405, 191, 8, 16);
		eat_panel.add(lbl_med2Q);
		
		JLabel lbl_med3Q = new JLabel("0");
		lbl_med3Q.setBounds(502, 191, 8, 16);
		eat_panel.add(lbl_med3Q);
		
		JLabel lbl_eatError = new JLabel("");
		lbl_eatError.setForeground(Color.RED);
		lbl_eatError.setBounds(267, 302, 519, 16);
		eat_panel.add(lbl_eatError);
		
		JLabel label_3 = new JLabel("Health:");
		label_3.setBounds(211, 341, 52, 16);
		eat_panel.add(label_3);
		
		JProgressBar health_bar = new JProgressBar();
		health_bar.setBounds(267, 343, 362, 14);
		eat_panel.add(health_bar);
		
		JLabel label_4 = new JLabel("Tiredness:");
		label_4.setBounds(190, 368, 78, 16);
		eat_panel.add(label_4);
		
		JProgressBar tiredness_bar = new JProgressBar();
		tiredness_bar.setBounds(267, 369, 362, 14);
		eat_panel.add(tiredness_bar);
		
		JLabel label_5 = new JLabel("Hunger:");
		label_5.setBounds(204, 393, 61, 16);
		eat_panel.add(label_5);
		
		JProgressBar hunger_bar = new JProgressBar();
		hunger_bar.setBounds(267, 395, 362, 14);
		eat_panel.add(hunger_bar);
		
		
		
		
		
		
		btn_food1.setBorder(raisedbevel);
		btn_food1.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/food1.png")));
		btn_food1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_food1.setIcon(null);
				btn_food1.setText("<html>+0<br />-10</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_food1.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food1.png"));
				btn_food1.setText("");
			}
		});
		btn_food1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(btn_food1.getBorder() == loweredbevel)
				{
					btn_food1.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_food1)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.f1);
						btn_food1.setBorder(loweredbevel);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_food1.setBounds(137, 39, 85, 77);
		eat_panel.add(btn_food1);
		
		btn_food2.setBorder(raisedbevel);
		btn_food2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food2.png"));
		btn_food2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_food2.setIcon(null);
				btn_food2.setText("<html>+0<br />-20</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_food2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food2.png"));
				btn_food2.setText("");
			}
		});
		btn_food2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(btn_food2.getBorder() == loweredbevel)
				{
					btn_food2.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_food2)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.f2);
						btn_food2.setBorder(loweredbevel);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_food2.setBounds(234, 39, 85, 77);
		eat_panel.add(btn_food2);
		
		btn_food3.setBorder(raisedbevel);
		btn_food3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food3.png"));
		btn_food3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_food3.setIcon(null);
				btn_food3.setText("<html>+0<br />-30</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_food3.setText("");
				btn_food3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food3.png"));
			}
		});
		btn_food3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(btn_food3.getBorder() == loweredbevel)
				{
					btn_food3.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_food3)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.f3);
						btn_food3.setBorder(loweredbevel);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_food3.setBounds(328, 39, 85, 77);
		eat_panel.add(btn_food3);
		
		btn_food4.setBorder(raisedbevel);
		btn_food4.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food4.png"));
		btn_food4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_food4.setIcon(null);
				btn_food4.setText("<html>+0<br />-40</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_food4.setText("");
				btn_food4.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food4.png"));
			}
		});
		btn_food4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(btn_food4.getBorder() == loweredbevel)
				{
					btn_food4.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_food4)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.f4);
						btn_food4.setBorder(loweredbevel);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_food4.setBounds(425, 39, 85, 77);
		eat_panel.add(btn_food4);
		
		btn_food5.setBorder(raisedbevel);
		btn_food5.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food5.png"));
		btn_food5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_food5.setIcon(null);
				btn_food5.setText("<html>+0<br />-50</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_food5.setText("");
				btn_food5.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food5.png"));
			}
		});
		btn_food5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(btn_food5.getBorder() == loweredbevel)
				{
					btn_food5.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_food5)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.f5);
						btn_food5.setBorder(loweredbevel);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_food5.setBounds(522, 39, 85, 77);
		eat_panel.add(btn_food5);
		
		btn_food6.setBorder(raisedbevel);
		btn_food6.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food6.png"));
		btn_food6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_food6.setIcon(null);
				btn_food6.setText("<html>+0<br />-60</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_food6.setText("");
				btn_food6.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food6.png"));
			}
		});
		btn_food6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(btn_food6.getBorder() == loweredbevel)
				{
					btn_food6.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_food6)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.f6);
						btn_food6.setBorder(loweredbevel);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_food6.setBounds(619, 39, 85, 77);
		eat_panel.add(btn_food6);
		
		btn_med1.setBorder(raisedbevel);
		btn_med1.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/icons8-pill-64.png"));
		btn_med1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_med1.setIcon(null);
				btn_med1.setText("<html>+25<br />-0</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_med1.setText("");
				btn_med1.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/icons8-pill-64.png"));
			}
		});
		btn_med1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(btn_med1.getBorder() == loweredbevel)
				{
					btn_med1.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_med1)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.med1);
						btn_med1.setBorder(loweredbevel);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_med1.setBounds(234, 191, 85, 77);
		eat_panel.add(btn_med1);
		
		btn_med2.setBorder(raisedbevel);
		btn_med2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/med3.png"));
		btn_med2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_med2.setIcon(null);
				btn_med2.setText("<html>+50<br />-0</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_med2.setText("");
				btn_med2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/med3.png"));
			}
		});
		btn_med2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(btn_med2.getBorder() == loweredbevel)
				{
					btn_med2.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_med2)
							{
								i.setBorder(raisedbevel);
							}
						}
						s.set_current_food(s.med2);
						lbl_eatError.setText("");
						btn_med2.setBorder(loweredbevel);
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_med2.setBounds(331, 191, 85, 77);
		eat_panel.add(btn_med2);
		
		btn_med3.setBorder(raisedbevel);
		btn_med3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/cure.png"));
		btn_med3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_med3.setIcon(null);
				btn_med3.setText("\"<html>+10<br />-0<br />cure</html>\"");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_med3.setText("");
				btn_med3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/cure.png"));
			}
		});
		btn_med3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(btn_med3.getBorder() == loweredbevel)
				{
					btn_med3.setBorder(raisedbevel);
					s.current_food = null;
				} else
				{
					try
					{
						for (JButton i : btn_food_and_med)
						{
							if(i.getBorder() == loweredbevel && i != btn_med3)
							{
								i.setBorder(raisedbevel);
							}
						}
						btn_med3.setBorder(loweredbevel);
						s.set_current_food(s.med3);
						lbl_eatError.setText("");
					} catch(InputSetupException e1)
					{
						lbl_eatError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_med3.setBounds(428, 191, 85, 77);
		eat_panel.add(btn_med3);
		
		JButton btn_applyItem = new JButton("Apply");
		btn_applyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.eat(s.current_food, s.current_char);
					health_bar.setValue(s.current_char.pilot_health);
					tiredness_bar.setValue(s.current_char.pilot_tired);
					hunger_bar.setValue(s.current_char.pilot_hunger);
					lbl_food1Q.setText(Integer.toString(s.f1.item_quantity));
					lbl_food2Q.setText(Integer.toString(s.f2.item_quantity));
					lbl_food3Q.setText(Integer.toString(s.f3.item_quantity));
					lbl_food4Q.setText(Integer.toString(s.f4.item_quantity));
					lbl_food5Q.setText(Integer.toString(s.f5.item_quantity));
					lbl_food6Q.setText(Integer.toString(s.f6.item_quantity));
					lbl_med1Q.setText(Integer.toString(s.med1.item_quantity));
					lbl_med2Q.setText(Integer.toString(s.med2.item_quantity));
					lbl_med3Q.setText(Integer.toString(s.med3.item_quantity));
				} catch(InputSetupException e1)
				{
					lbl_eatError.setText(e1.getMessage());
				}
			}
		});
		btn_applyItem.setBounds(669, 341, 117, 68);
		eat_panel.add(btn_applyItem);
		
		
		action_panel = new JPanel();
		action_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(action_panel);
		action_panel.setLayout(null);
		
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
		
		JLabel lbl_actionError = new JLabel("");
		lbl_actionError.setForeground(Color.RED);
		lbl_actionError.setBounds(208, 199, 473, 16);
		action_panel.add(lbl_actionError);
		
		JLabel lbl_plague1A = new JLabel("");
		lbl_plague1A.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague1A.setBounds(170, 142, 34, 34);
		lbl_plague1A.setVisible(false);
		action_panel.add(lbl_plague1A);
		
		JLabel lbl_plague2A = new JLabel("New label");
		lbl_plague2A.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague2A.setBounds(290, 142, 34, 34);
		lbl_plague2A.setVisible(false);
		action_panel.add(lbl_plague2A);
		
		JLabel lbl_plague3A = new JLabel("New label");
		lbl_plague3A.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague3A.setBounds(410, 142, 34, 34);
		lbl_plague3A.setVisible(false);
		action_panel.add(lbl_plague3A);
		
		JLabel lbl_plague4A = new JLabel("New label");
		lbl_plague4A.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague4A.setBounds(535, 142, 34, 34);
		lbl_plague4A.setVisible(false);
		action_panel.add(lbl_plague4A);
		
		JButton btn_charSleep = new JButton("sleep");
		btn_charSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.sleep(s.current_char);
					lbl_actionError.setText("");
				}catch(NullPointerException e1)
				{
					lbl_actionError.setText("Choose a pilot!");
				}catch(InputSetupException e2)
				{
					lbl_actionError.setText(e2.getMessage());
				}
			}
		});
		btn_charSleep.setBounds(693, 57, 139, 73);
		action_panel.add(btn_charSleep);
		
		JButton btn_charRepair = new JButton("repair");
		btn_charRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btn_charRepair.setBounds(693, 142, 139, 73);
		action_panel.add(btn_charRepair);
		
		JButton btn_search = new JButton("search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.search(s.current_char);
					lbl_actionError.setText(s.current_char.pilot_name + s.search_result);
					bar_Health.setValue(s.current_char.pilot_health);
					bar_Tiredness.setValue(s.current_char.pilot_tired);
					bar_Hunger.setValue(s.current_char.pilot_hunger);
					lbl_missingParts.setText(Integer.toString(s.parts_missing));
					try 
					{
						if (s.current_char.carry_plague == true && s.current_char == s.pilots.get(0))
						{
							lbl_plague1A.setVisible(true);
						}else if (s.current_char.carry_plague == true && s.current_char == s.pilots.get(1))
						{
							lbl_plague2A.setVisible(true);
						}else if (s.current_char.carry_plague == true && s.current_char == s.pilots.get(2))
						{
							lbl_plague3A.setVisible(true);
						}else if (s.current_char.carry_plague == true && s.current_char == s.pilots.get(3))
						{
							lbl_plague4A.setVisible(true);
						}
					}catch (IndexOutOfBoundsException e1)
					{
						
					}
					
				}catch(InputSetupException e1)
				{
					lbl_actionError.setText(e1.getMessage());
				}
			}
		});
		btn_search.setBounds(693, 227, 139, 73);
		action_panel.add(btn_search);
		
		JButton btnNewButton_3 = new JButton("eat");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (s.current_char == null)
				{
					lbl_actionError.setText("Choose a pilot!");
				} else 
				{
					switchPanels(eat_panel);
					health_bar.setValue(s.current_char.pilot_health);
					tiredness_bar.setValue(s.current_char.pilot_tired);
					hunger_bar.setValue(s.current_char.pilot_hunger);
					lbl_food1Q.setText(Integer.toString(s.f1.item_quantity));
					lbl_food2Q.setText(Integer.toString(s.f2.item_quantity));
					lbl_food3Q.setText(Integer.toString(s.f3.item_quantity));
					lbl_food4Q.setText(Integer.toString(s.f4.item_quantity));
					lbl_food5Q.setText(Integer.toString(s.f5.item_quantity));
					lbl_food6Q.setText(Integer.toString(s.f6.item_quantity));
					lbl_med1Q.setText(Integer.toString(s.med1.item_quantity));
					lbl_med2Q.setText(Integer.toString(s.med2.item_quantity));
					lbl_med3Q.setText(Integer.toString(s.med3.item_quantity));
				}
			}
		});
		btnNewButton_3.setBounds(693, 312, 139, 73);
		action_panel.add(btnNewButton_3);
		
		JButton btn_currentChar1 = new JButton("New button");
		JButton btn_currentChar2 = new JButton("New button");
		JButton btn_currentChar3 = new JButton("New button");
		JButton btn_currentChar4 = new JButton("New button");
		JButton[] action_slots = new JButton[] {btn_currentChar1, btn_currentChar2, btn_currentChar3, btn_currentChar4};
		btn_currentChar1.setBorder(raisedbevel);
		btn_currentChar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_currentChar1.setText(Integer.toString(s.pilots.get(0).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_currentChar1.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_currentChar1.setText(s.pilots.get(0).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar1.setText("x");
				}
			}
		});
		btn_currentChar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (btn_currentChar1.getBorder() == loweredbevel)
				{
					btn_currentChar1.setBorder(raisedbevel);
					s.current_char = null;
				}
				else
				{
					try
					{
						s.current_char = s.pilots.get(0);
						bar_Health.setValue(s.current_char.pilot_health);
						bar_Tiredness.setValue(s.current_char.pilot_tired);
						bar_Hunger.setValue(s.current_char.pilot_hunger);
						lbl_actionError.setText("");
						if (s.current_char.carry_plague == true)
						{
							lbl_plague1A.setVisible(true);
						}
						
						btn_currentChar1.setBorder(loweredbevel);
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel && i != btn_currentChar1)
							{
								i.setBorder(raisedbevel);
							}
						}
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_actionError.setText("The slot is empty!");
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel)
							{
								i.setBorder(raisedbevel);
							}
						}
						bar_Health.setValue(0);
						bar_Tiredness.setValue(0);
						bar_Hunger.setValue(0);
					}
				}
			}
		});
		btn_currentChar1.setBounds(123, 45, 110, 98);
		action_panel.add(btn_currentChar1);
		
		
		btn_currentChar2.setBorder(raisedbevel);
		btn_currentChar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_currentChar2.setText(Integer.toString(s.pilots.get(1).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_currentChar2.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_currentChar2.setText(s.pilots.get(1).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar2.setText("x");
				}
			}
		});
		btn_currentChar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (btn_currentChar2.getBorder() == loweredbevel)
				{
					btn_currentChar2.setBorder(raisedbevel);
					s.current_char = null;
				} else
				{
					try
					{
						s.current_char = s.pilots.get(1);
						bar_Health.setValue(s.current_char.pilot_health);
						bar_Tiredness.setValue(s.current_char.pilot_tired);
						bar_Hunger.setValue(s.current_char.pilot_hunger);
						lbl_actionError.setText("");
						if (s.current_char.carry_plague == true)
						{
							lbl_plague2A.setVisible(true);
						}
						
						btn_currentChar2.setBorder(loweredbevel);
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel && i != btn_currentChar2)
							{
								i.setBorder(raisedbevel);
							}
						}
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_actionError.setText("The slot is empty!");
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel)
							{
								i.setBorder(raisedbevel);
							}
						}
						bar_Health.setValue(0);
						bar_Tiredness.setValue(0);
						bar_Hunger.setValue(0);
					}
				}
			}
		});
		btn_currentChar2.setBounds(245, 45, 110, 98);
		action_panel.add(btn_currentChar2);
		
		
		btn_currentChar3.setBorder(raisedbevel);
		btn_currentChar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_currentChar3.setText(Integer.toString(s.pilots.get(2).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_currentChar3.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_currentChar3.setText(s.pilots.get(2).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar3.setText("x");
				}
			}
		});
		btn_currentChar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_currentChar3.getBorder() == loweredbevel)
				{
					btn_currentChar3.setBorder(raisedbevel);
					s.current_char = null;
				} else
				{
					try
					{
						s.current_char = s.pilots.get(2);
						bar_Health.setValue(s.current_char.pilot_health);
						bar_Tiredness.setValue(s.current_char.pilot_tired);
						bar_Hunger.setValue(s.current_char.pilot_hunger);
						lbl_actionError.setText("");
						if (s.current_char.carry_plague == true)
						{
							lbl_plague3A.setVisible(true);
						}
						
						btn_currentChar3.setBorder(loweredbevel);
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel && i != btn_currentChar3)
							{
								i.setBorder(raisedbevel);
							}
						}
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_actionError.setText("The slot is empty!");
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel)
							{
								i.setBorder(raisedbevel);
							}
						}
						bar_Health.setValue(0);
						bar_Tiredness.setValue(0);
						bar_Hunger.setValue(0);
					}
				}
			}
		});
		btn_currentChar3.setBounds(367, 45, 110, 98);
		action_panel.add(btn_currentChar3);
		
		
		btn_currentChar4.setBorder(raisedbevel);
		btn_currentChar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_currentChar4.setText(Integer.toString(s.pilots.get(3).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_currentChar4.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_currentChar4.setText(s.pilots.get(3).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar4.setText("x");
				}
			}
		});
		btn_currentChar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_currentChar4.getBorder() == loweredbevel)
				{
					btn_currentChar4.setBorder(raisedbevel);
					s.current_char = null;
				} else
				{
					try
					{
						s.current_char = s.pilots.get(3);
						bar_Health.setValue(s.current_char.pilot_health);
						bar_Tiredness.setValue(s.current_char.pilot_tired);
						bar_Hunger.setValue(s.current_char.pilot_hunger);
						lbl_actionError.setText("");
						if (s.current_char.carry_plague == true)
						{
							lbl_plague4A.setVisible(true);
						}
						
						btn_currentChar4.setBorder(loweredbevel);
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel && i != btn_currentChar4)
							{
								i.setBorder(raisedbevel);
							}
						}
					} catch(IndexOutOfBoundsException e1)
					{
						lbl_actionError.setText("The slot is empty!");
						for (JButton i : action_slots)
						{
							if(i.getBorder() == loweredbevel)
							{
								i.setBorder(raisedbevel);
							}
						}
						bar_Health.setValue(0);
						bar_Tiredness.setValue(0);
						bar_Hunger.setValue(0);
					}
				}
			}
		});
		btn_currentChar4.setBounds(489, 45, 110, 98);
		action_panel.add(btn_currentChar4);
		
		fly_panel = new JPanel();
		fly_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(fly_panel);
		fly_panel.setLayout(null);
		
		JLabel lbl_flyError = new JLabel("");
		lbl_flyError.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flyError.setForeground(Color.RED);
		lbl_flyError.setBounds(271, 23, 295, 16);
		fly_panel.add(lbl_flyError);
		
		JLabel lbl_flyConfirm = new JLabel("You are in other planet now!");
		lbl_flyConfirm.setForeground(Color.GREEN);
		lbl_flyConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_flyConfirm.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		lbl_flyConfirm.setBounds(181, 221, 477, 64);
		lbl_flyConfirm.setVisible(false);
		fly_panel.add(lbl_flyConfirm);
		
		JButton btn_tofly1 = new JButton("");
		btn_tofly1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_tofly1.setText(Integer.toString(s.pilots.get(0).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_tofly1.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_tofly1.setText(s.pilots.get(0).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly1.setText("x");
				}
			}
		});
		btn_tofly1.setBorder(raisedbevel);
		btn_tofly1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_tofly1.getBorder() == loweredbevel)
				{
					btn_tofly1.setBorder(raisedbevel);
					s.flying_pilots.remove(s.pilots.get(0));
				} else 
				{
					if (s.flying_pilots.size() >= 2)
					{
						lbl_flyError.setText("you need to choose 2!");
					} else
					{
						try
						{
							s.flying_pilots.add(s.pilots.get(0));
							btn_tofly1.setBorder(loweredbevel);
						} catch(IndexOutOfBoundsException e1)
						{
							lbl_flyError.setText("This slot is empty!");
						}
					}
				}
			}
		});
		btn_tofly1.setBounds(181, 65, 110, 98);
		fly_panel.add(btn_tofly1);
		
		JButton btn_tofly2 = new JButton("");
		btn_tofly2.setBorder(raisedbevel);
		btn_tofly2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_tofly2.setText(Integer.toString(s.pilots.get(1).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_tofly2.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_tofly2.setText(s.pilots.get(1).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly2.setText("x");
				}
			}
		});
		btn_tofly2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_tofly2.getBorder() == loweredbevel)
				{
					btn_tofly2.setBorder(raisedbevel);
					s.flying_pilots.remove(s.pilots.get(1));
				} else 
				{
					if (s.flying_pilots.size() >= 2)
					{
						lbl_flyError.setText("you need to choose 2!");
					} else
					{
						try
						{
							s.flying_pilots.add(s.pilots.get(1));
							btn_tofly2.setBorder(loweredbevel);
						} catch(IndexOutOfBoundsException e1)
						{
							lbl_flyError.setText("This slot is empty!");
						}
					}
				}
			}
		});
		btn_tofly2.setBounds(303, 65, 110, 98);
		fly_panel.add(btn_tofly2);
		
		JButton btn_tofly3 = new JButton("");
		btn_tofly3.setBorder(raisedbevel);
		btn_tofly3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_tofly3.setText(Integer.toString(s.pilots.get(2).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_tofly3.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_tofly3.setText(s.pilots.get(2).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly3.setText("x");
				}
			}
		});
		btn_tofly3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (btn_tofly3.getBorder() == loweredbevel)
				{
					btn_tofly3.setBorder(raisedbevel);
					s.flying_pilots.remove(s.pilots.get(2));
				} else 
				{
					if (s.flying_pilots.size() >= 2)
					{
						lbl_flyError.setText("you need to choose 2!");
					} else
					{
						try
						{
							s.flying_pilots.add(s.pilots.get(2));
							btn_tofly3.setBorder(loweredbevel);
						} catch(IndexOutOfBoundsException e1)
						{
							lbl_flyError.setText("This slot is empty!");
						}
					}
				}
			}
		});
		btn_tofly3.setBounds(425, 65, 110, 98);
		fly_panel.add(btn_tofly3);
		
		JButton btn_tofly4 = new JButton("");
		btn_tofly4.setBorder(raisedbevel);
		btn_tofly4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				try
				{
					btn_tofly4.setText(Integer.toString(s.pilots.get(3).actionCount));
				} catch (IndexOutOfBoundsException e1)
				{
					btn_tofly4.setText("x");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				try
				{
					btn_tofly4.setText(s.pilots.get(3).pilot_name);
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly4.setText("x");
				}
			}
		});
		btn_tofly4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (btn_tofly4.getBorder() == loweredbevel)
				{
					btn_tofly4.setBorder(raisedbevel);
					s.flying_pilots.remove(s.pilots.get(3));
				} else 
				{
					if (s.flying_pilots.size() >= 2)
					{
						lbl_flyError.setText("you need to choose 2!");
					} else
					{
						try
						{
							s.flying_pilots.add(s.pilots.get(3));
							btn_tofly4.setBorder(loweredbevel);
						} catch(IndexOutOfBoundsException e1)
						{
							lbl_flyError.setText("This slot is empty!");
						}
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
					try
					{
						lbl_flyError.setText("");
						lbl_flyConfirm.setVisible(true);
						s.fly(s.flying_pilots.get(0), s.flying_pilots.get(1));
						if (s.astroidBelt == true)
						{
							JOptionPane.showMessageDialog(frame, "You encountered an astroid belt!");
							bar_shipShield.setValue(s.shield_level);
							s.astroidBelt = false;
							if (s.pirate == true)
							{
								JOptionPane.showMessageDialog(frame, "You encountered space pirate!");
								bar_shipShield.setValue(s.shield_level);
								s.pirate = false;
							}
						}
						btn_tofly1.setBorder(raisedbevel);
						btn_tofly2.setBorder(raisedbevel);
						btn_tofly3.setBorder(raisedbevel);
						btn_tofly4.setBorder(raisedbevel);
						s.flying_pilots.clear();
					}catch(InputSetupException e1)
					{
						lbl_flyError.setText(e1.getMessage());
					}
				}
			}
		});
		btn_fly.setBounds(363, 297, 117, 64);
		fly_panel.add(btn_fly);
		
		JLabel lbl_plague1 = new JLabel("");
		lbl_plague1.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague1.setBounds(224, 175, 34, 34);
		lbl_plague1.setVisible(false);
		fly_panel.add(lbl_plague1);
		
		JLabel lbl_plague2 = new JLabel("");
		lbl_plague2.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague2.setBounds(345, 175, 34, 34);
		lbl_plague2.setVisible(false);
		fly_panel.add(lbl_plague2);
		
		JLabel lbl_plague3 = new JLabel("");
		lbl_plague3.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague3.setBounds(466, 175, 34, 34);
		lbl_plague3.setVisible(false);
		fly_panel.add(lbl_plague3);
		
		JLabel lbl_plague4 = new JLabel("");
		lbl_plague4.setIcon(new ImageIcon(ship_gui.class.getResource("/Game/images/plague-doctor-profile(1).png")));
		lbl_plague4.setBounds(588, 175, 34, 34);
		lbl_plague4.setVisible(false);
		fly_panel.add(lbl_plague4);
		
		outpost_panel = new JPanel();
		outpost_panel.setBounds(0, 0, 838, 455);
		layeredPane.add(outpost_panel);
		outpost_panel.setLayout(null);
		
		JLabel lbl_quantity1 = new JLabel("0");
		lbl_quantity1.setForeground(Color.RED);
		lbl_quantity1.setBounds(217, 56, 8, 16);
		outpost_panel.add(lbl_quantity1);
		
		JLabel lbl_quantity2 = new JLabel("0");
		lbl_quantity2.setForeground(Color.RED);
		lbl_quantity2.setBounds(314, 56, 8, 16);
		outpost_panel.add(lbl_quantity2);
		
		JLabel lbl_quantity3 = new JLabel("0");
		lbl_quantity3.setForeground(Color.RED);
		lbl_quantity3.setBounds(408, 56, 8, 16);
		outpost_panel.add(lbl_quantity3);
		
		JLabel lbl_quantity4 = new JLabel("0");
		lbl_quantity4.setForeground(Color.RED);
		lbl_quantity4.setBounds(505, 56, 8, 16);
		outpost_panel.add(lbl_quantity4);
		
		JLabel lbl_quantity5 = new JLabel("0");
		lbl_quantity5.setForeground(Color.RED);
		lbl_quantity5.setBounds(602, 56, 8, 16);
		outpost_panel.add(lbl_quantity5);
		
		JLabel lbl_quantity6 = new JLabel("0");
		lbl_quantity6.setForeground(Color.RED);
		lbl_quantity6.setBounds(699, 56, 8, 16);
		outpost_panel.add(lbl_quantity6);
		
		JLabel lbl_quantity7 = new JLabel("0");
		lbl_quantity7.setForeground(Color.RED);
		lbl_quantity7.setBounds(217, 204, 8, 16);
		outpost_panel.add(lbl_quantity7);
		
		JLabel lbl_quantity8 = new JLabel("0");
		lbl_quantity8.setForeground(Color.RED);
		lbl_quantity8.setBounds(314, 204, 8, 16);
		outpost_panel.add(lbl_quantity8);
		
		JLabel lbl_quantity9 = new JLabel("0");
		lbl_quantity9.setForeground(Color.RED);
		lbl_quantity9.setBounds(408, 204, 8, 16);
		outpost_panel.add(lbl_quantity9);
		
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
		btn_buyFood1.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food1.png"));
		btn_buyFood1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyFood1.setIcon(null);
				btn_buyFood1.setText("<html>+0<br />-10</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
					btn_buyFood1.setText("");
					btn_buyFood1.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food1.png"));
			}
		});
		btn_buyFood1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_foods(s.f1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity1+=1;
					lbl_quantity1.setText(Integer.toString(s.quantity1));
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
					s.remove_foods(s.f1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity1 = 0;
					lbl_quantity1.setText(Integer.toString(s.quantity1));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF1.setBounds(141, 130, 85, 29);
		outpost_panel.add(btn_cancelF1);
		
		JButton btn_buyFood2 = new JButton("");
		btn_buyFood2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food2.png"));
		btn_buyFood2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyFood2.setIcon(null);
				btn_buyFood2.setText("<html>+0<br />-20</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
					btn_buyFood2.setText("");
					btn_buyFood2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food2.png"));
			}
		});
		btn_buyFood2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(s.f2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity2+=1;
					lbl_quantity2.setText(Integer.toString(s.quantity2));
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
					s.remove_foods(s.f2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity2 = 0;
					lbl_quantity2.setText(Integer.toString(s.quantity2));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF2.setBounds(238, 130, 85, 29);
		outpost_panel.add(btn_cancelF2);
		
		JButton btn_buyFood3 = new JButton("\n");
		btn_buyFood3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food3.png"));
		btn_buyFood3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyFood3.setIcon(null);
				btn_buyFood3.setText("<html>+0<br />-30</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
					btn_buyFood3.setText("");
					btn_buyFood3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food3.png"));
			}
		});
		btn_buyFood3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(s.f3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity3+=1;
					lbl_quantity3.setText(Integer.toString(s.quantity3));
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
					s.remove_foods(s.f3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity3 = 0;
					lbl_quantity3.setText(Integer.toString(s.quantity3));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF3.setBounds(332, 130, 85, 29);
		outpost_panel.add(btn_cancelF3);
		
		JButton btn_buyFood4 = new JButton("");
		btn_buyFood4.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food4.png"));
		btn_buyFood4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyFood4.setIcon(null);
				btn_buyFood4.setText("<html>+0<br />-40</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_buyFood4.setText("");
				btn_buyFood4.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food4.png"));
			}
		});
		btn_buyFood4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					s.add_foods(s.f4);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity4+=1;
					lbl_quantity4.setText(Integer.toString(s.quantity4));
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
					s.remove_foods(s.f4);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity4 = 0;
					lbl_quantity4.setText(Integer.toString(s.quantity4));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF4.setBounds(429, 130, 85, 29);
		outpost_panel.add(btn_cancelF4);
		
		JButton btn_buyFood5 = new JButton("");
		btn_buyFood5.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food5.png"));
		btn_buyFood5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyFood5.setIcon(null);
				btn_buyFood5.setText("<html>+0<br />-50</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
					btn_buyFood5.setText("");
					btn_buyFood5.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food5.png"));
			}
		});
		btn_buyFood5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(s.f5);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity5+=1;
					lbl_quantity5.setText(Integer.toString(s.quantity5));
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
					s.remove_foods(s.f5);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity5 = 0;
					lbl_quantity5.setText(Integer.toString(s.quantity5));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF5.setBounds(526, 130, 85, 29);
		outpost_panel.add(btn_cancelF5);
		
		JButton btn_buyFood6 = new JButton("");
		btn_buyFood6.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food6.png"));
		btn_buyFood6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyFood6.setIcon(null);
				btn_buyFood6.setText("<html>+0<br />-60</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
					btn_buyFood6.setText("");
					btn_buyFood6.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/food6.png"));
			}
		});
		btn_buyFood6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					s.add_foods(s.f6);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity6+=1;
					lbl_quantity6.setText(Integer.toString(s.quantity6));
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
					s.remove_foods(s.f6);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity6 = 0;
					lbl_quantity6.setText(Integer.toString(s.quantity6));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelF6.setBounds(623, 130, 85, 29);
		outpost_panel.add(btn_cancelF6);
		
		JButton btn_buyMed1 = new JButton("");
		btn_buyMed1.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/icons8-pill-64.png"));
		btn_buyMed1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyMed1.setIcon(null);
				btn_buyMed1.setText("<html>+25<br />-0</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_buyMed1.setText("");
				btn_buyMed1.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/icons8-pill-64.png"));
			}
		});
		btn_buyMed1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(s.med1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity7+=1;
					lbl_quantity7.setText(Integer.toString(s.quantity7));
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
					s.remove_foods(s.med1);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity7 = 0;
					lbl_quantity7.setText(Integer.toString(s.quantity7));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelM1.setBounds(140, 278, 85, 29);
		outpost_panel.add(btn_cancelM1);
		
		JButton btn_buyMed2 = new JButton("");
		btn_buyMed2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/med3.png"));
		btn_buyMed2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyMed2.setIcon(null);
				btn_buyMed2.setText("<html>+50<br />-0</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_buyMed2.setText("");
				btn_buyMed2.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/med3.png"));
			}
		});
		btn_buyMed2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(s.med2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity8+=1;
					lbl_quantity8.setText(Integer.toString(s.quantity8));
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
					s.remove_foods(s.med2);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity8 = 0;
					lbl_quantity8.setText(Integer.toString(s.quantity8));
					lbl_buyItemError.setText("");
				} catch(InputSetupException e1)
				{
					lbl_buyItemError.setText(e1.getMessage());
				}
			}
		});
		btn_cancelM2.setBounds(237, 278, 85, 29);
		outpost_panel.add(btn_cancelM2);
		
		JButton btn_buyMed3 = new JButton("");
		btn_buyMed3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/cure.png"));
		btn_buyMed3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btn_buyMed3.setIcon(null);
				btn_buyMed3.setText("<html>+10<br />-0<br />cure</html>");
			}
			@Override
			public void mouseExited(MouseEvent e) 
			{
				btn_buyMed3.setText("");
				btn_buyMed3.setIcon(new ImageIcon("/Users/jeminlee/eclipse-workspace/Game_Assignment/src/Game/images/cure.png"));
			}
		});
		btn_buyMed3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					s.add_foods(s.med3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity9+=1;
					lbl_quantity9.setText(Integer.toString(s.quantity9));
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
					s.remove_foods(s.med3);
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					s.quantity9 = 0;
					lbl_quantity9.setText(Integer.toString(s.quantity9));
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

					s.crew_money -= s.total_item_price;
					s.total_item_price = 0;
					lbl_foodPrice.setText(Integer.toString(s.total_item_price));
					lbl_crewCurrentMoney.setText(Integer.toString(s.crew_money));
					lbl_purchased.setText("Purchased");
					lbl_buyItemError.setText("");
					s.buy_foods();
					lbl_quantity9.setText("0");
					lbl_quantity8.setText("0");
					lbl_quantity7.setText("0");
					lbl_quantity6.setText("0");
					lbl_quantity5.setText("0");
					lbl_quantity4.setText("0");
					lbl_quantity3.setText("0");
					lbl_quantity2.setText("0");
					lbl_quantity1.setText("0");
				}
			}
		});
		btn_buyItems.setBounds(556, 365, 127, 67);
		outpost_panel.add(btn_buyItems);
		
		JButton btn_flyPanel = new JButton("fly");
		btn_flyPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btn_tofly4.setBorder(raisedbevel);
				btn_tofly3.setBorder(raisedbevel);
				btn_tofly2.setBorder(raisedbevel);
				btn_tofly1.setBorder(raisedbevel);
				s.flying_pilots.clear();
				lbl_flyError.setText("");
				lbl_flyConfirm.setVisible(false);
				switchPanels(fly_panel);
				try
				{
					btn_tofly1.setText(s.pilots.get(0).pilot_name);
					if(s.pilots.get(0).carry_plague)
					{
						lbl_plague1.setVisible(true);
					} else
					{
						lbl_plague1.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly1.setText("x");
				}
				try
				{
					btn_tofly2.setText(s.pilots.get(1).pilot_name);
					if(s.pilots.get(1).carry_plague)
					{
						lbl_plague2.setVisible(true);
					} else
					{
						lbl_plague2.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly2.setText("x");
				}
				try
				{
					btn_tofly3.setText(s.pilots.get(2).pilot_name);
					if(s.pilots.get(2).carry_plague)
					{
						lbl_plague3.setVisible(true);
					} else
					{
						lbl_plague3.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly3.setText("x");
				}
				try
				{
					btn_tofly4.setText(s.pilots.get(3).pilot_name);
					if(s.pilots.get(3).carry_plague)
					{
						lbl_plague4.setVisible(true);
					} else
					{
						lbl_plague4.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_tofly4.setText("x");
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
				lbl_crewCurrentMoney.setText(Integer.toString(s.crew_money));
				
			}
		});
		btn_outpostPanel.setBounds(172, 6, 117, 64);
		contentPane.add(btn_outpostPanel);
		
		JButton btn_actionPanel = new JButton("action");
		btn_actionPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				switchPanels(action_panel);
				lbl_actionError.setText("");
				bar_Health.setValue(0);
				bar_Tiredness.setValue(0);
				bar_Hunger.setValue(0);
				btn_currentChar1.setBorder(raisedbevel);
				btn_currentChar2.setBorder(raisedbevel);
				btn_currentChar3.setBorder(raisedbevel);
				btn_currentChar4.setBorder(raisedbevel);
				s.current_char = null;
				try
				{
					btn_currentChar1.setText(s.pilots.get(0).pilot_name);
					if (s.pilots.get(0).carry_plague)
					{
						lbl_plague1A.setVisible(true);
					}else
					{
						lbl_plague1A.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar1.setText("x");
				}
				try
				{
					btn_currentChar2.setText(s.pilots.get(1).pilot_name);
					if (s.pilots.get(1).carry_plague)
					{
						lbl_plague2A.setVisible(true);
					}else
					{
						lbl_plague2A.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar2.setText("x");
				}
				try
				{
					btn_currentChar3.setText(s.pilots.get(2).pilot_name);
					if (s.pilots.get(2).carry_plague)
					{
						lbl_plague3A.setVisible(true);
					}else
					{
						lbl_plague3A.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar3.setText("x");
				}
				try
				{
					btn_currentChar4.setText(s.pilots.get(3).pilot_name);
					if (s.pilots.get(3).carry_plague)
					{
						lbl_plague4A.setVisible(true);
					}else
					{
						lbl_plague4A.setVisible(false);
					}
				} catch(IndexOutOfBoundsException e1)
				{
					btn_currentChar4.setText("x");
				}
			}
		});
		btn_actionPanel.setBounds(301, 6, 117, 64);
		contentPane.add(btn_actionPanel);
		
		JButton btn_nextDay = new JButton("next day");
		btn_nextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				btn_tofly4.setBorder(raisedbevel);
				btn_tofly3.setBorder(raisedbevel);
				btn_tofly2.setBorder(raisedbevel);
				btn_tofly1.setBorder(raisedbevel);
				lbl_flyError.setText("");
				lbl_flyConfirm.setVisible(false);
				lbl_actionError.setText("");
				btn_currentChar1.setBorder(raisedbevel);
				btn_currentChar2.setBorder(raisedbevel);
				btn_currentChar3.setBorder(raisedbevel);
				btn_currentChar4.setBorder(raisedbevel);
				bar_Health.setValue(0);
				bar_Tiredness.setValue(0);
				bar_Hunger.setValue(0);
				s.next_day();
				lbl_days.setText(Integer.toString(s.numDays));
			}
		});
		btn_nextDay.setBounds(727, 6, 117, 64);
		contentPane.add(btn_nextDay);
		
		JLabel lblNewLabel = new JLabel("missing parts:");
		lblNewLabel.setBounds(459, 41, 96, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("days:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(662, 6, 38, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("left");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(662, 70, 38, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ship shield");
		lblNewLabel_4.setBounds(6, 89, 69, 16);
		contentPane.add(lblNewLabel_4);
	}
}
