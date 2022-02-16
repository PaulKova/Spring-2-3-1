package web.service;

import web.models.User;

import java.util.List;

public interface UserService {

    void addUser(User u);

    void editUser(User u);

    User deleteUser(long id);

    User getUserById(long id);

    List<User> getAllUsers();

    void update(long id, User updateUser);
}
