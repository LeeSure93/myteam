package com.ccms.UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.ccms.client.*;
import com.ccms.util.User;
import com.ccms.util.User.USERTYPE;

@SuppressWarnings("serial")
public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {

			Login dialog = new Login();
			dialog.setLocationRelativeTo(null);
			dialog.setResizable(false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			// MainWindow.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		setTitle("HIT银行办公系统");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblXxx = new JLabel("HIT银行办公系统");
		lblXxx.setFont(new Font("黑体", Font.BOLD, 20));
		lblXxx.setBounds(147, 12, 159, 24);
		contentPanel.add(lblXxx);

		textField = new JTextField();
		textField.setBounds(192, 89, 114, 19);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("用户名");
		label.setBounds(147, 91, 39, 15);
		contentPanel.add(label);

		passwordField = new JPasswordField();
		passwordField.setBounds(192, 120, 114, 19);
		contentPanel.add(passwordField);

		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(157, 122, 26, 15);
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton OKButton = new JButton("OK");
				OKButton.setAction(action);
				OKButton.setActionCommand("OK");
				buttonPane.add(OKButton);
				getRootPane().setDefaultButton(OKButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setAction(action_1);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "登录");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

			System.out.println("here i am~~~");
			String userID = textField.getText();
			@SuppressWarnings("deprecation")
			String password = passwordField.getText();
			System.out.println(userID);
			System.out.println(password);
			User user = new User();
			user.setUserID(userID);
			user.setPassword(password);
			User ret = Client.UserLogin(user);
			// user = new User();
			// user.setUserType(USERTYPE.Common);
			if (ret == null) {
				String msg[] = new String[2];
				msg[0] = "登录错误！";
				msg[1] = "错误的用户名或密码！";
				InformBox.main(msg);

			} else if (ret.getUserType() == USERTYPE.Common) {
				Client.setOperator(ret);
				CCManage.terminate = false;
				AccountManage.terminate = false;
				MainWindow.main(ret);
				dispose();
			} else if (ret.getUserType() == USERTYPE.Admin) {
				Client.setOperator(ret);
				AdminWIndow.main(ret);
				dispose();
			}

		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "退出");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}
