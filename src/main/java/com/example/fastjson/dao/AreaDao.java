package com.example.fastjson.dao;

import com.example.fastjson.domain.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ProjectName: fastjson
 * @Package: com.example.fastjson.dao
 * @ClassName: AreaDao
 * @Author: jgp
 * @Description: ${DESCRIPTION}
 * @Date: 2019/4/29 16:01
 * @Version: 1.0
 */
@Mapper
public interface AreaDao {

    @Select("select * from T_AREA ")
    List<Area> getLists();

    @Select("select RPI_CHA_NAM from T_WX_BANK_AREACODE where PRO_COD=#{code}")
    String getAddressByCode(@Param("code") String code);
}
