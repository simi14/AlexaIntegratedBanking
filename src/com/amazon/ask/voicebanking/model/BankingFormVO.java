package com.amazon.ask.voicebanking.model;


public class BankingFormVO {


	private int bankingFormId;
	private String bankingFormName;
	private String bankingFormDescription;
	private String bankingFormFileName;
	private String bankingFormFilePath;
	private boolean bankingFormStatus = true;
	private String bankingFormlink;
	
	public String getBankingFormlink() {
		return bankingFormlink;
	}

	public void setBankingFormlink(String bankingFormlink) {
		this.bankingFormlink = bankingFormlink;
	}
	public int getBankingFormId() {
		return bankingFormId;
	}

	public void setBankingFormId(int bankingFormId) {
		this.bankingFormId = bankingFormId;
	}

	public String getBankingFormName() {
		return bankingFormName;
	}

	public void setBankingFormName(String bankingFormName) {
		this.bankingFormName = bankingFormName;
	}

	public String getBankingFormDescription() {
		return bankingFormDescription;
	}

	public void setBankingFormDescription(String bankingFormDescription) {
		this.bankingFormDescription = bankingFormDescription;
	}

	public String getBankingFormFileName() {
		return bankingFormFileName;
	}

	public void setBankingFormFileName(String bankingFormFileName) {
		this.bankingFormFileName = bankingFormFileName;
	}

	public String getBankingFormFilePath() {
		return bankingFormFilePath;
	}

	public void setBankingFormFilePath(String bankingFormFilePath) {
		this.bankingFormFilePath = bankingFormFilePath;
	}

	public boolean isBankingFormStatus() {
		return bankingFormStatus;
	}

	public void setBankingFormStatus(boolean bankingFormStatus) {
		this.bankingFormStatus = bankingFormStatus;
	}
}
