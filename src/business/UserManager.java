package business;

import core.Helper;
import dao.UserDao;
import entity.User;

import java.util.ArrayList;

public class UserManager {
    private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }
    public User findBylogin(String username, String password){
        //farklı işlemler yapabiliriz.
        return this.userDao.findByLogin(username,password);
    }
    public ArrayList<User> findAll(){
        return this.userDao.findAll();
    }
    public boolean save(User user){
        if (user.getId() !=0 ){
            Helper.showMsg("error");

        }
        return this.userDao.save(user);
    }
    public User getById(int id){
        return this.userDao.getById(id);
    }
    public boolean update(User user){
        if (this.getById(user.getId())== null){
            Helper.showMsg("notFound");
        }
        return this.userDao.update(user);
    }
    public boolean delete(int id){
        if (this.getById(id) == null){
            Helper.showMsg(id + " ID kayıtlı user bulunamadı");
            return false;
        }
        return this.userDao.delete(id);
    }
   // public ArrayList<User> userList = new ArrayList<>();

    public ArrayList<Object[]> getForTable(int size, ArrayList<User> users){
        ArrayList<Object[]> userList = new ArrayList<>();
        for (User obj : users){
            int i = 0;
            Object[] rowObject = new Object[size];
            rowObject[i++] = obj.getId();
            rowObject[i++] = obj.getUsername();
            rowObject[i++] = obj.getPassword();
            rowObject[i++] = obj.getRole();

            userList.add(rowObject);
        }
        return userList;
    }
    public ArrayList<User> findByRole(String userSearhRole){
        return userDao.findByRole(userSearhRole);
    }
}
