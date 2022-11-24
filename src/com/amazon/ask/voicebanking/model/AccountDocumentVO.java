package com.amazon.ask.voicebanking.model;

public class AccountDocumentVO {

	public int getAccountDocument_id() {
		return accountDocument_id;
	}

	public void setAccountDocument_id(int accountDocument_id) {
		this.accountDocument_id = accountDocument_id;
	}

	public AccountVO getAccountVO() {
		return accountVO;
	}

	public void setAccountVO(AccountVO accountVO) {
		this.accountVO = accountVO;
	}

	public DocumentsVO getDocumentsVO() {
		return documentsVO;
	}

	public void setDocumentsVO(DocumentsVO documentsVO) {
		this.documentsVO = documentsVO;
	}

	public boolean isAccountDocument_status() {
		return accountDocument_status;
	}

	public void setAccountDocument_status(boolean accountDocument_status) {
		this.accountDocument_status = accountDocument_status;
	}


	private int accountDocument_id;
	private AccountVO accountVO;
	private DocumentsVO documentsVO;
	private boolean accountDocument_status=true;
}
