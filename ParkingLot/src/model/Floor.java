package model;

import java.util.List;

import parkingSpot.ParkingSpot;
import vehicle.Vehicle;

public class Floor {

	private int floorId;
	private List<ParkingSpot> parkingSpot;

	public Floor(int i, List<ParkingSpot> floorSpots) {
		this.floorId = i;
		this.parkingSpot = floorSpots;
	}

	public int getFloorId() {
		return floorId;
	}

	public List<ParkingSpot> getParkingSpot() {
		return parkingSpot;
	}

	public void displayAvailableSpot() {
		for (ParkingSpot spot : parkingSpot) {
			if (spot.isAvailable())
				System.out.println("Floor: " + getFloorId() + " ,SpotId: " + spot.getSpotId() + " ,Type: "
						+ spot.getClass().getSimpleName());
		}
	}

	public ParkingSpot findAvaiableSpot(Vehicle vehicle) {
		for (ParkingSpot spot : parkingSpot) {
			if (spot.isAvailable() && spot.canPark(vehicle)) {
				return spot;
			}
		}
		return null;
	}
}
