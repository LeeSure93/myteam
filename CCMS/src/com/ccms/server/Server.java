/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccms.server;

import com.ccms.util.*;
import com.ccms.util.Account.ACCOUNTSTATE;
import com.ccms.util.CreditCard.CREDITCARDSTATE;
import com.ccms.util.DataPack.OPERATION;
import com.ccms.util.User.USERSTATE;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author magic282
 */
public class Server {

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		Date fileDate = new Date();
		String fileName = fileDate.toGMTString() + ".log";
		FileWriter fw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter(fileName, true);
			out = new PrintWriter(fw);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("日志文件建立失败！");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			System.out.println("日志文件建立失败！");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("日志文件建立失败！");
			System.exit(-1);
		}
		out.println("Log created at " + fileDate.toLocaleString());
		out.flush();
		fileDate = new Date();
		out.println(fileDate.toLocaleString() + " "
				+ "Trying to connect to the database server ...");
		out.flush();
		if (!DBOperation.Connnect()) {
			fileDate = new Date();
			System.out.println("无法连接到数据库服务器！");
			out.println(fileDate.toLocaleString()
					+ " Cannot connect to database server!");
			out.flush();
			out.close();
			return;
		}
		fileDate = new Date();
		out.println(fileDate.toLocaleString() + " "
				+ "Connect to database server");
		out.flush();
		ServerSocket s;
		try {
			s = new ServerSocket(8189);
			fileDate = new Date();
			out.println(fileDate.toLocaleString() + " "
					+ "Server listening to port 8189");
			out.flush();
			while (true) {
				System.out.println("waiting for connection ...");
				Socket pipe = s.accept();
				System.out.println("Connection established!");
				System.out.println("Connection from : "
						+ pipe.getRemoteSocketAddress());
				fileDate = new Date();
				out.println(fileDate.toLocaleString() + " "
						+ "Connection from : " + pipe.getRemoteSocketAddress());
				out.flush();
				Runnable r = new ThreadHandler(pipe);
				Thread t = new Thread(r);
				t.start();

			}
		} catch (IOException ex) {
			fileDate = new Date();
			out.println(fileDate.toLocaleString() + " "
					+ "catch an IOException !");
			out.flush();
			Logger.getLogger(Server.class.getName())
					.log(Level.SEVERE, null, ex);
		}
		fileDate = new Date();
		out.println(fileDate.toLocaleString() + " " + "Server terminated .");
		out.flush();
		out.close();

	}

}

class ThreadHandler implements Runnable {

	private Socket pipe;

	ThreadHandler(Socket s) {
		pipe = s;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {

		ObjectInputStream serverInputStream;
		ObjectOutputStream serverOutputStream;
		try {
			serverInputStream = new ObjectInputStream(pipe.getInputStream());
			serverOutputStream = new ObjectOutputStream(pipe.getOutputStream());
			DataPack dataPack = null;

			Object o;
			try {
				o = serverInputStream.readObject();

				/**
				 * 在此处把数据包截获，然后提取出需要的信息
				 * 
				 * 之后就可以调用原来的函数
				 * 
				 * 处理完之后把数据再封装回来，发送回客户端
				 */

				if (o instanceof String) {
					serverOutputStream
							.writeObject("Hello! Connection established!");
				} else if (o instanceof DataPack) {
					dataPack = (DataPack) o;
					User nowuser = new User();
					if (dataPack.getOperator() == null)// 获取进行操作的用户信息
					{
						System.out.println("未知操作人员 这里只是让记得加上操作人的信息");
						dataPack.setProcessSuccess(false);
						serverOutputStream.writeObject(dataPack);
					} else {
						nowuser = dataPack.getOperator();
						System.out.println(nowuser.getUserID() + " "
								+ nowuser.getBankID());

						Log log = new Log();
						log.setUserID(nowuser.getUserID());
						log.setOperationTime(new Date());
						log.setType(dataPack.getOperate().toString());
						log.setIsSuccefull("false");
						System.out.println("dataPack.getOperate()="
								+ dataPack.getOperate() + "");
						if (dataPack.getOperate() == OPERATION.Login) {
							User user = new User();
							user = dataPack.getUser();
							user = DBOperation.UserLogin(user.getUserID(),
									user.getPassword());
							if (user != null) {
								dataPack.setProcessSuccess(true);
								dataPack.setUser(user);
								log.setXID(user.getUserID());
								log.setIsSuccefull("true");
							}

						} else if (dataPack.getOperate() == OPERATION.Logout) {
							User user = new User();
							user = dataPack.getOperator();
							if (DBOperation.UserLogout(user)) {
								dataPack.setProcessSuccess(true);
								log.setXID(user.getUserID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.CreateUser) {
							User user = new User();
							user = dataPack.getUser();

							// user.setBankID("001");/* 本行银行的编号 */
							user.setStatus(USERSTATE.Offline);
							// user.setUserID(DBOperation.GenerateUserID());
							if (DBOperation.IsBankExist(user.getBankID())
									&& DBOperation.DBUser(user.getUserID()) == null) {
								if (DBOperation.Insert(user)) {
									dataPack.setUser(user);
									dataPack.setProcessSuccess(true);
									log.setXID(user.getUserID());
									log.setIsSuccefull("true");
								}
							}
						} else if (dataPack.getOperate() == OPERATION.DeleteUser) {
							User user = new User();
							user = dataPack.getUser();
							if (DBOperation.Pinuser(user.getUserID())) {
								dataPack.setProcessSuccess(true);
								log.setXID(user.getUserID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.GetUser) {
							User user = new User();
							user = dataPack.getUser();
							user = DBOperation.DBUser(user.getUserID());
							if (user != null) {
								dataPack.setUser(user);
								dataPack.setProcessSuccess(true);
								log.setXID(user.getUserID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.CreditCardStatistic) {
							Date start = new Date();
							Date end = new Date();
							start = dataPack.getStart();
							end = dataPack.getEnd();
							String ans = DBOperation.CreditCardStatistic(start,
									end);
							if (ans != null) {
								dataPack.setCreditCardStatistic(ans);
								dataPack.setProcessSuccess(true);
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.CreateCostumer) {
							Costumer costumer = new Costumer();
							costumer = dataPack.getCostumer();

							String costumerID = DBOperation
									.GenerateCostumerID();
							if (costumerID != null) {
								costumer.setCostumerID(costumerID);
								costumer.setBirthday(new Date());
								if (DBOperation.Insert(costumer)) {
									dataPack.setProcessSuccess(true);
									log.setXID(costumer.getCostumerID());
									log.setIsSuccefull("true");
								}
							}
						} else if (dataPack.getOperate() == OPERATION.GetCostumer) {
							Costumer costumer = new Costumer();
							costumer = dataPack.getCostumer();
							costumer = DBOperation.DBCostumer(costumer
									.getCostumerID());

							if (costumer != null) {
								dataPack.setCostumer(costumer);
								dataPack.setProcessSuccess(true);
								log.setXID(costumer.getCostumerID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.CreateAccount) {
							Account account = new Account();

							/*
							 * 创建一个账户，同时创建一个客户，并使该账户指向客户
							 */
							String accountID = DBOperation.GenerateAccountID();
							account.setAccountID(accountID);
							account.setCreditLine("0");
							/*
							 * TODO
							 * 
							 * 这个地方我已经不想说什么了
							 * 
							 * 已经说了n多遍了
							 */
							Bank bank=new Bank();
							bank=DBOperation.DBBank(nowuser.getBankID());
							account.setBankName(bank.getBankName());
							account.setStatus(ACCOUNTSTATE.normal);
							account.setMoney("0");
							account.setCreateAccountTime(new Date());/* 系统当前时间 */

							/* 创建用户的时候，同时创建一个客户 */
							Costumer costumer = new Costumer();
							costumer = dataPack.getCostumer();
							//String costumerID = DBOperation
									//.GenerateCostumerID();

							//costumer.setCostumerID(costumerID);
							account.setCostumerID(costumer.getCostumerID());// 建立链接
							/*
							 * TODO
							 * 
							 * 人家客户的生日需要你来设置吗？
							 */
							//costumer.setBirthday(new Date());
							/*
							 * TODOs
							 * 
							 * 如此巨大的一个bug
							 * 
							 * 开个户居然创建了两个Costumer
							 */
							if (accountID != null) {
								if (DBOperation.EditCostumer(costumer)
										&& DBOperation.Insert(account)) {
									dataPack.setAccount(account);
									dataPack.setCostumer(costumer);
									dataPack.setProcessSuccess(true);
									log.setXID(costumer.getCostumerID() + " = "
											+ account.getAccountID());
									log.setIsSuccefull("true");
								}
							}
						} else if (dataPack.getOperate() == OPERATION.GetAccount) {
							Account account = new Account();

							account = DBOperation.DBAccount(dataPack
									.getAccountID());

							if (account != null) {
								dataPack.setAccount(account);
								dataPack.setProcessSuccess(true);
								log.setXID(account.getAccountID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.Withdraw) {
							Account account = new Account();
							account = dataPack.getAccount();
							String money = dataPack.getMoney();

							if (DBOperation.MinusMoney(account, money)) {
								dataPack.setProcessSuccess(true);
								log.setXID(account.getAccountID());
								log.setContent(money);
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.Deposit) {
							Account account = new Account();
							account = dataPack.getAccount();
							String money = dataPack.getMoney();

							if (DBOperation.PlusMoney(account, money)) {
								dataPack.setProcessSuccess(true);
								log.setXID(account.getAccountID());
								log.setContent(money);
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.EditCostumer) {
							Costumer costumer = new Costumer();
							costumer = dataPack.getCostumer();

							if (DBOperation.EditCostumer(costumer)) {
								dataPack.setProcessSuccess(true);
								log.setXID(costumer.getCostumerID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.Lost) {
							Loss loss = new Loss();
							loss = dataPack.getLoss();

							CreditCard creditcard = new CreditCard();
							creditcard = DBOperation.DBCreditCard(loss
									.getCreditCardID());
							creditcard.setStatus(CREDITCARDSTATE.lost);
							DBOperation.EditCreditCard(creditcard);
							loss.setLossID(DBOperation.GenerateLossID());
							loss.setLossDate(new Date());// 获取系统当前的时间

							if (DBOperation.Insert(loss)) {
								dataPack.setLoss(loss);
								dataPack.setProcessSuccess(true);
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.DeleteCreditCard) {
							CreditCard creditcard = new CreditCard();
							creditcard = dataPack.getCreditCard();
							if (DBOperation.Pincard(creditcard
									.getCreditCardID())) {
								dataPack.setProcessSuccess(true);
								log.setXID(creditcard.getCreditCardID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.GetCreditCard) {
							CreditCard creditcard = new CreditCard();
							creditcard = dataPack.getCreditCard();
							creditcard = DBOperation.DBCreditCard(creditcard
									.getCreditCardID());

							if (creditcard != null) {
								dataPack.setCreditCard(creditcard);
								dataPack.setProcessSuccess(true);
								log.setXID(creditcard.getCreditCardID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.EditCreditCard) {
							CreditCard creditcard = new CreditCard();
							creditcard = dataPack.getCreditCard();

							if (DBOperation.EditCreditCard(creditcard)) {
								dataPack.setProcessSuccess(true);
								log.setXID(creditcard.getCreditCardID());
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.CreateCreditCard) {
							Account account = new Account();
							account = dataPack.getAccount();
							CreditCard creditcard = new CreditCard();

							creditcard.setCreditCardID(DBOperation
									.GenerateCreditCardID());
							creditcard.setAccountID(account.getAccountID());
							creditcard.setStatus(CREDITCARDSTATE.unActive);
							Bank bank = new Bank();
							bank = DBOperation.DBBank(nowuser.getBankID());
							if (bank != null) {
								creditcard.setBankName(bank.getBankName());
								Date local = new Date();
								Date deadline = new Date();
								creditcard.setCreateCreditCardTime(local);// 获得系统时间
								System.out.println(local);
								deadline.setYear(local.getYear() + 4);
								creditcard.setDeadline(deadline);// 系统时间+4
								System.out.println(deadline);

								if (creditcard.getCreditCardID() != null
										&& DBOperation.Insert(creditcard)) {
									dataPack.setCreditCard(creditcard);
									dataPack.setProcessSuccess(true);
									log.setIsSuccefull("true");
								}
							}
						} else if (dataPack.getOperate() == OPERATION.BillCheck) {
							Date start = new Date();
							Date end = new Date();
							Account account = new Account();

							account = dataPack.getAccount();
							start = dataPack.getStart();
							end = dataPack.getEnd();

							String ans1 = DBOperation.MoneyStatistic(account,
									start, end, "Deposit");
							String ans2 = DBOperation.MoneyStatistic(account,
									start, end, "Withdraw");
							if (ans1 != null && ans2 != null) {
								dataPack.setPositMoneyString(ans1);
								dataPack.setWithDrawMoneyStringString(ans2);
								dataPack.setProcessSuccess(true);
								log.setXID(account.getAccountID());
								log.setIsSuccefull("true");
							}

						} else if (dataPack.getOperate() == OPERATION.AccountStatistic) {
							Date start = new Date();
							Date end = new Date();
							start = dataPack.getStart();
							end = dataPack.getEnd();
							String ans = DBOperation.AccountStatistic(start,
									end);
							if (ans != null) {
								dataPack.setAccountStatisticString(ans);
								dataPack.setProcessSuccess(true);
								log.setIsSuccefull("true");
							}
						} else if (dataPack.getOperate() == OPERATION.UserOperationCheck) {
							User user = new User();
							user = dataPack.getUser();
							String[] res = DBOperation.DBLog(user.getUserID(),
									dataPack.getUserOperationCheckDate());
							if (res != null) {
								dataPack.setUserOperationCheckResult(res);
								dataPack.setUserOperationCheckResultSize(res.length);
								dataPack.setProcessSuccess(true);
								log.setXID(user.getUserID());
								log.setIsSuccefull("true");
							}
						}

						DBOperation.Insert(log);
					}
					serverOutputStream.writeObject(dataPack);
					serverInputStream.close();
					serverOutputStream.close();
				}
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(ThreadHandler.class.getName()).log(
						Level.SEVERE, null, ex);
			}

			serverInputStream.close();
			serverOutputStream.close();

		} catch (IOException ex) {
			Logger.getLogger(ThreadHandler.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}
}