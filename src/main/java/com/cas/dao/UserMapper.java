package com.cas.dao;

import com.cas.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xianglong
 * @since 2024-02-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
