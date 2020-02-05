package com.hl.mapper;


import com.hl.mapper.Impl.userMapperImpl;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class personMapperTest {


    @Autowired
    userMapperImpl pm;

    @Test
    public void selectByPrimaryKey() {
        System.out.println(pm.selectByUserName("zhangsan"));
    }

    @Test
    public void test(){
      Md5Hash ps = new Md5Hash("666", "黄林", 3);
      System.out.println(ps);
    }

}