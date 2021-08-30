package com.wixis.springbootcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String id;
    private String fristName;
    private String lastName;
    private String city;
    private RoleDTO roleDTO;

}
