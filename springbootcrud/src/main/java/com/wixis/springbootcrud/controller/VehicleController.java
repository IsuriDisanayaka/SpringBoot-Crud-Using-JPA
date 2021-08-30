package com.wixis.springbootcrud.controller;

import com.wixis.springbootcrud.dto.UserDTO;
import com.wixis.springbootcrud.dto.VehicleDTO;
import com.wixis.springbootcrud.entity.Vehicle;
import com.wixis.springbootcrud.exception.NotFoundException;
import com.wixis.springbootcrud.service.VehicleService;
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
@RequestMapping("/api/v1/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleService service;

    @PostMapping
    public ResponseEntity saveVehicle(@RequestBody VehicleDTO dto) {
        if (dto.getVId().trim().length() <= 0) {
            throw new NotFoundException("Vehicle id cannot be empty");
        }
        service.addVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity searchVehicle(@PathVariable String id) {
        VehicleDTO vehicleDTO = service.searchVehicle(id);
        return new ResponseEntity(new StandardResponse("200", "Done", vehicleDTO), HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteVehicle(@PathVariable String id) {
        boolean done = service.deleteVehicle(id);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO dto) {
        if (dto.getVId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getAllVehicles() {
        ArrayList<VehicleDTO> allUsers = service.getAllVehicles();
        return new ResponseEntity(new StandardResponse("200", "Done",
                allUsers), HttpStatus.OK);
    }
}
