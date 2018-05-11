package com.cetiti.gm.robot.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.cetiti.gm.robot.entity.CodeMap;
import com.cetiti.gm.robot.entity.Point;
import com.cetiti.gm.robot.provider.CommonProvider;

/**
 * 通用数据访问接口
 * 
 * @author chenbobo
 * @email chenbobo@cetiti.com
 * @create 2018-03-21 14:31:15
 */
@Mapper
public interface ICommonMapper {
	/**
	 * 根据序列名称获取序列值
	 * 
	 * @param sequence
	 * @return
	 * @throws Exception
	 */
	@SelectProvider(method = "getSequence", type = CommonProvider.class)
	public BigDecimal getSequence(String sequence) throws Exception;

	/**
	 * 根据type值获取所有子码值
	 * 
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@Select("select id,value from t_code_map where type=#{type} order by id")
	public List<CodeMap> getCodeMap(Integer type);

	/**
	 * 根据表名获取此表所有记录的坐标
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	@Select("select longitude,latitude from #{tableName}")
	public List<Point> getPoint(String tableName);

	
	
	
    /**
     * 根据type,id值获取码值
     * 
     * @param type
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select value from t_code_map where type=#{type} and id=#{id}")
    public String getCodeMapValue(@Param("type")Integer type, @Param("id")Integer id);	
    
    /**
     * 根据type,id值获取时间
     * @return
     * @throws Exception
     */
    @Select("select sysdate from dual")
    public LocalDateTime getDbTime();	
    
}
