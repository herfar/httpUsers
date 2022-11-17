package web.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;


@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp (UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Override
    public List<User> informationOfPeoples() {
        return userDao.informationOfPeoples();
    }
    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Override
    public User updateUser(int id, User user) {
        return userDao.updateUser(id, user);
    }
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

}
