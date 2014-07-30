package com.playundeadservice;

public enum MSG_SERVICE_FLAG{
	START_SERVICE(0), MESSAGE(1), NOTHING(2);
	
	private final int position;
	private MSG_SERVICE_FLAG(int position) {
		this.position = position;
	}
	
	public int getPosition(){
		return position;
	}
}
