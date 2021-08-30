package com.wixis.springbootcrud.service;

import com.wixis.springbootcrud.dto.PackDTO;


import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
public interface PackService {
    void addPackage(PackDTO dto);
    boolean deletePackage(String id);
    PackDTO searchPackage(String id);
    ArrayList<PackDTO> getAllPackages();
    void updatePackage(PackDTO dto);
}
