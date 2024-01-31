package business;

import dao.UserDao;
import entity.User;

public class UserManager {
    private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }
    public User findBylogin(String username, String password){
        //farklı işlemler yapabiliriz.
        return this.userDao.findByLogin(username,password);
    }
}
