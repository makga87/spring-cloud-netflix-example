package com.example.connector.vo;

public class ResultVo {
	private boolean result;
	private String msg;
	private String appName;
	private long returnTime;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public long getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(long returnTime) {
		this.returnTime = returnTime;
	}
	
}
