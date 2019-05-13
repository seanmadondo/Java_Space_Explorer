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
import java.awt.Color;

public class setUp_selectCrew_GUI extends JFrame {
	private JTextField txt_shipName;
	private JTextField txt_charChoiceName1;
	private JTextField txt_charChoiceName2;
	private JTextField txt_charChoiceName3;
	private JTextField txt_charChoiceName4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setUp_selectCrew_GUI frame = new setUp_selectCrew_GUI();
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
	public setUp_selectCrew_GUI() {
		ship s = new ship();
		Character_1 char_1 = new Character_1();
		Character_2 char_2 = new Character_2();
		Character_3 char_3 = new Character_3();
		Character_4 char_4 = new Character_4();
		Character_5 char_5 = new Character_5();
		Character_6 char_6 = new Character_6();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		
		txt_shipName = new JTextField();
		txt_shipName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txt_shipName.setColumns(10);
		
		JLabel lbl_crewSelectionError = new JLabel("");
		lbl_crewSelectionError.setForeground(Color.RED);
		lbl_crewSelectionError.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JLabel lbl_shipNameError = new JLabel("");
		lbl_shipNameError.setForeground(Color.RED);
		lbl_shipNameError.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JLabel lbl_nameSet = new JLabel("");
		lbl_nameSet.setForeground(Color.GREEN);
		lbl_nameSet.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		
		JLabel lbl_nameShip = new JLabel("Name the ship:");
		lbl_nameShip.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lbl_selectedCrewDisplay = new JLabel("Selected:");
		lbl_selectedCrewDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton btn_playerCharChoice1 = new JButton("");
		btn_playerCharChoice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice1.getText()=="")
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(char_1, 0);
					btn_playerCharChoice1.setText("");
				}
			}
		});
		
		txt_charChoiceName1 = new JTextField();
		txt_charChoiceName1.setColumns(10);
		
		JButton btn_playerCharChoice2 = new JButton("");
		btn_playerCharChoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice2.getText()=="")
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(char_2, 1);
					btn_playerCharChoice2.setText("");
				}
			}
		});
		
		txt_charChoiceName2 = new JTextField();
		txt_charChoiceName2.setColumns(10);
		
		JButton btn_playerCharChoice3 = new JButton("");
		btn_playerCharChoice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice3.getText()=="")
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(char_3, 2);
					btn_playerCharChoice3.setText("");
				}
			}
		});
		
		txt_charChoiceName3 = new JTextField();
		txt_charChoiceName3.setColumns(10);
		
		JButton btn_playerCharChoice4 = new JButton("");
		btn_playerCharChoice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (btn_playerCharChoice4.getText()=="")
				{
					lbl_crewSelectionError.setText("select from here!");
				} else
				{
					s.remove_pilots(char_4, 3);
					btn_playerCharChoice4.setText("");
				}
			}
		});
		
		txt_charChoiceName4 = new JTextField();
		txt_charChoiceName4.setColumns(10);
		
		JLabel lbl_selectCrewDisplay = new JLabel("Select:");
		lbl_selectCrewDisplay.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton[] slots = new JButton[]{btn_playerCharChoice1, btn_playerCharChoice2, btn_playerCharChoice3, btn_playerCharChoice4};
		
		JButton btn_char1Option = new JButton("");
		btn_char1Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					s.add_pilots(char_1);
					for (JButton i : slots)
					{
						if (i.getText() == "")
						{
							i.setText("1");
							break;
						}
					}
				} catch(IllegalArgumentException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char2Option = new JButton("");
		btn_char2Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(char_2);
					for (JButton i : slots)
					{
						if (i.getText() == "")
						{
							i.setText("2");
							break;
						}
					}
				} catch(IllegalArgumentException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char3Option = new JButton("");
		btn_char3Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(char_3);
					for (JButton i : slots)
					{
						if (i.getText() == "")
						{
							i.setText("3");
							break;
						}
					}
				} catch(IllegalArgumentException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char4Option = new JButton("");
		btn_char4Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(char_4);
					for (JButton i : slots)
					{
						if (i.getText() == "")
						{
							i.setText("4");
							break;
						}
					}
				} catch(IllegalArgumentException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char5Option = new JButton("");
		btn_char5Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(char_5);
					for (JButton i : slots)
					{
						if (i.getText() == "")
						{
							i.setText("5");
							break;
						}
					}
				} catch(IllegalArgumentException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_char6Option = new JButton("");
		btn_char6Option.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					s.add_pilots(char_6);
					for (JButton i : slots)
					{
						if (i.getText() == "")
						{
							i.setText("6");
							break;
						}
					}
				} catch(IllegalArgumentException e1)
				{
					lbl_crewSelectionError.setText(e1.getMessage());
				}
			}
		});
		
		JButton btn_toStartGame = new JButton("go");
		btn_toStartGame.setVisible(false);
		btn_toStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (!s.pilots.isEmpty())
				{
					lbl_crewSelectionError.setText("");
					if(btn_playerCharChoice1.getText() != "" && txt_charChoiceName1.getText() != "")
					{
						
					}
				} else
				{
					lbl_crewSelectionError.setText("Select characters!");
				}
			}
		});
		
		JButton btn_tosetShipName = new JButton("Set");
		btn_tosetShipName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try
				{
					s.set_ship_name(txt_shipName.getText());
					lbl_shipNameError.setText("");
					lbl_nameSet.setText("name set");
					btn_toStartGame.setVisible(true);
				} catch(IllegalArgumentException e1)
				{
					lbl_nameSet.setText("");
					lbl_shipNameError.setText(e1.getMessage());
					btn_toStartGame.setVisible(false);
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lbl_nameShip))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lbl_selectCrewDisplay)
							.addGap(18)
							.addComponent(lbl_crewSelectionError))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(btn_char1Option, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btn_char2Option, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btn_char3Option, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btn_char4Option, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btn_char5Option, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btn_char6Option, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(37)
								.addComponent(txt_shipName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btn_tosetShipName))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(43)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lbl_nameSet)
									.addComponent(lbl_shipNameError))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btn_playerCharChoice1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(btn_playerCharChoice2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(btn_playerCharChoice3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
											.addGap(5)
											.addComponent(btn_playerCharChoice4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txt_charChoiceName1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addGap(3)
											.addComponent(txt_charChoiceName2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
											.addGap(5)
											.addComponent(txt_charChoiceName3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
											.addGap(5)
											.addComponent(txt_charChoiceName4, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
									.addGap(227)
									.addComponent(btn_toStartGame, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_selectedCrewDisplay))))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lbl_nameShip)
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(txt_shipName, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addComponent(btn_tosetShipName, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_nameSet)
						.addComponent(lbl_shipNameError))
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_selectCrewDisplay)
						.addComponent(lbl_crewSelectionError))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_char1Option, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_char2Option, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_char3Option, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_char4Option, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_char5Option, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_char6Option, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(lbl_selectedCrewDisplay)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btn_toStartGame, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_playerCharChoice1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_playerCharChoice2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_playerCharChoice3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_playerCharChoice4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addGap(1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_charChoiceName1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_charChoiceName2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_charChoiceName3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_charChoiceName4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
		);
		getContentPane().setLayout(groupLayout);
	}
}
