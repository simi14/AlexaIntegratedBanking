package com.amazon.ask.voicebanking.model;


public class LoanRateVO {


	private int loanRate_id;
	private String loanRate_tenure;
	private String loanRate_rate;
	private String loanRate_maxAmount;
	private LoanTypeVO loanTypeVO;
	
	public LoanTypeVO getLoanTypeVO() {
		return loanTypeVO;
	}

	public void setLoanTypeVO(LoanTypeVO loanTypeVO) {
		this.loanTypeVO = loanTypeVO;
	}

	public int getLoanRate_id() {
		return loanRate_id;
	}

	public void setLoanRate_id(int loanRate_id) {
		this.loanRate_id = loanRate_id;
	}



	public String getLoanRate_tenure() {
		return loanRate_tenure;
	}

	public void setLoanRate_tenure(String loanRate_tenure) {
		this.loanRate_tenure = loanRate_tenure;
	}

	public String getLoanRate_rate() {
		return loanRate_rate;
	}

	public void setLoanRate_rate(String loanRate_rate) {
		this.loanRate_rate = loanRate_rate;
	}

	public String getLoanRate_maxAmount() {
		return loanRate_maxAmount;
	}

	public void setLoanRate_maxAmount(String loanRate_maxAmount) {
		this.loanRate_maxAmount = loanRate_maxAmount;
	}

	public boolean isLoanRate_status() {
		return loanRate_status;
	}

	public void setLoanRate_status(boolean loanRate_status) {
		this.loanRate_status = loanRate_status;
	}

	private boolean loanRate_status=true;
}
