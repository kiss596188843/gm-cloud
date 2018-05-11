package com.cetiti.gm.robot.vo;

import com.cetiti.gm.common.util.DateUtils;
import com.cetiti.gm.robot.entity.CommonMsg;
import com.cetiti.gm.robot.entity.Robot;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * created by sunliangliang
 */
@ApiModel
public class RobotVo extends Robot{
    @ApiModelProperty("行业名称")
    private String industryName;
    private List<CommonMsg> commonMsgs;
    /**
     * 行业库格式为：[{"type":{libId,libName}}]
     */

    public RobotVo( ) {

    }

    public RobotVo(Robot robot) {
        this.setId(robot.getId());
        this.setIndustryId(robot.getIndustryId());
        this.setHeadPortrait(robot.getHeadPortrait());
        this.setName(robot.getName());
        this.setSex(robot.getSex());
        this.setAccessWay(robot.getAccessWay());
        this.setAvaliable(robot.getAvaliable());
        this.setTenantId(robot.getTenantId());
        this.setGmtCreate(robot.getGmtCreate());
        this.setGmtModified(robot.getGmtModified());
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public List<CommonMsg> getCommonMsgs() {
        return commonMsgs;
    }

    public void setCommonMsgs(List<CommonMsg> commonMsgs) {
        this.commonMsgs = commonMsgs;
    }
}
