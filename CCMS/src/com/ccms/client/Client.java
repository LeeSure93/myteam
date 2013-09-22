package com.ccms.client;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ccms.util.Account;
import com.ccms.util.Costumer;
import com.ccms.util.CreditCard;
import com.ccms.util.DataPack;
import com.ccms.util.DataPack.OPERATION;
import com.ccms.util.Loss;
import com.ccms.util.User;

/**
 * 
 * @author hit-acm
 */
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String serverAddress = null;
	private static int serverPort;
	private static User operator;
	private static Socket socketConnection;

	public static void setOperator(User u) {
		operator = u;
	}

	public static boolean init(String add, int port) {
		serverAddress = add;
		serverPort = port;
		System.out.println("Server ip address is set to : " + serverAddress);
		System.out.println("Server port is set to : " + serverPort);
		return true;
	}

	private static DataPack transfer(DataPack dataPack) {
		try {
			socketConnection = new Socket(serverAddress, serverPort);
			ObjectOutputStream clientOutputStream = new ObjectOutputStream(
					socketConnection.getOutputStream());
			ObjectInputStream clientInputStream = new ObjectInputStream(
					socketConnection.getInputStream());
			dataPack.setOperator(operator);
			if (dataPack.getOperate() == OPERATION.Login) {
				dataPack.setOperator(dataPack.getUser());
			}
			clientOutputStream.writeObject(dataPack);
			DataPack ret = null;
			try {
				ret = (DataPack) clientInputStream.readObject();
				clientOutputStream.close();
				clientInputStream.close();
				return ret;
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE,
						null, ex);
				clientOutputStream.close();
				clientInputStream.close();
				return null;
			}

		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName())
					.log(Level.SEVERE, null, ex);
			return null;
		}
	}

	 public static boolean isConnectedToServer() {
		try {
			socketConnection = new Socket(serverAddress, serverPort);
			ObjectOutputStream clientOutputStream = new ObjectOutputStream(
					socketConnection.getOutputStream());
			ObjectInputStream clientInputStream = new ObjectInputStream(
					socketConnection.getInputStream());

			clientOutputStream.writeObject("Hello");
			String ret = null;
			try {
				ret = (String) clientInputStream.readObject();
				clientOutputStream.close();
				clientInputStream.close();
				if(ret.equals("Hello! Connection established!")){
					return true;
				}else{
					return false;
				}
			} catch (ClassNotFoundException ex) {
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE,
						null, ex);
				clientOutputStream.close();
				clientInputStream.close();
				return false;
			}

		} catch (IOException ex) {
			Logger.getLogger(Client.class.getName())
					.log(Level.SEVERE, null, ex);
			return false;
		}
	}
	
	public static User UserLogin(User user) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.Login);
		dataPack.setUser(user);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
//			/*cyb 2012.11.17修改*/
//			setOperator(ret.getUser());
//			System.out.println(operator.getBankID()+"^^^^^^^^^^^^^^^^^^^^");
//			/*********************/
			return ret.getUser();
		}
		return null;
	}

	public static User CreateUser(User user) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.CreateUser);
		dataPack.setUser(user);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getUser();
		}
		return null;
	}

	public static boolean DeleteUser(String userID) {
		User user = new User();
		user.setUserID(userID);
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.DeleteUser);
		dataPack.setUser(user);
		DataPack ret = transfer(dataPack);

		return ret.isProcessSuccess();

	}

	public static User GetUser(String userID) {
		User user = new User();
		user.setUserID(userID);
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.GetUser);
		dataPack.setUser(user);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getUser();
		}
		return null;
	}

	public static String CreditCardStatistic(Date Start, Date End) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.CreditCardStatistic);
		dataPack.setStart(Start);
		dataPack.setEnd(End);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getCreditCardStatisticString();
		}
		return null;

	}

	public static Costumer CreateCostumer(Costumer costumer) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.CreateCostumer);
		dataPack.setCostumer(costumer);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getCostumer();
		}
		return null;
	}

	public static Costumer GetCostumer(String costumerID) {
		Costumer tmpCostumer = new Costumer();
		tmpCostumer.setCostumerID(costumerID);
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.GetCostumer);
		dataPack.setCostumer(tmpCostumer);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getCostumer();
		}
		return null;
	}

	public static Account CreateAccount(Costumer costumer) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.CreateAccount);
		dataPack.setCostumer(costumer);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getAccount();
		}
		return null;
	}

	public static Account GetAccount(String AccountID) {

		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.GetAccount);
		dataPack.setAccountID(AccountID);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getAccount();
		}
		return null;
	}

	public static boolean DrawMoney(Account account, String money) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.Withdraw);
		dataPack.setAccount(account);
		dataPack.setMoney(money);
		DataPack ret = transfer(dataPack);// 居然是没有传，Debug了半天

		return ret.isProcessSuccess();

	}

	public static boolean Deposit(Account account, String money) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.Deposit);
		dataPack.setAccount(account);
		dataPack.setMoney(money);
		DataPack ret = transfer(dataPack);

		return ret.isProcessSuccess();

	}

	public static boolean EditCostumer(Costumer costumer) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.EditCostumer);
		dataPack.setCostumer(costumer);
		DataPack ret = transfer(dataPack);
		return ret.isProcessSuccess();

	}

	public static boolean Lost(Loss loss) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.Lost);
		dataPack.setLoss(loss);
		DataPack ret = transfer(dataPack);
		return ret.isProcessSuccess();
	}

	public static boolean DeleteCard(String cardID) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.DeleteCreditCard);
		CreditCard tmpCard = new CreditCard();
		tmpCard.setCreditCardID(cardID);
		dataPack.setCreditCard(tmpCard);
		DataPack ret = transfer(dataPack);
		return ret.isProcessSuccess();
	}

	public static CreditCard GetCreditCard(String cardID) {
		CreditCard tmp = new CreditCard();
		tmp.setCreditCardID(cardID);
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.GetCreditCard);
		dataPack.setCreditCard(tmp);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getCreditCard();
		}
		return null;
	}

	public static boolean EditCreditCard(CreditCard creditCard) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.EditCreditCard);
		dataPack.setCreditCard(creditCard);
		DataPack ret = transfer(dataPack);
		return ret.isProcessSuccess();
	}

	public static CreditCard CreateCC(Account account) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.CreateCreditCard);
		dataPack.setAccount(account);
		DataPack ret = transfer(dataPack);
		System.out.println(operator.getBankID()+"^^^^^^^^^^^^^^^^^^^^"+dataPack.getOperator().getBankID());
		if (ret.isProcessSuccess()) {
			return ret.getCreditCard();
		}
		return null;
	}

	public static boolean UserLogout(User user) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.Logout);
		dataPack.setUser(user);
		DataPack ret = transfer(dataPack);
		return ret.isProcessSuccess();
	}

	/**
	 * 
	 * 这个函数不得已采取了折中的办法，返回的结果为用户存款的总数+取款总数
	 * 
	 * @param account
	 * @param Start
	 * @param End
	 * @return
	 * 
	 *         加入用户在两个日期之前共存款100元，取款1000元，则返回的结果应当为
	 * 
	 *         "100+1000"
	 */
	public static String BillCheck(Account account, Date Start, Date End) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.BillCheck);
		dataPack.setAccount(account);
		dataPack.setStart(Start);
		dataPack.setEnd(End);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			/**********************************/
			System.out.println(ret.getPositMoneyString() + " = "
					+ ret.getWithDrawMoneyStringString()+"Debug 了半天发现是因为不能split + 号");
			/**********************************/
			return ret.getPositMoneyString() + " = "
					+ ret.getWithDrawMoneyStringString();
		} else {
			return null;
		}
	}

	public static String CreateAccountStatistic(Date Start, Date End) {
		DataPack dataPack = new DataPack();
		dataPack.setOperate(OPERATION.AccountStatistic);
		dataPack.setStart(Start);
		dataPack.setEnd(End);
		DataPack ret = transfer(dataPack);
		if (ret.isProcessSuccess()) {
			return ret.getAccountStatisticString();
		}
		return null;
	}

	/**
	 * 
	 * @param s
	 * @return 判断是否为数字组成的字符串
	 */
	public static boolean IsDigit(String s) {
		char temp[] = s.toCharArray();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > '9' || temp[i] < '0') {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean IsCreditCardID(String s) {
		int CreditCardIDSIZE = 16;// 信用卡帐号长度
		return s.length() == CreditCardIDSIZE && IsDigit(s);
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean IsAccountID(String s) {
		int AccountIDSIZE = 16;// 帐号长度
		return s.length() == AccountIDSIZE && IsDigit(s);
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static boolean IsCostumerID(String s) {
		int CostumerIDSIZE = 16;// 客户编号长度
		return s.length() == CostumerIDSIZE && IsDigit(s);
	}
    
    public static boolean IsTelephoneNumber(String s){
		int CostumerIDSIZE = 11;// 电话号码的长度，不管是电话还是手机都是11位的。
    	return s.length()==CostumerIDSIZE && IsDigit(s);
    }
    public static String [] UserOperationCheck(User user,Date Date){
    	DataPack dataPack = new DataPack();
    	dataPack.setOperate(OPERATION.UserOperationCheck);
    	dataPack.setUser(user);
    	dataPack.setUserOperationCheckDate(Date);
    	DataPack ret = transfer(dataPack);
    	if(ret.isProcessSuccess()){
    		return ret.getUserOperationCheckResult();
    	}
    	return null;
    }
}