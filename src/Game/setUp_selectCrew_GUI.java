package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

public class setUp_selectCrew_GUI extends JFrame {
	private JTextField txt_shipName;
	private JTextField txt_charChoiceName1;
	private JTextField txt_charChoiceName2;
	private JTextField txt_charChoiceName3;
	private JTextField txt_charChoiceName4;
	public static setUp_selectCrew_GUI frame = new setUp_selectCrew_GUI();
	public ship s;
	/**
	 * Launch the application.
	 */
	
	public void setShip (ship s)
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

	/**
	 * Create the frame.
	 */
	public setUp_selectCrew_GUI() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		
		txt_shipName = new JTextField();
		txt_shipName.setBounds(37, 68, 200, 49);
		txt_shipName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txt_shipName.setColumns(10);
		
		JLabel lbl_crewSelectionError = new JLabel("");
		lbl_crewSelectionError.setBounds(37, 331, 673, 35);
		lbl_crewSelectionError.setForeground(Color.RED);
		lbl_crewSelectionError.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		JLabel lbl_shipNameError = new JLabel("");
		lbl_shipNameError.setBounds(37, 115, 228, 25);
		lbl_shipNameError.setForeground(Color.RED);
		lbl_shipNameError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JLabel lbl_nameSet = new JLabel("");
		lbl_nameSet.setBounds(37, 125, 623, 25);
		lbl_nameSet.setForeground(Color.GREEN);
		lbl_nameSet.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		JLabel lbl_nameShip = new JLabel("Give your ship a name");
		lbl_nameShip.setForeground(Color.WHITE);
		lbl_nameShip.setBounds(37, 37, 293, 25);
		lbl_nameShip.setFont(new Font("Silom", Font.BOLD, 22));
		
		JLabel lbl_selectedCrewDisplay = new JLabel("Your Crew:");
		lbl_selectedCrewDisplay.setForeground(Color.WHITE);
		lbl_selectedCrewDisplay.setBounds(37, 372, 179, 25);
		lbl_selectedCrewDisplay.setFont(new Font("Silom", Font.BOLD, 20));
		
		JLabel lbl_nameCharError = new JLabel("");
		lbl_nameCharError.setBackground(Color.LIGHT_GRAY);
		lbl_nameCharError.setBounds(37, 522, 379, 35);
		lbl_nameCharError.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lbl_nameCharError.setForeground(new Color(255, 0, 0));
		
		JButton btn_playerCharChoice1 = new JButton("");
		btn_playerCharChoice1.setBounds(37, 415, 86, 85);
		btn_playerCharChoice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice1.getIcon() == null)
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(s.char_1, 0);
					btn_playerCharChoice1.setIcon(null);
					txt_charChoiceName1.setText("");
				}
			}
		});
		
		txt_charChoiceName1 = new JTextField();
		txt_charChoiceName1.setBounds(37, 501, 86, 26);
		txt_charChoiceName1.setColumns(10);
		
		JButton btn_playerCharChoice2 = new JButton("");
		btn_playerCharChoice2.setBounds(127, 415, 92, 85);
		btn_playerCharChoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice2.getIcon() == null)
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(s.char_2, 1);
					btn_playerCharChoice2.setIcon(null);
					txt_charChoiceName2.setText("");
				}
			}
		});
		
		txt_charChoiceName2 = new JTextField();
		txt_charChoiceName2.setBounds(126, 501, 92, 26);
		txt_charChoiceName2.setColumns(10);
		
		JButton btn_playerCharChoice3 = new JButton("");
		btn_playerCharChoice3.setBounds(223, 415, 92, 85);
		btn_playerCharChoice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice3.getIcon() == null)
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(s.char_3, 2);
					btn_playerCharChoice3.setIcon(null);
					txt_charChoiceName3.setText("");
				}
			}
		});
		
		txt_charChoiceName3 = new JTextField();
		txt_charChoiceName3.setBounds(223, 501, 92, 26);
		txt_charChoiceName3.setColumns(10);
		
		JButton btn_playerCharChoice4 = new JButton("");
		btn_playerCharChoice4.setBounds(320, 415, 91, 85);
		btn_playerCharChoice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice4.getIcon() == null)
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(s.char_4, 3);
					btn_playerCharChoice4.setIcon(null);
					txt_charChoiceName4.setText("");
				}
			}
		});
		
		txt_charChoiceName4 = new JTextField();
		txt_charChoiceName4.setBounds(320, 501, 91, 26);
		txt_charChoiceName4.setColumns(10);
		
		JLabel lbl_selectCrewDisplay = new JLabel("Select your crew members");
		lbl_selectCrewDisplay.setForeground(Color.WHITE);
		lbl_selectCrewDisplay.setBounds(37, 196, 421, 25);
		lbl_selectCrewDisplay.setFont(new Font("Silom", Font.BOLD, 23));
		
		JButton[] slots = new JButton[]{btn_playerCharChoice1, btn_playerCharChoice2, btn_playerCharChoice3, btn_playerCharChoice4};
		JTextField[] names = new JTextField[] {txt_charChoiceName1, txt_charChoiceName2, txt_charChoiceName3, txt_charChoiceName4};
		
		JButton btn_char1Option = new JButton("");
		btn_char1Option.setIcon(new ImageIcon(setUp_selectCrew_GUI.class.getResource("/Game/images/character1.png")));
		btn_char1Option.setBounds(37, 227, 90, 103);
		btn_char1Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.add_pilots(s.char_1);
					for (JButton i : slots)
					{
						if (i.getIcon() == null)
						{
							i.setIcon(btn_char1Option.getIcon());
							break;
						}
					}
				} catch(InputSetupException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char2Option = new JButton("");
		btn_char2Option.setIcon(new ImageIcon(setUp_selectCrew_GUI.class.getResource("/Game/images/character2.png")));
		btn_char2Option.setBounds(139, 227, 88, 103);
		btn_char2Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(s.char_2);
					for (JButton i : slots)
					{
						if (i.getIcon() == null)
						{
							i.setIcon(btn_char2Option.getIcon());
							break;
						}
					}
				} catch(InputSetupException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char3Option = new JButton("");
		btn_char3Option.setIcon(new ImageIcon(setUp_selectCrew_GUI.class.getResource("/Game/images/character3.png")));
		btn_char3Option.setBounds(239, 227, 92, 103);
		btn_char3Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(s.char_3);
					for (JButton i : slots)
					{
						if (i.getIcon() == null)
						{
							i.setIcon(btn_char3Option.getIcon());
							break;
						}
					}
				} catch(InputSetupException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char4Option = new JButton("");
		btn_char4Option.setIcon(new ImageIcon(setUp_selectCrew_GUI.class.getResource("/Game/images/character4.png")));
		btn_char4Option.setBounds(343, 227, 91, 103);
		btn_char4Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(s.char_4);
					for (JButton i : slots)
					{
						if (i.getIcon() == null)
						{
							i.setIcon(btn_char4Option.getIcon());
							break;
						}
					}
				} catch(InputSetupException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char5Option = new JButton("");
		btn_char5Option.setIcon(new ImageIcon(setUp_selectCrew_GUI.class.getResource("/Game/images/character5.png")));
		btn_char5Option.setBounds(446, 227, 94, 103);
		btn_char5Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(s.char_5);
					for (JButton i : slots)
					{
						if (i.getIcon() == null)
						{
							i.setIcon(btn_char5Option.getIcon());
							break;
						}
					}
				} catch(InputSetupException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char6Option = new JButton("");
		btn_char6Option.setIcon(new ImageIcon(setUp_selectCrew_GUI.class.getResource("/Game/images/character6.png")));
		btn_char6Option.setBounds(552, 227, 91, 103);
		btn_char6Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(s.char_6);
					for (JButton i : slots)
					{
						if (i.getIcon() == null)
						{
							i.setIcon(btn_char6Option.getIcon());
							break;
						}
					}
				} catch(InputSetupException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_toStartGame = new JButton("GO");
		btn_toStartGame.setBounds(588, 428, 200, 132);
		btn_toStartGame.setVisible(false);
		btn_toStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (s.pilots.size() < 2)
				{
					lbl_crewSelectionError.setText("Please select 2 or more characters!");
				} else {
					
					lbl_crewSelectionError.setVisible(false);
					int named_count = 0;
					for (int i = 0; i < s.pilots.size(); i++) {
						if (names[i].getText().isEmpty()) {
							lbl_nameCharError.setText("Please name all your chosen characters!");
						} else {
							characters_Command current_char = s.pilots.get(i);
							current_char.pilot_name = names[i].getText();
							named_count += 1;
						}
					}
					
					if (s.pilots.size() == named_count) {
						dispose();
						frame.setVisible(false);
						ship_gui ship = new ship_gui();
						ship.setShip(s);
						ship.setVisible(true);
					} else {
						lbl_nameCharError.setText("Please name all your chosen characters!");
					}
				}
			}
		});
		
		JButton btn_tosetShipName = new JButton("Set");
		btn_tosetShipName.setBounds(255, 66, 75, 51);
		btn_tosetShipName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try
				{
					s.set_ship_name(txt_shipName.getText());
					lbl_shipNameError.setText("");
					lbl_nameSet.setText("Welcome " + txt_shipName.getText());
					btn_toStartGame.setVisible(true);
				} catch(IllegalArgumentException e1)
				{
					lbl_nameSet.setText("");
					lbl_shipNameError.setText(e1.getMessage());
					btn_toStartGame.setVisible(false);
				}
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(lbl_nameShip);
		getContentPane().add(lbl_selectCrewDisplay);
		getContentPane().add(lbl_crewSelectionError);
		getContentPane().add(btn_char1Option);
		getContentPane().add(btn_char2Option);
		getContentPane().add(btn_char3Option);
		getContentPane().add(btn_char4Option);
		getContentPane().add(btn_char5Option);
		getContentPane().add(btn_char6Option);
		getContentPane().add(txt_shipName);
		getContentPane().add(btn_tosetShipName);
		getContentPane().add(lbl_nameSet);
		getContentPane().add(lbl_shipNameError);
		getContentPane().add(btn_playerCharChoice1);
		getContentPane().add(btn_playerCharChoice2);
		getContentPane().add(btn_playerCharChoice3);
		getContentPane().add(btn_playerCharChoice4);
		getContentPane().add(txt_charChoiceName1);
		getContentPane().add(txt_charChoiceName2);
		getContentPane().add(txt_charChoiceName3);
		getContentPane().add(txt_charChoiceName4);
		getContentPane().add(lbl_nameCharError);
		getContentPane().add(btn_toStartGame);
		getContentPane().add(lbl_selectedCrewDisplay);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(setUp_selectCrew_GUI.class.getResource("/Game/images/space-dribbble.gif")));
		lblNewLabel.setBounds(0, 0, 847, 572);
		getContentPane().add(lblNewLabel);
	}
}
