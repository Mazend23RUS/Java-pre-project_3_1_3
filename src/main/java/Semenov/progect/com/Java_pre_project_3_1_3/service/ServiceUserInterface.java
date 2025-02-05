package Semenov.progect.com.Java_pre_project_3_1_3.service;


public interface ServiceUserInterface {

    List<User> getAllUsersList();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);

//    Optional<User> getUserByName(String userName);
    User getUserByName(String userName);

}
