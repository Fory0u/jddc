package com.neusoft.vo;

import java.sql.Date;
/***
 * 
 * @author GXD
 *	订单
 */
public class Order {
	private String CId;
	private String CUser;
	private String CDcxx;
	private Date DCjsj;
	private float NZj;
	public float getNZj() {
		return NZj;
	}
	public void setNZj(float nZj) {
		NZj = nZj;
	}
	private String CCzr;
	public String getCId() {
		return CId;
	}
	public void setCId(String cId) {
		CId = cId;
	}
	public String getCUser() {
		return CUser;
	}
	public void setCUser(String cUser) {
		CUser = cUser;
	}
	public String getCDcxx() {
		return CDcxx;
	}
	public void setCDcxx(String cDcxx) {
		CDcxx = cDcxx;
	}
	public Date getDCjsj() {
		return DCjsj;
	}
	public void setDCjsj(Date dCjsj) {
		DCjsj = dCjsj;
	}
	public String getCCzr() {
		return CCzr;
	}
	public void setCCzr(String cCzr) {
		CCzr = cCzr;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
