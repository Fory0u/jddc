package com.neusoft.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeUtil {

	public static String getCodeStr(int len){
		String prefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String suffix = radmonkey(len);
		return prefix + suffix;
	}
	
	/*
	 * @param count :需要产生随机数的个数
	 */
	public static String radmonkey(int count){
		StringBuffer sbf=new StringBuffer();
		for (int i = 0; i <count; i++) {
			int num=(int)(Math.random()*10);
			sbf.append(num);
		}
		
		return sbf.toString();
	}
	
	/**
	 * 部门：通信与企业互联事业部
	 * 功能：生成时间戳字符串
	 * 描述：略
	 * 作成者：朱庆锋
	 * 作成时间：2018年6月10日
	 */
	public static String dateString(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}
	
	/**
	 * 部门：通信与企业互联事业部
	 * 功能：
	 * 描述：略
	 * 作成者：朱庆锋
	 * 作成时间：2018年6月10日
	 */
	public static String spliceCodeStr(String prefix, String seq, int len){
		if(null == prefix || null == seq){
			return null;
		}
		StringBuffer buf = new StringBuffer();
		buf.append(prefix).append(dateString()).append(lpdStr(seq, len));
		
		return buf.toString();
	}
	
	/**
	 * 部门：通信与企业互联事业部
	 * 功能：左补零
	 * 描述：略
	 * 作成者：朱庆锋
	 * 作成时间：2018年6月10日
	 */
	public static String lpdStr(String seq, int len){
		StringBuffer buf = new StringBuffer();
		buf.append("%0").append(len).append("d");
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		// String.format("%04d", Integer.valueOf(seq))
		return String.format(buf.toString(), Integer.valueOf(seq));
	}

	public static void main(String[] args) {
		String  a = "20170828105651222000011111111111111113333333333311111000";
		BigDecimal b = new BigDecimal(a);
		System.err.println(b.add(new BigDecimal(1)));
	}
}
