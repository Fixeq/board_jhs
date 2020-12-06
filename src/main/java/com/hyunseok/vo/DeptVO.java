package com.hyunseok.vo;

import java.util.Date;

public class DeptVO {

	private int deptSeq;		/*부서 번호*/
	private String deptName;	/*부서 명*/
	private Date regDate;		/*부서 작성일*/
	private String regUserId;	/*부서 작성자*/
	private Date updateDate;	/*수정 작성일*/
	
	private String updateUserId;/*수정 작성자*/
	
	public int getDeptSeq() {
		return deptSeq;
	}
	public void setDeptSeq(int deptSeq) {
		this.deptSeq = deptSeq;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
		return "DeptVO [deptSeq=" + deptSeq + ", deptName=" + deptName + ", regDate=" + regDate + ", regUserId="
				+ regUserId + ", updateDate=" + updateDate + ", updateUserId=" + updateUserId + "]";
	}

	
}
