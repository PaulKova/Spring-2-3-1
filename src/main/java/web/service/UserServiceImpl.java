package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User u) {
        userDao.addUser(u);
    }

    @Override
    @Transactional
    public void editUser(User u) {
        userDao.editUser(u);
    }

    @Override
    @Transactional
    public User deleteUser(long id) {
        return userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void update(long id, User updateUser) {
        userDao.update(id,updateUser);
    }
}
