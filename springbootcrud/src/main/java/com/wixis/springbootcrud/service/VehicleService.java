package com.wixis.springbootcrud.service;


import com.wixis.springbootcrud.dto.VehicleDTO;

import java.util.ArrayList;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
public interface VehicleService {
    void addVehicle(VehicleDTO dto);
    boolean deleteVehicle(String id);
    VehicleDTO searchVehicle(String id);
    ArrayList<VehicleDTO> getAllVehicles();
    void updateVehicle(VehicleDTO dto);
}
