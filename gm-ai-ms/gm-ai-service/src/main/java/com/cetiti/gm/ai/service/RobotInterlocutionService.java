package com.cetiti.gm.ai.service;

import com.cetiti.gm.ai.entity.Interlocution;
import com.cetiti.gm.robot.entity.CodeMap;
import java.util.Map;

/**
 * created by sunliangliang
 */
public interface RobotInterlocutionService {
    public String getAnswer(String question);
    public Interlocution getInterlocation(String question);
    public Map<Integer, CodeMap>    listRobots();
}
