package parkingSpot;

import util.VehicleType;
import vehicle.Vehicle;

public class TruckSpot extends ParkingSpot {

	public TruckSpot(int spotId) {
		super(spotId);
	}

	@Override
	public boolean canPark(Vehicle vehicle) {
		return vehicle.getVehicleType() == VehicleType.TRUCK;
	}

}
