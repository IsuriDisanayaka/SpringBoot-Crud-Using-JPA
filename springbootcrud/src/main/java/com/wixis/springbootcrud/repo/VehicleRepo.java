package com.wixis.springbootcrud.repo;

import com.wixis.springbootcrud.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
