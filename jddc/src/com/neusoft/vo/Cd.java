package com.neusoft.vo;

/***
 * 
 * @author GXD 菜品/菜单 信息
 */
public class Cd {
	private String CId;
	private String CCdmc;// 菜名
	private float FJg;// 价格
	private String CCl;// 菜类
	private String CPhoto;//图片
	


	public Cd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCPhoto() {
		return CPhoto;
	}

	public void setCPhoto(String cPhoto) {
		CPhoto = cPhoto;
	}
	public String getCId() {
		return CId;
	}

	public void setCId(String cId) {
		CId = cId;
	}

	public String getCCdmc() {
		return CCdmc;
	}

	public void setCCdmc(String cCdmc) {
		CCdmc = cCdmc;
	}

	public float getFJg() {
		return FJg;
	}

	public void setFJg(float fJg) {
		FJg = fJg;
	}

	public String getCCl() {
		return CCl;
	}

	public void setCCl(String cCl) {
		CCl = cCl;
	}
}
