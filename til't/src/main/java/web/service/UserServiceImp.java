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
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public List<User> informationOfPeoples() {
        return userDao.informationOfPeoples();
    }
    @Transactional
    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Transactional
    @Override
    public User updateUser(int id, User user) {
        return userDao.updateUser(id, user);
    }
    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

}
