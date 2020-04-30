package com.wangyuxuan.mybatis.phase02;

import com.wangyuxuan.mybatis.phase02.mapper.UserMapper;
import com.wangyuxuan.mybatis.phase02.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author wangyuxuan
 * @date 2020/4/30 16:07
 * @description 测试基础应用案例 XML方式
 */
public class Test2 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        // 加载全局配置文件（同时把映射文件也加载了）
        String resource = "phase02/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // sqlsessionFactory需要通过sqlsessionFactoryBuilder读取全局配置文件信息之后
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用UserMapper对象的API
        User user = mapper.findUserById(1);
        System.out.println(user);
        // 关闭sqlSession
        sqlSession.close();
    }
}
