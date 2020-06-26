package com.yhq.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhq.mybatisplusdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: YHQ
 * @Date: 2020/6/25 21:12
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
