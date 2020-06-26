package com.yhq.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhq.mybatisplusdemo.entity.User;
import com.yhq.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: YHQ
 * @Date: 2020/6/26 17:24
 */
@SpringBootTest
public class wrapperTest {
    @Resource
    UserMapper mapper;

    @Test
    public void wrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",10);
        mapper.selectList(wrapper);
    }
    @Test
    public void wrapper2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .like("name","yhq")       // %x%
                .likeRight("email","t");  // x%

        mapper.selectList(wrapper);
    }

    @Test
    public void wrapper3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id>3");

        mapper.selectObjs(wrapper);
    }

}
