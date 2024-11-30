package model;

import java.util.List;

import parkingSpot.ParkingSpot;
import vehicle.Vehicle;

//Singleton
public class ParkingLot {

	private static ParkingLot instance;
	private List<Floor> floors;

	public ParkingLot(List<Floor> floors) {
		this.floors = floors;
	}

	public static ParkingLot getInstance(List<Floor> floors) {
		if (instance == null)
			return new ParkingLot(floors);
		return instance;
	}

	public boolean parkVehicle(Vehicle vehicle) {
		for (Floor floor : floors) {
			ParkingSpot spot = floor.findAvaiableSpot(vehicle);
			if (spot != null) {
				spot.park(vehicle);
				System.out.println("Parked " + vehicle.getVehicleType() + " with license plate "
						+ vehicle.getVehicleId() + " on floor " + floor.getFloorId() + " in spot " + spot.getSpotId());
				return true;
			}
		}
		System.out.println("No Parking Avaiable");
		return false;
	}

	public void unParkVehicle(String vehicleId) {
		for (Floor floor : floors) {
			for (ParkingSpot spot : floor.getParkingSpot()) {
				if (!spot.isAvailable() && spot.getVehicle().getVehicleId().equalsIgnoreCase(vehicleId)) {

					System.out.println(vehicleId + " " + spot.getVehicle().getVehicleType()
							+ " has left the parking spot " + spot.getSpotId() + " on floor:" + floor.getFloorId());
					spot.unPark();
					return;
				}
			}
		}
		System.out.println("No vehicle of this id is parked here");
	}

	public void displayAvailableSpots() {
		for (Floor floor : floors) {
			floor.displayAvailableSpot();
		}

	}
}
