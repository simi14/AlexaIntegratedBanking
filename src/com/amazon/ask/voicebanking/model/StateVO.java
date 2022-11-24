package com.amazon.ask.voicebanking.model;


public class StateVO {


	private int state_id;
	private String state_name;
	private boolean state_status=true;
	
	public boolean isState_status() {
		return state_status;
	}

	public void setState_status(boolean state_status) {
		this.state_status = state_status;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	
	

}
