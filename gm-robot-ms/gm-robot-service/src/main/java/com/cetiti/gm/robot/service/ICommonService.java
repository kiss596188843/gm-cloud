package com.cetiti.gm.robot.service;

import java.util.List;
import java.util.Map;

import com.cetiti.gm.robot.entity.CodeMap;
import com.cetiti.gm.robot.entity.Point;

/**
 * 公共接口类
 * @author chenbobo
 * @email chenbobo@cetiti.com
 * @create 2018-03-30 14:31:15
 */
public interface ICommonService {
	
	 /**
     * 码表列表
     * @param typeList
     * @return
     * @throws Exception
     */
	Map<Integer, CodeMap> listCodeMap(String typeList);
	
	 /**
     * 序列查询
     * @param tableName
     * @return
     * @throws Exception
     */
	List<Point> listPoint(String tableName);

	/**
	 * 根据type,id值获取码值
	 * @param type
	 * @param id
	 * @return
	 */
	String getCodeMapValue(Integer type,Integer id);
}
