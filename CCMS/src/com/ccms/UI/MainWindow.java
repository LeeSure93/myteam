package com.ccms.UI;

import java.awt.EventQueue;
import javax.swing.*;

import com.ccms.client.*;
import com.ccms.util.User;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Date;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindow {

	private JFrame frame;
	private final Action action = new SwingAction();
	private static User user;
	private JTextField textField;
	private JTextField textField_1;
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();

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
					MainWindow window = new MainWindow(args);
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.frame.setVisible(true);

					window.frame.setResizable(false);
					window.frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public MainWindow(User user) {
		initialize();
		startTime();
		setUserID(user);
		setUserID(user);
	}

	class SystemTime implements Runnable {
		private Date currentDate;

		@SuppressWarnings("deprecation")
		public void run() {
			while (true) {
				currentDate = new Date();
				// textField.setText(currentDate.toLocaleString().substring(5,
				// currentDate.toLocaleString().length()));
				textField.setText(currentDate.toLocaleString());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void startTime() {
		Runnable r = new SystemTime();
		Thread t = new Thread(r);
		t.start();
	}

	private void setUserID(User user) {
		textField_1.setText(user.getUserID());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);

		frame.setTitle("银行办公系统");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("离开");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("注销");
		mntmNewMenuItem_1.setAction(action_3);
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setAction(action);
		mnNewMenu.add(mntmNewMenuItem);

		JMenu menu = new JMenu("关于");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("关于");
		menuItem.setAction(action_4);
		menu.add(menuItem);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblXxx = new JLabel("HIT银行办公系统");
		lblXxx.setFont(new Font("黑体", Font.BOLD, 20));
		panel.add(lblXxx);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("工号");
		panel_1.add(lblNewLabel);

		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel("Current Time");

		textField = new JTextField();
		textField.setText("0000-00-00 00-00-00");
		textField.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addGap(105)
						.addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE,
								139, GroupLayout.PREFERRED_SIZE).addGap(93)));
		gl_panel_2
				.setVerticalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addGap(5)
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_1))));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("账户管理");
		btnNewButton.setAction(action_1);

		JButton btnNewButton_1 = new JButton("信用卡管理");
		btnNewButton_1.setAction(action_2);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_3
						.createSequentialGroup()
						.addGap(81)
						.addComponent(btnNewButton)
						.addPreferredGap(ComponentPlacement.RELATED, 100,
								Short.MAX_VALUE).addComponent(btnNewButton_1)
						.addGap(80)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(
				Alignment.LEADING)
				.addGroup(
						gl_panel_3
								.createSequentialGroup()
								.addGap(71)
								.addGroup(
										gl_panel_3
												.createParallelGroup(
														Alignment.BASELINE)
												.addComponent(btnNewButton)
												.addComponent(btnNewButton_1))
								.addContainerGap(88, Short.MAX_VALUE)));
		panel_3.setLayout(gl_panel_3);

	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "退出");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			// System.out.println("the system is going to exit now ...");
			if (Client.UserLogout(user)) {
				Login.main(null);
				CCManage.terminate = true;
				AccountManage.terminate = true;
				System.exit(0);
			} else {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "注销失败！请重新尝试";
				InformBox.main(msg);
			}

		}
	}

	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_1() {
			putValue(NAME, "账户管理");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			Runnable r = new AM();
			Thread t = new Thread(r);
			t.start();
		}
	}

	private class AM implements Runnable {

		public void run() {
			AccountManage.main(getUser());
		}
	}

	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_2() {
			putValue(NAME, "信用卡管理");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			Runnable r = new CC();
			Thread t = new Thread(r);
			t.start();
		}
	}

	private class CC implements Runnable {

		public void run() {
			CCManage.main(getUser());
		}
	}

	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_3() {
			putValue(NAME, "注销");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			if (Client.UserLogout(user)) {
				Login.main(null);
				CCManage.terminate = true;
				AccountManage.terminate = true;
				frame.dispose();
			} else {
				String[] msg = new String[2];
				msg[0] = "错误！";
				msg[1] = "注销失败！请重新尝试";
				InformBox.main(msg);
			}
		}
	}

	private class SwingAction_4 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_4() {
			putValue(NAME, "关于");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			String[] msg = new String[2];
			msg[0] = "关  于";
			msg[1] = "欢迎使用HIT银行办公系统 v1.0";
			InformBox.main(msg);
		}
	}
}
