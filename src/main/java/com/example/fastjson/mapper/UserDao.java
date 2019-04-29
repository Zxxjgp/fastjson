package com.example.fastjson.mapper;

import com.example.fastjson.domain.Area;
import com.example.fastjson.domain.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

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
@Qualifier("db2SqlSessionFactory")
public interface UserDao {

    @Select("select * from T_AREA ")
    List<Area> getList();

    @Insert("insert into T_TEST (ID,NAME) values(#{id} ， #{name}) ")
    Integer addTest(@Param("id") String id , @Param("name") String name);
}
