package com.wangyuxuan.mybatis.phase01;

import com.wangyuxuan.mybatis.phase01.dao.UserDao;
import com.wangyuxuan.mybatis.phase01.dao.UserDaoImpl;
import com.wangyuxuan.mybatis.phase01.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author wangyuxuan
 * @date 2020/4/30 13:47
 * @description 测试入门案例
 */
public class Test1 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        // 加载全局配置文件（同时把映射文件也加载了）
        String resource = "phase01/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // sqlsessionFactory需要通过sqlsessionFactoryBuilder读取全局配置文件信息之后
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> userList = userDao.findUserByUsername("wangyuxuan");
        System.out.println(userList);
    }

    @Test
    public void testInsertUser() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setUsername("wangyuxuan");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("123");
        userDao.insertUser(user);
        System.out.println(user.getId());
    }
}
