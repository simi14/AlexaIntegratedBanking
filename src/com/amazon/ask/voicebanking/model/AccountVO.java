package com.amazon.ask.voicebanking.model;



public class AccountVO {

	private int account_id;
	private String account_name;
	private String account_description;
	private String account_rate;
	private String account_minBalance;
	private String account_debitCardCharge;
	private String account_cashDepositLimit;
	private String account_smsCharge;
	
	
	public String getAccount_debitCardCharge() {
		return account_debitCardCharge;
	}

	public void setAccount_debitCardCharge(String account_debitCardCharge) {
		this.account_debitCardCharge = account_debitCardCharge;
	}

	public String getAccount_cashDepositLimit() {
		return account_cashDepositLimit;
	}

	public void setAccount_cashDepositLimit(String account_cashDepositLimit) {
		this.account_cashDepositLimit = account_cashDepositLimit;
	}

	public String getAccount_smsCharge() {
		return account_smsCharge;
	}

	public void setAccount_smsCharge(String account_smsCharge) {
		this.account_smsCharge = account_smsCharge;
	}

	private boolean account_status=true;

	public boolean isAccount_status() {
		return account_status;
	}

	public void setAccount_status(boolean account_status) {
		this.account_status = account_status;
	}

	public String getAccount_rate() {
		return account_rate;
	}

	public void setAccount_rate(String account_rate) {
		this.account_rate = account_rate;
	}

	public String getAccount_minBalance() {
		return account_minBalance;
	}

	public void setAccount_minBalance(String account_minBalance) {
		this.account_minBalance = account_minBalance;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_description() {
		return account_description;
	}

	public void setAccount_description(String account_description) {
		this.account_description = account_description;
	}
	
	
}
