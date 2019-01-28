package com.fxsong.model;

public class UserVO {
	
	String userId;
	String userNm;
	String userTyCdId;
	
	public UserVO() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserTyCdId() {
		return userTyCdId;
	}

	public void setUserTyCdId(String userTyCdId) {
		this.userTyCdId = userTyCdId;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userNm=" + userNm + ", userTyCdId=" + userTyCdId + "]";
	}

}
