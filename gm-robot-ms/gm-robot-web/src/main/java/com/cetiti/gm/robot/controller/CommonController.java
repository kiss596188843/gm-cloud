package com.cetiti.gm.robot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetiti.gm.robot.entity.CodeMap;
import com.cetiti.gm.robot.entity.Point;
import com.cetiti.gm.robot.service.ICommonService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 公用类访问层
 *
 * @author chenbobo
 * @email chenbobo@cetiti.com
 * @create 2018-03-26 16:55:15
 */
@RestController
@RequestMapping("/common")
//@RefreshScope 自动刷新配置
public class CommonController {
	@Autowired
	private ICommonService commonService;

	@GetMapping(value = "/listCodeMap.do")
	@ApiOperation(value = "码表访问接口", notes = "码表访问接口", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "typeList", value = "", required = true, dataType = "string", paramType = "query") })
	public Map<Integer, CodeMap> listCodeMap(final String typeList) throws Exception {
		Map<Integer, CodeMap> map = commonService.listCodeMap(typeList);
		return map;
	}
	
	
	@GetMapping(value = "/listPoint.do")
	@ApiOperation(value = "坐标查询", notes = "坐标查询接口", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "tableName", value = "表名称", required = true, dataType = "string", paramType = "query") })
	public List<Point> listPoint(final String tableName) throws Exception {
		List<Point> page = commonService.listPoint(tableName);
		return page;
	}
	
}
