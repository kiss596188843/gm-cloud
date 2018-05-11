package com.cetiti.gm.robot.provider;

/**
 * 通用数据访问类
 * 
 * @author chenbobo
 * @email chenbobo@cetiti.com
 * @create 2018-03-21 14:31:15
 */
public class CommonProvider {
	public String getSequence(String sequence) {
		return "select " + sequence + ".nextval from dual";
	}
}
