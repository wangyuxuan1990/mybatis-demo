package com.wangyuxuan.mybatis.phase02.mapper;

import com.wangyuxuan.mybatis.phase02.po.User;

/**
 * @author wangyuxuan
 * @date 2020/4/30 15:59
 * @description mapper接口
 */
public interface UserMapper {
    public User findUserById(int id) throws Exception;
}
