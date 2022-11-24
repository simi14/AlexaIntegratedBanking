package com.amazon.ask.voicebanking.model;


public class CityVO {


	private int city_id;
	private String city_name;
	private boolean city_status=true;
	private StateVO stateVO;

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public boolean isCity_status() {
		return city_status;
	}

	public void setCity_status(boolean city_status) {
		this.city_status = city_status;
	}

	public StateVO getStateVO() {
		return stateVO;
	}

	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}
	
	
}
