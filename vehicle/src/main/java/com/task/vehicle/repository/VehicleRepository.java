package com.task.vehicle.repository;

import com.task.vehicle.entity.Vehicle;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "vehicle")
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	Vehicle findVehicleByCarPlate(String carPlate);



}
