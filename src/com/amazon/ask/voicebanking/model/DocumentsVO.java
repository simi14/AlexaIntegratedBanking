package com.amazon.ask.voicebanking.model;

public class DocumentsVO {

	private int document_id;
	private String document_name;
	private String document_description;
	private String documentFileName;
	private String documentFilePath;
	private boolean document_status = true;

	public boolean isDocument_status() {
		return document_status;
	}

	public void setDocument_status(boolean document_status) {
		this.document_status = document_status;
	}

	public int getDocument_id() {
		return document_id;
	}

	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}

	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	public String getDocument_description() {
		return document_description;
	}

	public void setDocument_description(String document_description) {
		this.document_description = document_description;
	}

	public String getDocumentFileName() {
		return documentFileName;
	}

	public void setDocumentFileName(String documentFileName) {
		this.documentFileName = documentFileName;
	}

	public String getDocumentFilePath() {
		return documentFilePath;
	}

	public void setDocumentFilePath(String documentFilePath) {
		this.documentFilePath = documentFilePath;
	}

}
