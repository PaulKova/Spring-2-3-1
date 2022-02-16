package web.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addUser(User u) {
        em.persist(u);
        logger.info("Person saved successfully, Person Details=" + u);
    }

    @Override
    public void editUser(User u) {
        em.merge(u);
        logger.info("Person editing successfully, Person Details=" + u);
    }

    @Override
    public User deleteUser(long id) throws NullPointerException {
        User user = getUserById(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        em.remove(user);
        logger.info("Person deleting successfully, Person Details=" + user);
        return user;
    }

    @Override
    public User getUserById(long id) {
        logger.info("Person detail by ID: " + em.find(User.class, id));
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> qr = em.createQuery("SELECT e FROM User e", User.class);
        for (User us : qr.getResultList()) {
            logger.info("Person List::" + us);
        }
        return qr.getResultList();
    }

    @Override
    public void update(long id, User updateUser) {
        User userUpdated = getUserById(id);
        userUpdated.setName(updateUser.getName());
        userUpdated.setEmail(updateUser.getEmail());
        userUpdated.setAddress(updateUser.getEmail());
    }
}
