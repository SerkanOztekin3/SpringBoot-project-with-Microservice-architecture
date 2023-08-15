package com.task.vehicle.service;

import com.task.vehicle.entity.Vehicle;
import com.task.vehicle.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

	private final VehicleRepository vehicleRepository;

	public void createVehicle(Vehicle vehicle) {vehicleRepository.save(vehicle); }

	public Vehicle findVehicle(String carPlate) {
		return vehicleRepository.findVehicleByCarPlate(carPlate);
	}

	public void deleteVehicle(Long id) {
		vehicleRepository.deleteById(id);
	}

	public Vehicle updateVehicle(Long userId, Vehicle updatedUser) {
		Vehicle existingUser = vehicleRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException("User not found"));

		existingUser.setBrand(updatedUser.getBrand());
		existingUser.setUserId(updatedUser.getUserId());
		existingUser.setCarPlate(updatedUser.getCarPlate());
		existingUser.setModel(updatedUser.getModel());
		existingUser.setYear(updatedUser.getYear());
		existingUser.setFiloName(updatedUser.getFiloName());
		existingUser.setGroupName(updatedUser.getGroupName());
		existingUser.setCompanyId(updatedUser.getCompanyId());

		return vehicleRepository.save(existingUser);
	}



}
