package com.amazon.ask.voicebanking.model;


public class LoanTypeVO {


	private int loantype_id;
	private String loantype_name;
	private String loantype_description;
	private boolean loantype_status=true;
	
	public boolean isLoantype_status() {
		return loantype_status;
	}

	public void setLoantype_status(boolean loantype_status) {
		this.loantype_status = loantype_status;
	}

	public int getLoantype_id() {
		return loantype_id;
	}

	public void setLoantype_id(int loantype_id) {
		this.loantype_id = loantype_id;
	}

	public String getLoantype_name() {
		return loantype_name;
	}

	public void setLoantype_name(String loantype_name) {
		this.loantype_name = loantype_name;
	}

	public String getLoantype_description() {
		return loantype_description;
	}

	public void setLoantype_description(String loantype_description) {
		this.loantype_description = loantype_description;
	}

	
}
