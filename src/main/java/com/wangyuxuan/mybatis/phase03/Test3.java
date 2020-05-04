package com.wangyuxuan.mybatis.phase03;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyuxuan.mybatis.phase03.mapper.UserMapper;
import com.wangyuxuan.mybatis.phase03.po.User;
import com.wangyuxuan.mybatis.phase03.po.UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author wangyuxuan
 * @date 2020/5/4 4:46 下午
 * @description 测试逆向工程代码和PageHelper分页插件案例
 */
public class Test3 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws Exception {
        // 加载全局配置文件（同时把映射文件也加载了）
        String resource = "phase03/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // sqlsessionFactory需要通过sqlsessionFactoryBuilder读取全局配置文件信息之后
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1() {
        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        List<User> users = mapper.selectByExample(userExample);
        System.out.println(users);
    }

    @Test
    public void test2() {
        // 创建UserMapper对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 编写分页代码
        PageHelper.startPage(2, 1);

        UserExample userExample = new UserExample();
        // 此处返回的list实现类不再是ArrayList，而是PageHelper提供的Page对象
        List<User> users = mapper.selectByExample(userExample);
        System.out.println(users);

        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println(pageInfo.getTotal());
    }
}
