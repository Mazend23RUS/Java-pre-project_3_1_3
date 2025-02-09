package com.example.javapreproject_3_1_3.service;


import com.example.javapreproject_3_1_3.models.User;

import java.util.List;

public interface ServiceUserInterface {

    List<User> getAllUsersList();

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);

//    Optional<User> getUserByName(String userName);
    User getUserByName(String userName);

}
