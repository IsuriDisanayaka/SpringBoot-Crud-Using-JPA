package com.wixis.springbootcrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class pack {
    @Id
    private String pId;
    private String description;
    private String price;
    @ManyToOne
    private User user;
    @ManyToOne
    private Vehicle vehicle;
}
