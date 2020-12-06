package com.hyunseok.vo;

import java.util.Date;

public class LevelVO {

	private int levelSeq;		/*직급 번호*/
	private String levelName;	/*직급 명*/
	private Date regDate;		/*직급 작성일*/
	private String regUserId;	/*직급 작성자*/
	private Date updateDate;	/*수정 작성일*/
	
	private String updateUserId;/*수정 작성자*/
	
	
	
	public int getLevelSeq() {
		return levelSeq;
	}



	public void setLevelSeq(int levelSeq) {
		this.levelSeq = levelSeq;
	}



	public String getLevelName() {
		return levelName;
	}



	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}



	public Date getRegDate() {
		return regDate;
	}



	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	public String getRegUserId() {
		return regUserId;
	}



	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}



	public Date getUpdate() {
		return updateDate;
	}



	public void setUpdate(Date update) {
		this.updateDate = update;
	}



	public String getUpdateUserId() {
		return updateUserId;
	}



	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}



	@Override
	public String toString() {
		return "LevelVO [levelSeq=" + levelSeq + ", levelName=" + levelName + ", regDate=" + regDate + ", regUserId="
				+ regUserId + ", updateDate=" + updateDate + ", updateUserId=" + updateUserId + "]";
	}
	
	
}
