package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);              //if u want to add some person

    List<User> informationOfPeoples();    //if u want to check the list of peoples

    void removeUser(int id);             //if u want to delete some person by his id

    User updateUser(int id, User user);  //if u want to change some user

    User getUserById(int id);           //if u want to get user by his id

}
