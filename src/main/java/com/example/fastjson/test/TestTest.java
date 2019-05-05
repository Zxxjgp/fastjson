package com.example.fastjson.test;

import com.example.fastjson.domain.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName TestTest
 * @date 2019/5/5  14:39
 */
public class TestTest {

    public static void main(String[] args) {
        List<Test> list = new ArrayList<>(13);
        Test t = new Test();
        t.setId(11);
        list.add(t);
        Test tt = new Test();
        tt.setId(1);
        list.add(tt);
        System.out.println(list);
        for (Test i : list) {
            i.setName("wqwq");
        }
        System.out.println(list);
    }
}
