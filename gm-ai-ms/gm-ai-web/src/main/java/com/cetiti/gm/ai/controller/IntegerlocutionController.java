package com.cetiti.gm.ai.controller;

import com.cetiti.gm.ai.service.RobotInterlocutionService;
import com.cetiti.gm.common.model.RestResult;
import com.cetiti.gm.common.model.RestResultBuilder;
import com.cetiti.gm.common.web.controller.BaseController;
import com.cetiti.gm.robot.entity.CodeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * created by sunliangliang
 * 问答接口
 */
@RestController
@RequestMapping("/api")
//@RefreshScope
public class IntegerlocutionController extends BaseController{
    @Autowired
    private RobotInterlocutionService interlocutionService;
    /**
     * 测试内部通过feign调用服务
     */
    @GetMapping("/robots")
    public RestResult listRobots(){
        Map<Integer, CodeMap> robots = interlocutionService.listRobots();
        return RestResultBuilder.builder().success(robots).build();
    }
}
