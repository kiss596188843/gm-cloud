package com.cetiti.gm.robot.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 坐标model类
 * @author chenbobo
 * @email chenbobo@cetiti.com
 * @create 2018-03-30 14:31:15
 */
@Data
public class Point {
	BigDecimal id;
	Double longitude;
	Double latitude;
}
