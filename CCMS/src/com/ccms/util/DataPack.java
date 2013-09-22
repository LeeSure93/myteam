/**
 * 
 */
package com.ccms.util;

import java.io.Serializable;
import java.util.Date;

/**
 * @author magic282
 * 
 *         本类作为在网络中传送的实体使用
 * 
 *         在本类中用枚举类型定义了所有的操作
 * 
 *         接受方只需要在接受到本数据包之后查看操作类型，即可知道要进行哪种操作
 * 
 *         进行操作需要的数据已经全包打进数据包内，进行操作时直接get即可
 * 
 * 
 */
public class DataPack implements Serializable {
	/**
	 * 
	 */
	public DataPack() {
		setProcessSuccess(false);
		costumer = null;
		account = null;
		creditCard = null;
		user = null;
		loss = null;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum OPERATION {
		CreateCostumer, CreateAccount, CreateCreditCard, CreateUser,

		GetCostumer, GetAccount, GetCreditCard, GetUser,

		EditCostumer, EditAccount, EditCreditCard, EditUser,

		DeleteCostumer, DeleteAccount, DeleteCreditCard, DeleteUser,

		Deposit, // 存款
		Withdraw, // 取款
		Lost,

		Login, Logout,

		BillCheck, // 账单查询

		SettleAccount, // 结算，实际上估计就是余额查询

		CreateAccountReport, CreateCreditCardReport,

		ConsumeReport, // 这里是开题报告中的那个消费情况报表，但是目前未实现
		CreditCardStatistic, // 信用卡开卡情况报表
		AccountStatistic, UserOperationCheck// 用来统计user进行了那些操作

	};

	private OPERATION operate;

	private boolean ProcessSuccess;

	private User Operator;

	private Costumer costumer;
	private Account account;
	private CreditCard creditCard;
	private User user;
	private Loss loss;
	private String creditCardStatisticString;
	private String accountStatisticString;
	private Date Start;
	private Date End;
	private String AccountID;
	private String money;
	private String positMoneyString;

	private int UserOperationCheckResultSize;
	private Date UserOperationCheckDate;
	private String[] UserOperationCheckResult;
	/**
	 * @return the userOperationCheckDate
	 */
	public Date getUserOperationCheckDate() {
		return UserOperationCheckDate;
	}

	/**
	 * @param userOperationCheckDate the userOperationCheckDate to set
	 */
	public void setUserOperationCheckDate(Date userOperationCheckDate) {
		UserOperationCheckDate = userOperationCheckDate;
	}

	

	/**
	 * @return the userOperationCheckResultSize
	 */
	public int getUserOperationCheckResultSize() {
		return UserOperationCheckResultSize;
	}

	/**
	 * @param userOperationCheckResultSize
	 *            the userOperationCheckResultSize to set
	 */
	public void setUserOperationCheckResultSize(int userOperationCheckResultSize) {
		UserOperationCheckResultSize = userOperationCheckResultSize;
	}

	/**
	 * @return the userOperationCheckResult
	 */
	public String[] getUserOperationCheckResult() {
		return UserOperationCheckResult;
	}

	/**
	 * @param userOperationCheckResult
	 *            the userOperationCheckResult to set
	 */
	public void setUserOperationCheckResult(String[] userOperationCheckResult) {
		UserOperationCheckResult = userOperationCheckResult;
	}

	/**
	 * @return the accountStatisticString
	 */
	public String getAccountStatisticString() {
		return accountStatisticString;
	}

	/**
	 * @param accountStatisticString
	 *            the accountStatisticString to set
	 */
	public void setAccountStatisticString(String accountStatisticString) {
		this.accountStatisticString = accountStatisticString;
	}

	/**
	 * @return the positMoneyString
	 */
	public String getPositMoneyString() {
		return positMoneyString;
	}

	/**
	 * @param positMoneyString
	 *            the positMoneyString to set
	 */
	public void setPositMoneyString(String positMoneyString) {
		this.positMoneyString = positMoneyString;
	}

	/**
	 * @return the withDrawMoneyStringString
	 */
	public String getWithDrawMoneyStringString() {
		return withDrawMoneyStringString;
	}

	/**
	 * @param withDrawMoneyStringString
	 *            the withDrawMoneyStringString to set
	 */
	public void setWithDrawMoneyStringString(String withDrawMoneyStringString) {
		this.withDrawMoneyStringString = withDrawMoneyStringString;
	}

	private String withDrawMoneyStringString;

	/**
	 * @return the operator
	 */
	public User getOperator() {
		return Operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(User operator) {
		Operator = operator;
	}

	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * @return the processSuccess
	 */
	public boolean isProcessSuccess() {
		return ProcessSuccess;
	}

	/**
	 * @param processSuccess
	 *            the processSuccess to set
	 */
	public void setProcessSuccess(boolean processSuccess) {
		ProcessSuccess = processSuccess;
	}

	/**
	 * @return the accountID
	 */
	public String getAccountID() {
		return AccountID;
	}

	/**
	 * @param accountID
	 *            the accountID to set
	 */
	public void setAccountID(String accountID) {
		AccountID = accountID;
	}

	/**
	 * @return the creditCardStatisticString
	 */
	public String getCreditCardStatisticString() {
		return creditCardStatisticString;
	}

	/**
	 * @param creditCardStatisticString
	 *            the creditCardStatisticString to set
	 */
	public void setCreditCardStatisticString(String creditCardStatisticString) {
		this.creditCardStatisticString = creditCardStatisticString;
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return Start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Date start) {
		Start = start;
	}

	/**
	 * @return the end
	 */
	public Date getEnd() {
		return End;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(Date end) {
		End = end;
	}

	/**
	 * @return the creditCardStatistic
	 */
	public String getCreditCardStatistic() {
		return creditCardStatisticString;
	}

	/**
	 * @param creditCardStatistic
	 *            the creditCardStatistic to set
	 */
	public void setCreditCardStatistic(String creditCardStatistic) {
		creditCardStatisticString = creditCardStatistic;
	}

	/**
	 * @return the loss
	 */
	public Loss getLoss() {
		return loss;
	}

	/**
	 * @param loss
	 *            the loss to set
	 */
	public void setLoss(Loss loss) {
		this.loss = loss;
	}

	/**
	 * @return the costumer
	 */
	public Costumer getCostumer() {
		return costumer;
	}

	/**
	 * @param costumer
	 *            the costumer to set
	 */
	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the creditCard
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard
	 *            the creditCard to set
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the operate
	 */
	public OPERATION getOperate() {
		return operate;
	}

	/**
	 * @param operate
	 *            the operate to set
	 */
	public void setOperate(OPERATION operate) {
		this.operate = operate;
	}

}
