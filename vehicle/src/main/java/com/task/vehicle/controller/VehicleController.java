package com.task.vehicle.controller;

import com.task.vehicle.entity.Vehicle;
import com.task.vehicle.repository.VehicleRepository;
import com.task.vehicle.service.VehicleService;
import jakarta.ws.rs.PUT;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody Vehicle vehicle) { vehicleService.createVehicle(vehicle);}

	@GetMapping("/{car-plate}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("car-plate") String carPlate) {
		return ResponseEntity.ok(vehicleService.findVehicle(carPlate));
	}

	@DeleteMapping("/{vehicle-id}")
	public void deleteVehicle(@PathVariable("vehicle-id") Long vehicleId ) {
		vehicleService.deleteVehicle(vehicleId);
	}

	@PutMapping("/{user-id}")
	public ResponseEntity<Vehicle> findUserByName(
			@PathVariable Long userId,
			@RequestBody Vehicle updatedVehicle) {
		Vehicle vehicle = vehicleService.updateVehicle(userId, updatedVehicle);
		return ResponseEntity.ok(vehicle);
	}



}
