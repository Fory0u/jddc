package com.neusoft.vo;

/***
 * 
 * @author GXD 用户信息
 */
public class User {

	private String CId;
	private String CLoginId;
	private String CName;
	private String CPassword;
	private Integer NLx;// 1管理员 2用户

	public String getCId() {
		return CId;
	}

	public void setCId(String cId) {
		CId = cId;
	}

	public String getCLoginId() {
		return CLoginId;
	}

	public void setCLoginId(String cLoginId) {
		CLoginId = cLoginId;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getCPassword() {
		return CPassword;
	}

	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}

	public Integer getNLx() {
		return NLx;
	}

	public void setNLx(Integer nLx) {
		NLx = nLx;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
