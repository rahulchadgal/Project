package service;

import java.util.ArrayList;
import java.util.List;

import model.Vehicle;

public class ParkingLot {

	private static ParkingLot instance;
	List<Floor> floors = new ArrayList<>();

	public ParkingLot(List<Floor> floors) {
		this.floors = floors;
	}

	public static ParkingLot getInstance(List<Floor> floors) {
		if (instance == null)
			return new ParkingLot(floors);
		return instance;
	}

	public boolean parkVehicle(Vehicle vehicle) {
		return true;
	}

	public Vehicle unParkVehicle(String carId) {
		return null;
	}

	public void displayAvailableSpots() {

	}

}
