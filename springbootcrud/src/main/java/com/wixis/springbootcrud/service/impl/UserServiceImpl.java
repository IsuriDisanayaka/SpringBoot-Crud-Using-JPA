package com.wixis.springbootcrud.service.impl;

import com.wixis.springbootcrud.dto.UserDTO;
import com.wixis.springbootcrud.entity.User;
import com.wixis.springbootcrud.exception.ValidateException;
import com.wixis.springbootcrud.repo.UserRepo;
import com.wixis.springbootcrud.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addUser(UserDTO dto) {
        if (userRepo.existsById(dto.getId())) {
            throw new ValidateException("User Already Exist");
        }
        userRepo.save(mapper.map(dto, User.class));

    }

    @Override
    public boolean deleteUser(String id) {
        if (!userRepo.existsById(id)) {
            throw new ValidateException("No User for Delete..!");
        }
        userRepo.deleteById(id);
        return true;
    }


    @Override
    public UserDTO searchUser(String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return mapper.map(user.get(), UserDTO.class);
        }
        return null;

    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> all = userRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (userRepo.existsById(dto.getId())) {
            userRepo.save(mapper.map(dto, User.class));

        }
    }
}
