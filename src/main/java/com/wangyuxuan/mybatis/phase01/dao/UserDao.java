package com.wangyuxuan.mybatis.phase01.dao;

import com.wangyuxuan.mybatis.phase01.po.User;

import java.util.List;

/**
 * @author wangyuxuan
 * @date 2020/4/30 13:25
 * @description dao接口
 */
public interface UserDao {
    public User findUserById(int id) throws Exception;

    public List<User> findUserByUsername(String username) throws Exception;

    public void insertUser(User user) throws Exception;
}
