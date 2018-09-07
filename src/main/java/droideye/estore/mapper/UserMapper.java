package droideye.estore.mapper;

import droideye.estore.pojo.User;

public interface UserMapper {

    /**
     * 根据用户名查询出User对象
     */
    //User selectByUsername(String username);

    User selectByUsername(String username);

    /**
     * 插入方法
     * @param user
     * @return 插入成功的条数
     */
    int insert(User user);

    /*
     *  根据用户ID将传入的User更新
     * */
    boolean modifyUserById(User user);

    boolean changePassword(User user);

}
