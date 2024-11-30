package driver;

import java.util.ArrayList;
import java.util.List;

import model.Vehicle;
import service.Floor;
import service.ParkingLot;
import service.ParkingSpot;

public class Driver {

	public static void main(String[] args) {

		List<Floor> floors = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			List<ParkingSpot> floorSpots = new ArrayList<>();

			floorSpots.add(new TruckSpot(0));
			floorSpots.add(new BikeSpot(1));
			floorSpots.add(new BikeSpot(2));

			for (int j = 3; j < 6; j++) {
				floorSpots.add(new CarSpot(j));
			}

			// Create the floor
			floors.add(new Floor(i + 1, floorSpots));
		}
		ParkingLot parkingLot = new ParkingLot(floors);

		Vehicle car1 = new Car("CAR123");
		Vehicle bike1 = new Bike("BIKE123");
		Vehicle truck1 = new Truck("TRUCK123");

		// Parking vehicles
		parkingLot.parkVehicle(car1); // Should park car in the closest available spot
		parkingLot.parkVehicle(bike1); // Should park bike in the closest available spot
		parkingLot.parkVehicle(truck1); // Should park truck in the closest available spot

		parkingLot.displayAvailableSpots(); // Show available spots

		// A vehicle leaves
		parkingLot.unParkVehicle("CAR123");
		parkingLot.displayAvailableSpots();

	}

}
