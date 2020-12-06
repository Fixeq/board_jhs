package com.hyunseok.vo;

import java.util.Date;

public class UserVO {

	private int userSeq;			/*유저 번호*/
	private String userId;			/*유저 아이디*/
	private String userPw;			/*유저 비밀번호*/
	private String regUserId;		/*유저 등록자*/
	private Date regDate;			/*유저 등록일*/
	
	private String updateUserId;	/*유저 수정자*/
	private Date updateDate;		/*유저 수정일*/
	private int deptSeq;			/*유저 부서번호*/
	private int levelSeq;			/*유저 직급번호*/
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Date getUpdate() {
		return updateDate;
	}
	public void setUpdate(Date update) {
		this.updateDate = update;
	}
	public int getDeptSeq() {
		return deptSeq;
	}
	public void setDeptSeq(int deptSeq) {
		this.deptSeq = deptSeq;
	}
	public int getLevelSeq() {
		return levelSeq;
	}
	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}
	
	@Override
	public String toString() {
		return "UserVO [userSeq=" + userSeq + ", userId=" + userId + ", userPw=" + userPw + ", regUserId=" + regUserId
				+ ", regDate=" + regDate + ", updateUserId=" + updateUserId + ", updateDate=" + updateDate + ", deptSeq="
				+ deptSeq + ", levelSeq=" + levelSeq + "]";
	}
	
}
