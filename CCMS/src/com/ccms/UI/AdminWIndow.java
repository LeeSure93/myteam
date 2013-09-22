package com.ccms.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.ccms.client.*;
import com.ccms.util.User;
import com.ccms.util.User.USERSTATE;
import com.ccms.util.User.USERTYPE;

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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminWIndow {

	private JFrame frmXxx;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_12;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JComboBox comboBox;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();

	private static User user;
	private final Action action_5 = new SwingAction_5();
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private final Action action_6 = new SwingAction_6();
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextArea textArea;
	private final Action action_7 = new SwingAction_7();

	public User getUser() {
		return user;
	}

	@SuppressWarnings("unused")
	private static void setUser(User u) {
		user = u;
	}

	/**
	 * Launch the application.
	 */
	public static void main(final User args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWIndow window = new AdminWIndow(args);
					window.frmXxx.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminWIndow(User u) {
		user = u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmXxx = new JFrame();
		frmXxx.setTitle("HIT银行系统管理界面");
		frmXxx.setBounds(100, 100, 499, 348);
		frmXxx.setLocationRelativeTo(null);
		frmXxx.setResizable(false);
		frmXxx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmXxx.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 442,
								Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 277,
								Short.MAX_VALUE).addContainerGap()));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE));

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("添加用户", null, panel_1, null);

		JLabel lblNewLabel = new JLabel("工号");

		JLabel lblNewLabel_1 = new JLabel("姓名");

		JLabel lblNewLabel_2 = new JLabel("类型");

		JLabel lblNewLabel_3 = new JLabel("Email");

		JLabel lblNewLabel_4 = new JLabel("状态");

		JLabel lblNewLabel_5 = new JLabel("所属银行");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "操作员", "管理员" }));

		JLabel label_7 = new JLabel("密码");

		passwordField = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(31)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblNewLabel_5)
														.addComponent(
																lblNewLabel_4)
														.addComponent(
																lblNewLabel_3)
														.addComponent(
																lblNewLabel_2)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																lblNewLabel))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textField_5,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_4,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				textField,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				label_7)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				passwordField,
																				GroupLayout.PREFERRED_SIZE,
																				130,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				textField_3,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(85)
																		.addComponent(
																				btnNewButton))
														.addGroup(
																gl_panel_1
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addComponent(
																				comboBox,
																				Alignment.LEADING,
																				0,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				textField_1,
																				Alignment.LEADING)))
										.addContainerGap(87, Short.MAX_VALUE)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(25)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
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
																								lblNewLabel)
																						.addComponent(
																								label_7)
																						.addComponent(
																								passwordField,
																								GroupLayout.PREFERRED_SIZE,
																								22,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textField_1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(7)
																		.addComponent(
																				comboBox,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								textField_3,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnNewButton))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textField_4,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				lblNewLabel_1)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblNewLabel_2)
																		.addGap(18)
																		.addComponent(
																				lblNewLabel_3)
																		.addGap(18)
																		.addComponent(
																				lblNewLabel_4)))
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
										.addContainerGap(42, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("删除用户", null, panel_2, null);

		JLabel label_6 = new JLabel("工号");

		textField_12 = new JTextField();
		textField_12.setColumns(10);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2
				.setHorizontalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addGap(143)
																		.addComponent(
																				btnNewButton_1))
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addGap(118)
																		.addComponent(
																				label_6)
																		.addGap(18)
																		.addComponent(
																				textField_12,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(157, Short.MAX_VALUE)));
		gl_panel_2
				.setVerticalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_panel_2
										.createSequentialGroup()
										.addGap(50)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_6))
														.addComponent(
																textField_12,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 67,
												Short.MAX_VALUE)
										.addComponent(btnNewButton_1)
										.addGap(61)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("查询用户信息", null, panel_3, null);

		JLabel label = new JLabel("所属银行");

		JLabel label_1 = new JLabel("状态");

		JLabel label_2 = new JLabel("Email");

		JLabel label_3 = new JLabel("类型");

		JLabel label_4 = new JLabel("姓名");

		JLabel label_5 = new JLabel("工号");

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		// textField_6.setEditable(false);
		// textField_6.setVisible(false);
		textField_6.setColumns(10);

		JButton button = new JButton("New button");
		button.setAction(action_2);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		// textField_7.setEditable(false);
		// textField_7.setVisible(false);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		// textField_8.setEditable(false);
		// textField_8.setVisible(false);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		// textField_9.setEditable(false);
		// textField_9.setVisible(false);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setEditable(false);
		// textField_11.setEditable(false);
		// textField_11.setVisible(false);
		textField_11.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3
				.setHorizontalGroup(gl_panel_3
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_3
										.createSequentialGroup()
										.addContainerGap(86, Short.MAX_VALUE)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				label_5,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(44)
																		.addComponent(
																				textField_10,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				label_4,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(44)
																		.addComponent(
																				textField_9,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				label_3,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(44)
																		.addComponent(
																				textField_8,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				label_2,
																				GroupLayout.PREFERRED_SIZE,
																				37,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(33)
																		.addComponent(
																				textField_11,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				label_1,
																				GroupLayout.PREFERRED_SIZE,
																				26,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(44)
																		.addComponent(
																				textField_7,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addComponent(
																				label,
																				GroupLayout.PREFERRED_SIZE,
																				52,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				textField_6,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(73)
																		.addComponent(
																				button)))
										.addGap(79)));
		gl_panel_3
				.setVerticalGroup(gl_panel_3
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_panel_3
										.createSequentialGroup()
										.addGap(30)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_5))
														.addComponent(
																textField_10,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				label_4))
														.addComponent(
																textField_9,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(label_3)
														.addComponent(
																textField_8,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_2))
														.addComponent(
																textField_11,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(4)
																		.addComponent(
																				label_1))
														.addComponent(
																textField_7,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(12)
										.addGroup(
												gl_panel_3
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label))
														.addComponent(
																textField_6,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_3
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				button)))
										.addContainerGap(35, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("开卡情况报表", null, panel_4, null);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("2010");
		textField_2.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setText("01");
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setText("2012");
		textField_14.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setText("12");
		textField_15.setColumns(10);

		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);

		JButton btnNewButton_2 = new JButton("统计");
		btnNewButton_2.setAction(action_3);

		JLabel label_8 = new JLabel("年");

		JLabel label_9 = new JLabel("年");

		JLabel label_10 = new JLabel("月");

		JLabel label_11 = new JLabel("月");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4
				.setHorizontalGroup(gl_panel_4
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_4.createSequentialGroup().addGap(203)
										.addComponent(btnNewButton_2)
										.addContainerGap(219, Short.MAX_VALUE))
						.addGroup(
								gl_panel_4
										.createSequentialGroup()
										.addGap(20)
										.addComponent(textField_2,
												GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(label_8)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(textField_13,
												GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_4
																		.createSequentialGroup()
																		.addComponent(
																				textField_16,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
														.addGroup(
																gl_panel_4
																		.createSequentialGroup()
																		.addComponent(
																				label_10,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				93,
																				Short.MAX_VALUE)
																		.addComponent(
																				textField_14,
																				GroupLayout.PREFERRED_SIZE,
																				59,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(3)
																		.addComponent(
																				label_9,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				textField_15,
																				GroupLayout.PREFERRED_SIZE,
																				59,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				label_11,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(24)))));
		gl_panel_4
				.setVerticalGroup(gl_panel_4
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_panel_4
										.createSequentialGroup()
										.addGap(42)
										.addGroup(
												gl_panel_4
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_13,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_8)
														.addComponent(
																textField_15,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_10)
														.addComponent(label_11)
														.addComponent(
																textField_14,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_9))
										.addGap(54)
										.addComponent(btnNewButton_2)
										.addGap(45)
										.addComponent(textField_16,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(46, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("开户情况报表", null, panel_5, null);

		JButton button_1 = new JButton("统计");
		button_1.setAction(action_6);

		textField_17 = new JTextField();
		textField_17.setText("2010");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setColumns(10);

		JLabel label_12 = new JLabel("年");

		textField_18 = new JTextField();
		textField_18.setText("01");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);

		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);

		JLabel label_13 = new JLabel("月");

		textField_20 = new JTextField();
		textField_20.setText("2012");
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setColumns(10);

		JLabel label_14 = new JLabel("年");

		textField_21 = new JTextField();
		textField_21.setText("12");
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setColumns(10);

		JLabel label_15 = new JLabel("月");
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5
				.setHorizontalGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_5
										.createSequentialGroup()
										.addGap(20)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addComponent(
																				textField_17,
																				GroupLayout.PREFERRED_SIZE,
																				59,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(6)
																		.addComponent(
																				label_12,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				textField_18,
																				GroupLayout.PREFERRED_SIZE,
																				59,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				label_13,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(87)
																		.addComponent(
																				textField_20,
																				GroupLayout.PREFERRED_SIZE,
																				59,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(3)
																		.addComponent(
																				label_14,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				textField_21,
																				GroupLayout.PREFERRED_SIZE,
																				59,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				label_15,
																				GroupLayout.PREFERRED_SIZE,
																				13,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(183)
																		.addComponent(
																				button_1,
																				GroupLayout.PREFERRED_SIZE,
																				60,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(161)
																		.addComponent(
																				textField_19,
																				GroupLayout.PREFERRED_SIZE,
																				114,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(24, Short.MAX_VALUE)));
		gl_panel_5
				.setVerticalGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_5
										.createSequentialGroup()
										.addGap(41)
										.addGap(21)
										.addGroup(
												gl_panel_5
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textField_17,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_12))
														.addComponent(
																textField_18,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_13))
														.addComponent(
																textField_20,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_14))
														.addComponent(
																textField_21,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_5
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_15)))
										.addGap(54)
										.addComponent(button_1)
										.addGap(45)
										.addComponent(textField_19,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(47, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);

		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("用户操作日志", null, panel_6, null);

		textField_22 = new JTextField();
		textField_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_22.setText("");
				textArea.setText("");
			}
		});
		textField_22.setColumns(10);

		JLabel label_16 = new JLabel("用户编号");

		JLabel label_17 = new JLabel("日期");

		textField_23 = new JTextField();
		textField_23.setColumns(10);

		JLabel label_18 = new JLabel("年");

		textField_24 = new JTextField();
		textField_24.setColumns(10);

		JLabel label_19 = new JLabel("月");

		textField_25 = new JTextField();
		textField_25.setColumns(10);

		JLabel label_20 = new JLabel("日");

		JButton button_2 = new JButton("查     询");
		button_2.setAction(action_7);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(gl_panel_6
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel_6
								.createSequentialGroup()
								.addGap(97)
								.addComponent(label_16)
								.addGap(12)
								.addComponent(textField_22,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_panel_6
								.createSequentialGroup()
								.addGap(123)
								.addComponent(label_17)
								.addGap(12)
								.addComponent(textField_23,
										GroupLayout.PREFERRED_SIZE, 56,
										GroupLayout.PREFERRED_SIZE)
								.addGap(1)
								.addComponent(label_18)
								.addGap(18)
								.addComponent(textField_24,
										GroupLayout.PREFERRED_SIZE, 26,
										GroupLayout.PREFERRED_SIZE)
								.addGap(3)
								.addComponent(label_19)
								.addGap(12)
								.addComponent(textField_25,
										GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE).addGap(12)
								.addComponent(label_20))
				.addGroup(
						gl_panel_6
								.createSequentialGroup()
								.addGap(173)
								.addComponent(button_2,
										GroupLayout.PREFERRED_SIZE, 102,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_panel_6
								.createSequentialGroup()
								.addGap(12)
								.addComponent(scrollPane,
										GroupLayout.PREFERRED_SIZE, 444,
										GroupLayout.PREFERRED_SIZE)));
		gl_panel_6
				.setVerticalGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_6
										.createSequentialGroup()
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
																				label_16))
														.addComponent(
																textField_22,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(6)
										.addGroup(
												gl_panel_6
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_17))
														.addComponent(
																textField_23,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_18))
														.addComponent(
																textField_24,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_19))
														.addComponent(
																textField_25,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_panel_6
																		.createSequentialGroup()
																		.addGap(2)
																		.addComponent(
																				label_20)))
										.addGap(6)
										.addComponent(button_2)
										.addGap(6)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												135, GroupLayout.PREFERRED_SIZE)));

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		panel_6.setLayout(gl_panel_6);
		panel.setLayout(gl_panel);
		frmXxx.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frmXxx.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("离开");
		menuBar.add(mnNewMenu);

		JMenuItem menuItem = new JMenuItem("注销");
		menuItem.setAction(action_4);
		mnNewMenu.add(menuItem);

		JMenuItem mntmNewMenuItem = new JMenuItem("退出");
		mntmNewMenuItem.setAction(action_5);
		mnNewMenu.add(mntmNewMenuItem);
	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "添加");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			// TODO 完成调用函数
			String UserID = textField.getText();
			String UserName = textField_1.getText();

			String EmailAddress = textField_3.getText();
			@SuppressWarnings("unused")
			String statusString = textField_4.getText();
			String BankID = textField_5.getText();

			User user = new User();
			user.setUserID(UserID);
			user.setPassword(passwordField.getText());
			user.setUserName(UserName);
			if (comboBox.getSelectedIndex() == 0) {
				user.setUserType(USERTYPE.Common);
			} else if (comboBox.getSelectedIndex() == 1) {
				user.setUserType(USERTYPE.Admin);
			}

			user.setEmailAddress(EmailAddress);
			user.setStatus(USERSTATE.Offline);
			user.setBankID(BankID);
			User tmpUser = Client.CreateUser(user);

			String msg[] = new String[2];
			if (tmpUser == null) {
				msg[0] = "添加用户错误";
				msg[1] = "错误！请检查用户信息！";
			} else {
				msg[0] = "成功！";
				msg[1] = "成功添加新用户！";
			}
			InformBox.main(msg);

		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "删除");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			// TODO 完成调用函数
			String UserID = textField_12.getText();
			String[] msg = new String[2];
			if (Client.DeleteUser(UserID)) {
				msg[0] = "通知";
				msg[1] = "删除成功！";
			} else {
				msg[0] = "错误！";
				msg[1] = "删除失败！";
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

		public void actionPerformed(ActionEvent e) {

			String userID = textField_10.getText();
			System.out.println("the is " + userID);

			User user = Client.GetUser(userID);
			String msg[] = new String[2];
			if (user == null) {
				msg[0] = "错误！";
				msg[1] = "用户不存在！";
				InformBox.main(msg);
			}
			System.out.println("successgul!");
			System.out.println(user.getUserName());
			textField_9.setText(user.getUserName());
			textField_8.setText(user.getUserType().toString());
			textField_11.setText(user.getEmailAddress());
			textField_7.setText(user.getStatus().toString());
			textField_6.setText(user.getBankID());

			frmXxx.repaint();
		}
	}

	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_3() {
			putValue(NAME, "统计");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String startYear = textField_2.getText();
			String startMonth = textField_13.getText();
			String endYear = textField_14.getText();
			String endMonth = textField_15.getText();
			Date Start = null;
			Date End = null;
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Start = format1.parse(startYear + "-" + startMonth + "-01");
				End = format1.parse(endYear + "-" + endMonth + "-01");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "日期格式错误！";
				InformBox.main(msg);
				return;
			}

			String result = Client.CreditCardStatistic(Start, End);
			if (result == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "统计失败！";
				InformBox.main(msg);
			} else {
				textField_16.setText(result);
			}
		}
	}

	private class SwingAction_4 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_4() {
			putValue(NAME, "注销");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			if (Client.UserLogout(user)) {
				Login.main(null);
				frmXxx.dispose();
			} else {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "注销失败！请重新尝试";
				InformBox.main(msg);
			}
		}
	}

	private class SwingAction_5 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_5() {
			putValue(NAME, "退出");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			if (Client.UserLogout(user)) {
				Login.main(null);
				System.exit(0);
			} else {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "注销失败！请重新尝试";
				InformBox.main(msg);
			}
		}
	}

	@SuppressWarnings("serial")
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "统计");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String startYear = textField_17.getText();
			String startMonth = textField_18.getText();
			String endYear = textField_20.getText();
			String endMonth = textField_21.getText();
			Date Start = null;
			Date End = null;
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Start = format1.parse(startYear + "-" + startMonth + "-01");
				End = format1.parse(endYear + "-" + endMonth + "-01");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "日期格式错误！";
				InformBox.main(msg);
				return;
			}

			String result = Client.CreateAccountStatistic(Start, End);
			if (result == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "统计失败！";
				InformBox.main(msg);
			} else {
				textField_19.setText(result);
			}
		}
	}

	private class SwingAction_7 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_7() {
			putValue(NAME, "查     询");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String userID = textField_22.getText();
			System.out.println("the is " + userID);

			User user = Client.GetUser(userID);

			if (user == null) {
				String msg[] = new String[2];
				msg[0] = "错误！";
				msg[1] = "用户不存在！";
				InformBox.main(msg);
			}
			Date day = null;
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				day = format1
						.parse(textField_23.getText() + "-"
								+ textField_24.getText() + "-"
								+ textField_25.getText());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "日期格式错误！";
				InformBox.main(msg);
				return;
			}
			String[] ret = Client.UserOperationCheck(user, day);
			if (ret == null) {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "查询失败！";
				InformBox.main(msg);
			} else {
				String toPrint = String.format("%-13s  %-20s  %-4s", "日期",
						"操作", "成功与否");
				textArea.append(toPrint + "\n\n");
				for (String string : ret) {
					if (string == null) {
						break;
					}
					String[] tmp = string.split(" ");
					if (tmp[2].equals("true")) {
						tmp[2] = "成功";
					} else {
						tmp[2] = "失败";
					}
					toPrint = String.format("%-13s  %-20s  %-4s", tmp[0],
							tmp[1], tmp[2]);
					textArea.append(toPrint + "\n");

				}

			}
		}
	}
}
