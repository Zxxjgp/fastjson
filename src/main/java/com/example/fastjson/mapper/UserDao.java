package com.example.fastjson.mapper;

import com.example.fastjson.domain.Area;
import com.example.fastjson.domain.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
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

    /**
     * JpaRepository<Test, Integer>  第一个是entity，第二个是主键的类型
     * @return
     */
    @Select("select * from T_AREA ")
    List<Area> getList();

    @Insert("insert into T_TEST (ID,NAME) values(#{id} ， #{name}) ")
    Integer addTest(@Param("id") String id , @Param("name") String name);

    @Select("select * from T_TEST")
    List<Test> getlistaa();


}
