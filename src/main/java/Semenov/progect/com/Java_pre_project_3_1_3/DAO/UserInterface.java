package Semenov.progect.com.Java_pre_project_3_1_3.DAO;


public interface UserInterface {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);

//    Optional<User> getUserByName(String userName);
    User getUserByName(String userName);
}
