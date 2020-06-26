package com.yhq.mybatisplusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhq.mybatisplusdemo.entity.User;
import com.yhq.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusdemoApplicationTests {

    @Resource
    UserMapper mapper;

    @Test
    void contextLoads() {
        List<User> users = mapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    void insert() {
        User u = new User();
        u.setName("yhq3");
        u.setEmail("email");
        u.setAge(18L);
        mapper.insert(u);
    }

    @Test
    public void update(){
        User u = new User();
        u.setId(1276154804866953218L);
        u.setName("yhq3 -- update");
        u.setAge(3L);
        mapper.updateById(u);
    }

    @Test
    public void OptimisticLocker(){
        User user = mapper.selectById(1L);
        user.setName("yhq");
        user.setEmail("new@new.com");
        mapper.updateById(user);
    }

    @Test
    public void OptimisticLocker2(){
        User user = mapper.selectById(1L);
        User user2 = mapper.selectById(1L);

        user.setName("user11111");
        user2.setName("user2222");

        mapper.updateById(user);
        mapper.updateById(user2);
    }

    @Test
    public void select1(){
        User user = mapper.selectById(1L);
        System.out.println(user);
    }
    @Test
    public void select2(){
        List<User> users = mapper.selectBatchIds(Arrays.asList(1, 2, 3));

        users.forEach(System.out::println);
    }
    @Test
    public void select3(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","yhq");

        List<User> users = mapper.selectByMap(map);
        users.forEach(System.out::println);


    }

    @Test
    public void page(){
        Page<User> page = new Page<>(1,5);

        mapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);

    }

    @Test
    public void delete1(){
        List<User> users = mapper.selectList(null);

        users.forEach(System.out::println);
    }
}
