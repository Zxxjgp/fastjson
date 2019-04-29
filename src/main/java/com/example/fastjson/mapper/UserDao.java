package com.example.fastjson.mapper;

import com.example.fastjson.domain.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ProjectName: fastjson
 * @Package: com.example.fastjson.mapper
 * @ClassName: UserDao
 * @Author: jgp
 * @Description: ${DESCRIPTION}
 * @Date: 2019/4/29 15:56
 * @Version: 1.0
 */
@Mapper
public interface UserDao {

    @Select("select * from T_AREA ")
    List<Area> getList();
}
