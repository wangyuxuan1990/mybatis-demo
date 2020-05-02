package com.wangyuxuan.mybatis.phase02;

import com.wangyuxuan.mybatis.phase02.mapper.AnnotationUserMapper;
import com.wangyuxuan.mybatis.phase02.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author wangyuxuan
 * @date 2020/4/30 16:51
 * @description 测试基础应用案例 注解方式
 */
public class AnnotationUserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        // 加载全局配置文件（同时把映射文件也加载了）
        String resource = "phase02/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // sqlsessionFactory需要通过sqlsessionFactoryBuilder读取全局配置文件信息之后
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        sqlSessionFactory.getConfiguration().addMapper(AnnotationUserMapper.class);
    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AnnotationUserMapper mapper = sqlSession.getMapper(AnnotationUserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AnnotationUserMapper mapper = sqlSession.getMapper(AnnotationUserMapper.class);
        List<User> userList = mapper.findUserByUsername("wangyuxuan");
        System.out.println(userList);
    }

    @Test
    public void testInsertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AnnotationUserMapper mapper = sqlSession.getMapper(AnnotationUserMapper.class);
        User user = new User();
        user.setUsername("wangyuxuan");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("123");
        mapper.insertUser(user);
        sqlSession.commit();
        System.out.println(user.getId());
    }
}
