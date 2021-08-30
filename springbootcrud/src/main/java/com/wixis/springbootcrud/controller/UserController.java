package com.wixis.springbootcrud.controller;

import com.wixis.springbootcrud.dto.UserDTO;
import com.wixis.springbootcrud.exception.NotFoundException;
import com.wixis.springbootcrud.service.UserService;
import com.wixis.springbootcrud.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("Customer id cannot be empty");
        }
        service.addUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchUser(@PathVariable String id) {
        UserDTO userDTO = service.searchUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", userDTO), HttpStatus.OK);
    }


@DeleteMapping(path = "/{id}")
public ResponseEntity deleteUser(@PathVariable String id) {
    boolean done = service.deleteUser(id);
    return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
}
    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getAllCustomers() {
        ArrayList<UserDTO> allUsers = service.getAllUsers();
        return new ResponseEntity(new StandardResponse("200", "Done",
                allUsers), HttpStatus.OK);
    }
}
