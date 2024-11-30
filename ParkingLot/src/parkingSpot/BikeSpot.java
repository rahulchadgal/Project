package parkingSpot;

import util.VehicleType;
import vehicle.Vehicle;

public class BikeSpot extends ParkingSpot {

	public BikeSpot(int spotId) {
		super(spotId);
	}

	@Override
	public boolean canPark(Vehicle vehicle) {
		return vehicle.getVehicleType() == VehicleType.BIKE;
	}

}
