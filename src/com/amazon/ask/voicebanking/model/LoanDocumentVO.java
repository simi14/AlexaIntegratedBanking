package com.amazon.ask.voicebanking.model;


public class LoanDocumentVO {


	private int loanDocument_id;
	private LoanTypeVO loanTypeVO;
	private DocumentsVO documentsVO;
	


	public int getLoanDocument_id() {
		return loanDocument_id;
	}

	public void setLoanDocument_id(int loanDocument_id) {
		this.loanDocument_id = loanDocument_id;
	}

	public LoanTypeVO getLoanTypeVO() {
		return loanTypeVO;
	}

	public void setLoanTypeVO(LoanTypeVO loanTypeVO) {
		this.loanTypeVO = loanTypeVO;
	}

	public DocumentsVO getDocumentsVO() {
		return documentsVO;
	}

	public void setDocumentsVO(DocumentsVO documentsVO) {
		this.documentsVO = documentsVO;
	}

	public boolean isLoanDocument_status() {
		return loanDocument_status;
	}

	public void setLoanDocument_status(boolean loanDocument_status) {
		this.loanDocument_status = loanDocument_status;
	}

	private boolean loanDocument_status=true;
	
}
