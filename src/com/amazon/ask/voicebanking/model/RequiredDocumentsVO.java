package com.amazon.ask.voicebanking.model;

public class RequiredDocumentsVO {

	private int requiredDocument_id;
	
	
	private ServicesVO servicesVO;
	private DocumentsVO documentsVO;
	private boolean requiredDocument_status=true;

	public int getRequiredDocument_id() {
		return requiredDocument_id;
	}

	public void setRequiredDocument_id(int requiredDocument_id) {
		this.requiredDocument_id = requiredDocument_id;
	}

	public ServicesVO getServicesVO() {
		return servicesVO;
	}

	public void setServicesVO(ServicesVO servicesVO) {
		this.servicesVO = servicesVO;
	}

	public DocumentsVO getDocumentsVO() {
		return documentsVO;
	}

	public void setDocumentsVO(DocumentsVO documentsVO) {
		this.documentsVO = documentsVO;
	}

	public boolean isRequiredDocument_status() {
		return requiredDocument_status;
	}

	public void setRequiredDocument_status(boolean requiredDocument_status) {
		this.requiredDocument_status = requiredDocument_status;
	}
	

	
}
