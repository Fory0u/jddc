package com.neusoft.vo;

/***
 * 
 * @author GXD 餐桌信息
 */
public class Cz {
	private String CId;
	private String CCzmc;// 餐桌名称
	private String CCzzt;// 餐桌状态
	private Integer NCzrs;// 餐桌人数

	public String getCCzzt() {
		return CCzzt;
	}

	public void setCCzzt(String cCzzt) {
		CCzzt = cCzzt;
	}

	public Integer getNCzrs() {
		return NCzrs;
	}

	public void setNCzrs(Integer nCzrs) {
		NCzrs = nCzrs;
	}

	public String getCId() {
		return CId;
	}

	public void setCId(String cId) {
		CId = cId;
	}

	public String getCCzmc() {
		return CCzmc;
	}

	public void setCCzmc(String cCzmc) {
		CCzmc = cCzmc;
	}

	public Cz() {
		super();
		// TODO Auto-generated constructor stub
	}

}
