package com.neusoft.vo;

import java.sql.Date;
/***
 * 
 * @author GXD
 *	订单
 */
public class Order {
	private String CId;
	private String CUser;//点菜人
	private String CCzmc;//餐桌名称
	private String CDcxx;//点菜信息
	private Integer CDcsl;//点菜数量
	private float FZj;//总价
	private Integer NZs;//总数
	private String CDdzt;//订单状态
	private Date DCjsj;//创建时间
	
	public float getFZj() {
		return FZj;
	}
	public void setFZj(float fZj) {
		FZj = fZj;
	}
	public String getCCzmc() {
		return CCzmc;
	}
	public void setCCzmc(String cCzmc) {
		CCzmc = cCzmc;
	}
	public Integer getCDcsl() {
		return CDcsl;
	}
	public void setCDcsl(Integer cDcsl) {
		CDcsl = cDcsl;
	}
	public Integer getNZs() {
		return NZs;
	}
	public void setNZs(Integer nZs) {
		NZs = nZs;
	}
	public String getCDdzt() {
		return CDdzt;
	}
	public void setCDdzt(String cDdzt) {
		CDdzt = cDdzt;
	}
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
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
