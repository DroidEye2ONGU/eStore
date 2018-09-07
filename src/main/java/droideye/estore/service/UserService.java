package droideye.estore.service;

import droideye.estore.pojo.User;

public interface UserService {

    public User selectByUsername(String username);

    public Integer insertUser(User user);

    public boolean modifyUserById(User user);

    public boolean changPassword(User user);
}
