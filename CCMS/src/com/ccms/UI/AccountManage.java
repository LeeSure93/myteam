package com.ccms.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.ccms.client.*;
import com.ccms.util.Account;
import com.ccms.util.Costumer;
import com.ccms.util.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;

public class AccountManage {

	public static boolean terminate;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private final Action action_6 = new SwingAction_6();
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private final Action action_7 = new SwingAction_7();

	/**
	 * Launch the application.
	 */
	public static void main(User args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManage window = new AccountManage();
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
	public AccountManage() {
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
		frame.setTitle("账户管理");
		frame.setBounds(100, 100, 478, 335);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 422,
								Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 249,
								Short.MAX_VALUE).addContainerGap()));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE));

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("开户", null, panel_1, null);

		JLabel lblNewLabel = new JLabel("身份证号");

		JLabel lblNewLabel_1 = new JLabel("姓");

		JLabel lblNewLabel_2 = new JLabel("出生日期");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("名");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("电话号码");

		JLabel lblNewLabel_5 = new JLabel("住址");

		JLabel label = new JLabel("电子邮件");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JLabel label_1 = new JLabel("@");

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setColumns(10);

		JButton button = new JButton("开户");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setAction(action);

		textField_34 = new JTextField();
		textField_34.setVisible(false);
		textField_34.setEditable(false);
		textField_34.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("账户号");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(30)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_5)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				textField_5,
																				282,
																				282,
																				282))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				textField_2,
																				256,
																				256,
																				256))
														.addGroup(
																gl_panel_1
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addGroup(
																				gl_panel_1
																						.createSequentialGroup()
																						.addGroup(
																								gl_panel_1
																										.createParallelGroup(
																												Alignment.LEADING,
																												false)
																										.addGroup(
																												gl_panel_1
																														.createSequentialGroup()
																														.addComponent(
																																lblNewLabel_2)
																														.addPreferredGap(
																																ComponentPlacement.RELATED)
																														.addComponent(
																																textField_7,
																																GroupLayout.PREFERRED_SIZE,
																																58,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																ComponentPlacement.RELATED)
																														.addComponent(
																																textField_8,
																																0,
																																0,
																																Short.MAX_VALUE))
																										.addGroup(
																												gl_panel_1
																														.createSequentialGroup()
																														.addComponent(
																																lblNewLabel_4)
																														.addPreferredGap(
																																ComponentPlacement.RELATED)
																														.addComponent(
																																textField_6,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE)))
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								textField_9,
																								0,
																								0,
																								Short.MAX_VALUE))
																		.addGroup(
																				gl_panel_1
																						.createSequentialGroup()
																						.addComponent(
																								lblNewLabel_1)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								56,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								lblNewLabel_3)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								textField_1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								label)
																						.addComponent(
																								lblNewLabel_6))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addComponent(
																								textField_34,
																								Alignment.LEADING)
																						.addGroup(
																								Alignment.LEADING,
																								gl_panel_1
																										.createSequentialGroup()
																										.addComponent(
																												textField_3,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(4)
																										.addComponent(
																												label_1)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												textField_4,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				button)))
										.addContainerGap(29, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(24)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel)
														.addComponent(
																textField_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblNewLabel_1)
														.addGroup(
																gl_panel_1
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				textField,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				lblNewLabel_3)
																		.addComponent(
																				textField_1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_2)
														.addComponent(
																textField_7,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_8,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_9,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_4)
														.addComponent(
																textField_6,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_5)
														.addComponent(
																textField_5,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label)
														.addComponent(
																textField_3,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_1)
														.addComponent(
																textField_4,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(button))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField_34,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_6))
										.addContainerGap(13, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("客户信息维护", null, panel_2, null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);

		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("查询", null, panel_6, null);

		JLabel label_6 = new JLabel("电子邮件");

		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);

		JLabel label_7 = new JLabel("@");

		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);

		JButton button_3 = new JButton("查询");
		button_3.setAction(action_3);

		JLabel label_8 = new JLabel("住址");

		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);

		JLabel label_9 = new JLabel("客户编号");

		textField_17 = new JTextField();
		textField_17.setColumns(10);

		JLabel label_10 = new JLabel("出生日期");

		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setText("年");
		textField_18.setColumns(10);

		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setText("月");
		textField_19.setColumns(10);

		JLabel label_11 = new JLabel("电话号码");

		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setText("日");
		textField_21.setColumns(10);

		JLabel label_12 = new JLabel("姓");

		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setColumns(10);

		JLabel label_13 = new JLabel("名");

		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6
				.setHorizontalGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_6
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				label_9,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_17,
																				GroupLayout.PREFERRED_SIZE,
																				256,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				button_3,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				label_12,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_22,
																				GroupLayout.PREFERRED_SIZE,
																				56,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				label_13,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_23,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				label_10,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_18,
																				GroupLayout.PREFERRED_SIZE,
																				58,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(6)
																		.addComponent(
																				textField_19,
																				GroupLayout.PREFERRED_SIZE,
																				50,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(6)
																		.addComponent(
																				textField_21,
																				GroupLayout.PREFERRED_SIZE,
																				48,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				label_11,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_20,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				label_8,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_16,
																				GroupLayout.PREFERRED_SIZE,
																				282,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addComponent(
																				label_6,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_14,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(4)
																		.addComponent(
																				label_7,
																				GroupLayout.PREFERRED_SIZE,
																				12,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_15,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_panel_6
				.setVerticalGroup(gl_panel_6
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_6
										.createSequentialGroup()
										.addContainerGap(15, Short.MAX_VALUE)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_9))
														.addGroup(
																gl_panel_6
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				textField_17,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				button_3)))
										.addGap(12)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(label_12)
														.addComponent(
																textField_22,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_13))
														.addComponent(
																textField_23,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_10))
														.addComponent(
																textField_18,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_19,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_21,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_11))
														.addComponent(
																textField_20,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_8))
														.addComponent(
																textField_16,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				label_6))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				textField_14,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				label_7))
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				textField_15,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(3)));
		panel_6.setLayout(gl_panel_6);

		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("修改", null, panel_7, null);

		JLabel label_14 = new JLabel("电子邮件");

		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setColumns(10);

		JLabel label_15 = new JLabel("@");

		textField_25 = new JTextField();
		textField_25.setEditable(false);
		textField_25.setColumns(10);

		JButton button_4 = new JButton("修改");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setAction(action_5);

		JLabel label_16 = new JLabel("住址");

		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setColumns(10);

		JLabel label_17 = new JLabel("客户编号");

		textField_27 = new JTextField();
		textField_27.setColumns(10);

		JLabel label_18 = new JLabel("出生日期");

		textField_28 = new JTextField();
		textField_28.setEditable(false);
		textField_28.setText("年");
		textField_28.setColumns(10);

		textField_29 = new JTextField();
		textField_29.setEditable(false);
		textField_29.setText("月");
		textField_29.setColumns(10);

		JLabel label_19 = new JLabel("电话号码");

		textField_30 = new JTextField();
		textField_30.setEditable(false);
		textField_30.setColumns(10);

		textField_31 = new JTextField();
		textField_31.setEditable(false);
		textField_31.setText("日");
		textField_31.setColumns(10);

		JLabel label_20 = new JLabel("姓");

		textField_32 = new JTextField();
		textField_32.setEditable(false);
		textField_32.setColumns(10);

		JLabel label_21 = new JLabel("名");

		textField_33 = new JTextField();
		textField_33.setEditable(false);
		textField_33.setColumns(10);

		JButton button_5 = new JButton("查询");
		button_5.setAction(action_4);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7
				.setHorizontalGroup(gl_panel_7
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_7
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_7
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addComponent(
																				label_17,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_27,
																				GroupLayout.PREFERRED_SIZE,
																				256,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				button_5,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addComponent(
																				label_20,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_32,
																				GroupLayout.PREFERRED_SIZE,
																				56,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				label_21,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_33,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addComponent(
																				label_18,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_28,
																				GroupLayout.PREFERRED_SIZE,
																				58,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(6)
																		.addComponent(
																				textField_29,
																				GroupLayout.PREFERRED_SIZE,
																				50,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(6)
																		.addComponent(
																				textField_31,
																				GroupLayout.PREFERRED_SIZE,
																				48,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addComponent(
																				label_19,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_30,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addComponent(
																				label_16,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_26,
																				GroupLayout.PREFERRED_SIZE,
																				282,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addComponent(
																				label_14,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_24,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(4)
																		.addComponent(
																				label_15,
																				GroupLayout.PREFERRED_SIZE,
																				12,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_25,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(6)
																		.addComponent(
																				button_4,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		gl_panel_7
				.setVerticalGroup(gl_panel_7
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_7
										.createSequentialGroup()
										.addGroup(
												gl_panel_7
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_7
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_7
																										.createSequentialGroup()
																										.addGap(2)
																										.addComponent(
																												label_17))
																						.addComponent(
																								textField_27,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(12)
																		.addGroup(
																				gl_panel_7
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								label_20)
																						.addComponent(
																								textField_32,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_panel_7
																										.createSequentialGroup()
																										.addGap(2)
																										.addComponent(
																												label_21))
																						.addComponent(
																								textField_33,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(12)
																		.addGroup(
																				gl_panel_7
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_7
																										.createSequentialGroup()
																										.addGap(2)
																										.addComponent(
																												label_18))
																						.addComponent(
																								textField_28,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textField_29,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								textField_31,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(12)
																		.addGroup(
																				gl_panel_7
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_7
																										.createSequentialGroup()
																										.addGap(2)
																										.addComponent(
																												label_19))
																						.addComponent(
																								textField_30,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(12)
																		.addGroup(
																				gl_panel_7
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_7
																										.createSequentialGroup()
																										.addGap(2)
																										.addComponent(
																												label_16))
																						.addComponent(
																								textField_26,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(button_5))
										.addGap(12)
										.addGroup(
												gl_panel_7
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				label_14))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				textField_24,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				label_15))
														.addGroup(
																gl_panel_7
																		.createSequentialGroup()
																		.addGap(3)
																		.addComponent(
																				textField_25,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(button_4))
										.addContainerGap(18, Short.MAX_VALUE)));
		panel_7.setLayout(gl_panel_7);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE,
								404, Short.MAX_VALUE).addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addGap(5)
						.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE,
								205, Short.MAX_VALUE).addContainerGap()));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("存款", null, panel_3, null);

		JLabel label_2 = new JLabel("帐号");

		JLabel label_3 = new JLabel("金额");

		textField_10 = new JTextField();
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);

		JButton button_1 = new JButton("存入");
		button_1.setAction(action_1);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3
				.setHorizontalGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(102)
																		.addGroup(
																				gl_panel_3
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_3
																										.createSequentialGroup()
																										.addComponent(
																												label_2)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												textField_10,
																												GroupLayout.PREFERRED_SIZE,
																												194,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_panel_3
																										.createSequentialGroup()
																										.addComponent(
																												label_3)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												textField_11,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(170)
																		.addComponent(
																				button_1)))
										.addContainerGap(94, Short.MAX_VALUE)));
		gl_panel_3
				.setVerticalGroup(gl_panel_3
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addGap(40)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_2)
														.addComponent(
																textField_10,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
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
										.addPreferredGap(
												ComponentPlacement.RELATED, 52,
												Short.MAX_VALUE)
										.addComponent(button_1).addGap(49)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("取款", null, panel_4, null);

		JLabel label_4 = new JLabel("帐号");

		JLabel label_5 = new JLabel("金额");

		textField_12 = new JTextField();
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setColumns(10);

		JButton button_2 = new JButton("取出");
		button_2.setAction(action_2);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4
				.setHorizontalGroup(gl_panel_4
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_4
										.createSequentialGroup()
										.addGap(104)
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_4
																		.createSequentialGroup()
																		.addComponent(
																				label_5)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textField_13,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_4
																		.createSequentialGroup()
																		.addComponent(
																				label_4)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textField_12,
																				GroupLayout.PREFERRED_SIZE,
																				240,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(40, Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING,
								gl_panel_4.createSequentialGroup()
										.addContainerGap(190, Short.MAX_VALUE)
										.addComponent(button_2).addGap(178)));
		gl_panel_4
				.setVerticalGroup(gl_panel_4
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_4
										.createSequentialGroup()
										.addGap(57)
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_4)
														.addComponent(
																textField_12,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_5)
														.addComponent(
																textField_13,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 45,
												Short.MAX_VALUE)
										.addComponent(button_2).addGap(39)));
		panel_4.setLayout(gl_panel_4);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("账单查询", null, panel_5, null);

		JLabel label_24 = new JLabel("帐号");

		textField_37 = new JTextField();
		textField_37.setColumns(10);

		JButton button_7 = new JButton("查询");
		button_7.setAction(action_7);

		JLabel label_25 = new JLabel("存入");
		label_25.setFont(new Font("宋体", Font.BOLD, 12));

		textField_38 = new JTextField();
		textField_38.setEditable(false);
		textField_38.setColumns(10);

		JLabel label_26 = new JLabel("年");

		textField_39 = new JTextField();
		textField_39.setColumns(10);

		JLabel label_27 = new JLabel("月");

		textField_40 = new JTextField();
		textField_40.setColumns(10);

		JLabel label_28 = new JLabel("取出");

		textField_41 = new JTextField();
		textField_41.setEditable(false);
		textField_41.setColumns(10);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5
				.setHorizontalGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_5
										.createSequentialGroup()
										.addGap(90)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addComponent(
																				label_24,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_37,
																				GroupLayout.PREFERRED_SIZE,
																				194,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_5
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								button_7,
																								GroupLayout.PREFERRED_SIZE,
																								60,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_panel_5
																										.createParallelGroup(
																												Alignment.LEADING,
																												false)
																										.addGroup(
																												gl_panel_5
																														.createSequentialGroup()
																														.addComponent(
																																label_25,
																																GroupLayout.PREFERRED_SIZE,
																																26,
																																GroupLayout.PREFERRED_SIZE)
																														.addGap(18)
																														.addComponent(
																																textField_38,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												gl_panel_5
																														.createSequentialGroup()
																														.addComponent(
																																label_26,
																																GroupLayout.PREFERRED_SIZE,
																																26,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																ComponentPlacement.RELATED)
																														.addComponent(
																																textField_39,
																																GroupLayout.PREFERRED_SIZE,
																																59,
																																GroupLayout.PREFERRED_SIZE)
																														.addPreferredGap(
																																ComponentPlacement.RELATED,
																																GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																label_27,
																																GroupLayout.PREFERRED_SIZE,
																																26,
																																GroupLayout.PREFERRED_SIZE))
																										.addGroup(
																												gl_panel_5
																														.createSequentialGroup()
																														.addComponent(
																																label_28)
																														.addPreferredGap(
																																ComponentPlacement.UNRELATED)
																														.addComponent(
																																textField_41,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))))
																		.addGap(12)
																		.addComponent(
																				textField_40,
																				GroupLayout.PREFERRED_SIZE,
																				59,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(123, Short.MAX_VALUE)));
		gl_panel_5
				.setVerticalGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_5
										.createSequentialGroup()
										.addGap(45)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_24))
														.addComponent(
																textField_37,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(20)
																		.addComponent(
																				label_26))
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(18)
																		.addGroup(
																				gl_panel_5
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_panel_5
																										.createParallelGroup(
																												Alignment.BASELINE)
																										.addComponent(
																												textField_40,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addComponent(
																												label_27))
																						.addComponent(
																								textField_39,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(button_7)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_25))
														.addComponent(
																textField_38,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_28)
														.addComponent(
																textField_41,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(36, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);

		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("结算", null, panel_8, null);

		JLabel label_22 = new JLabel("帐号");

		textField_35 = new JTextField();
		textField_35.setColumns(10);

		JLabel label_23 = new JLabel("余额");
		label_23.setFont(new Font("宋体", Font.BOLD, 12));

		textField_36 = new JTextField();
		textField_36.setEditable(false);
		textField_36.setColumns(10);

		JButton button_6 = new JButton("结算");
		button_6.setAction(action_6);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8
				.setHorizontalGroup(gl_panel_8
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_8
										.createSequentialGroup()
										.addGap(98)
										.addGroup(
												gl_panel_8
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_8
																		.createSequentialGroup()
																		.addComponent(
																				label_22,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_35,
																				GroupLayout.PREFERRED_SIZE,
																				194,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_8
																		.createParallelGroup(
																				Alignment.TRAILING)
																		.addComponent(
																				button_6,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE)
																		.addGroup(
																				gl_panel_8
																						.createSequentialGroup()
																						.addComponent(
																								label_23,
																								GroupLayout.PREFERRED_SIZE,
																								26,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(
																								textField_36,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(115, Short.MAX_VALUE)));
		gl_panel_8
				.setVerticalGroup(gl_panel_8
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_8
										.createSequentialGroup()
										.addGap(36)
										.addGroup(
												gl_panel_8
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_8
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_22))
														.addComponent(
																textField_35,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(28)
										.addComponent(button_6)
										.addGap(26)
										.addGroup(
												gl_panel_8
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_8
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_23))
														.addComponent(
																textField_36,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(89, Short.MAX_VALUE)));
		panel_8.setLayout(gl_panel_8);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "开户");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {
			Costumer costumer = new Costumer();
			// String CostumerID;
			String ID;
			String FirstName;
			String LastName;
			String Gender;
			Date Birthday;
			String PhoneNumber;
			String Address;
			String EmailAddress;

			ID = textField_2.getText();
			LastName = textField.getText();
			FirstName = textField_1.getText();
			PhoneNumber = textField_6.getText();
			Address = textField_5.getText();
			EmailAddress = textField_3.getText() + "@" + textField_4.getText();

			if (!Client.IsTelephoneNumber(PhoneNumber)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "电话格式错误！";
				InformBox.main(msg);
				return;
			}
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date CostumerBirthDay = null;
			try {
				CostumerBirthDay = format1.parse(textField_7.getText() + "-"
						+ textField_8.getText() + "-" + textField_9.getText());
			} catch (ParseException e1) {
				e1.printStackTrace();
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "日期格式错误！";
				InformBox.main(msg);
				return;
			}

			costumer.setID(ID);
			costumer.setFirstName(FirstName);
			costumer.setSecondName(LastName);
			costumer.setPhoneNumber(PhoneNumber);
			costumer.setAddress(Address);
			costumer.setBirthday(CostumerBirthDay);
			costumer.setEmailAddress(EmailAddress);

			costumer = Client.CreateCostumer(costumer);

			Account account = Client.CreateAccount(costumer);

			if (account == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "开户失败！";
				InformBox.main(msg);

			} else {
				String[] msg = new String[2];
				msg[0] = "通知";
				msg[1] = "开户成功！";
				InformBox.main(msg);
				textField_34.setVisible(true);
				textField_34.setText(account.getAccountID());
				frame.repaint();
			}

		}
	}

	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_1() {
			putValue(NAME, "存入");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String AccountID = textField_10.getText();
			String money = textField_11.getText();

			if (!Client.IsAccountID(AccountID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "帐号格式错误！";
				InformBox.main(msg);
				return;
			}

			Account account = Client.GetAccount(AccountID);
			String msg[] = new String[2];
			if (Client.Deposit(account, money)) {
				msg[0] = "成功！";
				msg[1] = "存款成功！";
			} else {
				msg[0] = "错误！";
				msg[1] = "存款发生错误！";
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
			putValue(NAME, "取出");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String AccountID = textField_12.getText();
			String money = textField_13.getText();

			if (!Client.IsAccountID(AccountID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "帐号格式错误！";
				InformBox.main(msg);
				return;
			}

			Account account = Client.GetAccount(AccountID);
			String msg[] = new String[2];
			if (Client.DrawMoney(account, money)) {
				msg[0] = "成功！";
				msg[1] = "取款成功！";
			} else {
				msg[0] = "错误！";
				msg[1] = "取款发生错误！";
			}
			InformBox.main(msg);

		}
	}

	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_3() {
			putValue(NAME, "查询");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			String ID = textField_17.getText();

			if (!Client.IsCostumerID(ID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "帐客户号格式错误！";
				InformBox.main(msg);
				return;
			}

			Costumer costumer = Client.GetCostumer(ID);
			if (costumer == null) {
				String msg[] = new String[2];
				msg[0] = "错误！";
				msg[1] = "储户不存在！";
				return;
			}
			textField_23.setText(costumer.getFirstName());
			textField_22.setText(costumer.getSecondName());
			textField_20.setText(costumer.getPhoneNumber());
			textField_16.setText(costumer.getAddress());
			String[] Email;
			Email = costumer.getEmailAddress().split("@");

			textField_14.setText(Email[0]);

			textField_15.setText(Email[1]);

			textField_18.setText(String.valueOf(costumer.getBirthday()
					.getYear() + 1900));
			textField_19.setText(String.valueOf(costumer.getBirthday()
					.getMonth()));
			textField_21.setText(String.valueOf(costumer.getBirthday()
					.getDate()));

			// 18 19 21 是生日的年月日

			frame.repaint();

		}
	}

	private class SwingAction_4 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_4() {
			putValue(NAME, "查询");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		// 供先查询后修改之用
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			String ID = textField_27.getText();

			if (!Client.IsCostumerID(ID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "帐号格式错误！";
				InformBox.main(msg);
				return;
			}

			Costumer costumer = Client.GetCostumer(ID);

			if (costumer == null) {
				String msg[] = new String[2];
				msg[0] = "错误！";
				msg[1] = "储户不存在！";
				return;
			}

			textField_30.setEditable(true);
			textField_26.setEditable(true);
			textField_24.setEditable(true);
			textField_25.setEditable(true);

			textField_33.setText(costumer.getFirstName());
			textField_32.setText(costumer.getSecondName());
			textField_30.setText(costumer.getPhoneNumber());
			textField_26.setText(costumer.getAddress());

			String[] Email;
			Email = costumer.getEmailAddress().split("@");

			textField_24.setText(Email[0]);

			textField_25.setText(Email[1]);
			textField_28.setText(String.valueOf(costumer.getBirthday()
					.getYear() + 1900));
			textField_29.setText(String.valueOf(costumer.getBirthday()
					.getMonth()));
			textField_31.setText(String.valueOf(costumer.getBirthday()
					.getDate()));
			textField_30.setEditable(true);
			textField_26.setEditable(true);
			textField_24.setEditable(true);
			textField_25.setEditable(true);
			frame.repaint();
		}
	}

	private class SwingAction_5 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_5() {
			putValue(NAME, "修改");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			textField_30.setEditable(true);
			textField_26.setEditable(true);
			textField_24.setEditable(true);
			textField_25.setEditable(true);
			frame.repaint();

			String NewPhone = textField_30.getText();

			if (!Client.IsTelephoneNumber(NewPhone)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "电话格式错误！";
				InformBox.main(msg);
				return;
			}

			String NewAddress = textField_26.getText();
			String[] EmaiStrings;
			EmaiStrings = new String[2];
			EmaiStrings[0] = textField_24.getText();
			EmaiStrings[1] = textField_25.getText();
			/*
			 * 
			 * 
			 * 24 25 26 30
			 */
			String ID = textField_27.getText();

			if (!Client.IsCostumerID(ID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "客户号格式错误！";
				InformBox.main(msg);
				return;
			}

			Costumer costumer = Client.GetCostumer(ID);
			costumer.setAddress(NewAddress);
			costumer.setPhoneNumber(NewPhone);
			costumer.setEmailAddress(EmaiStrings[0] + "@" + EmaiStrings[1]);
			String msg[] = new String[2];
			if (Client.EditCostumer(costumer)) {

				msg[0] = "错误！";
				msg[1] = "修改储户信息失败！";
			} else {
				msg[0] = "通知";
				msg[1] = "修改储户信息成功";
			}
			InformBox.main(msg);

		}
	}

	private class SwingAction_6 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_6() {
			putValue(NAME, "结算");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String AccountID = textField_35.getText();
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
				msg[1] = "找不到账户！";
				return;
			}

			textField_36.setText(account.getMoney());
		}
	}

	private class SwingAction_7 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_7() {
			putValue(NAME, "查询");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

			/*
			 * 37 是帐号 39是年 40是月 38存入 41取出
			 */
			String accountID = textField_37.getText();

			if (!Client.IsAccountID(accountID)) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "帐号格式错误！";
				InformBox.main(msg);
				return;
			}

			Account account = Client.GetAccount(accountID);
			if (account == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "帐号错误！";
				InformBox.main(msg);
				return;
			}

			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date Start = null;
			Date End = null;
			try {
				Start = format1.parse(textField_39.getText() + "-"
						+ textField_40.getText() + "-01");
				End = format1.parse(textField_39.getText() + "-"
						+ textField_40.getText() + "-30");
			} catch (ParseException e1) {
				e1.printStackTrace();
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "日期格式错误！";
				InformBox.main(msg);
				return;
			}
			String ret = Client.BillCheck(account, Start, End);
			if (ret == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "查询错误！";
				InformBox.main(msg);
				return;
			} else {
				textField_38.setText(ret.split(" = ")[0]);
				textField_41.setText(ret.split(" = ")[1]);
				frame.repaint();
			}
		}
	}
}
