package droideye.estore.service.Impl;

import org.apache.ibatis.session.SqlSession;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.UserMapper;
import droideye.estore.pojo.User;
import droideye.estore.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User selectByUsername(String username) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectByUsername(username);

        return user;
    }

    @Override
    public Integer insertUser(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int insertNum = 0;

        if (userMapper.selectByUsername(user.getUsername()) == null) {
            insertNum = userMapper.insert(user);
        }


        return insertNum;
    }

    @Override
    public boolean modifyUserById(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        boolean result = false;

        User thisUser = userMapper.selectByUsername(user.getUsername());

        if (user.getZip() == null || user.getZip().trim().equals("")) {
            user.setZip(thisUser.getZip());
        }
        if (user.getPhone() == null || user.getPhone().trim().equals("")) {
            user.setPhone(thisUser.getPhone());
        }
        if (user.getEmail() == null || user.getEmail().trim().equals("")) {
            user.setEmail(thisUser.getEmail());
        }

        try {
            result = userMapper.modifyUserById(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();

        return result;
    }

    @Override
    public boolean changPassword(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        boolean result = userMapper.changePassword(user);
        sqlSession.close();

        return result;
    }
}
