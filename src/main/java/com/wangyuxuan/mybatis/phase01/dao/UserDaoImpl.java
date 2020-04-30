package com.wangyuxuan.mybatis.phase01.dao;

import com.wangyuxuan.mybatis.phase01.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author wangyuxuan
 * @date 2020/4/30 13:27
 * @description 1. sqlsession：方法级别
 *              2. sqlsessionFactory：全局范围（应用级别）
 *              3. sqlsessionFactoryBuilder：方法级别
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    // 注入SqlSessionFactory
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        // SqlSessionFactory工厂类去创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = null;
        try {
            // sqlsession接口，开发人员使用它对数据库进行增删改查操作
            // 参数1：指定定义的statement的id，参数2：指定向statement中传递的参数
            user = sqlSession.selectOne("test.findUserById", id);
            System.out.println(user);
        } finally {
            sqlSession.close();
        }
        return user;
    }

    public List<User> findUserByUsername(String username) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = null;
        try {
            userList = sqlSession.selectList("test.findUserByUsername", username);
            System.out.println(userList);
        } finally {
            sqlSession.close();
        }
        return userList;
    }

    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("test.insertUser", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
