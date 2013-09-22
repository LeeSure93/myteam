package com.ccms.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.ccms.client.*;
import com.ccms.util.Account;
import com.ccms.util.CreditCard;
import com.ccms.util.Loss;
import com.ccms.util.User;
import com.ccms.util.CreditCard.CREDITCARDSTATE;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CCManage {
	public static boolean terminate;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action action = new SwingAction();
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_17;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private JTextField textField_15;
	private JTextField textField_16;

	/**
	 * Launch the application.
	 */
	public static void main(User args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CCManage window = new CCManage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	private class monitor implements Runnable {

		public void run() {
			while (true) {
				if (terminate) {
					frame.dispose();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Create the application.
	 */
	public CCManage() {
		Runnable r = new monitor();
		Thread t = new Thread(r);
		t.start();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("信用卡管理");
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 422, 283);
		frame.getContentPane().add(panel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE,
								287, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("查询", null, panel_2, null);

		JLabel label_2 = new JLabel("信用卡卡号");

		JLabel lblNewLabel = new JLabel("所属账户");

		JLabel lblNewLabel_1 = new JLabel("开卡行");

		JLabel lblNewLabel_2 = new JLabel("办卡时间");

		JLabel lblNewLabel_3 = new JLabel("激活状态");

		JLabel lblNewLabel_4 = new JLabel("信用卡状态");

		JLabel lblNewLabel_5 = new JLabel("有效期");

		JButton btnNewButton = new JButton("查询");
		btnNewButton.setAction(action_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2
				.setHorizontalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addGap(65)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_2
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addGroup(
																				gl_panel_2
																						.createSequentialGroup()
																						.addComponent(
																								label_2)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								textField_3,
																								GroupLayout.PREFERRED_SIZE,
																								253,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				gl_panel_2
																						.createSequentialGroup()
																						.addGroup(
																								gl_panel_2
																										.createParallelGroup(
																												Alignment.TRAILING)
																										.addGroup(
																												gl_panel_2
																														.createSequentialGroup()
																														.addComponent(
																																lblNewLabel_1)
																														.addGap(37)
																														.addComponent(
																																textField_5,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												gl_panel_2
																														.createSequentialGroup()
																														.addComponent(
																																lblNewLabel)
																														.addGap(24)
																														.addComponent(
																																textField_4,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												gl_panel_2
																														.createSequentialGroup()
																														.addComponent(
																																lblNewLabel_2)
																														.addGap(24)
																														.addComponent(
																																textField_6,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												gl_panel_2
																														.createSequentialGroup()
																														.addComponent(
																																lblNewLabel_3)
																														.addGap(24)
																														.addComponent(
																																textField_7,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)))
																						.addPreferredGap(
																								ComponentPlacement.RELATED,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								btnNewButton)))
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_2
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNewLabel_4)
																						.addComponent(
																								lblNewLabel_5))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_panel_2
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								textField_9,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textField_8,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(22, Short.MAX_VALUE)));
		gl_panel_2
				.setVerticalGroup(gl_panel_2
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_2)
														.addComponent(
																textField_3,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel)
														.addComponent(
																textField_4,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnNewButton))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																textField_5,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_2)
														.addComponent(
																textField_6,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_3)
														.addComponent(
																textField_7,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_4)
														.addComponent(
																textField_8,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_5)
														.addComponent(
																textField_9,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("修改", null, panel_3, null);

		JLabel label_3 = new JLabel("信用卡卡号");

		JLabel lblNewLabel_6 = new JLabel("所属帐号");

		JLabel lblNewLabel_7 = new JLabel("开卡行");

		JLabel lblNewLabel_8 = new JLabel("办卡时间");

		JLabel lblNewLabel_9 = new JLabel("激活状态");

		JLabel lblNewLabel_10 = new JLabel("信用卡状态");

		JLabel lblNewLabel_11 = new JLabel("有效期");

		textField_11 = new JTextField();
		textField_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox.setEditable(false);
				comboBox.setEnabled(false);
				comboBox_1.setEditable(false);
				comboBox_1.setEnabled(false);
				comboBox.repaint();
				comboBox_1.repaint();
			}
		});
		textField_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEditable(false);
				comboBox.setEnabled(false);
				comboBox_1.setEditable(false);
				comboBox_1.setEnabled(false);
				comboBox.repaint();
				comboBox_1.repaint();

			}
		});
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);

		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);

		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.setAction(action_3);

		JButton button_2 = new JButton("查询");
		button_2.setAction(action_5);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "激活", "未激活" }));

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "正常", "挂失" }));

		JLabel label_6 = new JLabel("年");

		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);

		JLabel label_7 = new JLabel("月");

		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);

		JLabel label_8 = new JLabel("日");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3
				.setHorizontalGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addGap(56)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								label_3)
																						.addComponent(
																								lblNewLabel_7)
																						.addComponent(
																								lblNewLabel_6)
																						.addComponent(
																								lblNewLabel_8)
																						.addComponent(
																								lblNewLabel_9))
																		.addGap(18)
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(
																								gl_panel_3
																										.createSequentialGroup()
																										.addComponent(
																												comboBox,
																												GroupLayout.PREFERRED_SIZE,
																												81,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												btnNewButton_2))
																						.addComponent(
																								textField_11,
																								GroupLayout.PREFERRED_SIZE,
																								249,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_panel_3
																										.createSequentialGroup()
																										.addComponent(
																												textField_12,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(92)
																										.addComponent(
																												button_2,
																												GroupLayout.PREFERRED_SIZE,
																												60,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								textField_13,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textField_14,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNewLabel_10)
																						.addComponent(
																								lblNewLabel_11))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								comboBox_1,
																								GroupLayout.PREFERRED_SIZE,
																								73,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_panel_3
																										.createSequentialGroup()
																										.addComponent(
																												textField_17,
																												GroupLayout.PREFERRED_SIZE,
																												55,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(2)
																										.addComponent(
																												label_6)
																										.addGap(18)
																										.addComponent(
																												textField_15,
																												GroupLayout.PREFERRED_SIZE,
																												40,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												label_7)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												textField_16,
																												GroupLayout.PREFERRED_SIZE,
																												35,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												label_8)))))
										.addContainerGap()));
		gl_panel_3
				.setVerticalGroup(gl_panel_3
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_3)
														.addComponent(
																textField_11,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField_12,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_6)
														.addComponent(button_2))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblNewLabel_7)
														.addComponent(
																textField_13,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textField_14,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_8))
										.addGap(4)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_9)
														.addComponent(
																comboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnNewButton_2))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_10)
														.addComponent(
																comboBox_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField_17,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_11)
														.addComponent(label_6)
														.addComponent(
																textField_15,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_7)
														.addComponent(
																textField_16,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_8))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("挂失", null, panel_4, null);

		JLabel label_4 = new JLabel("信用卡卡号");

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JButton button_1 = new JButton("挂失");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setAction(action);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4
				.setHorizontalGroup(gl_panel_4
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_4
										.createSequentialGroup()
										.addGap(70)
										.addComponent(label_4)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(button_1)
														.addComponent(
																textField_2,
																GroupLayout.PREFERRED_SIZE,
																223,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(41, Short.MAX_VALUE)));
		gl_panel_4
				.setVerticalGroup(gl_panel_4
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_4
										.createSequentialGroup()
										.addGap(45)
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_4)
														.addComponent(
																textField_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 70,
												Short.MAX_VALUE)
										.addComponent(button_1).addGap(63)));
		panel_4.setLayout(gl_panel_4);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("开卡", null, panel_1, null);

		JLabel label = new JLabel("账户编号");

		textField = new JTextField();
		textField.setColumns(10);

		JButton button = new JButton("开卡");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setAction(action_4);

		JLabel label_1 = new JLabel("新开卡号");

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(105)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				label_1)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textField_1))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				label)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								button)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								212,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(30, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(54)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addComponent(button)
										.addGap(30)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_1)
														.addComponent(
																textField_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(61, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("销卡", null, panel_5, null);

		JLabel label_5 = new JLabel("信用卡卡号");

		textField_10 = new JTextField();
		textField_10.setColumns(10);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5
				.setHorizontalGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_5
										.createSequentialGroup()
										.addGap(55)
										.addComponent(label_5)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnNewButton_1)
														.addComponent(
																textField_10,
																GroupLayout.PREFERRED_SIZE,
																243,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(42, Short.MAX_VALUE)));
		gl_panel_5
				.setVerticalGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_5
										.createSequentialGroup()
										.addGap(48)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_5)
														.addComponent(
																textField_10,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(65)
										.addComponent(btnNewButton_1)
										.addContainerGap(72, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);
		panel.setLayout(gl_panel);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "挂失");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String CreditCardID = textField_2.getText();

			if (!Client.IsCreditCardID(CreditCardID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "信用卡卡号格式错误！";
				InformBox.main(msg);
				return;
			}

			Date LossDate = new Date();
			Loss loss = new Loss();
			loss.setCreditCardID(CreditCardID);
			loss.setLossDate(LossDate);
			String msg[] = new String[2];
			if (Client.Lost(loss)) {
				msg[0] = "通知";
				msg[1] = "挂失成功！";
			} else {
				msg[0] = "错误！";
				msg[1] = "挂失失败！";
			}
			InformBox.main(msg);
		}
	}

	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_1() {
			putValue(NAME, "销卡");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String CardID = textField_10.getText();

			if (!Client.IsCreditCardID(CardID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "信用卡卡号格式错误！";
				InformBox.main(msg);
				return;
			}

			String msg[] = new String[2];

			if (Client.DeleteCard(CardID)) {
				msg[0] = "通知";
				msg[1] = "销卡成功！";
			} else {
				msg[0] = "错误1";
				msg[1] = "销卡失败！";
			}
			InformBox.main(msg);
		}
	}

	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_2() {
			putValue(NAME, "查询");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			String CardID = textField_3.getText();
			if (!Client.IsCreditCardID(CardID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "信用卡卡号格式错误！";
				InformBox.main(msg);
				return;
			}

			CreditCard creditCard = Client.GetCreditCard(CardID);
			if (creditCard == null) {
				String msg[] = new String[2];
				msg[0] = "错误！";
				msg[1] = "找不到信用卡！";
				InformBox.main(msg);
			} else {
				textField_4.setText(creditCard.getAccountID());
				textField_5.setText(creditCard.getBankName());
				textField_6.setText(creditCard.getCreateCreditCardTime()
						.toLocaleString());
				if (creditCard.getStatus() == CREDITCARDSTATE.lost) {
					textField_7.setText(CreditCard.CREDITCARDSTATE.unActive
							.toString());
					textField_8.setText(creditCard.getStatus().toString());
				} else {
					textField_7.setText(creditCard.getStatus().toString());
					textField_8.setText(creditCard.getStatus().toString());
				}

				textField_9.setText(creditCard.getDeadline().toLocaleString());
				frame.repaint();
			}

		}
	}

	private class SwingAction_5 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// 修改前的查询
		public SwingAction_5() {
			putValue(NAME, "查询");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			comboBox.setEnabled(false);
			comboBox.setEditable(false);
			comboBox_1.setEnabled(false);
			comboBox_1.setEditable(false);
			comboBox.repaint();
			comboBox_1.repaint();
			frame.repaint();

			String CardID = textField_11.getText();

			if (!Client.IsCreditCardID(CardID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "信用卡卡号格式错误！";
				InformBox.main(msg);
				return;
			}

			CreditCard creditCard = Client.GetCreditCard(CardID);
			if (creditCard == null) {
				String msg[] = new String[2];
				msg[0] = "错误！";
				msg[1] = "找不到信用卡！";
				InformBox.main(msg);
				return;
			}
			textField_12.setText(creditCard.getAccountID());
			textField_13.setText(creditCard.getBankName());
			textField_14.setText(creditCard.getCreateCreditCardTime()
					.toLocaleString());
			System.out.println(creditCard.getStatus());
			if (creditCard.getStatus() == CREDITCARDSTATE.Active) {
				// 0表示激活
				comboBox.setEnabled(true);
				comboBox.setEditable(true);
				comboBox.setSelectedIndex(0);
				comboBox.repaint();

			} else if (creditCard.getStatus() == CREDITCARDSTATE.unActive) {
				// 0表示未激活
				comboBox.setEnabled(true);
				comboBox.setEditable(true);
				comboBox.setSelectedIndex(1);
				comboBox.repaint();

			}
			comboBox.repaint();
			comboBox_1.repaint();
			/* cyb修改2012.11.17.8.45 */
			if (creditCard.getStatus() == CREDITCARDSTATE.lost) {
				// lost表示挂失
				comboBox_1.setEnabled(true);
				comboBox_1.setEditable(true);
				comboBox.setSelectedIndex(1);
				comboBox_1.setSelectedIndex(1);
				comboBox_1.repaint();
				comboBox.repaint();

			} else {
				comboBox_1.setSelectedIndex(0);
			}
			comboBox.repaint();
			comboBox_1.repaint();
			textField_17.setText(String.valueOf(creditCard.getDeadline()
					.getYear() + 1900));
			textField_15.setText(String.valueOf(creditCard.getDeadline()
					.getMonth()));
			textField_16.setText(String.valueOf(creditCard.getDeadline()
					.getDate()));

			textField_17.setEditable(true);
			textField_17.setEnabled(true);
			textField_15.setEditable(true);
			textField_15.setEnabled(true);
			textField_16.setEditable(true);
			textField_16.setEnabled(true);
			comboBox.repaint();
			comboBox_1.repaint();
			frame.repaint();
			comboBox.repaint();
			comboBox_1.repaint();
		}
	}

	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_3() {
			putValue(NAME, "修改");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			// if (!comboBox.isEnabled()) {
			// // TODO此处还可以给点小提示啥的。。。
			//
			// return;
			// }
			String CardID = textField_11.getText();

			if (!Client.IsCreditCardID(CardID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "信用卡卡号格式错误！";
				InformBox.main(msg);
				return;
			}

			CreditCard creditCard = Client.GetCreditCard(CardID);

			if ((!comboBox.isEnabled()) && (!comboBox.isEnabled())) {
				if (comboBox_1.getSelectedIndex() == 0) {
					creditCard.setStatus(CREDITCARDSTATE.unActive);
				} else if (comboBox_1.getSelectedIndex() == 1) {
					creditCard.setStatus(CREDITCARDSTATE.lost);
				}
			} else {
				if (comboBox.getSelectedIndex() == 0) {
					creditCard.setStatus(CREDITCARDSTATE.Active);
				} else if (comboBox.getSelectedIndex() == 1) {
					creditCard.setStatus(CREDITCARDSTATE.unActive);
				}
			}
			// 17 15 16 分别为年月日
			Date dead = null;
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				dead = format1
						.parse(textField_17.getText() + "-"
								+ textField_15.getText() + "-"
								+ textField_16.getText());
			} catch (ParseException e1) {
				e1.printStackTrace();
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "日期格式错误！";
				InformBox.main(msg);
				return;
			}
			creditCard.setDeadline(dead);// 这样不知道对不对

			String[] msg = new String[2];
			if (Client.EditCreditCard(creditCard)) {
				msg[0] = "通知";
				msg[1] = "信用卡信息修改成功！";
			} else {
				msg[0] = "错误！";
				msg[1] = "信用卡信息修改失败！";
			}
			InformBox.main(msg);

		}
	}

	private class SwingAction_4 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_4() {
			putValue(NAME, "开卡");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String AccountID = textField.getText();

			if (!Client.IsAccountID(AccountID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "帐号格式错误！";
				InformBox.main(msg);
				return;
			}

			Account account = Client.GetAccount(AccountID);
			if (account == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "没有此账户！";
				InformBox.main(msg);
				return;
			}
			CreditCard creditCard = Client.CreateCC(account);
			if (creditCard == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "开卡失败！";
				InformBox.main(msg);
				return;
			}
			textField_1.setText(creditCard.getCreditCardID());

			String[] msg = new String[2];
			msg[0] = "通知";
			msg[1] = "开卡成功！";
			InformBox.main(msg);

		}
	}
}
