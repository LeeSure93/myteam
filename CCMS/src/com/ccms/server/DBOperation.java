/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccms.server;

import com.ccms.util.*;
import com.ccms.util.CreditCard.CREDITCARDSTATE;
import com.ccms.util.User.USERSTATE;
import com.ccms.util.User.USERTYPE;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 1.ID的生成在数据库Insert中实现
 * 
 * @author hit-acm
 */
public class DBOperation {

	private static java.util.Properties prop = new java.util.Properties();
	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static String url;
	private static String username;
	private static String password;
	private static ResultSet mResultSet = null;
	private static Connection mConnection = null;
	private static Statement statement = null;
	private static String sql = null;
	private static String d = ",";
	private static Scanner cin;

	/**
	 * 对于没有加“”的字符串进行处理
	 * 
	 * @param s
	 * @return
	 */

	private static boolean init() {
		File file = new File("ServerConf.ini");
		try {
			cin = new Scanner(file);
			String[] temp = new String[10];
			while (cin.hasNext()) {
				String tmp = cin.nextLine();

				temp = tmp.split(" = ");
				url = "jdbc:mysql://" + temp[1] + "/";
				tmp = cin.nextLine();

				temp = tmp.split(" = ");
				url += temp[1] + "?useUnicode=true&characterEncoding=utf-8";
				username = cin.nextLine();
				temp = username.split(" = ");
				username = temp[1];

				password = cin.nextLine();
				temp = password.split(" = ");
				password = temp[1];
			}
			System.out.println(url + "\n" + username + "\n" + password);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public static String Actoma(String s) {
		if (s != null) {
			s = "\"" + s + "\"";
		}
		return s;
	}

	public static String Actoma(Date s) {
		String res = new String();
		if (s == null) {
			return null;
		}
		res = "\"" + s + "\"";
		System.out.println(res);
		return res;
	}

	/**
	 * 数据库连接建立
	 * 
	 * @return
	 */
	public static boolean Connnect() {
		if (!init()) {
			System.out.println("配置文件初始化失败！");
			return false;
		}
		prop.put("charSet", "utf8");
		prop.put("user", username);
		prop.put("password ", password);
		try {
			Class.forName(dbDriver);
			mConnection = DriverManager.getConnection(url, username, password);
			if (!mConnection.isClosed()) {
				System.out.println("Connected successfully\n");
			}
			statement = mConnection.createStatement();
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			System.out.println("something wrong with the SQL !!!");
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void CloseDB() throws SQLException {
		mConnection.close();
	}

	/**
	 * 
	 * @param user
	 */
	public static boolean Insert(User user) {
		try {
			sql = "insert into User values(" + Actoma(user.getUserID()) + d
					+ Actoma(user.getUserName()) + d
					+ Actoma(user.getUserType().toString()) + d
					+ Actoma(user.getEmailAddress()) + d
					+ Actoma(user.getStatus().toString()) + d
					+ Actoma(user.getBankID()) + d + Actoma(user.getPassword())
					+ ");";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 如果的类中ID返回值为null，说明不存
	 * 
	 * @param ID
	 * @return
	 */
	public static User DBUser(String ID) {
		try {
			User user = new User();
			sql = "select * from User where User.UserID=" + Actoma(ID) + ";";
			System.out.println(sql);
			int judge = 0;
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					user.setBankID(mResultSet.getString("BankID"));
					user.setEmailAddress(mResultSet.getString("EmailAddress"));
					String stateString = mResultSet.getString("Status");
					USERSTATE state = USERSTATE.Online;
					if (stateString.equals("Online") == false) {
						state = USERSTATE.Offline;
					}
					user.setStatus(state);
					user.setUserID(mResultSet.getString("UserID"));
					user.setUserName(mResultSet.getString("UserName"));
					String typeString = mResultSet.getString("UserType");
					USERTYPE type = USERTYPE.Common;
					if (typeString.equals("Common")) {
						type = USERTYPE.Common;
					} else if (typeString.equals("Admin")) {
						type = USERTYPE.Admin;
					}
					user.setUserType(type);
					judge++;
				}
			} else {
				System.out.println("数据库未连接！");
			}
			if (judge == 1) {
				return user;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * 
	 * @param costumer
	 */
	public static boolean Insert(Costumer costumer) {
		try {
			java.sql.Date a = new java.sql.Date(costumer.getBirthday()
					.getTime());
			sql = "insert into Costumer values("
					+ Actoma(costumer.getCostumerID()) + d
					+ Actoma(costumer.getID()) + d
					+ Actoma(costumer.getFirstName()) + d
					+ Actoma(costumer.getSecondName()) + d
					+ Actoma(costumer.getGender()) + d + Actoma(a) + d
					+ Actoma(costumer.getPhoneNumber()) + d
					+ Actoma(costumer.getAddress()) + d
					+ Actoma(costumer.getEmailAddress()) + ");";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 如果的类中ID返回值为null，说明不存
	 * 
	 * @param ID
	 * @return
	 */
	public static Costumer DBCostumer(String ID) {
		try {
			Costumer costumer = new Costumer();
			sql = "select * from Costumer where Costumer.CostumerID="
					+ Actoma(ID) + ";";
			System.out.println(sql);
			int judge = 0;
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					costumer.setAddress(mResultSet.getString("Address"));
					costumer.setBirthday(mResultSet.getDate("Birthday"));
					costumer.setCostumerID(mResultSet.getString("CostumerID"));
					costumer.setEmailAddress(mResultSet
							.getString("EmailAddress"));
					costumer.setFirstName(mResultSet.getString("FirstName"));
					costumer.setGender(mResultSet.getString("Gender"));
					costumer.setID(mResultSet.getString("ID"));
					costumer.setPhoneNumber(mResultSet.getString("PhoneNumber"));
					costumer.setSecondName(mResultSet.getString("SecondName"));
					judge++;
				}
			} else {
				System.out.println("数据库未连接！");
			}
			if (judge == 1) {
				return costumer;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * 
	 * @param bank
	 */
	public static boolean Insert(Bank bank) {
		try {
			sql = "insert into Bank values(" + Actoma(bank.getBankID()) + d
					+ Actoma(bank.getBankName()) + d
					+ Actoma(bank.getBankAddress()) + d
					+ Actoma(bank.getTelephoneNumber()) + ");";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 如果的类中ID返回值为null，说明不存
	 * 
	 * @param ID
	 * @return
	 * @throws SQLException
	 */
	public static Bank DBBank(String ID) {
		try {
			Bank bank = new Bank();
			sql = "select * from Bank where Bank.BankID=" + Actoma(ID) + ";";
			System.out.println(sql);
			int judge = 0;
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					bank.setBankAddress(mResultSet.getString("BankAddress"));
					bank.setBankID(mResultSet.getString("BankID"));
					bank.setBankName(mResultSet.getString("BankName"));
					bank.setTelephoneNumber(mResultSet
							.getString("TelephoneNumber"));
					judge++;
				}
			} else {
				System.out.println("数据库未连接！");
			}
			if (judge == 1) {
				return bank;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * // * // * @param operationList //
	 */
	// public static boolean Insert(Log operationList) {
	// try {
	// sql = "insert into Bank values("
	// + Actoma(operationList.getUserID()) + d
	// + Actoma(operationList.getCostumerID()) + d
	// + Actoma(operationList.getOperationTime()) + d
	// + Actoma(operationList.getContent()) + ");";
	// System.out.println(sql);
	// if (!mConnection.isClosed()) {
	// statement.execute(sql);
	// return true;
	// } else {
	// System.out.println("数据库未连接！");
	// }
	// } catch (SQLException ex) {
	// Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
	// null, ex);
	// }
	// return false;
	// }

	// /**
	// * 如果的类中ID返回值为null，说明不存
	// *
	// * @param CostumerID
	// * ,UserID
	// * @return
	// */
	// public static OperationList DBOperationList(String CostumerID, String
	// UserID) {
	// try {
	// OperationList operationList = new OperationList();
	// sql = "select * from OperationList where OperationList.CostumerID="
	// + Actoma(CostumerID) + " AND OperationList.UserID="
	// + Actoma(UserID) + ";";
	// if (!mConnection.isClosed()) {
	// mResultSet = statement.executeQuery(sql);
	// while (mResultSet.next()) {
	// operationList.setContent(mResultSet.getString("Content"));
	// operationList.setCostumerID(mResultSet
	// .getString("CostumerID"));
	// operationList.setOperationTime(mResultSet
	// .getDate("OperationTime"));
	// operationList.setUserID(mResultSet.getString("UserID"));
	// }
	// } else {
	// System.out.println("数据库未连接！");
	// }
	// return operationList;
	// } catch (SQLException ex) {
	// Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
	// null, ex);
	// }
	// return null;
	// }

	/**
	 * 
	 * @param creditCard
	 */
	public static boolean Insert(CreditCard creditCard) {
		try {
			java.sql.Date a = new java.sql.Date(creditCard
					.getCreateCreditCardTime().getTime());
			java.sql.Date b = new java.sql.Date(creditCard.getDeadline()
					.getTime());
			sql = "insert into CreditCard values("
					+ Actoma(creditCard.getCreditCardID()) + d
					+ Actoma(creditCard.getBankName()) + d + Actoma(a) + d
					+ Actoma(creditCard.getPassword()) + d + Actoma(b) + d
					+ Actoma(creditCard.getStatus().toString()) + d
					+ Actoma(creditCard.getAccountID()) + ");";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 
	 * @param account
	 */
	public static boolean Insert(Account account) {
		try {
			java.sql.Date a = new java.sql.Date(account.getCreateAccountTime()
					.getTime());
			sql = "insert into Account values("
					+ Actoma(account.getAccountID()) + d + Actoma(a) + d
					+ Actoma(account.getBankName()) + d
					+ Actoma(account.getCostumerID()) + d + Actoma("0") + d
					+ Actoma(account.getCreditLine()) + ");";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 如果的类中ID返回值为null，说明不存
	 * 
	 * @param ID
	 * @return
	 */
	public static Account DBAccount(String ID) {
		try {
			Account account = new Account();
			sql = "select * from Account where Account.AccountID=" + Actoma(ID)
					+ ";";
			System.out.println(sql);
			int judge = 0;
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					account.setAccountID(mResultSet.getString("AccountID"));
					account.setBankName(mResultSet.getString("BankName"));
					account.setCostumerID(mResultSet.getString("CostumerID"));
					account.setCreateAccountTime(mResultSet
							.getDate("CreateAccountTime"));
					account.setMoney(mResultSet.getString("Money"));
					judge++;
				}
			} else {
				System.out.println("数据库未连接！");
			}
			if (judge == 1) {
				return account;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	public static boolean Insert(Loss loss) {
		try {
			java.sql.Date a = new java.sql.Date(loss.getLossDate().getTime());
			sql = "insert into Loss values(" + Actoma(loss.getLossID()) + d
					+ Actoma(loss.getLossCostumer()) + d
					+ Actoma(loss.getCreditCardID()) + d + Actoma(a) + ");";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	// /**
	// *
	// * @param transationRecord
	// * @throws SQLException
	// */
	// public static boolean Insert(TransationRecord transationRecord) {
	// try {
	// sql = "insert into Bank values("
	// + Actoma(transationRecord.getTransationID()) + d
	// + Actoma(transationRecord.getTransationTime()) + d
	// + Actoma(transationRecord.getCreditCardID()) + d
	// + Actoma(transationRecord.getAccountTime()) + d
	// + Actoma(transationRecord.getTransationAmount()) + d
	// + Actoma(transationRecord.getTransationAddress()) + d
	// + Actoma(transationRecord.getTransationType()) + ");";
	// System.out.println(sql);
	// if (!mConnection.isClosed()) {
	// statement.execute(sql);
	// return true;
	// } else {
	// System.out.println("数据库未连接！");
	// }
	// } catch (SQLException ex) {
	// Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
	// null, ex);
	// }
	// return false;
	// }

	/**
	 * 
	 * @param log
	 * @return
	 */
	public static boolean Insert(Log log) {
		try {
			java.sql.Date a = new java.sql.Date(log.getOperationTime()
					.getTime());
			sql = "insert into Log values(" + Actoma(log.getUserID()) + d
					+ Actoma(a) + d + Actoma(log.getType()) + d
					+ Actoma(log.getIsSuccefull()) + d + Actoma(log.getXID())
					+ d + Actoma(log.getContent()) + ");";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * // * 如果的类中ID返回值为null，说明不存 // * // * @param CreditCardID // * @return // * @throws
	 * SQLException //
	 */
	// public static TransationRecord DBTransationRecord(String CreditCardID) {
	// try {
	// TransationRecord transationRecord = new TransationRecord();
	// sql =
	// "select * from TransationRecord where TransationRecord.CreditCardID="
	// + Actoma(CreditCardID) + ";";
	// if (!mConnection.isClosed()) {
	// mResultSet = statement.executeQuery(sql);
	// while (mResultSet.next()) {
	// transationRecord.setAccountTime(mResultSet
	// .getDate("AccountTime"));
	// transationRecord.setCreditCardID(mResultSet
	// .getString("CreditCardID"));
	// transationRecord.setTransationAddress(mResultSet
	// .getString("TransationAddress"));
	// transationRecord.setTransationAmount(mResultSet
	// .getString("TransationAmount"));
	// transationRecord.setTransationID(mResultSet
	// .getString("TransationID"));
	// transationRecord.setTransationTime(mResultSet
	// .getDate("TransationTime"));
	// transationRecord.setTransationType(mResultSet
	// .getString("TransationType"));
	// }
	// } else {
	// System.out.println("数据库未连接！");
	// }
	// return transationRecord;
	// } catch (SQLException ex) {
	// Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
	// null, ex);
	// }
	// return null;
	// }

	/**
	 * 
	 * @param costumer
	 * @param money
	 * @throws SQLException
	 */
	public static boolean PlusMoney(Account account, String money) {
		try {
			long Money = Long.parseLong(money);
			sql = "select * from Account where Account.AccountID="
					+ Actoma(account.getAccountID()) + ";";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				int i = 0;
				String[] TotalMoney = new String[10];
				while (mResultSet.next()) {
					TotalMoney[i++] = mResultSet.getString("Money");
				}
				if (i == 0) {
					System.out.println("对不起该用户不存在！");
				} else if (i == 1) {
					Money = Money + Long.parseLong(TotalMoney[0]);
					sql = "update Account set Money=" + Money
							+ " where AccountID=" + account.getAccountID()
							+ ";";
					System.out.println(sql);
					statement.execute(sql);
					System.out.println("存款成功！");
					return true;
				} else {
					System.out.println("数据库存在错误，有多个有相同帐号的用户存在！");
				}
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 
	 * @param costumer
	 * @param money
	 * @throws SQLException
	 */
	public static boolean MinusMoney(Account account, String money) {
		if (money == "" || money == null) {
			money = "0";
		}
		try {
			long Money = Long.parseLong(money);
			sql = "select * from Account where Account.AccountID="
					+ Actoma(account.getAccountID()) + ";";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				int i = 0;
				String[] TotalMoney = new String[10];
				while (mResultSet.next()) {
					TotalMoney[i++] = mResultSet.getString("Money");
				}
				if (i == 0) {
					System.out.println("对不起该用户不存在！");
				} else if (i == 1) {
					Money = -Money + Long.parseLong(TotalMoney[0]);
					if (Money >= 0) {
						sql = "update Account set Money=" + Money
								+ " where AccountID=" + account.getAccountID()
								+ ";";
						System.out.println(sql);
						statement.execute(sql);
						System.out.println("取款成功！");
						return true;
					} else {
						System.out.println("对不起，余额不足！");
					}
				} else {
					System.out.println("数据库存在错误，有多个有相同帐号的用户存在！");
				}
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 注销信用卡
	 * 
	 * @param CreditCardID
	 * @throws SQLException
	 */
	public static boolean Pincard(String CreditCardID) {
		try {
			sql = "delete from CreditCard where CreditCard.CreditCardID="
					+ Actoma(CreditCardID) + ";";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				System.out.println("注销信用卡成功！");
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 注销账户
	 * 
	 * @param AccountID
	 * @throws SQLException
	 */
	public static boolean Pinaccount(String AccountID) {
		try {
			if (!mConnection.isClosed()) {
				sql = "delete from Account where Account.AccountID="
						+ Actoma(AccountID) + ";";
				System.out.println(sql);
				sql = "delete from CreditCard where CreditCard.AccountID="
						+ Actoma(AccountID) + ";";
				System.out.println(sql);
				statement.execute(sql);
				System.out.println("注销账户成功！");
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 注销user用户
	 * 
	 * @param UserID
	 * @throws SQLException
	 */
	public static boolean Pinuser(String UserID) {
		try {
			sql = "delete from User where User.UserID=" + Actoma(UserID) + ";";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				System.out.println("用户注销成功！");
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String GenerateCreditCardID() {
		String one = NumString.ZERO();
		while (one.compareTo(NumString.MAXN()) < 0) {
			try {
				sql = "select count(*) from CreditCard where CreditCardID="
						+ Actoma(one) + ";";
				if (!mConnection.isClosed()) {
					mResultSet = statement.executeQuery(sql);
					if (mResultSet.next()) {
						int res = mResultSet.getInt(1);
						if (res == 0) {
							return one;
						}
					}
				} else {
					System.out.println("数据库未连接！");
				}
				one = NumString.Inc(one);
			} catch (SQLException ex) {
				Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return null;
	}

	/**
	 * 生成CostumerID
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String GenerateCostumerID() {
		String one = NumString.ZERO();
		while (one.compareTo(NumString.MAXN()) < 0) {
			try {
				sql = "select count(*) from Costumer where CostumerID="
						+ Actoma(one) + ";";
				if (!mConnection.isClosed()) {
					mResultSet = statement.executeQuery(sql);
					if (mResultSet.next()) {
						int res = mResultSet.getInt(1);
						if (res == 0) {
							return one;
						}
					}
				} else {
					System.out.println("数据库未连接！");
				}
				one = NumString.Inc(one);
			} catch (SQLException ex) {
				Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return null;
	}

	/**
	 * 生成新的UserID
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static String GenerateUserID() {
		String one = NumString.ZERO();
		while (one.compareTo(NumString.MAXN()) < 0) {
			try {
				sql = "select count(*) from User where UserID=" + Actoma(one)
						+ ";";
				if (!mConnection.isClosed()) {
					mResultSet = statement.executeQuery(sql);
					if (mResultSet.next()) {
						int res = mResultSet.getInt(1);
						if (res == 0) {
							return one;
						}
					}
				} else {
					System.out.println("数据库未连接！");
				}
				one = NumString.Inc(one);
			} catch (SQLException ex) {
				Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public static String GenerateAccountID() {
		String one = NumString.ZERO();
		while (one.compareTo(NumString.MAXN()) < 0) {
			try {
				sql = "select count(*) from Account where AccountID="
						+ Actoma(one) + ";";
				if (!mConnection.isClosed()) {
					mResultSet = statement.executeQuery(sql);
					if (mResultSet.next()) {
						int res = mResultSet.getInt(1);
						if (res == 0) {
							return one;
						}
					}
				} else {
					System.out.println("数据库未连接！");
				}
				one = NumString.Inc(one);
			} catch (SQLException ex) {
				Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public static String GenerateLossID() {
		String one = NumString.ZERO();
		while (one.compareTo(NumString.MAXN()) < 0) {
			try {
				sql = "select count(*) from Loss where LossID=" + Actoma(one)
						+ ";";
				if (!mConnection.isClosed()) {
					mResultSet = statement.executeQuery(sql);
					if (mResultSet.next()) {
						int res = mResultSet.getInt(1);
						if (res == 0) {
							return one;
						}
					}
				} else {
					System.out.println("数据库未连接！");
				}
				one = NumString.Inc(one);
			} catch (SQLException ex) {
				Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return null;
	}

	/**
	 * 
	 * @param CostumerID
	 * @return
	 */
	public static boolean DeleteCostumer(String CostumerID) {
		try {
			if (!mConnection.isClosed()) {
				sql = "delete from Costumer where Costumer.CostumerID="
						+ Actoma(CostumerID) + ";";
				System.out.println(sql);
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 
	 * @param NewCostumer
	 * @return
	 */
	public static boolean EditCostumer(Costumer NewCostumer) {
		return DeleteCostumer(NewCostumer.getCostumerID())
				&& Insert(NewCostumer);
	}

	/**
	 * 
	 * @param AccountID
	 * @return
	 */
	public static boolean DeleteAccount(String AccountID) {
		try {
			sql = "delete from Account where Account.AccountID="
					+ Actoma(AccountID) + ";";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 
	 * @param NewAccount
	 * @return
	 */
	public static boolean EditAccount(Account NewAccount) {
		return DeleteCostumer(NewAccount.getAccountID()) && Insert(NewAccount);
	}

	/**
	 * 
	 * @param CreditCardID
	 * @return
	 */
	public static CreditCard DBCreditCard(String CreditCardID) {
		try {
			CreditCard creditcard = new CreditCard();
			sql = "select * from CreditCard where CreditCard.CreditCardID="
					+ Actoma(CreditCardID) + ";";
			System.out.println(sql);
			int judge = 0;
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					creditcard.setAccountID(mResultSet.getString("AccountID"));
					creditcard.setBankName(mResultSet.getString("BankName"));
					creditcard.setCreateCreditCardTime(mResultSet
							.getDate("CreateCreditCardTime"));
					creditcard.setCreditCardID(mResultSet
							.getString("CreditCardID"));
					creditcard.setDeadline(mResultSet.getDate("Deadline"));
					creditcard.setPassword(mResultSet.getString("Password"));
					CREDITCARDSTATE state = CREDITCARDSTATE.unActive;
					String temp = mResultSet.getString("Status");
					if (temp.equals("lost")) {
						state = CREDITCARDSTATE.lost;
					} else if (temp.equals("deleted")) {
						state = CREDITCARDSTATE.deleted;
					} else if (temp.equals("Active")) {
						state = CREDITCARDSTATE.Active;
					}
					creditcard.setStatus(state);
					judge++;
				}
			} else {
				System.out.println("数据库未连接！");
			}
			if (judge == 1) {
				return creditcard;
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * 
	 * @param CreditCardID
	 */
	public static boolean DeleteCreditCard(String CreditCardID) {
		try {
			if (!mConnection.isClosed()) {
				sql = "delete from CreditCard where CreditCard.CreditCardID="
						+ Actoma(CreditCardID) + ";";
				System.out.println(sql);
				statement.execute(sql);
				return true;
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 
	 * @param NewCreditCard
	 * @return
	 */
	public static boolean EditCreditCard(CreditCard NewCreditCard) {
		return DeleteCreditCard(NewCreditCard.getCreditCardID())
				&& Insert(NewCreditCard);
	}

	/**
	 * 
	 * @param UserID
	 * @param Password
	 * @return
	 */
	public static User UserLogin(String UserID, String Password) {
		try {
			User user = new User();
			sql = "select * from User where User.UserID=" + Actoma(UserID)
					+ " and " + "User.Password=" + Actoma(Password) + ";";
			System.out.println(sql);
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					user.setBankID(mResultSet.getString("BankID"));
					user.setEmailAddress(mResultSet.getString("EmailAddress"));
					String stateString = mResultSet.getString("Status");
					USERSTATE state = USERSTATE.Offline;
					if (stateString != null && stateString.equals("Online")) {
						state = USERSTATE.Online;
					}
					user.setStatus(state);
					user.setUserID(mResultSet.getString("UserID"));
					user.setUserName(mResultSet.getString("UserName"));
					String typeString = mResultSet.getString("UserType");
					USERTYPE type = USERTYPE.Common;
					if (typeString == null || typeString.equals("Common")) {
						type = USERTYPE.Common;
					} else if (typeString.equals("Admin")) {
						type = USERTYPE.Admin;
					}
					user.setUserType(type);
					user.setPassword(mResultSet.getString("Password"));

					/* 查看是否真的找出来了！ */
					if (user.getUserID().equals(UserID)
							&& user.getPassword().equals(Password)
							&& user.getStatus() != USERSTATE.Online) {
						user.setStatus(USERSTATE.Online);

						/* 更新用户状态 */
						sql = "update User set User.Status=" + Actoma("Online")
								+ " WHERE User.UserID="
								+ Actoma(user.getUserID()) + ";";
						statement.execute(sql);
						return user;
					} else {
						return null;
					}
				}
			} else {
				System.out.println("数据库未连接！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public static boolean UserLogout(User user) {
		user.setStatus(USERSTATE.Offline);
		sql = "update User set User.Status=" + Actoma("Offline")
				+ " where User.UserID=" + Actoma(user.getUserID()) + ";";
		try {
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static String CreditCardStatistic(Date start, Date end) {
		java.sql.Date date1 = new java.sql.Date(start.getTime());
		java.sql.Date date2 = new java.sql.Date(end.getTime());
		try {
			if (!mConnection.isClosed()) {
				sql = "select count(*) from CreditCard where "
						+ " CreateCreditCardTime>=" + Actoma(date1) + " and "
						+ " CreateCreditCardTime<= " + Actoma(date2) + ";";
				System.out.println(sql);
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					Long l = mResultSet.getLong(1);
					System.out.println(l);
					return l.toString();
				}
			} else {
				System.out.println("数据库链接有问题！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static String AccountStatistic(Date start, Date end) {
		java.sql.Date date1 = new java.sql.Date(start.getTime());
		java.sql.Date date2 = new java.sql.Date(end.getTime());
		try {
			if (!mConnection.isClosed()) {
				sql = "select count(*) from Account where "
						+ " CreateAccountTime>=" + Actoma(date1) + " and "
						+ " CreateAccountTime<= " + Actoma(date2) + ";";
				System.out.println(sql);
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					Long l = mResultSet.getLong(1);
					System.out.println(l);
					return l.toString();
				}
			} else {
				System.out.println("数据库链接有问题！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static String MoneyStatistic(Account account, Date start, Date end,
			String Type) {
		java.sql.Date date1 = new java.sql.Date(start.getTime());
		java.sql.Date date2 = new java.sql.Date(end.getTime());
		try {
			if (!mConnection.isClosed()) {
				sql = "select * from Log where " + " Type=" + Actoma(Type)
						+ " and " + " OperationTime>=" + Actoma(date1)
						+ " and " + " OperationTime<= " + Actoma(date2)
						+ " and " + " IsSuccesfull=" + Actoma("true") + " and "
						+ " XID=" + Actoma(account.getAccountID()) + ";";
				System.out.println(sql);
				mResultSet = statement.executeQuery(sql);
				long res = Long.valueOf(0);
				while (mResultSet.next()) {
					res = res + Long.valueOf(mResultSet.getString("Content"));
				}
				return res + "";
			} else {
				System.out.println("数据库链接有问题！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return null;
	}

	/**
	 * 
	 * @param BankID
	 * @return
	 */
	public static boolean IsBankExist(String BankID) {

		try {
			if (!mConnection.isClosed()) {
				sql = "select count(*) from Bank where " + " BankID="
						+ Actoma(BankID) + ";";
				System.out.println(sql);
				mResultSet = statement.executeQuery(sql);
				while (mResultSet.next()) {
					Long l = mResultSet.getLong(1);
					System.out.println(l);
					if (l > 0) {
						return true;
					}
				}
			} else {
				System.out.println("数据库链接有问题！");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return false;
	}

	/**
	 * 获取某一段时间段内的用户的操作信息
	 * 
	 * @return
	 */
	public static String[] DBLog(String UserID, Date now) {
		int MAXN = 10000;// 一次能够显示的上限
		String[] res = new String[MAXN];
		java.sql.Date date1 = new java.sql.Date(now.getTime());
		sql = "select * from Log where UserID=" + Actoma(UserID)
				+ " and OperationTime=" + Actoma(date1) + ";";
		System.out.println(sql);
		try {
			if (!mConnection.isClosed()) {
				mResultSet = statement.executeQuery(sql);
				int size = 0;
				while (mResultSet.next()) {
					Date date = mResultSet.getDate("OperationTime");
					String b = mResultSet.getString("Type");
					String c = mResultSet.getString("IsSuccesfull");
					res[size] = "" + date + " " + b + " " + c;
					System.out.println(res[size]);
					size++;
				}
				return res;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

/**
 * 
 * @author hit-acm SIZE为号码长度
 */
class NumString {
	private static int SIZE = 16;
	private static char c[] = new char[SIZE];

	private static void init() {
		for (int i = 0; i < SIZE; i++) {
			c[i] = '0';
		}
	}

	public static String ZERO() {
		init();
		return String.copyValueOf(c, 0, SIZE);
	}

	public static String MAXN() {
		return "9999999999999999";
	}

	public static String Inc(String s) {
		init();
		c = s.toCharArray();
		int pre = 1;
		for (int i = SIZE - 1; i >= 0; i--) {
			int now = c[i] - '0' + pre;
			if (now > 9) {
				now -= 10;
				pre = 1;
			} else {
				pre = 0;
			}
			c[i] = (char) ('0' + now);
		}
		return String.copyValueOf(c, 0, SIZE);
	}
}
