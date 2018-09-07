import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.sql.Timestamp;
import java.util.Date;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.UserMapper;
import droideye.estore.pojo.User;

public class UserTest {


    @Test
    public void userQueryTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);


        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User zhangsan = userMapper.selectByUsername("wdadadad");

        System.out.println(zhangsan);
        sqlSession.close();

    }

    @Test
    public void insertUserTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("黄永琪", "123456", "0321", "19222131321", "laowang@qq.com",
                new Timestamp(System.currentTimeMillis()), 1);
        int state = userMapper.insert(user);
        System.out.println(state);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void updateUserById() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setZip("0351");
        user.setPhone("18077898676");
        user.setEmail("lisi@qq.com");

        boolean b = userMapper.modifyUserById(user);
        System.out.println(b);
        sqlSession.close();

    }

    @Test
    public void changePasswordTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setPassword("123");

        boolean result = userMapper.changePassword(user);

        System.out.println(result);
        sqlSession.close();

    }

    @Test
    public void modifyUserByIdTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(2);
        user.setUsername("lisi");
        user.setEmail(null);
        user.setZip(null);
        user.setPhone(null);
        boolean result = userMapper.modifyUserById(user);

        System.out.println(result);
    }
}
