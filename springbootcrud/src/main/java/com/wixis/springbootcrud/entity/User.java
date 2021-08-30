package com.wixis.springbootcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
        @Id
        private String id;
        private String fristName;
        private String lastName;
        private String city;
        @ManyToOne
        private Role role;
        @OneToMany
        private List<pack> pack;



}
