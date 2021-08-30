package com.wixis.springbootcrud.service.impl;

import com.wixis.springbootcrud.dto.VehicleDTO;
import com.wixis.springbootcrud.entity.Vehicle;
import com.wixis.springbootcrud.exception.ValidateException;
import com.wixis.springbootcrud.repo.VehicleRepo;
import com.wixis.springbootcrud.service.VehicleService;
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
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addVehicle(VehicleDTO dto) {
        if (vehicleRepo.existsById(dto.getVId())) {
            throw new ValidateException("Vehicle Already Exist");
        }
        vehicleRepo.save(mapper.map(dto, Vehicle.class));
    }

    @Override
    public boolean deleteVehicle(String id) {
        if (!vehicleRepo.existsById(id)) {
            throw new ValidateException("No Vehicle for Delete..!");
        }
        vehicleRepo.deleteById(id);

        return true;
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if (vehicle.isPresent()) {
            return mapper.map(vehicle.get(), VehicleDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<VehicleDTO> getAllVehicles() {
        List<Vehicle> all = vehicleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if (vehicleRepo.existsById(dto.getVId())) {
            vehicleRepo.save(mapper.map(dto, Vehicle.class));

        }

    }
}
