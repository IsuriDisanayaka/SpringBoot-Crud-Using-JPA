package com.wixis.springbootcrud.controller;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import com.wixis.springbootcrud.dto.PackDTO;
import com.wixis.springbootcrud.dto.UserDTO;
import com.wixis.springbootcrud.exception.NotFoundException;

import com.wixis.springbootcrud.service.PackService;
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
@RequestMapping("/api/v1/pack")
@CrossOrigin
public class PackController {
    @Autowired
    private PackService service;

    @PostMapping
    public ResponseEntity savePack(@RequestBody PackDTO dto) {
        if (dto.getPId().trim().length() <= 0) {
            throw new NotFoundException("Package id cannot be empty");
        }
        service.addPackage(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchPack(@PathVariable String id) {
        PackDTO packDTO = service.searchPackage(id);
        return new ResponseEntity(new StandardResponse("200", "Done", packDTO), HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePack(@PathVariable String id) {
        boolean done = service.deletePackage(id);
        return new ResponseEntity(new StandardResponse("200", "Done", done), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity updatePack(@RequestBody PackDTO dto) {
        if (dto.getPId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updatePackage(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllPack() {
        ArrayList<PackDTO> allPacks = service.getAllPackages();
        return new ResponseEntity(new StandardResponse("200", "Done",
                allPacks), HttpStatus.OK);
    }
}
