package com.yhq.blog.service.impl;

import com.yhq.blog.entity.TbBrand;
import com.yhq.blog.mapper.TbBrandMapper;
import com.yhq.blog.service.TbBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表，一个品牌下有多个商品（spu），一对多关系 服务实现类
 * </p>
 *
 * @author yhq
 * @since 2020-06-26
 */
@Service
public class TbBrandServiceImpl extends ServiceImpl<TbBrandMapper, TbBrand> implements TbBrandService {

}
