package com.example.fastjson.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @ProjectName: fastjson
 * @Package: com.example.fastjson.domain
 * @ClassName: Test
 * @Author: jgp
 * @Description: ${DESCRIPTION}
 * @Date: 2019/4/29 16:35
 * @Version: 1.0
 */
@Entity
@Table(name = "T_TEST")
@Data
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    private String name;
}
