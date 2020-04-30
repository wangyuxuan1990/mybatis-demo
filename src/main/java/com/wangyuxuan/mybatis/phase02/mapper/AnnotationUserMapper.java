package com.wangyuxuan.mybatis.phase02.mapper;

import com.wangyuxuan.mybatis.phase02.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

/**
 * @author wangyuxuan
 * @date 2020/4/30 16:38
 * @description AnnotationUserMapper接口
 */
public interface AnnotationUserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    public User findUserById(int id) throws Exception;

    @Select("SELECT * FROM user WHERE username LIKE '%${value}%'")
    public List<User> findUserByUsername(String username) throws Exception;

    @Insert("INSERT INTO user (username, birthday, sex, address) values (#{username}, #{birthday}, #{sex}, #{address})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Integer.class, before = false)
    public void insertUser(User user) throws Exception;
}
