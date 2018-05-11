package com.cetiti.gm.ai.service;

/**
 * created by sunliangliang
 */

import com.cetiti.gm.robot.entity.CodeMap;
import com.cetiti.gm.robot.entity.Point;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("GM-ROBOT-MS")
public interface RobotFeignClient {
	@GetMapping("/common/listCodeMap.do")
	public Map<Integer, CodeMap> listCodeMap(@RequestParam("typeList") final String typeList);

	@GetMapping("/common/listPoint.do")
	public List<Point> listPoint(@RequestParam("tableName") final String tableName);
}
