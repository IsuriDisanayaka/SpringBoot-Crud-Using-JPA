package com.wixis.springbootcrud.service;

import com.wixis.springbootcrud.dto.UserDTO;

import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
public interface UserService {
    void addUser(UserDTO dto);
    boolean deleteUser(String id);
    UserDTO searchUser(String id);
    ArrayList<UserDTO>getAllUsers();
    void updateUser(UserDTO dto);

}
