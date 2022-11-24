package com.amazon.ask.voicebanking.model;


public class BranchVO {

	private int branchId;
	private String branchName;
	private String ifscCode;
	private String bankName;
	private boolean branch_status=true;
	private String branchAddress;
	private String branchDistrict;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public boolean isBranch_status() {
		return branch_status;
	}

	public void setBranch_status(boolean branch_status) {
		this.branch_status = branch_status;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getBranchDistrict() {
		return branchDistrict;
	}

	public void setBranchDistrict(String branchDistrict) {
		this.branchDistrict = branchDistrict;
	}

	public StateVO getStateVO() {
		return stateVO;
	}

	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}

	public CityVO getCityVO() {
		return cityVO;
	}

	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}

	private StateVO stateVO;
	
	private CityVO cityVO;
}
