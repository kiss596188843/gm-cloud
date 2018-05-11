package com.cetiti.gm.robot.dto;

import com.cetiti.gm.common.util.DateUtils;
import com.cetiti.gm.robot.entity.CommonMsg;
import com.cetiti.gm.robot.entity.Robot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * created by sunliangliang
 */
public class RobotDto extends Robot{
    @ApiModelProperty("欢迎语和未知未知问题答案的集合")
    private List<CommonMsg> commonMsgs;
    public Robot getRobot(){
        Robot robot = new Robot();
        robot.setId(this.getId());
        robot.setIndustryId(this.getIndustryId());
        robot.setHeadPortrait(this.getHeadPortrait());
        robot.setName(this.getName());
        robot.setSex(this.getSex());
        robot.setAccessWay(this.getAccessWay());
        robot.setAvaliable(this.getAvaliable());
        robot.setTenantId(this.getTenantId());
        robot.setGmtCreate(DateUtils.now());
        robot.setGmtModified(DateUtils.now());
        return robot;
    }

    public List<CommonMsg> getCommonMsgs(Long robotId) {
        if (commonMsgs!=null){
            for (CommonMsg commonMsg :commonMsgs){
                commonMsg.setGmtCreate(DateUtils.now());
                commonMsg.setGmtModified(DateUtils.now());
                commonMsg.setRobotId(robotId);
            }
        }
        return commonMsgs;
    }

    public void setCommonMsgs(List<CommonMsg> commonMsgs) {
        this.commonMsgs = commonMsgs;
    }
}
