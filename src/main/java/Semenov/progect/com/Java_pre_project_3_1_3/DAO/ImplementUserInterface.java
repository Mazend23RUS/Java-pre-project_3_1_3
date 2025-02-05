package Semenov.progect.com.Java_pre_project_3_1_3.DAO;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Component
public class ImplementUserInterface implements UserInterface {

    private static final Logger logger = LoggerFactory.getLogger(ImplementUserInterface.class);


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        @SuppressWarnings("unchecked")
        List allUsers = entityManager.createQuery("select p from User p", User.class)
                .getResultList();
        return allUsers;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }


//    @Transactional
//    @Override
//    public Optional<User> getUserByName(String userName) {
//        return Optional.ofNullable(entityManager.find(User.class, userName));
//    }


//    @Transactional
    @Override
    public User getUserByName(String userName) {
        List<User> userListFromDb = entityManager.createQuery("select u from User u where u.userName = userName").getResultList();
        return userListFromDb.stream().filter(  f -> f.getUsername().equals(userName)).findFirst().get();
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = getUserById(id);

//        logger.info("Вот какой айдишник приходит с страницы " + user.getId());
//        logger.info("Вот какой user приходит из БД ы " + user.getUserName());

            entityManager.remove(user);

    }

    @Override
    @Transactional
    public void updateUser(User user){
        entityManager.merge(user);
    }


}
