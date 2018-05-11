package com.cetiti.gm.robot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.cetiti.gm.robot.dao.ICommonMapper;
import com.cetiti.gm.robot.entity.CodeMap;
import com.cetiti.gm.robot.entity.Point;
import com.cetiti.gm.robot.service.ICommonService;


/**
 * 公共实现类
 * @author chenbobo
 * @email chenbobo@cetiti.com
 * @create 2018-03-30 14:31:15
 */
@Service
public class CommonServiceImpl implements ICommonService {
	@Resource
	private ICommonMapper commonMapper;

	@Override
	public Map<Integer, CodeMap> listCodeMap(String typeList) {
		Map<Integer, CodeMap> acmList = new HashMap<>();
		for (String type : typeList.split(",")) {
			Integer iType = Integer.valueOf(type);
			List<CodeMap> cmiList = commonMapper.getCodeMap(iType);
			for (CodeMap cm : cmiList) {
				acmList.put(iType, cm);
			}
		}
		return acmList;
	}

	@Override
	public List<Point> listPoint(String tableName) {
		return commonMapper.getPoint(tableName);
	}

	@Override
	public String getCodeMapValue(Integer type, Integer id) {
		return (null == id) ? "" : commonMapper.getCodeMapValue(type, id);
	}


}
